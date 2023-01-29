package com.ducktem.ducktemapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class MemberInfoRequest {
	private String nickName;
	private String intro;
	private String email;
	private String profileUrl;
}
