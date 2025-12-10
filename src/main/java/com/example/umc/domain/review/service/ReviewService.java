package com.example.umc.domain.review.service;

import com.example.umc.domain.review.dto.ReviewResponseDTO;

public interface ReviewService {
    ReviewResponseDTO.ReviewPreViewListDTO searchReview(String filter, String type);
    ReviewResponseDTO.ReviewPreViewListDTO findReview(String storeName, Integer page);

}
