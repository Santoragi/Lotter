package com.example.lotter.lotto.repository;

import com.example.lotter.lotto.domain.LottoDraw;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryLottoRepository implements LottoRepository {

    private LottoDraw lottoDraw;

    @Override
    public void save(LottoDraw lottoDraw) {
        this.lottoDraw = lottoDraw;
    }

    @Override
    public LottoDraw findTodayLottoDraw() {
        return this.lottoDraw;
    }
}
