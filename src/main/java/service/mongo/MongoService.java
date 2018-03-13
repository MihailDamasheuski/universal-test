package service.mongo;


import com.google.gson.*;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import utils.mongo.MongoCollections;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MongoService {

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private MongoCredential mongoCredential;
    private MongoClientOptions clientOptions;
    private ServerAddress serverAddress;
    private String databaseName;
    private String userName;
    private String userPassword;
    private String databaseAddress;
    private int databasePort;
    private static final String ID_FIELD = "_id";
    private static final long SECOND = 1000;
    private static final long WAIT_TIMEOUT = 10000;

    private MongoService() {
    }

    public MongoService(String databaseName, String userName, String userPassword, String databaseAddress, int databasePort) {
        this.databaseName = databaseName;
        this.userName = userName;
        this.userPassword = userPassword;
        this.databaseAddress = databaseAddress;
        this.databasePort = databasePort;
    }

    public void connectToMongo() {
        this.mongoCredential = MongoCredential.createCredential(userName, databaseName, userPassword.toCharArray());
        this.serverAddress = new ServerAddress(databaseAddress, databasePort);
        this.clientOptions = MongoClientOptions.builder().build();
        this.mongoClient = new MongoClient(Collections.singletonList(serverAddress), mongoCredential, clientOptions);
        this.mongoDatabase = mongoClient.getDatabase(databaseName);
    }

    public boolean isRecordExist(String id) {
        String collectionName = getCollectionName(id);
        if (collectionName == null) {
            return false;
        }
        MongoCollection collection = mongoDatabase.getCollection(collectionName);
        Document document = (Document) collection.find(Filters.eq(ID_FIELD, id)).first();
        return document != null;
    }

    public JsonObject waitFor(String guid, Boolean condition) {
        long timeStamp = 0;
        while (timeStamp <= WAIT_TIMEOUT) {
            if (condition) {
                return getObjectById(guid);
            }
            try {
                Thread.sleep(SECOND);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timeStamp += SECOND;
        }
        return null;
    }

    public JsonObject getObjectById(String id) {
        String collectionName = getCollectionName(id);
        if (!collectionExists(collectionName)) {
            return null;
        }
        MongoCollection collection = mongoDatabase.getCollection(collectionName);
        BasicDBObject query = new BasicDBObject();
        query.put(ID_FIELD, id);
        Document document = (Document) collection.find(query).first();
        if (document == null) {
            System.out.println("No document with _id: " + id + " found in collection " + collectionName);
            return null;
        }
        return documentToJsonObject(document);
    }

    public JsonObject queryDBForJsonObject(String collectionName, BasicDBObject query) {
        Document document = queryDBForDocument(collectionName, query);
        return document != null ? documentToJsonObject(document) : null;
    }

    private Document queryDBForDocument(String collectionName, BasicDBObject query) {
        MongoCollection collection = mongoDatabase.getCollection(collectionName);
        Document document = null;
        if (collectionExists(collectionName)) {
            document = (Document) collection.find(query).first();
            if (document == null) {
                System.out.println("No document found in collection with query: " + query.toString());
            }
        } else {
            System.out.println("No collection found with name " + collectionName);
        }
        return document;
    }

    public JsonArray queryDBForJsonArray(String collectionName, BasicDBObject query) {
        JsonArray result = new JsonArray();
        MongoCollection collection = mongoDatabase.getCollection(collectionName);
        if (collectionExists(collectionName)) {
            collection.find(query).forEach((Block<Document>)
                    document -> result.add(documentToJsonObject(document)));
        } else {
            System.out.println("No collection found with name " + collectionName);
        }
        return result.size() != 0 ? result : null;
    }

    public MongoCollection getCollection(String collectionName) {
        if (!collectionExists(collectionName)) {
            return null;
        }
        return mongoDatabase.getCollection(collectionName);
    }

    private boolean collectionExists(String collectionName) {
        return mongoDatabase.listCollectionNames()
                .into(new ArrayList<>()).contains(collectionName);
    }

    public JsonObject documentToJsonObject(Document document) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateTypeAdapter()).create();
        return gson.toJsonTree(document).getAsJsonObject();
    }

    private String getCollectionName(String guid) {
            return MongoCollections.getCollectionByGuid(guid);
    }

    public void closeConnection() {
        this.mongoClient.close();
    }

    final class DateTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
        private final DateFormat dateFormat;

        DateTypeAdapter() {
            this.dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
            this.dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        public synchronized Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            try {
                return this.dateFormat.parse(jsonElement.getAsString());
            } catch (ParseException exception) {
                throw new JsonParseException(exception.getCause());
            }
        }

        public synchronized JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(this.dateFormat.format(date));
        }

    }
}
