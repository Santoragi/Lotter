package com.example.lotter.lotto.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class LottoResponseDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LottoPurchaseResponse {
        private List<Integer> numbers;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LottoPurchaseListResponse {
        private List<LottoPurchaseResponse> lottos;
    }


}
