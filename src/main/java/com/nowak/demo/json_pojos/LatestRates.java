
package com.nowak.demo.json_pojos;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CAD",
        "HKD",
        "ISK",
        "PHP",
        "DKK",
        "HUF",
        "CZK",
        "AUD",
        "RON",
        "SEK",
        "IDR",
        "INR",
        "BRL",
        "RUB",
        "HRK",
        "JPY",
        "THB",
        "CHF",
        "SGD",
        "PLN",
        "BGN",
        "TRY",
        "CNY",
        "NOK",
        "NZD",
        "ZAR",
        "USD",
        "MXN",
        "ILS",
        "GBP",
        "KRW",
        "MYR"
})
public class LatestRates {

    @JsonProperty("CAD")
    private Double cAD;
    @JsonProperty("HKD")
    private Double hKD;
    @JsonProperty("ISK")
    private Double iSK;
    @JsonProperty("PHP")
    private Double pHP;
    @JsonProperty("DKK")
    private Double dKK;
    @JsonProperty("HUF")
    private Double hUF;
    @JsonProperty("CZK")
    private Double cZK;
    @JsonProperty("AUD")
    private Double aUD;
    @JsonProperty("RON")
    private Double rON;
    @JsonProperty("SEK")
    private Double sEK;
    @JsonProperty("IDR")
    private Double iDR;
    @JsonProperty("INR")
    private Double iNR;
    @JsonProperty("BRL")
    private Double bRL;
    @JsonProperty("RUB")
    private Double rUB;
    @JsonProperty("HRK")
    private Double hRK;
    @JsonProperty("JPY")
    private Double jPY;
    @JsonProperty("THB")
    private Double tHB;
    @JsonProperty("CHF")
    private Double cHF;
    @JsonProperty("SGD")
    private Double sGD;
    @JsonProperty("PLN")
    private Double pLN;
    @JsonProperty("BGN")
    private Double bGN;
    @JsonProperty("TRY")
    private Double tRY;
    @JsonProperty("CNY")
    private Double cNY;
    @JsonProperty("NOK")
    private Double nOK;
    @JsonProperty("NZD")
    private Double nZD;
    @JsonProperty("ZAR")
    private Double zAR;
    @JsonProperty("USD")
    private Double uSD;
    @JsonProperty("MXN")
    private Double mXN;
    @JsonProperty("ILS")
    private Double iLS;
    @JsonProperty("GBP")
    private Double gBP;
    @JsonProperty("KRW")
    private Double kRW;
    @JsonProperty("MYR")
    private Double mYR;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("CAD")
    public Double getCAD() {
        return cAD;
    }

    @JsonProperty("CAD")
    public void setCAD(Double cAD) {
        this.cAD = cAD;
    }

    @JsonProperty("HKD")
    public Double getHKD() {
        return hKD;
    }

    @JsonProperty("HKD")
    public void setHKD(Double hKD) {
        this.hKD = hKD;
    }

    @JsonProperty("ISK")
    public Double getISK() {
        return iSK;
    }

    @JsonProperty("ISK")
    public void setISK(Double iSK) {
        this.iSK = iSK;
    }

    @JsonProperty("PHP")
    public Double getPHP() {
        return pHP;
    }

    @JsonProperty("PHP")
    public void setPHP(Double pHP) {
        this.pHP = pHP;
    }

    @JsonProperty("DKK")
    public Double getDKK() {
        return dKK;
    }

    @JsonProperty("DKK")
    public void setDKK(Double dKK) {
        this.dKK = dKK;
    }

    @JsonProperty("HUF")
    public Double getHUF() {
        return hUF;
    }

    @JsonProperty("HUF")
    public void setHUF(Double hUF) {
        this.hUF = hUF;
    }

    @JsonProperty("CZK")
    public Double getCZK() {
        return cZK;
    }

    @JsonProperty("CZK")
    public void setCZK(Double cZK) {
        this.cZK = cZK;
    }

    @JsonProperty("AUD")
    public Double getAUD() {
        return aUD;
    }

    @JsonProperty("AUD")
    public void setAUD(Double aUD) {
        this.aUD = aUD;
    }

    @JsonProperty("RON")
    public Double getRON() {
        return rON;
    }

    @JsonProperty("RON")
    public void setRON(Double rON) {
        this.rON = rON;
    }

    @JsonProperty("SEK")
    public Double getSEK() {
        return sEK;
    }

    @JsonProperty("SEK")
    public void setSEK(Double sEK) {
        this.sEK = sEK;
    }

