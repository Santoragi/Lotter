package com.example.lotter.lotto.util.generator;

import static com.example.lotter.lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static com.example.lotter.lotto.constant.LottoConstant.MAX_NUMBER;
import static com.example.lotter.lotto.constant.LottoConstant.MIN_NUMBER;

import java.util.List;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class NumberGenerator {

    RandomGenerator random = RandomGenerator.getDefault();

    public List<Integer> generateLottoNumbers() {

        return random.ints(MIN_NUMBER, MAX_NUMBER + 1)
                .distinct()
                .limit(LOTTO_NUMBER_COUNT)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
    }

    public Integer generateBonusNumber(List<Integer> numbers) {

        return random.ints(MIN_NUMBER, MAX_NUMBER + 1)
                .filter(num -> !numbers.contains(num))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("보너스 번호 생성 실패"));
    }

}
