package dyds.act2.parte1;

public class SearchInfo {
    private String textToSeach;
    private String topic;

    public SearchInfo(String textToSeach, String topic) {
        this.textToSeach = textToSeach;
        this.topic = topic;
    }

    public String getTextToSeach() {
        return textToSeach;
    }

    public String getTopic() {
        return topic;
    }
}
