package ru.idsys.idsystest.services;

public interface ExchangeRateService {
    Float getExchangeRate(Integer currencyPairId, String rateDate);

    Float getExchangeRate(Integer currencyPairId);
}
