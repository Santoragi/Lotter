package com.example.lotter.user.service;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final static int DAILY_AMOUNT = 100_000;

    @Override
    public Map<String, Object> depositDailyAmount() {
        return Map.of("amount", DAILY_AMOUNT);
    }
}
