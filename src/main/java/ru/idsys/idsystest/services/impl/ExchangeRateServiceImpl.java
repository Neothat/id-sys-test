package ru.idsys.idsystest.services.impl;

import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.idsys.idsystest.services.ExchangeRateService;

@Service
@Getter
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Override
    public Float getExchangeRate(Integer currencyPairId, String rateDate) {
        return null;
    }

    @Override
    public Float getExchangeRate(Integer currencyPairId) {
        return null;
    }
}
