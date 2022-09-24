package ru.idsys.idsystest.services.impl;

import org.springframework.stereotype.Service;
import ru.idsys.idsystest.entyties.CurrencyPair;
import ru.idsys.idsystest.services.CurrencyPairService;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyPairServiceImpl implements CurrencyPairService {

    @Override
    public List<CurrencyPair> getAllCurrencyPair() {
        return null;
    }

    @Override
    public Optional<CurrencyPair> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void saveCurrencyPair(String baseCharCode, String quotedCharCode) {

    }
}
