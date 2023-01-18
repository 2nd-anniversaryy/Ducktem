package com.ducktem.ducktemapi.entity;

public class ChatRoom {
    private Long id;
    private String sellerId;
    private String customerId;
    private String chatting;
    private Long productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getChatting() {
        return chatting;
    }

    public void setChatting(String chatting) {
        this.chatting = chatting;
    }

    @Override
    public String toString() {
        return "ChatRoom{" +
                "id=" + id +
                ", sellerId='" + sellerId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", productId=" + productId +
                '}';
    }
}
