package com.ducktem.ducktemapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "Member")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false, name = "userId")
	private String userId;
	@Column(unique = true, nullable = false, name = "nickName")
	private String nickName;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String pwd;
	@Column(nullable = false, name = "phoneNumber")
	private String phoneNumber;
	@Column(nullable = false)
	private String email;
	@Column(name = "profileImg")
	private String profileImg;
	private String intro;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "regDate")
	private String regDate;
	private float level;
	@Column(name = "CountryId")
	private Country country;
	private MemberStatus status;
	@Column(name = "autoLogin")
	private String autoLogin;
	@OneToOne
	@JoinColumn(name = "refreshTokenId")
	private RefreshToken refreshToken;

}
