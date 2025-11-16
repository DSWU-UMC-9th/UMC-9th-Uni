package com.example.umc.domain.member.converter;

import com.example.umc.domain.member.dto.MyPageDTO;
import com.example.umc.domain.member.entity.Member;

public class MemberConverter {
    public static MyPageDTO toMyPageDTO(Member member) {
        return new MyPageDTO(
                member.getNickname(),
                member.getEmail(),
                member.getPhoneNum(),
                member.getPoints()
        );
    }
}
