package utils.splunk;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.splunk.Args;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import service.splunk.SplunkService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.splunk.EventFields.*;

public class SplunkUtils {

    private static final long SECOND = 1000;
    private static final long WAIT_TIMEOUT = 10000;

    @Autowired
    private SplunkService service;
    private String index;
    private String source;

    public SplunkUtils(SplunkService service, String index, String source) {
        this.service = service;
        this.index = index;
        this.source = source;
    }

    public JsonObject getScmObjectFromSplunk(String guid) {
        SearchQueryBuilder builder = new SearchQueryBuilder();
        String query = builder.with(guid).with(SCM_COMPLETE.getField()).build();
        return getEventContent(getEventItems(service.executeSearchRequest(query, constructSearchArgs(),
                constructOutputArgs())));
    }

    public Map<String, String> getErrorMessageFromSplunk(String query){
        SearchQueryBuilder builder = new SearchQueryBuilder(query);
        String searchQuery = builder.with(EVENT_LOG_SEVERITY.getField(), EVENT_SEVERITY_ERROR.getField()).build();
        return getEventItems(service.executeSearchRequest(searchQuery, constructSearchArgs(), constructOutputArgs()));
    }

    public Map<String, String> getWarnMessageFromSplunk(String query){
        SearchQueryBuilder builder = new SearchQueryBuilder(query);
        String searchQuery = builder.with(EVENT_LOG_SEVERITY.getField(), EVENT_SEVERITY_WARN.getField()).build();
        return getEventItems(service.executeSearchRequest(searchQuery, constructSearchArgs(), constructOutputArgs()));
    }

    public void waitForEvent(String query){
        waitFor(service.executeSearchRequest(query, constructSearchArgs(), constructOutputArgs()) != null);
    }

    private static Map<String, String> getEventItems(List<Map<String, String>> response) {
        String rawData = response.get(0).get(EVENT_RAW.getField());
        String[] parts = rawData.split(EVENT_PARTS_DELIMETER.getField());
        Map<String, String> result = new HashMap<>();
        result.put(EVENT_LOG_TIMESTAMP.getField(), parts[0]);
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            String[] pair = part.trim().split(EVENT_EQUAL.getField());
            result.put(pair[0], String.valueOf(pair[1]));
        }
        return result;
    }

    private static JsonObject getEventContent(Map<String, String> items) {
        JsonParser parser = new JsonParser();
        return parser.parse(items.get(EVENT_LOG_CONTENT.getField())).getAsJsonObject();
    }

    private Args constructSearchArgs() {
        SplunkArgsBuilder builder = new SplunkArgsBuilder();
        return builder.withIndex(StringUtils.isNotBlank(index) ? index : null)
                .withSearchTimeOut()
                .withPoolingInterval()
                .withEarliest()
                .withSource(StringUtils.isNotBlank(source) ? source : null)
                .build();
    }

    private Args constructOutputArgs() {
        SplunkArgsBuilder builder = new SplunkArgsBuilder();
        return builder.withOutputMode().build();
    }

    public JsonObject waitFor(Boolean condition) {
        long timeStamp = 0;
        while (timeStamp <= WAIT_TIMEOUT) {
            if(condition){
                break;
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
}
