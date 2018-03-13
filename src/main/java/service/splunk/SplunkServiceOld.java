package service.splunk;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import com.splunk.Args;
import com.splunk.Event;
import com.splunk.ResultsReaderXml;
import com.splunk.Service;

public class SplunkServiceOld {

    private final static List<String> LOCAL_SPLUNK_ENVS = Arrays.asList("LOCAL", "SANDBOX");

    private static final String SEARCH_QUERY_PATTERN = "search %s";

    private static final String SOURCE_PATTERN = " source=%s";

    private static final String INDEX_PATTERN = "index=%s ";

    private static final String SOURCETYPE_PATTERN = " sourcetype=%s";

    public static final String QUERY_PART_DELIMITER = " ";

    private static final String RAW_LOG_ENTRY = "_raw";

    private static final Map<String, Object> SPLUNK_OUTPUT_MODE = Collections.singletonMap("output_mode",
            (Object) "xml");

    private final static int SECOND = 1000;

    private final static int MAX_TIMEOUT = 40000;

    private final static int POOLING_INTERVAL = 500;

    public static final String POOLING_INTERVAL_PARAM = "poolingInterval";

    public static final String WAIT_SEARCH_TIMEOUT_PARAM = "waitSearchTimeout";

    public static final String INDEX_PARAM = "index";

    public static final String SOURCE_PARAM = "source";

    public static final String SOURCE_TYPE_PARAM = "sourceType";

    public static final String USER_NAME_PARAM = "username";

    public static final String PASSWORD_PARAM = "password";

    public static final String HOST_PARAM = "host";

    public static final String PORT_PARAM = "port";

    public static final String EARLIEST_PARAM = "earliest";

    private static String index;

    private static String envName;

    private final Service splunkService;

    private int splunkPollingInterval = POOLING_INTERVAL;

    private int waitSearchTimeout = MAX_TIMEOUT;

    private String indexFilter;

    private String sourceFilter;

    private String sourceTypeFilter;

    private SplunkServiceOld(final Service service, Map<String, Object> args) {
        this.splunkService = service;

        if (args.containsKey(POOLING_INTERVAL_PARAM)) {
            splunkPollingInterval = (Integer) args.get(POOLING_INTERVAL_PARAM);
        }
        if (args.containsKey(WAIT_SEARCH_TIMEOUT_PARAM)) {
            waitSearchTimeout = (Integer) args.get(WAIT_SEARCH_TIMEOUT_PARAM);
        }
        if (args.containsKey(INDEX_PARAM)) {
            indexFilter = (String) args.get(INDEX_PARAM);
        }
        if (args.containsKey(SOURCE_PARAM)) {
            sourceFilter = (String) args.get(SOURCE_PARAM);
        }
        if (args.containsKey(SOURCE_TYPE_PARAM)) {
            sourceTypeFilter = (String) args.get(SOURCE_TYPE_PARAM);
        }
    }


    private static String getIndexFilter(String specificEnvIndex) {
        if (StringUtils.isNotBlank(specificEnvIndex)) {
            return String.format(INDEX_PATTERN, specificEnvIndex);
        }
        return "";
    }

    private static String getSourceFilter(String source) {
        if (StringUtils.isNotBlank(source)) {
            return String.format(SOURCE_PATTERN, source);
        }
        return "";
    }

    private static String getSourcetypeFilter(String sourceType) {
        if (StringUtils.isNotBlank(sourceType)) {
            return String.format(SOURCETYPE_PATTERN, sourceType);
        }
        return "";
    }

    private static String getQueryString(String query) {
        if (StringUtils.isNotBlank(query)) {
            return String.format(SEARCH_QUERY_PATTERN, query);
        }
        return "";
    }

    public static SplunkServiceOld connectToSplunk(Map<String, Object> args) {
        Service connection = Service.connect(args);
        return new SplunkServiceOld(connection, args);
    }

    public List<Map<String, String>> search(String query) {
        return search(splunkService, getIndexFilter(indexFilter) + QUERY_PART_DELIMITER + query + getSourceFilter(sourceFilter)
                + getSourcetypeFilter(sourceTypeFilter));
    }

    private static List<Map<String, String>> search(Service service, String query) {
        String fullQuery = getQueryString(query);
        return retrieveOneshotSearchResults(service.oneshotSearch(fullQuery, new Args(SPLUNK_OUTPUT_MODE)));
    }

    public List<Map<String, String>> getAllLogsForGivenKey(String key, String... filters) {
        return getAllLogsForGivenKey(-1, key, filters);
    }

    public static List<String> oneshotSearch(Service service, String query, String log) {
        Map<String, Object> searchParams = new HashMap<>();
        if (null != envName && !LOCAL_SPLUNK_ENVS.contains(envName)) {
            searchParams.put(INDEX_PARAM, index);
        }
        searchParams.put(SOURCE_PARAM, "*" + log);

        String[] parts = query.split(QUERY_PART_DELIMITER);
        int secondPartIndex = query.indexOf(parts[1]) + parts[1].length() + QUERY_PART_DELIMITER.length();
        String[] otherQueryParts = new String[0];
        if (secondPartIndex < query.length()) {
            otherQueryParts = new String[] { query.substring(secondPartIndex) };
        }
        List<Map<String, String>> results = new SplunkServiceOld(service, searchParams).getAllLogsForGivenKey(parts[1],
                otherQueryParts);
        return getRawLogEntriesFromResponse(results);
    }

    public static List<String> getRawLogEntriesFromResponse(List<Map<String, String>> response) {
        if (null == response) {
            return null;
        }
        List<String> result = new ArrayList<>(response.size());
        for (Map<String, String> entry : response) {
            result.add(entry.get(RAW_LOG_ENTRY));
        }
        return result;
    }

    public List<Map<String, String>> getAllLogsForGivenKey(int recordsNumber, String key, String... filters) {
        StringBuilder waitQueryBuilder = new StringBuilder(key);
        if (filters != null) {
            for (String part : filters) {
                waitQueryBuilder.append(QUERY_PART_DELIMITER);
                waitQueryBuilder.append(part);
            }
        }
        String query = waitQueryBuilder.toString();

        List<Map<String, String>> results = waitSearch(query);
        if (null == results) {
            throw new IllegalStateException("Splunk result waiting timeout, target query: " + query);
        }
        results = waitSearch(recordsNumber, key);
        for (Map<String, String> result : results) {
        }
        return results;
    }

    public List<Map<String, String>> waitSearch(final String query) {
        return waitSearch(-1, query);
    }

    public List<Map<String, String>> waitSearch(final int recordsNumber, final String query) {
        boolean isExpectedSize = false;
        long end = System.currentTimeMillis() + waitSearchTimeout;

        do {
            List<Map<String, String>> result = search(query);
            isExpectedSize = recordsNumber >= 0 ? result.size() == recordsNumber : result.size() > 0;
            if (result != null && isExpectedSize) {
                return result;
            }
            sleep();
        } while (System.currentTimeMillis() < end);
        return null;
    }

    private void sleep() {
        try {
            Thread.sleep(splunkPollingInterval);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    private static List<Map<String, String>> retrieveOneshotSearchResults(InputStream searchResults) {
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();

        try {
            ResultsReaderXml outputReader = new ResultsReaderXml(searchResults);
            for (Event event : outputReader) {
                result.add(new HashMap<String, String>(event));
            }
            outputReader.close();
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read Splunk response.", e);
        }
        return result;
    }

}
