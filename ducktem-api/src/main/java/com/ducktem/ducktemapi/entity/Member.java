package com.ducktem.ducktemapi.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	@Column(unique = true, nullable = false)
	private String userId;
	@Column(unique = true, nullable = false)
	private String nickName;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String pwd;
	@Column(nullable = false)
	private String phoneNumber;
	@Column(nullable = false)
	private String email;
	private String profileImg;
	private String intro;
	@Temporal(TemporalType.TIMESTAMP)
	private String regDate;
	private float level;
	@Enumerated(EnumType.STRING)
	private MemberStatus status;
	@OneToMany(mappedBy = "member")
	private List<Product> productList = new ArrayList<>();

}
