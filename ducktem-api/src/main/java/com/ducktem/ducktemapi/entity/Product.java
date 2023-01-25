package com.ducktem.ducktemapi.entity;

import java.util.Date;

import org.hibernate.resource.beans.internal.FallbackBeanInstanceProducer;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private String price;
	@Column(nullable = false)
	private String description;
	// @Column(nullable = false)
	// private String condition;
	@Column(name = "deliveryType")
	private String deliveryType;
	private int hit;
	// private String tag;
	// @Temporal(TemporalType.TIMESTAMP)
	// @Column(nullable = true)
	// private Date regDate;
	// @ManyToOne
	// @JoinColumn(name = "categoryId")
	// private Category category;
	@ManyToOne
	@JoinColumn(referencedColumnName = "userId", name = "regMemberId")
	@JsonBackReference
	private Member member;
	// @Enumerated(EnumType.STRING)
	// private SalesStatus salesStatus;
 
 }

