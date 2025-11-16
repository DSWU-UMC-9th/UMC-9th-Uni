package com.example.umc.domain.member.service;

import com.example.umc.domain.member.converter.MemberConverter;
import com.example.umc.domain.member.dto.MyPageDTO;
import com.example.umc.domain.member.entity.Member;
import com.example.umc.domain.member.repository.MemberRepositiory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepositiory memberRepository;

    public MyPageDTO getMyPageInfo(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        return MemberConverter.toMyPageDTO(member);
    }
}
