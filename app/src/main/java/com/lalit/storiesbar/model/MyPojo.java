package com.lalit.storiesbar.model;

public class MyPojo {
    private String code;

    private Data[] data;

    private String message;

    private String status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ClassPojo [code = " + code + ", data = " + data + ", message = " + message + ", status = " + status + "]";
    }
}
