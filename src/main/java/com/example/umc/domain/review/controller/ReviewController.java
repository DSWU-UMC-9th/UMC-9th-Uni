package com.example.umc.domain.review.controller;

import com.example.umc.domain.review.code.ReviewSuccessCode;
import com.example.umc.domain.review.converter.ReviewConverter;
import com.example.umc.domain.review.dto.ReviewResponseDTO;
import com.example.umc.domain.review.entity.Review;
import com.example.umc.domain.review.repository.ReviewRepository;
import com.example.umc.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewRepository reviewRepository;

    @PostMapping
    public ApiResponse<ReviewResponseDTO.CreateReview> createReview(@RequestBody Review review) {
        return ApiResponse.onSuccess(ReviewSuccessCode.REVIEW_CREATE_SUCCESS, ReviewConverter.createReview(review));
    }

}
