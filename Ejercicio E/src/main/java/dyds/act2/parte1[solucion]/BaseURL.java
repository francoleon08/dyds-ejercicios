package dyds.act2.parte1;

public class BaseURL {
    private String baseURL;

    public BaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getBaseURL() {
        return "https://"+ baseURL + "/w/api.php?action=query&format=json&list=search&srsearch=";
    }
}
