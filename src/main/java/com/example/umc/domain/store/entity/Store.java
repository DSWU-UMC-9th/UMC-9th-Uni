package com.example.umc.domain.store.entity;

import com.example.umc.domain.mission.entity.Mission;
import com.example.umc.domain.review.entity.Review;
import com.example.umc.domain.store.enums.StoreType;
import com.example.umc.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name="Store")
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)
    private String address;

    @Column(length = 11, nullable = false)
    private String phoneNumber;

    @Column(length = 10, nullable = false)
    private String owner_code;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StoreType storeType;

    @OneToMany(mappedBy = "store")
    private List<Review> reviews;

    @OneToMany(mappedBy = "store")
    private List<Mission> missions = new ArrayList<>();
}
