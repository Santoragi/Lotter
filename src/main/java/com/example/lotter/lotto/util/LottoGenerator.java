package com.example.lotter.lotto.util;

import static com.example.lotter.lotto.constant.LottoConstant.LOTTO_PRICE;

import com.example.lotter.lotto.domain.Lotto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LottoGenerator {

    private final NumberGenerator numberGenerator;

    public List<Lotto> generateByPrice(int price) {
        int count = price / LOTTO_PRICE;

        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            lottos.add(generate());
        }

        return lottos;
    }

    private Lotto generate() {
        return new Lotto(numberGenerator.generateLottoNumbers());
    }
}
