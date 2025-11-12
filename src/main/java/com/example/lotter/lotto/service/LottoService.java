package com.example.lotter.lotto.service;

import com.example.lotter.lotto.domain.LottoDraw;

public interface LottoService {

    LottoDraw generateTodayLottoDraw();
    LottoDraw getTodayLottoDraw();
}
