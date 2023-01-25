package com.ducktem.ducktemapi.entity;

import lombok.Getter;

@Getter
public enum MemberStatus {
	ENABLE("Enable"),
	DISABLE("Disable");
	private final String status;

	MemberStatus(String status) {
		this.status=status;
	}
}
