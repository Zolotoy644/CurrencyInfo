package com.zolotarev.currencyinfo.service;

import com.zolotarev.currencyinfo.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.*;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;

@Service
//@RequiredArgsConstructor
public class CurrencyService {
    private final Gson gson;

    @Autowired
    public CurrencyService(Gson gson) {
        this.gson = gson;
    }

    public Currency getCurrencyRate(String code, LocalDate date) throws IOException {
        if (!checkCode(code)) {
            throw new IllegalArgumentException("Invalid currency code: " + code);
        }
        Currency currency = new Currency();

        String currencyJson = new String(
                new URL(getUrl(date))
                        .openStream()
                        .readAllBytes()
        );
        JsonObject jsonObject = gson.fromJson(currencyJson, JsonObject.class);
        JsonObject currencyData = jsonObject.getAsJsonObject("Valute");
        JsonObject currencyObject = currencyData.getAsJsonObject(code);
        currency.setDate(date);
        currency.setName(currencyObject.get("Name").getAsString());
        currency.setNumCode(currencyObject.get("NumCode").getAsString());
        currency.setCharCode(currencyObject.get("CharCode").getAsString());
        currency.setValue(currencyObject.get("Value").getAsString());

        return currency;
    }

    private static String getUrl(LocalDate date){
        if (Objects.equals(date, LocalDate.now())) {
            return "https://www.cbr-xml-daily.ru/daily_json.js";
        } else {
            String url = String.format("https://www.cbr-xml-daily.ru//archive//%d//%02d//%02d//daily_json.js",
                    date.getYear(),
                    date.getMonthValue(),
                    date.getDayOfMonth());
            return url;
        }
    }

    private boolean checkCode(String code) {
        for (CurrencyType type : CurrencyType.values()) {
            if (code.equals(type.toString())) {
                return true;
            }
        }
        return false;
    }

    public enum CurrencyType {
        AUD,
        AZN,
        GBP,
        AMD,
        BYN,
        BGN,
        BRL,
        HUF,
        VND,
        HKD,
        GEL,
        DKK,
        AED,
        USD,
        EUR,
        EGP,
        INR,
        IDR,
        KZT,
        CAD,
        QAR,
        KGS,
        CNY,
        MDL,
        NZD,
        NOK,
        PLN,
        RON,
        XDR,
        SGD,
        TJS,
        THB,
        TRY,
        TMT,
        UZS,
        UAH,
        CZK,
        SEK,
        CHF,
        RSD,
        ZAR,
        KRW,
        JPY
    }


}
