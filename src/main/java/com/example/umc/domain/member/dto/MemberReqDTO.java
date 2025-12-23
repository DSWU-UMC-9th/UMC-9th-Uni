package com.example.umc.domain.member.dto;

import com.example.umc.domain.member.enums.Address;
import com.example.umc.domain.member.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class MemberReqDTO {
    public record RegisterDTO(
            @NotBlank String name,
            @NotBlank String nickname,
            @NotNull Gender gender,
            LocalDate birth,
            Address address,
            @NotBlank String email,
            @NotBlank String password,
            @NotBlank String phonenum
    ) {}

    public record LoginDTO(
            @NotBlank String email,
            @NotBlank String password
    ) {}
}
