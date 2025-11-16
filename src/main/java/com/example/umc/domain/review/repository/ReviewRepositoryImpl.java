package com.example.umc.domain.review.repository;

import com.example.umc.domain.review.dto.ReviewResponseDTO;
import com.example.umc.domain.review.entity.QReply;
import com.example.umc.domain.review.entity.QReview;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public ReviewRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<ReviewResponseDTO> findReviews(Long storeId, Float rating) {
        QReview qReview = QReview.review;
        QReply qReply = QReply.reply;

        return queryFactory

                .select(Projections.constructor(ReviewResponseDTO.class,
                        qReview.member.nickname,
                        qReview.rating,
                        qReview.content,
                        qReview.images,
                        qReply.content))
                .from(qReview)
                .leftJoin(qReview.reply, qReply)
                .where(storeIdEq(storeId), ratingEq(rating))
                .fetch();
    }

    // 동적 필터링
    private BooleanExpression storeIdEq(Long storeId) {
        return storeId != null ? QReview.review.store.id.eq(storeId):null;
    }

    private BooleanExpression ratingEq(Float rating) {
        return rating != null? QReview.review.rating.eq(rating):null;
    }
}
