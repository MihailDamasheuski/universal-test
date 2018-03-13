package utils.mongo;

public enum MongoCollections {

    NA("news_article"),
    TC("taxonomy_config");

    String collection;

    MongoCollections(String collection) {
        this.collection = collection;
    }

    public String getCollection() {
        return collection;
    }

    public static String getCollectionByGuid(String guid){
        for(MongoCollections collection : MongoCollections.values()){
            if(collection.name().equalsIgnoreCase(collectionPrefix(guid))){
                return collection.getCollection();
            }
        }
        return null;
    }

    private static String collectionPrefix(String guid){
        return guid.substring(2,4);
    }
}
