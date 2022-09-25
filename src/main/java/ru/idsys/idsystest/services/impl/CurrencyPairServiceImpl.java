package ru.idsys.idsystest.services.impl;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.idsys.idsystest.entyties.CurrencyPair;
import ru.idsys.idsystest.repositories.CurrencyPairDao;
import ru.idsys.idsystest.services.CurrencyPairService;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyPairServiceImpl implements CurrencyPairService {

    @Setter(onMethod = @__(@Autowired))
    @Getter
    CurrencyPairDao currencyPairDao;

    @Override
    public List<CurrencyPair> getAllCurrencyPair() {
        return getCurrencyPairDao().getAllCurrencyPair();
    }

    @Override
    public Optional<CurrencyPair> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void saveCurrencyPair(String baseCharCode, String quotedCharCode) {

    }
}
