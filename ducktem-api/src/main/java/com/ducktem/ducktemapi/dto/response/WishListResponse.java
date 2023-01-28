package com.ducktem.ducktemapi.dto.response;

import com.ducktem.ducktemapi.entity.WishList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WishListResponse {
    private Long productId;
    private String memberId;

    public static WishListResponse from(WishList wishList){
        return WishListResponse.builder()
                .productId(wishList.getProduct().getId())
                .memberId(wishList.getMember().getUserId())
                .build();
    }

}
