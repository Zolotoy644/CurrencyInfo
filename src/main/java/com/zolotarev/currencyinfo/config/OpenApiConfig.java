package com.zolotarev.currencyinfo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;


@OpenAPIDefinition(
        info=@Info(
                contact = @Contact(
                        name = "Oleg Z/",
                        email = "Zolotoy644@yandex.ru"
                ),
                description = "Documentation for CurrencyInfo",
                title = "CurrencyInfo",
                version = "0.0.1"
        )
)
public class OpenApiConfig {
}