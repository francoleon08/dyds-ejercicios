package dyds.act2.parte1.utils;

import dyds.act2.parte1.SearchQuery;

public class URLBuilder {

    private static final String SPACE_ENCODED = "%20";
    private static final String QUOTE_ENCODED = "%22";

    public static String buildUrl(SearchQuery searchQuery) {
        String url = searchQuery.getBaseURL() + searchQuery.getTextToSeach();
        if(hasTopic(searchQuery))
            url +=" articletopic%3A\"" + searchQuery.getTopic() + "\"";
        return encodeUrl(url);
    }

    private static boolean hasTopic(SearchQuery searchQuery) {
        String topic = searchQuery.getTopic();
        return topic != null && topic != "";
    }

    private static String encodeUrl(String url) {
        return url.replace(" ", SPACE_ENCODED).replace("\"", QUOTE_ENCODED);
    }
}
