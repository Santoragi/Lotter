package com.example.lotter.lotto;

import java.util.List;
import lombok.Getter;

@Getter
public class LottoDraw {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public LottoDraw(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
