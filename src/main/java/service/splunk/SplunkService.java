package service.splunk;

import com.splunk.*;
import utils.splunk.SplunkFields;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplunkService {

    private Service splunkService;
    private String splunkHost;
    private int splunkPort;
    private String splunkUsername;
    private String splunkPassword;

    public SplunkService(String splunkHost, int splunkPort, String splunkUsername, String splunkPassword) {
        this.splunkHost = splunkHost;
        this.splunkPort = splunkPort;
        this.splunkUsername = splunkUsername;
        this.splunkPassword = splunkPassword;

    }

    public void connectToSplunk() {
        Map<String, Object> splunkConnectionParams = new HashMap<>();
        splunkConnectionParams.put(SplunkFields.HOST_PARAM.getField(), splunkHost);
        splunkConnectionParams.put(SplunkFields.PORT_PARAM.getField(), splunkPort);
        splunkConnectionParams.put(SplunkFields.USER_NAME_PARAM.getField(), splunkUsername);
        splunkConnectionParams.put(SplunkFields.PASSWORD_PARAM.getField(), splunkPassword);
        splunkService = new Service(splunkConnectionParams);
    }

    public List<Map<String, String>> executeSearchRequest(String query, Args searchArgs, Args outputArguments) {
        HttpService.setSslSecurityProtocol(SSLSecurityProtocol.TLSv1_2);
        connectToSplunk();
        Job job = splunkService.getJobs().create(query, searchArgs);

        while (!job.isDone()){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }

        InputStream stream = job.getResults(outputArguments);
        return parseInputStream(stream);
    }

    private List<Map<String, String>> parseInputStream(InputStream stream){
        List<Map<String, String>> result = null;
        try {
            ResultsReaderJson resultsReaderJson = new ResultsReaderJson(stream);
            result = new ArrayList<>();
            for (Event event : resultsReaderJson) {
                result.add(new HashMap<>(event));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
