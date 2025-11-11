package com.example.lotter.lotto;

import java.util.List;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class NumberGenerator {

    RandomGenerator random = RandomGenerator.getDefault();

    public List<Integer> generateLottoNumbers() {

        return random.ints(1, 46)
                .distinct()
                .limit(6)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
    }

    public Integer generateBonusNumber(List<Integer> numbers) {

        return random.ints(1, 46)
                .filter(num -> !numbers.contains(num))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("보너스 번호 생성 실패"));
    }

}
