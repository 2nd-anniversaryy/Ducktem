package com.ducktem.ducktemapi.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ducktem.ducktemapi.dto.request.ProductRegisterRequest;
import com.ducktem.ducktemapi.dto.response.ProductDetailResponse;
import com.ducktem.ducktemapi.dto.response.ProductPreviewResponse;
import com.ducktem.ducktemapi.dto.response.WishListResponse;
import com.ducktem.ducktemapi.entity.Product;
import com.ducktem.ducktemapi.repository.ProductRepository;
import com.ducktem.ducktemapi.service.ProductImageService;
import com.ducktem.ducktemapi.service.ProductService;
import com.ducktem.ducktemapi.service.ProductTagService;
import com.ducktem.ducktemapi.service.SearchService;
import com.ducktem.ducktemapi.service.WishListService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {

	private final ProductService productservice;
	private final ProductImageService productImageService;
	private final ProductTagService productTagService;

	private final WishListService wishListService;
	// /products?p=1&s=15
	private final SearchService searchService;

	@GetMapping
	public List<ProductPreviewResponse> getList(@PageableDefault(size = 20) Pageable pageable,
		Authentication authentication) {
		List<ProductPreviewResponse> ProductPreviewResponseList = productservice.getList(pageable);

		if (authentication != null) {
			List<WishListResponse> userWishList = wishListService.getList(authentication.getName());
			List<ProductPreviewResponse> resultList = wishListService.confirmWishStatus(ProductPreviewResponseList,
				userWishList);
			ProductPreviewResponseList = resultList;
		}

		return ProductPreviewResponseList;
	}

	@GetMapping("filter")
	@Transactional
	public Map<String, Object> getList(
		@PageableDefault(size = 20) Pageable pageable,
		@RequestParam(name = "q", defaultValue = "") String query,
		@RequestParam(name = "c", defaultValue = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15") Integer[] category,
		@RequestParam(name = "f", defaultValue = "최신순") String filter,
		Authentication authentication
	) {
		Map<String, Object> searchResultByCategory = new HashMap<>();

		Long countResult = searchService.getCountByQuery(query, category);
		searchResultByCategory.put("countResult", countResult);

		switch (filter) {
			case "최신순" -> {
				List<ProductPreviewResponse> productResult = searchService.getListByCategoryAndSearch(pageable, query,
					category);
				searchResultByCategory.put("productResult", productResult);
			}
			case "높은가격순" -> {
				List<ProductPreviewResponse> productResultByPriceDesc = searchService.getListByCategoryAndSearchOrderByPriceDesc(
					pageable, query, category);
				searchResultByCategory.put("productResult", productResultByPriceDesc);
			}
			case "낮은가격순" -> {
				List<ProductPreviewResponse> productResultByPrice = searchService.getListByCategoryAndSearchOrderByPrice(
					pageable, query, category);
				searchResultByCategory.put("productResult", productResultByPrice);
			}
			case "인기상품순" -> {
				List<ProductPreviewResponse> productResultByHit = searchService.getListByCategoryAndSearchOrderByHit(
					pageable, query, category);
				searchResultByCategory.put("productResult", productResultByHit);
			}
		}

		if (authentication != null) {
			List<WishListResponse> userWishList = wishListService.getList(authentication.getName());
			List<ProductPreviewResponse> resultList = wishListService.confirmWishStatus(
				(List<ProductPreviewResponse>)searchResultByCategory.get("productResult"),
				userWishList);
			//			List<ProductPreviewResponse> resultList = wishListService.confirmWishStatus(
			//					(List<ProductPreviewResponse>) searchResultByCategory.values().stream().toList().get(0),
			//					userWishList);

			if (filter != null) {
				searchResultByCategory.put("productResult", resultList);
			} else {
				searchResultByCategory.put("countResult", resultList);
			}
		}

		return searchResultByCategory;
	}

	// /products/2
	@GetMapping("{id}")
	public ProductDetailResponse get(@PathVariable Long id, Authentication authentication) {
		ProductDetailResponse productDetailResponse = productservice.get(id);
		if (authentication != null) {
			List<WishListResponse> list = wishListService.getList(authentication.getName());
			List<ProductPreviewResponse> otherProducts = productDetailResponse.getOtherProducts();
			productDetailResponse.setOtherProducts(wishListService.confirmWishStatus(otherProducts, list));
			if (list.stream().anyMatch(l -> l.getProductId().equals(productDetailResponse.getId()))) {
				productDetailResponse.setWishStatus(1);
			}
		}
		return productDetailResponse;
	}

	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<Void> add(ProductRegisterRequest request, Authentication authentication,@RequestPart MultipartFile[] files) {

		String regMemberId = authentication.getName();
		Product product = productservice.add(request, regMemberId);
		productImageService.add(files, product);
		productTagService.add(request.getTagNames(), product);

		return ResponseEntity.created(URI.create("/products/" + product.getId().toString())).build();
	}

	@PutMapping("{id}")
	// @Transactional
	public ResponseEntity<Void> update(@PathVariable Long id, ProductRegisterRequest request, @RequestPart MultipartFile[] files) {
		Product product = productservice.update(request, id);
		productImageService.add(files, product);
		productTagService.add(request.getTagNames(), product);

		return ResponseEntity.created(URI.create("/products/" + product.getId().toString())).build();
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id){
		productservice.delete(id);
		Product product = null;
		// //tag랑 img도 삭제해야
	}

	// 아래 URL 고민해봐야...

	@DeleteMapping("editImg/{imgId}")//이미지 삭제
	public void deleteImage(@PathVariable Long id){
		productImageService.delete(id);
	}

	@DeleteMapping("editTag/{tagId}")//태그 삭제
	public void deleteTag(@PathVariable Long id){
		productTagService.delete(id);
	}

	@PutMapping("{id}/{status}")//상품 상태 변경
	public void updateStatus(@PathVariable(name = "id") Long id, @PathVariable(name = "status") String status){
		productservice.updateStatus(id, status);
	}
	@GetMapping("/me")
	public ResponseEntity<List<ProductPreviewResponse>> mySellProductList(Authentication authentication) {
		return new ResponseEntity<>(productservice.productList(authentication.getName()), HttpStatus.OK);

	}

	@GetMapping("/wish")
	public ResponseEntity<List<ProductPreviewResponse>> myWishProductList(Authentication authentication) {
		List<ProductPreviewResponse> list = wishListService.getMyWishList(authentication.getName());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}