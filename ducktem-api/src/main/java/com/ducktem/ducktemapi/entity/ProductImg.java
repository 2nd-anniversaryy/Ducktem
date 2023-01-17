package com.ducktem.ducktemapi.entity;

public class ProductImg {
    private String name;

    private Long productId;
    private byte thumbNail;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getThumbNail() {
        return thumbNail;
    }

    public void setThumbnail(byte thumbNail) {
        this.thumbNail = thumbNail;
    }
}
