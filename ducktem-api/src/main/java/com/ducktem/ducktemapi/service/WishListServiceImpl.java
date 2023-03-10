package com.ducktem.ducktemapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ducktem.ducktemapi.dto.response.ProductPreviewResponse;
import com.ducktem.ducktemapi.dto.response.WishListResponse;
import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.entity.Product;
import com.ducktem.ducktemapi.entity.WishList;
import com.ducktem.ducktemapi.exception.MemberException;
import com.ducktem.ducktemapi.exception.ProductException;
import com.ducktem.ducktemapi.repository.MemberRepository;
import com.ducktem.ducktemapi.repository.ProductRepository;
import com.ducktem.ducktemapi.repository.WishListRepository;
import com.ducktem.ducktemapi.util.TimeFormatter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class WishListServiceImpl implements WishListService {

	private final WishListRepository wishListRepository;
	private final MemberRepository memberRepository;
	private final ProductRepository productRepository;

	@Override
	public List<WishListResponse> getList(String memberId) {
		Member member = memberRepository.findByUserId(memberId).orElseThrow(() -> new MemberException("잘못된 접근입니다."));
		return member.getMemberWishProducts().stream().map(WishListResponse::from).toList();
	}

	@Override
	public List<ProductPreviewResponse> confirmWishStatus(List<ProductPreviewResponse> tempProductPeviewResponseList,
		List<WishListResponse> userWishList) {

		for (int i = 0; i < tempProductPeviewResponseList.size(); i++) {
			for (int j = 0; j < userWishList.size(); j++) {
				if (tempProductPeviewResponseList.get(i).getProductId() == userWishList.get(j).getProductId())
					tempProductPeviewResponseList.get(i).setWishStatus(1);
			}
		}
		List<ProductPreviewResponse> withWishStatusList = tempProductPeviewResponseList;

		return withWishStatusList;
	}

	//    @Override
	//    public int confirmWishStatus(Long productId, String memberId) {
	//        Optional<Member> member = memberRepository.findByUserId(memberId);
	//        Optional<Product> product = productRepository.findById(productId);
	//
	//        List<WishList> wishList = wishListRepository.findByProductAndMember(product.get(), member.get());
	//
	//        if (wishList != null)
	//            return 1;
	//        else
	//            return 0;
	//    }

	@Override
	public void add(Long productId, String memberId) {
		Member member = memberRepository.findByUserId(memberId).orElseThrow(() -> new MemberException("error"));
		Product product = productRepository.findById(productId).orElseThrow(() -> new ProductException("error"));
		wishListRepository.save(
			WishList.builder().member(member).product(product).regDate(TimeFormatter.NOW()).build());
	}

	@Override
	public void delete(Long productId, String memberId) {
		Member member = memberRepository.findByUserId(memberId).orElseThrow(() -> new MemberException("error"));
		Product product = productRepository.findById(productId).orElseThrow(() -> new ProductException("error"));

		wishListRepository.delete(wishListRepository.findByProductAndMember(product, member));
	}

	@Override
	public List<ProductPreviewResponse> getMyWishList(String name) {
		Member member = memberRepository.findByUserId(name).orElseThrow(() -> new MemberException("회원 오류"));
		List<ProductPreviewResponse> productPreviewResponses = wishListRepository.findByMember(member)
			.stream()
			.map(WishList::getProduct)
			.map(ProductPreviewResponse::from)
			.toList();

		// 시연을 위해 급하게 추가하는 코드 wish 전체적인 수정이 필요함.
		productPreviewResponses.forEach(preview -> preview.setWishStatus(1));
		return productPreviewResponses;
	}
}
