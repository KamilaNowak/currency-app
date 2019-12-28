package com.nowak.demo.java_objects;

public class LatestDto {

    private String currencyName;
    private Double currencyValue;

    public LatestDto(String currencyName, Double currencyValue) {
        this.currencyName = currencyName;
        this.currencyValue = currencyValue;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Double getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(Double currencyValue) {
        this.currencyValue = currencyValue;
    }
}
