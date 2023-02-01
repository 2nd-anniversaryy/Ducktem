package com.ducktem.ducktemapi.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@Entity
@Table(name = "WishList")
public class WishList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "productId")
	private Product product;
	@ManyToOne
	@JoinColumn(referencedColumnName = "userId", name = "memberId")
	private Member member;
	private Date regDate;
}
