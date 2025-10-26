package com.example.umc.domain.review.repository;

import com.example.umc.domain.review.dto.ReviewResponseDTO;
import com.example.umc.domain.review.entity.Review;
import com.example.umc.domain.store.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Pageable;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    @Query("SELECT new com.example.umc.domain.review.dto.ReviewResponseDTO(" +
            "r.id, " + "r.member.nickname, " + "r.createdAt, " + "r.rating, " +
            "r.content, " + "rp.content, " + "rp.createdAt) " +
            "FROM Review r " + "LEFT JOIN r.reply rp " +
            "WHERE r.store = :store")
    Page<ReviewResponseDTO> findReviewByStore(@Param("store") Store store, Pageable pageable);
}
