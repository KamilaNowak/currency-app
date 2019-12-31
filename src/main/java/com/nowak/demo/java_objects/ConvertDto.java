package com.nowak.demo.java_objects;

import com.nowak.demo.json_pojos_conv.Rates;

public class ConvertDto {
    String convertName;
    double convertValue;

    public ConvertDto(String convertName, double convertValue) {
        this.convertName = convertName;
        this.convertValue = convertValue;
    }

    public String getConvertName() {
        return convertName;
    }

    public void setConvertName(String convertName) {
        this.convertName = convertName;
    }

    public double getConvertValue() {
        return convertValue;
    }

    public void setConvertValue(double convertValue) {
        this.convertValue = convertValue;
    }
}
