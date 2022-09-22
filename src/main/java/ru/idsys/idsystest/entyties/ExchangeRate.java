package ru.idsys.idsystest.entyties;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "EXCHANGE_RATE")
@Data
@NoArgsConstructor
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "RATE_DATE")
    private OffsetDateTime rateDate;

    @Column(name = "RATE_VALUE")
    private Float rateValue;

    @ManyToOne
    @JoinColumn(name = "CURRENCY_PAIR_ID")
    private CurrencyPair currencyPair;
}


