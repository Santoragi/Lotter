package com.example.lotter.lotto.scheduler;

import com.example.lotter.lotto.LottoDraw;
import com.example.lotter.lotto.service.LottoService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LottoScheduler {

    private final LottoService lottoService;

    @Scheduled(cron = "0 0 0 * * *", zone = "Asia/Seoul")
    public void generateDailyLottoDraw() {
        LottoDraw draw = lottoService.generateTodayLottoDraw();
    }

}
