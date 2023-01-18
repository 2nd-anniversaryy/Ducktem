package com.ducktem.ducktemapi.entity;

public class Buy {
	private Long productId;
	private String memberId;
	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
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
	public Buy(Long productId, String memberId) {

		this.productId = productId;
		this.memberId = memberId;
	}
	
}
