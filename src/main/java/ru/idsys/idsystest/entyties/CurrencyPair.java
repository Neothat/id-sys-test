package ru.idsys.idsystest.entyties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CURRENCY_PAIR")
@Getter
@Setter
@NoArgsConstructor
public class CurrencyPair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "BASE_CHARCODE")
    private String baseCharCode;

    @Column(name = "QUOTED_CHARCODE")
    private String quotedCharCode;

    @Column(name = "DESCRIPTION")
    private String description;

    public CurrencyPair(String baseCharCode, String quotedCharCode) {
        this.baseCharCode = baseCharCode;
        this.quotedCharCode = quotedCharCode;
    }
}
