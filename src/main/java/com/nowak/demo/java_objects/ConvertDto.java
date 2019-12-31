package com.nowak.demo.java_objects;

import com.nowak.demo.json_pojos_conv.Rates;

public class ConvertDto {
    String convertName;
    Double convertValue;

    public ConvertDto(String convertName, Double convertValue) {
        this.convertName = convertName;
        this.convertValue = convertValue;
    }

    public String getConvertName() {
        return convertName;
    }

    public void setConvertName(String convertName) {
        this.convertName = convertName;
    }

    public Double getConvertValue() {
        return convertValue;
    }

    public void setConvertValue(Double convertValue) {
        this.convertValue = convertValue;
    }
}
