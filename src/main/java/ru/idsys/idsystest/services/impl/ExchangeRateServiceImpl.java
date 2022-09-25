package ru.idsys.idsystest.services.impl;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.idsys.idsystest.entyties.CurrencyPair;
import ru.idsys.idsystest.repositories.CurrencyPairDao;
import ru.idsys.idsystest.repositories.ExchangeRateDao;
import ru.idsys.idsystest.services.ExchangeRateService;

@Service
@Getter
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Setter(onMethod = @__(@Autowired))
    ExchangeRateDao exchangeRateDao;

    @Setter(onMethod = @__(@Autowired))
    CurrencyPairDao currencyPairDao;

    @Override
    public Float getExchangeRate(Integer currencyPairId) {
        CurrencyPair currencyPair = getCurrencyPairDao().findById(currencyPairId);
        return getExchangeRateDao().getExchangeRate(currencyPair).getRateValue();
    }
}
