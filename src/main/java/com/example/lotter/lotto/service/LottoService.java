package com.example.lotter.lotto.service;

import com.example.lotter.lotto.domain.LottoDraw;
import com.example.lotter.lotto.dto.LottoRequestDto;
import com.example.lotter.lotto.dto.LottoResponseDto;

public interface LottoService {

    LottoDraw generateTodayLottoDraw();
    LottoDraw getTodayLottoDraw();
    LottoResponseDto.LottoPurchaseListResponse generateLottos(LottoRequestDto.LottoPurchaseRequest request);
}
