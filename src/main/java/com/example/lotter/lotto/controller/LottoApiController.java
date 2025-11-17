package com.example.lotter.lotto.controller;

import com.example.lotter.lotto.dto.LottoRequestDto;
import com.example.lotter.lotto.dto.LottoRequestDto.LottoPurchaseRequest;
import com.example.lotter.lotto.dto.LottoResponseDto;
import com.example.lotter.lotto.service.LottoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class LottoApiController {

    private final LottoService lottoService;

    @PostMapping("/lotto")
    public LottoResponseDto.LottoPurchaseListResponse purchaseLottos(
            @RequestBody LottoRequestDto.LottoPurchaseRequest request) {

        return lottoService.generateLottos(request);
    }


}
