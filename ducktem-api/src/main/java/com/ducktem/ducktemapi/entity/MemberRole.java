package com.ducktem.ducktemapi.entity;

import lombok.Getter;

@Getter
public enum MemberRole {
	MEMBER("ROLE_MEMBER");
	private String role;

	MemberRole(String role){
		this.role = role;
	}
}
