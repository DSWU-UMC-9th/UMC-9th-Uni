package com.example.umc.domain.review.controller;

import com.example.umc.domain.review.dto.ReviewResponseDTO;
import com.example.umc.global.apiPayload.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface ReviewControllerDocs {

    @Operation(
            summary = "가게의 리뷰 목록 조회 API",
            description = "특정 가게의 리뷰를 모두 조회합니다. 페이지네이션으로 제공합니다."
    )
    @ApiResponses(
            value = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode="200", description="성공"),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode="400", description="실패")
            }
    )
    ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviews(String storeName, Integer page);
}
