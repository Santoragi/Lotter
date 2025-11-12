package com.example.lotter.lotto.scheduler;

import com.example.lotter.lotto.domain.LottoDraw;
import com.example.lotter.lotto.service.LottoService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LottoScheduler {

    private final LottoService lottoService;

    public void generateDailyLottoDraw() {
        LottoDraw draw = lottoService.generateTodayLottoDraw();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onStart() {
        generateDailyLottoDraw();
    }

    @Scheduled(cron = "0 0 0 * * *", zone = "Asia/Seoul")
    public void onMidnight() {
        generateDailyLottoDraw();
    }

}
