package com.example.umc.domain.review.controller;

import com.example.umc.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc.domain.review.converter.ReviewConverter;
import com.example.umc.domain.review.dto.ReviewResponseDTO;
import com.example.umc.domain.review.entity.Review;
import com.example.umc.domain.review.service.ReviewService;
import com.example.umc.global.annotation.CheckPage;
import com.example.umc.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
@Validated
public class ReviewController implements ReviewControllerDocs {
    private final ReviewService reviewService;

    @Operation(
            summary = "리뷰 작성"
    )
    @PostMapping
    public ApiResponse<ReviewResponseDTO.CreateReview> createReview(@RequestBody Review review) {
        return ApiResponse.onSuccess(ReviewSuccessCode.REVIEW_CREATE_SUCCESS, ReviewConverter.createReview(review));
    }

    @Operation(summary = "내가 작성한 리뷰 목록")
    @GetMapping
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviews(
            @RequestParam String storeName,
            @CheckPage @RequestParam(defaultValue = "1") Integer page
    ){
        ReviewSuccessCode code = ReviewSuccessCode.FOUND;
        return ApiResponse.onSuccess(code, reviewService.findReview(storeName, page));
    }

    @Operation(summary = "리뷰 검색")
    @GetMapping("/search")
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> searchReview(
            @RequestParam String filter,
            @RequestParam String type
    ){
        ReviewResponseDTO.ReviewPreViewListDTO result = reviewService.searchReview(filter, type);

        return ApiResponse.onSuccess(ReviewSuccessCode.FOUND, result);
    }
}
