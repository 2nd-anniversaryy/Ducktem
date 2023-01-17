package com.ducktem.ducktemapi.entity;

import java.util.Date;

public class ProductPreview {
    private Long productId;
    private String thumbNailImg;
    private String price;
    private String name;
    private Date regDate;
    private int salesStatusId;
    private int hit;
    private int status;

    private String nTimeAgo;

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getSalesStatusId() {
        return salesStatusId;
    }

    public void setSalesStatusId(int salesStatusId) {
        this.salesStatusId = salesStatusId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getThumbNailImg() {
        return thumbNailImg;
    }

    public void setThumbNailImg(String thumbNailImg) {
        this.thumbNailImg = thumbNailImg;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getStatus() {
    	return status;
    }
    
    
    public void setStatus(int status) {
    	this.status = status;
    }

    public String getNTimeAgo() {
        return nTimeAgo;
    }

    public void setNTimeAgo(String nTimeAgo) {
        this.nTimeAgo = nTimeAgo;
    }

    @Override
    public String toString() {
        return "ProductPreview{" +
                "thumbNailImg='" + thumbNailImg + '\'' +
                ", price='" + price + '\'' +
                ", name='" + name + '\'' +
                ", regDate='" + regDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }



	
}
