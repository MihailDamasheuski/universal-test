package utils.splunk;

public enum SplunkFields {

    POOLING_INTERVAL_PARAM("poolingInterval"),
    WAIT_SEARCH_TIMEOUT_PARAM("waitSearchTimeout"),
    INDEX_PARAM("index"),
    SOURCE_PARAM("source"),
    SOURCE_TYPE_PARAM("sourceType"),
    EARLIEST_PARAM("earliest"),
    OUTPUT_MODE("output_mode"),
    USER_NAME_PARAM("username"),
    PASSWORD_PARAM("password"),
    HOST_PARAM("host"),
    PORT_PARAM("port");

    private String field;

    SplunkFields(String field){
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
