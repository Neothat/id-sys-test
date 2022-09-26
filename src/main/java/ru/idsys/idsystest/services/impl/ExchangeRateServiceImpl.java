package ru.idsys.idsystest.services.impl;

import liquibase.repackaged.org.apache.commons.lang3.StringUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.idsys.idsystest.entyties.CurrencyPair;
import ru.idsys.idsystest.repositories.CurrencyPairDao;
import ru.idsys.idsystest.repositories.ExchangeRateDao;
import ru.idsys.idsystest.services.ExchangeRateService;

import java.sql.Timestamp;

@Service
@Getter
@Slf4j
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Setter(onMethod = @__(@Autowired))
    ExchangeRateDao exchangeRateDao;

    @Setter(onMethod = @__(@Autowired))
    CurrencyPairDao currencyPairDao;

    @Override
    public Float getExchangeRate(Integer currencyPairId, String rateDate) {
        CurrencyPair currencyPair = getCurrencyPairDao().findById(currencyPairId);
        if (rateDate != null) {
            return getExchangeRateDao().getExchangeRate(currencyPair,
                    Timestamp.valueOf(rateDate.replace("T", StringUtils.SPACE))).getRateValue();
        }
        return getExchangeRateDao().getExchangeRate(currencyPair).getRateValue();
    }

    @Override
    public void save(Timestamp rateDate, Float rateValue, CurrencyPair currencyPair) {
        getExchangeRateDao().save(rateDate, rateValue, currencyPair);
        log.info("New exchange rate crated");
    }
}
