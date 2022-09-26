package ru.idsys.idsystest.services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.idsys.idsystest.services.CurrateAPIService;

@Service
public class CurrateAPIServiceScheduler {

    @Setter(onMethod = @__(@Autowired))
    @Getter
    private CurrateAPIService currateAPIService;

    @Scheduled(fixedRate = 1000L * 60)
    void makeRequest() {
        getCurrateAPIService().getRatesForCurrencies();
    }
}