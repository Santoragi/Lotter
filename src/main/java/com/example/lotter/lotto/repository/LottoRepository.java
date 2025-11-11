package com.example.lotter.lotto.repository;

import com.example.lotter.lotto.LottoDraw;

public interface LottoRepository {
    void save(LottoDraw lottoDraw);
    LottoDraw findTodayLottoDraw();
}
