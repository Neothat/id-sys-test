package ru.idsys.idsystest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.idsys.idsystest.entyties.CurrencyPair;

import java.time.OffsetDateTime;

@RestController("/currencyWS")
public class CurrencyWSController {

    @GetMapping("/exchangeRate")
    public ResponseEntity<Float> getExchangeRate(Integer currencyPairId, OffsetDateTime rateDate) {
        return null;
    }

    @GetMapping("/exchangeRate")
    public ResponseEntity<Float> getExchangeRate(Integer currencyPairId) {
        return null;
    }

    @GetMapping("/currencyPairs")
    public ResponseEntity<CurrencyPair> getCurrencyPairs() { // Replace with DTO/Mapper
        return null;
    }

    @PostMapping("/currencyPairs")
    public ResponseEntity<String> getCurrencyPairs(@RequestBody String baseCharCode,
                                 @RequestBody String quotedCharCode) {
        return null;
    }
}
