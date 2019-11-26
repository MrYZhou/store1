package com.lar.store.pojo;

public class Status {
    int flag=0;//0成功，1错误
    String message;

    public Status() {
    }

    public Status(int flag) {
        this.flag = flag;
    }

    public Status(int flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
