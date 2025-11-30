package com.example.umc.domain.review.repository;

import com.example.umc.domain.review.entity.Review;
import com.example.umc.domain.store.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findReviewsByMemberId(Long memberId);
    Page<Review> findAllByStore(Store store, Pageable pageRequest);
}

