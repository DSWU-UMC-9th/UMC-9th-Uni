package com.example.umc.domain.member.dto;

import com.example.umc.domain.member.enums.Address;
import com.example.umc.domain.member.enums.Gender;
import com.example.umc.global.annotation.ExistFoods;

import java.time.LocalDate;
import java.util.List;

public class MemberReqDTO {
    public record RegisterDTO(
            String name,
            Gender gender,
            LocalDate birth,
            Address address,
            String specAddress,

            @ExistFoods
            List<Long> preferCategory
    ) {}
}
