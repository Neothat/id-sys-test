package ru.idsys.idsystest.repositories;

import ru.idsys.idsystest.entyties.CurrencyPair;
import ru.idsys.idsystest.entyties.ExchangeRate;

import java.sql.Timestamp;

public interface ExchangeRateDao {
    ExchangeRate getExchangeRate (CurrencyPair currencyPair);
    ExchangeRate getExchangeRate (CurrencyPair currencyPair, Timestamp rateDate);
}