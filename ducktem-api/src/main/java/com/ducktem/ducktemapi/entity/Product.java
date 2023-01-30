package com.ducktem.ducktemapi.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private Long price;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false, name = "conditionName")
	private String condition;
	@Column(name = "deliveryType")
	private String deliveryType;
	private int hit;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "regDate")
	private String regDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updateDate")
	private String updateDate;
	@OneToMany(mappedBy = "product")
	List<Tag> tag = new ArrayList<>();
	//프로덕트 이미지와 양방향 관계 설정.
	@OneToMany(mappedBy = "product")
	private List<ProductImage> productImageList;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId")
	private Category category;
	@ManyToOne
	@JoinColumn(referencedColumnName = "userId", name = "regMemberId")
	private Member member;
	@Enumerated(EnumType.STRING)
	private SalesStatus salesStatus;

	public void setMember(Member member) {
		this.member = member;
		if(!member.getProductList().contains(this)) {
			member.getProductList().add(this);
		}
	}
}

