package ru.idsys.idsystest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.idsys.idsystest.entyties.CurrencyPair;
import ru.idsys.idsystest.mappers.dtos.CurrencyPairDto;

@Mapper
public interface CurrencyPairMapper {

    CurrencyPairMapper INSTANCE = Mappers.getMapper(CurrencyPairMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "baseCharCode", source = "baseCharCode")
    @Mapping(target = "quotedCharCode", source = "quotedCharCode")
    @Mapping(target = "description", source = "description")
    CurrencyPairDto toDto(CurrencyPair currencyPair);
}
