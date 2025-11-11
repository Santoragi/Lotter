package com.example.lotter.lotto.service;

import com.example.lotter.lotto.LottoDraw;
import com.example.lotter.lotto.NumberGenerator;
import com.example.lotter.lotto.repository.LottoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LottoServiceImpl implements LottoService{

    private final NumberGenerator numberGenerator;
    private final LottoRepository lottoRepository;

    @Override
    public LottoDraw generateTodayLottoDraw() {

        List<Integer> winningNumbers = numberGenerator.generateLottoNumbers();
        Integer bonusNumber = numberGenerator.generateBonusNumber(winningNumbers);

        LottoDraw todayLottoDraw = new LottoDraw(winningNumbers, bonusNumber);
        lottoRepository.save(todayLottoDraw);

        return todayLottoDraw;
    }
}
