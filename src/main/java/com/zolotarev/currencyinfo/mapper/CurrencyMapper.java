package com.zolotarev.currencyinfo.mapper;

import com.zolotarev.currencyinfo.dto.CurrencyResponse;
import com.zolotarev.currencyinfo.model.Currency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CurrencyMapper {
    CurrencyMapper INSTANCE = Mappers.getMapper(CurrencyMapper.class);

    @Mapping(source = "currency.charCode", target = "code")
    @Mapping(source = "currency.value", target = "rate")
    CurrencyResponse toCurrencyResponse(Currency currency);
}
