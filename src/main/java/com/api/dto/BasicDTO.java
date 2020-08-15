package main.java.com.api.dto;

public class BasicDTO<T> {
    private T[] data;
    private T message;


    public T[] getData() {
        return data;
    }

    public void setData(T[] data) {
        this.data = data;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

}
