package ru.idsys.idsystest.services;

import ru.idsys.idsystest.entyties.CurrencyPair;

import java.util.List;
import java.util.Optional;

public interface CurrencyPairService {
    List<CurrencyPair> getAllCurrencyPair();

    List<String> getListCurrencyPair();

    void saveCurrencyPair(String baseCharCode, String quotedCharCode);

    CurrencyPair findByBaseCharAndQuotedChar(String baseCharCode, String quotedCharCode);
}