    @JsonProperty("IDR")
    public Double getIDR() {
        return iDR;
    }

    @JsonProperty("IDR")
    public void setIDR(Double iDR) {
        this.iDR = iDR;
    }

    @JsonProperty("INR")
    public Double getINR() {
        return iNR;
    }

    @JsonProperty("INR")
    public void setINR(Double iNR) {
        this.iNR = iNR;
    }

    @JsonProperty("BRL")
    public Double getBRL() {
        return bRL;
    }

    @JsonProperty("BRL")
    public void setBRL(Double bRL) {
        this.bRL = bRL;
    }

    @JsonProperty("RUB")
    public Double getRUB() {
        return rUB;
    }

    @JsonProperty("RUB")
    public void setRUB(Double rUB) {
        this.rUB = rUB;
    }

    @JsonProperty("HRK")
    public Double getHRK() {
        return hRK;
    }

    @JsonProperty("HRK")
    public void setHRK(Double hRK) {
        this.hRK = hRK;
    }

    @JsonProperty("JPY")
    public Double getJPY() {
        return jPY;
    }

    @JsonProperty("JPY")
    public void setJPY(Double jPY) {
        this.jPY = jPY;
    }

    @JsonProperty("THB")
    public Double getTHB() {
        return tHB;
    }

    @JsonProperty("THB")
    public void setTHB(Double tHB) {
        this.tHB = tHB;
    }

    @JsonProperty("CHF")
    public Double getCHF() {
        return cHF;
    }

    @JsonProperty("CHF")
    public void setCHF(Double cHF) {
        this.cHF = cHF;
    }

    @JsonProperty("SGD")
    public Double getSGD() {
        return sGD;
    }

    @JsonProperty("SGD")
    public void setSGD(Double sGD) {
        this.sGD = sGD;
    }

    @JsonProperty("PLN")
    public Double getPLN() {
        return pLN;
    }

    @JsonProperty("PLN")
    public void setPLN(Double pLN) {
        this.pLN = pLN;
    }

    @JsonProperty("BGN")
    public Double getBGN() {
        return bGN;
    }

    @JsonProperty("BGN")
    public void setBGN(Double bGN) {
        this.bGN = bGN;
    }

    @JsonProperty("TRY")
    public Double getTRY() {
        return tRY;
    }

    @JsonProperty("TRY")
    public void setTRY(Double tRY) {
        this.tRY = tRY;
    }

    @JsonProperty("CNY")
    public Double getCNY() {
        return cNY;
    }

    @JsonProperty("CNY")
    public void setCNY(Double cNY) {
        this.cNY = cNY;
    }

    @JsonProperty("NOK")
    public Double getNOK() {
        return nOK;
    }

    @JsonProperty("NOK")
    public void setNOK(Double nOK) {
        this.nOK = nOK;
    }

    @JsonProperty("NZD")
    public Double getNZD() {
        return nZD;
    }

    @JsonProperty("NZD")
    public void setNZD(Double nZD) {
        this.nZD = nZD;
    }

    @JsonProperty("ZAR")
    public Double getZAR() {
        return zAR;
    }

    @JsonProperty("ZAR")
    public void setZAR(Double zAR) {
        this.zAR = zAR;
    }

    @JsonProperty("USD")
    public Double getUSD() {
        return uSD;
    }

    @JsonProperty("USD")
    public void setUSD(Double uSD) {
        this.uSD = uSD;
    }

    @JsonProperty("MXN")
    public Double getMXN() {
        return mXN;
    }

    @JsonProperty("MXN")
    public void setMXN(Double mXN) {
        this.mXN = mXN;
    }

    @JsonProperty("ILS")
    public Double getILS() {
        return iLS;
    }

    @JsonProperty("ILS")
    public void setILS(Double iLS) {
        this.iLS = iLS;
    }

    @JsonProperty("GBP")
    public Double getGBP() {
        return gBP;
    }

    @JsonProperty("GBP")
    public void setGBP(Double gBP) {
        this.gBP = gBP;
    }

    @JsonProperty("KRW")
    public Double getKRW() {
        return kRW;
    }

    @JsonProperty("KRW")
    public void setKRW(Double kRW) {
        this.kRW = kRW;
    }

    @JsonProperty("MYR")
    public Double getMYR() {
        return mYR;
    }

    @JsonProperty("MYR")
    public void setMYR(Double mYR) {
        this.mYR = mYR;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
