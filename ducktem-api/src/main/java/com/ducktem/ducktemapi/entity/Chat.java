package com.ducktem.ducktemapi.entity;

public class Chat {
    private String senderId;

    private String chatMsg;
    private String regDate;

    public Chat() {

    }

    public Chat(String senderId, String chatMsg, String regDate) {
        this.chatMsg = chatMsg;
        this.senderId = senderId;
        this.regDate = regDate;
    }

    public String getChatMsg() {
        return chatMsg;
    }

    public void setChatMsg(String chatMsg) {
        this.chatMsg = chatMsg;
    }

    public String getSenderId() {
        return senderId;
    }
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
