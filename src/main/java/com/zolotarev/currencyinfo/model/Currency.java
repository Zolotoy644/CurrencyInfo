package com.zolotarev.currencyinfo.model;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currency {
    private String numCode;
    private String charCode;
    private String name;
    private String value;
    private LocalDate date;

    public String getCharCode() {
        return charCode;
    }

    public String getValue() {
        return value;
    }

    public String getNumCode() {
        return numCode;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
