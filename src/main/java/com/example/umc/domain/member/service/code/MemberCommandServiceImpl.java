package com.example.umc.domain.member.service.code;

import com.example.umc.domain.member.converter.MemberConverter;
import com.example.umc.domain.member.dto.MemberReqDTO;
import com.example.umc.domain.member.dto.MemberResDTO;
import com.example.umc.domain.member.dto.MyPageDTO;
import com.example.umc.domain.member.entity.Member;
import com.example.umc.domain.member.entity.MemberFood;
import com.example.umc.domain.member.exception.MemberException;
import com.example.umc.domain.member.exception.code.FoodErrorCode;
import com.example.umc.domain.member.repository.FoodRepository;
import com.example.umc.domain.member.repository.MemberFoodRepository;
import com.example.umc.domain.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodRepository foodRepository;
    private final MemberFoodRepository memberFoodRepository;

    @Override
    @Transactional
    public MemberResDTO.RegisterDTO register(
            MemberReqDTO.RegisterDTO dto
    ) {
        Member member = MemberConverter.toMember(dto);
        // DB 적용
        memberRepository.save(member);

        // 선호 음식 존재 여부 확인
        if (dto.preferCategory().size() > 1) {
            List<MemberFood> memberFoodList = new ArrayList<>();

            // 선호 음식 ID별 조회
            if (dto.preferCategory().size() > 1) {
                List<MemberFood> memberFood = dto.preferCategory().stream()
                        .map(id -> MemberFood.builder()
                                .member(member)
                                .food(foodRepository.findById(id)
                                        .orElseThrow(() -> new MemberException(FoodErrorCode.NOT_FOUND)))
                                .build()
                        )
                        .collect(Collectors.toList());

                memberFoodRepository.saveAll(memberFood);
            }
        }


        // 응답 DTO 생성
        return MemberConverter.toJoinDTO(member);
    }

    public MyPageDTO getMyPageInfo(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        return MemberConverter.toMyPageDTO(member);
    }
}