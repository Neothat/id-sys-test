package ru.idsys.idsystest.repositories;

import ru.idsys.idsystest.entyties.CurrencyPair;
import ru.idsys.idsystest.entyties.ExchangeRate;

public interface ExchangeRateDao {
    ExchangeRate getExchangeRate (CurrencyPair currencyPair);
}