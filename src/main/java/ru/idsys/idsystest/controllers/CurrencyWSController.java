package ru.idsys.idsystest.controllers;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.idsys.idsystest.entyties.CurrencyPair;
import ru.idsys.idsystest.services.ExchangeRateService;

@RestController()
@RequestMapping("/currencyWS")
@Getter
public class CurrencyWSController {

    @Setter(onMethod = @__(@Autowired))
    ExchangeRateService exchangeRateService;

    @GetMapping("/exchangeRate")
    public ResponseEntity<Float> getExchangeRate(@RequestParam(name = "currencyPairId") Integer currencyPairId,
                                                 @RequestParam(name = "rateDate", required = false) String rateDate) {
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
