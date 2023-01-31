package com.ducktem.ducktemapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
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
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;
}
