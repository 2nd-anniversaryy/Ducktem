package com.ducktem.ducktemapi.entity;

import java.util.Date;

public class MyPageReview {
	
    private String profileImg;
	private String productName;
	private String memberId;
	private String content;
    private Date regDate;
    
	/**
	 * @return the profileImg
	 */
	public String getProfileImg() {
		return profileImg;
	}
	/**
	 * @param profileImg the profileImg to set
	 */
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the regDate
	 */
	public Date getRegDate() {
		return regDate;
	}
	/**
	 * @param regDate the regDate to set
	 */
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public MyPageReview(String profileImg, String productName, String memberId, String content, Date regDate) {
		this.profileImg = profileImg;
		this.productName = productName;
		this.memberId = memberId;
		this.content = content;
		this.regDate = regDate;
	}

    
}
