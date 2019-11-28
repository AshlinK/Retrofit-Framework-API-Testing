package main.java.com.api.dto;

public class AnswerRequest {

    private String id;
    private int order;
    private String value;

    public void setId(String id) {
        this.id = id;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public int getOrder() {
        return order;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
