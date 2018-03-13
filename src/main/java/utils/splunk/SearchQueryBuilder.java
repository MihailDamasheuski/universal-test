package utils.splunk;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchQueryBuilder {

    private static final String DELIMETER = " ";
    private String searchQuery;

    private List<QueryPart> queryParts = new ArrayList<>();

    public SearchQueryBuilder(){
        this.searchQuery = "search ";
    }

    public SearchQueryBuilder(String query){
        this.searchQuery = query;
    }

    public SearchQueryBuilder with(String key, Object value){
        QueryPart part = new QueryPart(key, value);
        queryParts.add(part);
        return this;
    }

    public SearchQueryBuilder with(String value){
        searchQuery = searchQuery.concat(value).concat(DELIMETER);
        return this;
    }

    public String build(){
        return searchQuery.concat(queryParts.stream().map(QueryPart::toString).collect(Collectors.joining(DELIMETER)));
    }

    public static class QueryPart {

        private String key;
        private Object value;

        public QueryPart(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return this.key + value;
        }
    }

}
