package ru.idsys.idsystest.mappers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyPairDto {
    int id;
    String baseCharCode;
    String quotedCharCode;
    String description;
}
