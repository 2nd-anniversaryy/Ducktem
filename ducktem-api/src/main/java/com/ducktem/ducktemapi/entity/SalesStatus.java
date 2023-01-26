package com.ducktem.ducktemapi.entity;

public enum SalesStatus {
	ON("ON"),
	Completion("Completion"),
	Reserve("Reserve");
	private final String status;

	SalesStatus(String status) {
		this.status=status;
	}

}
