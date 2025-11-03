package com.example.umc.domain.review.repository;


import com.example.umc.domain.review.dto.ReviewResponseDTO;
import com.example.umc.domain.review.entity.Review;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<ReviewResponseDTO> findReviews(Long storeId, Float rating);
}
