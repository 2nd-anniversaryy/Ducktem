package com.ducktem.ducktemapi.service;

import com.ducktem.ducktemapi.dto.response.WishListResponse;
import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.repository.MemberRepository;
import com.ducktem.ducktemapi.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class WishListServiceImpl implements WishListService{

    private final WishListRepository wishListRepository;
    private final MemberRepository memberRepository;

    @Override
    public List<WishListResponse> getList(String memberId) {
        System.out.println(memberId);
        Optional<Member> member = memberRepository.findByUserId(memberId);

        return wishListRepository.findByMember(member.get());
    }
}
