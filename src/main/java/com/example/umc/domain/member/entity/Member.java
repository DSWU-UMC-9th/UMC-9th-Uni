package com.example.umc.domain.member.entity;


import com.example.umc.domain.member.enums.FoodType;
import com.example.umc.domain.mission.entity.MemberMission;
import com.example.umc.domain.member.enums.Gender;
import com.example.umc.domain.review.entity.Review;
import com.example.umc.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name="member")
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 3,nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Gender gender = Gender.NONE;

    @Column(name = "birth", nullable = false)
    private LocalDate birth;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @Column(name = "prefer_food", nullable = false)
    @Enumerated(EnumType.STRING)
    private FoodType preferFood;

    @Column(name = "points")
    private Integer points;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "member")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberMission> missions = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberFood> foods = new ArrayList<>();
}
