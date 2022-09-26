package ru.idsys.idsystest.services;

import ru.idsys.idsystest.entyties.CurrencyPair;

import java.sql.Timestamp;

public interface ExchangeRateService {
    Float getExchangeRate(Integer currencyPairId, String rateDate);

    void save(Timestamp rateDate, Float rateValue, CurrencyPair currencyPair);
}
