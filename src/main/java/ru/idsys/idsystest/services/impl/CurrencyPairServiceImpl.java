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
import java.util.stream.Collectors;

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
    public List<String> getListCurrencyPair() {
        return getAllCurrencyPair().stream()
                .map(pair -> pair.getBaseCharCode() + pair.getQuotedCharCode())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CurrencyPair> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void saveCurrencyPair(String baseCharCode, String quotedCharCode) {
        getCurrencyPairDao().saveOrUpdate(baseCharCode, quotedCharCode);
    }

    @Override
    public CurrencyPair findByBaseCharAndQuotedChar(String baseCharCode, String quotedCharCode) {
        return getCurrencyPairDao().findByBaseCharAndQuotedChar(baseCharCode, quotedCharCode);
    }

    @Override
    public Integer getIdByBaseCharAndQuotedChar(String baseCharCode, String quotedCharCode) {
        return getCurrencyPairDao().getIdByBaseCharAndQuotedChar(baseCharCode, quotedCharCode);
    }
}
