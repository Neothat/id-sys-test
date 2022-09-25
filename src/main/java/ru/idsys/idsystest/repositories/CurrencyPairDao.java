package ru.idsys.idsystest.repositories;

import ru.idsys.idsystest.entyties.CurrencyPair;

import java.util.List;

public interface CurrencyPairDao {
    List<CurrencyPair> getAllCurrencyPair();

    CurrencyPair findById(Integer id);

    void saveOrUpdate(String baseCharCode, String quotedCharCode);
}
