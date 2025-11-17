package com.example.lotter.lotto.service;

import com.example.lotter.lotto.domain.Lotto;
import com.example.lotter.lotto.domain.LottoDraw;
import com.example.lotter.lotto.dto.LottoRequestDto.LottoPurchaseRequest;
import com.example.lotter.lotto.dto.LottoResponseDto.LottoPurchaseListResponse;
import com.example.lotter.lotto.dto.LottoResponseDto.LottoPurchaseResponse;
import com.example.lotter.lotto.util.LottoGenerator;
import com.example.lotter.lotto.util.NumberGenerator;
import com.example.lotter.lotto.repository.LottoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LottoServiceImpl implements LottoService{

    private final NumberGenerator numberGenerator;
    private final LottoGenerator lottoGenerator;
    private final LottoRepository lottoRepository;

    @Override
    public LottoDraw generateTodayLottoDraw() {

        List<Integer> winningNumbers = numberGenerator.generateLottoNumbers();
        Integer bonusNumber = numberGenerator.generateBonusNumber(winningNumbers);

        LottoDraw todayLottoDraw = new LottoDraw(winningNumbers, bonusNumber);
        lottoRepository.save(todayLottoDraw);

        return todayLottoDraw;
    }

    @Override
    public LottoDraw getTodayLottoDraw() {
        return lottoRepository.findTodayLottoDraw();
    }

    @Override
    public LottoPurchaseListResponse generateLottos(LottoPurchaseRequest request) {
        int price = request.getPrice();

        List<Lotto> lottos = lottoGenerator.generateByPrice(price);

        List<LottoPurchaseResponse> lottoNumbers = lottos.stream()
                .map(lotto -> LottoPurchaseResponse.builder()
                        .numbers(lotto.getNumbers())
                        .build())
                .toList();

        return LottoPurchaseListResponse.builder()
                .lottos(lottoNumbers)
                .build();
    }
}
