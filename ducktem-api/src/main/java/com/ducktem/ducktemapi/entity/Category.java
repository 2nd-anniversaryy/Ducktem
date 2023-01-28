package com.ducktem.ducktemapi.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Category")
public class Category {

	//양방향 Mapping 준비
	// @OneToMany(mappedBy = "category")
	// private List<Product> productList = new ArrayList<>();
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;	// 대분류+소분류 전체 ID
	@ManyToOne
	@JoinColumn(name = "superCategoryId")
    private SuperCategory superCategory; //대분류 ID
    private String name;//소분류 이름


}
