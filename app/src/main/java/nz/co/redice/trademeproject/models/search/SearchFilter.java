package nz.co.redice.trademeproject.models.search;

import java.util.Map;

public class SearchFilter {

    Map <String, String> queryParameters;

    public Map<String, String> getQueryParameters() {
        return queryParameters;
    }

    public void setQueryParameters(Map<String, String> queryParameters) {
        this.queryParameters = queryParameters;
    }
}
