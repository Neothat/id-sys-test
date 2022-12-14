package ru.idsys.idsystest.entyties;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "EXCHANGE_RATE")
@Data
@NoArgsConstructor
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private BigInteger id;

    @Column(name = "RATE_DATE")
    private Timestamp rateDate;

    @Column(name = "RATE_VALUE")
    private Float rateValue;

    @ManyToOne
    @JoinColumn(name = "CURRENCY_PAIR_ID", referencedColumnName = "ID")
    private CurrencyPair currencyPair;

    public ExchangeRate(Timestamp rateDate, Float rateValue, CurrencyPair currencyPair) {
        this.rateDate = rateDate;
        this.rateValue = rateValue;
        this.currencyPair = currencyPair;
    }
}


