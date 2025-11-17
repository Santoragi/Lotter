package com.example.lotter.lotto.domain;

import java.util.List;
import lombok.Getter;

@Getter
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
