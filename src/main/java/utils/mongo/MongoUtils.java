package utils.mongo;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import service.mongo.MongoService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.BiFunction;

public class MongoUtils {

    private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    private static final String UPDATED_FIELD = "_updated";
    private static final String UNIQUEID_FIELD = "_id";

    private MongoService service;

    public MongoUtils(MongoService service) {
        this.service = service;
    }

    public final void waitForRecordWithGuidInDB(String guid) {
        try {
            service.connectToMongo();
            service.waitFor(guid, service.isRecordExist(guid));
        } finally {
            service.closeConnection();
        }
    }

    public final boolean checkExistenceOfRecordWithGuidInDB(String guid) {
        boolean result;
        try {
            service.connectToMongo();
            result = service.isRecordExist(guid);
        } finally {
            service.closeConnection();
        }
        return result;
    }

    public final boolean isFieldInDB(String uniqueId, String field) {
        boolean result;
        try {
            service.connectToMongo();
            JsonObject dbObject = service.getObjectById(uniqueId);
            result = dbObject.has(field);
        } finally {
            service.closeConnection();
        }
        return result;
    }

    public final JsonArray getJsonArrayFromDBObject(Object object) {
        Gson gson = new Gson();
        JsonElement result = gson.toJsonTree(object);
        return result.isJsonNull() ? new JsonArray() : result.getAsJsonArray();
    }

    public final JsonObject waitForRecordInDBAfterUpdate(String uniqueId) {
        JsonObject result;
        try {
            service.connectToMongo();
            if (!service.isRecordExist(uniqueId)) {
                return null;
            }
            JsonObject dbObject = service.getObjectById(uniqueId);
            result = service.waitFor(uniqueId, dbObject.has(UPDATED_FIELD));
        } finally {
            service.closeConnection();
        }
        return result;
    }

    public final JsonObject getObjectValueFromDb(String guid, String field) {
        JsonObject dbObject;
        try {
            service.connectToMongo();
            dbObject = service.getObjectById(guid);
        } finally {
            service.closeConnection();
        }
        if (dbObject != null) {
            return dbObject.getAsJsonObject(field);
        }
        return null;
    }

    public final JsonArray getArrayValueFromDb(String guid, String field) {
        JsonObject dbObject;
        try {
            service.connectToMongo();
            dbObject = service.getObjectById(guid);
        } finally {
            service.closeConnection();
        }
        if (dbObject != null) {
            return dbObject.getAsJsonArray(field);
        }
        return null;
    }

    public final JsonElement getValueFromDb(String guid, String field) {
        JsonObject dbObject;
        try {
            service.connectToMongo();
            dbObject = service.getObjectById(guid);
        } finally {
            service.closeConnection();
        }
        if (dbObject != null) {
            return dbObject.get(field);
        }
        return null;
    }

    public final Date getDateValueFromDb(String guid, String field) {
        JsonObject dbObject;
        try {
            service.connectToMongo();
            dbObject = service.getObjectById(guid);
        } finally {
            service.closeConnection();
        }
        Date date = null;
        if (dbObject != null) {
            DateFormat format = new SimpleDateFormat(DATE_PATTERN, Locale.US);
            try {
                date = format.parse(dbObject.get(field).getAsString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    public final JsonObject getObjectByGuid(String guid) {
        JsonObject result;
        try {
            service.connectToMongo();
            result = service.getObjectById(guid);
        } finally {
            service.closeConnection();
        }
        return result;
    }

    public final JsonObject waitForRecordInDBAfterUpdateHasSpecifiedValue(String uniqueId, String updatedField, String
            expectedValue) {
        JsonObject result;
        try {
            service.connectToMongo();
            BiFunction<String, String, Boolean> function = (guid, field) -> {
                if (service.isRecordExist(guid)) {
                    JsonObject dbObject = service.getObjectById(guid);
                    if (dbObject.has(UPDATED_FIELD) &&
                            dbObject.has(field) &&
                            !dbObject.get(field).isJsonNull()) {
                        JsonArray jsonArray = dbObject.getAsJsonArray(field);
                        for (JsonElement jElement : jsonArray) {
                            for (Map.Entry<String, JsonElement> entry : jElement.getAsJsonObject().entrySet()) {
                                if (expectedValue.equals(entry.getValue().getAsString())) {
                                    return true;
                                }
                            }
                        }
                    }
                }
                return false;
            };
            result = service.waitFor(uniqueId, function.apply(uniqueId, updatedField));
        } finally {
            service.closeConnection();
        }
        return result;
    }

    public final JsonObject waitForRecordInDBHasSpecifiedArrayValueUnknownGuid(String collection, String field, JsonArray expectedValue) {
        JsonObject result;
        try {
            service.connectToMongo();
            List<String> expectedValues = new ArrayList<>();
            expectedValue.forEach(value -> expectedValues.add(value.getAsString()));
            MongoCollection mongoCollection = service.getCollection(collection);
            Bson filter = Filters.all(field, expectedValues);
            Object object = mongoCollection.find(filter).first();
            result = service.waitFor(collection, object != null);
        } finally {
            service.closeConnection();
        }
        return result;
    }

    public final JsonObject queryDBForJsonObject(String collection, BasicDBObject query) {
        JsonObject result;
        try {
            service.connectToMongo();
            result = service.queryDBForJsonObject(collection, query);
        } finally {
            service.closeConnection();
        }
        return result;
    }

    public final JsonArray queryDBForJsonArray(String collection, BasicDBObject query) {
        JsonArray result;
        try {
            service.connectToMongo();
            result = service.queryDBForJsonArray(collection, query);
        } finally {
            service.closeConnection();
        }
        return result;
    }

    public final JsonObject queryDBForJsonObject(String collection, String guid) {
        BasicDBObject query = new BasicDBObject();
        query.put(UNIQUEID_FIELD, guid);
        return queryDBForJsonObject(collection, query);
    }

    public final List<JsonObject> getRecordsFromCollection(String collectionName) {
        List<JsonObject> result;
        try {
            service.connectToMongo();
            result = new ArrayList<>();
            MongoCollection collection = service.getCollection(collectionName);
            List<Document> records = (List<Document>) collection
                    .find()
                    .limit(50)
                    .into(new ArrayList<Document>());
            records.forEach(item -> result.add(service.documentToJsonObject((Document) item)));
        } finally {
            service.closeConnection();
        }
        return result;
    }

    public final int getRecordsCountInCollection(String collection) {
        return getRecordsCountInCollection(collection, new BasicDBObject());
    }

    public final int getRecordsCountInCollection(String collection, BasicDBObject query) {
        int result;
        try {
            service.connectToMongo();
            result = (int) service.getCollection(collection).count(query);
        } finally {
            service.closeConnection();
        }
        return result;
    }
}
