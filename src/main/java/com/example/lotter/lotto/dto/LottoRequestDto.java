package com.example.lotter.lotto.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class LottoRequestDto {

    @Getter
    @NoArgsConstructor
    public static class LottoPurchaseRequest {
        private int price;
    }
}
