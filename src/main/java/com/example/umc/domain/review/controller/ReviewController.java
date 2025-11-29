package com.example.umc.domain.review.controller;

import com.example.umc.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc.domain.review.converter.ReviewConverter;
import com.example.umc.domain.review.dto.ReviewResponseDTO;
import com.example.umc.domain.review.entity.Review;
import com.example.umc.domain.review.repository.ReviewRepository;
import com.example.umc.domain.review.service.ReviewService;
import com.example.umc.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController implements ReviewControllerDocs {
    private final ReviewRepository reviewRepository;
    private final ReviewService reviewService;

    @PostMapping
    public ApiResponse<ReviewResponseDTO.CreateReview> createReview(@RequestBody Review review) {
        return ApiResponse.onSuccess(ReviewSuccessCode.REVIEW_CREATE_SUCCESS, ReviewConverter.createReview(review));
    }

    @GetMapping
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviews(
            @RequestParam String storeName, @RequestParam(defaultValue = "1") Integer page
    ){

        ReviewSuccessCode code = ReviewSuccessCode.FOUND;
        return ApiResponse.onSuccess(code, reviewService.findReview(storeName, page));
    }

    @GetMapping("/search")
    public ReviewResponseDTO.ReviewPreViewListDTO serarchReview(@RequestParam String filter, @RequestParam String type) throws Exception{
        ReviewResponseDTO.ReviewPreViewListDTO result = reviewService.searchReview(filter, type);
        return result;
    }

}
