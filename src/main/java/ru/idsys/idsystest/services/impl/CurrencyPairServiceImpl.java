package ru.idsys.idsystest.services.impl;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.idsys.idsystest.entyties.CurrencyPair;
import ru.idsys.idsystest.repositories.CurrencyPairDao;
import ru.idsys.idsystest.services.CurrencyPairService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
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
    public void saveCurrencyPair(String baseCharCode, String quotedCharCode) {
        getCurrencyPairDao().saveOrUpdate(baseCharCode, quotedCharCode);
        log.info("New currency pair crated");
    }

    @Override
    public CurrencyPair findByBaseCharAndQuotedChar(String baseCharCode, String quotedCharCode) {
        return getCurrencyPairDao().findByBaseCharAndQuotedChar(baseCharCode, quotedCharCode);
    }

}
