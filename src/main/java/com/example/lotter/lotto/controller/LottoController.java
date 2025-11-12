package com.example.lotter.lotto.controller;

import com.example.lotter.lotto.domain.LottoDraw;
import com.example.lotter.lotto.service.LottoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class LottoController {

    private final LottoService lottoService;

    @GetMapping("/lotto/today")
    public String getTodayLottoDraw(Model model) {
        LottoDraw lottoDraw = lottoService.getTodayLottoDraw();

        model.addAttribute("winningNumbers", lottoDraw.getWinningNumbers());
        model.addAttribute("bonusNumber", lottoDraw.getBonusNumber());

        return "lotto/today";
    }
}
