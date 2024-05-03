package dyds.act2.parte1;

public class SearchInfo {

  private String textToSeach;
  private String topic;
  private String baseURL;

  public SearchInfo(String textToSeach, String topic, String baseURL) {
    this.textToSeach = textToSeach;
    this.topic = topic;
    this.baseURL = baseURL; //in which wiki we should search
  }

  public String getTextToSeach() {
    return textToSeach;
  }

  public String getTopic() {
    return topic;
  }

  public String getBaseURL() {
      return baseURL;
  }
}
