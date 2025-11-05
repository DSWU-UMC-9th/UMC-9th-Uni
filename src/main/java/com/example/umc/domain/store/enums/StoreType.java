package com.example.umc.domain.store.enums;

public enum StoreType {
    KOREAN_FOOD("한식당"),
    CHINESE_FOOD("중식당"),
    WESTERN_FOOD("양식당"),
    JAPANESE_FOOD("일식당"),
    SNACK_FOOD("분식"),
    MEAT_GRILL("고기/구이"),
    FAST_FOOD("패스트푸드"),
    DESSERT("디저트"),
    CAFE("카페");

    private String label;
    StoreType(String label) {
        this.label = label;
    }
}
