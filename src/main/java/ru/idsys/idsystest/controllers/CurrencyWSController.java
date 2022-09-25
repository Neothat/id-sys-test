package ru.idsys.idsystest.controllers;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.idsys.idsystest.mappers.CurrencyPairMapper;
import ru.idsys.idsystest.mappers.dtos.CurrencyPairDto;
import ru.idsys.idsystest.services.CurrencyPairService;
import ru.idsys.idsystest.services.ExchangeRateService;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/currencyWS")
@Getter
public class CurrencyWSController {

    @Setter(onMethod = @__(@Autowired))
    ExchangeRateService exchangeRateService;

    @Setter(onMethod = @__(@Autowired))
    CurrencyPairService currencyPairService;

    @GetMapping("/exchangeRate")
    public ResponseEntity<Float> getExchangeRate(@RequestParam(name = "currencyPairId") Integer currencyPairId,
                                                 @RequestParam(name = "rateDate", required = false) String rateDate) {
        return new ResponseEntity<>(getExchangeRateService().getExchangeRate(currencyPairId, rateDate), HttpStatus.OK);
    }

    @GetMapping("/currencyPairs")
    public ResponseEntity<List<CurrencyPairDto>> getCurrencyPairs() {
        return new ResponseEntity<>(getCurrencyPairService().getAllCurrencyPair().stream()
                .map(CurrencyPairMapper.INSTANCE::toDto)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping("/currencyPairs")
    public ResponseEntity<String> getCurrencyPairs(@RequestBody String baseCharCode,
                                                   @RequestBody String quotedCharCode) {
        return null;
    }
}
