package com.ducktem.ducktemapi.dto.response;

import com.ducktem.ducktemapi.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberInfoResponse {
	private String nickName;
	private String intro;
	private String email;
	private String profileUrl;

	public static MemberInfoResponse from(Member member) {
		return MemberInfoResponse.builder()
			.nickName(member.getNickName())
			.intro(member.getIntro())
			.email(member.getEmail())
			.profileUrl(member.getProfileImg())
			.build();
	}
}
