package ru.idsys.idsystest.services;

import ru.idsys.idsystest.entyties.CurrencyPair;

import java.util.List;
import java.util.Optional;

public interface CurrencyPairService {
    List<CurrencyPair> getAllCurrencyPair();

    Optional<CurrencyPair> getById(Integer id);

    void saveCurrencyPair(String baseCharCode, String quotedCharCode);
}
