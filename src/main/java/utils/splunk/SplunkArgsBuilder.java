package utils.splunk;

import com.splunk.Args;

public class SplunkArgsBuilder {

    private static final int SEARCH_TIMEOUT = 300000;
    private static final int POOLING_INTERVAL = 5000;
    private static final String EARLIEST = "-10m";
    private static final String OUTPUT_MODE = "json";

    private Args args;

    public SplunkArgsBuilder() {
        this.args = new Args();
    }

    public SplunkArgsBuilder withIndex(String index){
        if(index != null) {
            args.add(SplunkFields.INDEX_PARAM.getField(), index);
        }
        return this;
    }

    public SplunkArgsBuilder withSource(String source){
        if(source != null) {
            args.add(SplunkFields.SOURCE_PARAM.getField(), source);
        }
        return this;
    }

    public SplunkArgsBuilder withSourceType(String sourceType){
        args.add(SplunkFields.SOURCE_TYPE_PARAM.getField(), sourceType);
        return this;
    }

    public SplunkArgsBuilder withSearchTimeOut(){
        args.add(SplunkFields.WAIT_SEARCH_TIMEOUT_PARAM.getField(), SEARCH_TIMEOUT);
        return this;
    }

    public SplunkArgsBuilder withPoolingInterval(){
        args.add(SplunkFields.POOLING_INTERVAL_PARAM.getField(), POOLING_INTERVAL);
        return this;
    }

    public SplunkArgsBuilder withEarliest(){
        args.add(SplunkFields.EARLIEST_PARAM.getField(), EARLIEST);
        return this;
    }

    public SplunkArgsBuilder withOutputMode(){
        args.add(SplunkFields.OUTPUT_MODE.getField(), OUTPUT_MODE);
        return this;
    }

    public Args build(){
        return args;
    }
}
