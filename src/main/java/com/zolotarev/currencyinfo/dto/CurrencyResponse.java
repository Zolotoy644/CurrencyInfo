package com.zolotarev.currencyinfo.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyResponse {
    private String code;
    private String rate;
    private LocalDate date;

    public void setCode(String code) {
        this.code = code;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getRate() {
        return rate;
    }

    public String getCode() {
        return code;
    }
}
