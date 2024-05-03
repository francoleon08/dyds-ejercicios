package dyds.act2.parte1;

public class SearchQuery {

  private SearchInfo searchInfo;
  private BaseURL baseURL;

  public SearchQuery(SearchInfo searchInfo, BaseURL baseURL) {
    this.searchInfo = searchInfo;
    this.baseURL = baseURL;
  }

  public String getTextToSeach() {
    return searchInfo.getTextToSeach();
  }

  public String getTopic() {
    return searchInfo.getTopic();
  }

  public String getBaseURL() {
      return baseURL.getBaseURL();
  }
}
