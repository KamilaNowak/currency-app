package com.nowak.demo.ops;

import com.nowak.demo.java_objects.ConvertDto;
import com.nowak.demo.java_objects.LatestDto;
import com.nowak.demo.json_pojos.Latest;
import com.nowak.demo.json_pojos_conv.Convert;
import com.nowak.demo.objects.Currencies;
import reactor.core.publisher.Mono;
import java.util.*;

public class LatestListOperations {
    public List<LatestDto> convertAndAddToList(Mono<Latest> latestMono, List<LatestDto> finalList) {
        Collection<LatestDto>list = new LinkedList<>();
            list.add(new LatestDto("CAD", Objects.requireNonNull(latestMono.block()).getRates().getCAD()));
            list.add(new LatestDto("HKD", Objects.requireNonNull(latestMono.block()).getRates().getHKD()));
            list.add(new LatestDto("ISK", Objects.requireNonNull(latestMono.block()).getRates().getISK()));
            list.add(new LatestDto("PHP", Objects.requireNonNull(latestMono.block()).getRates().getPHP()));
            list.add(new LatestDto("DKK", Objects.requireNonNull(latestMono.block()).getRates().getDKK()));
            list.add(new LatestDto("HUF", Objects.requireNonNull(latestMono.block()).getRates().getHUF()));
            list.add(new LatestDto("CZK", Objects.requireNonNull(latestMono.block()).getRates().getCZK()));
            list.add(new LatestDto("AUD", Objects.requireNonNull(latestMono.block()).getRates().getAUD()));
            list.add(new LatestDto("RON", Objects.requireNonNull(latestMono.block()).getRates().getRON()));
            list.add(new LatestDto("SEK", Objects.requireNonNull(latestMono.block()).getRates().getSEK()));
            list.add(new LatestDto("IDR", Objects.requireNonNull(latestMono.block()).getRates().getIDR()));
            list.add(new LatestDto("INR", Objects.requireNonNull(latestMono.block()).getRates().getINR()));
            list.add(new LatestDto("BRL", Objects.requireNonNull(latestMono.block()).getRates().getBRL()));
            list.add(new LatestDto("RUB", Objects.requireNonNull(latestMono.block()).getRates().getRUB()));
            list.add(new LatestDto("HRK", Objects.requireNonNull(latestMono.block()).getRates().getHRK()));
            list.add(new LatestDto("JPY", Objects.requireNonNull(latestMono.block()).getRates().getJPY()));
            list.add(new LatestDto("THB", Objects.requireNonNull(latestMono.block()).getRates().getTHB()));
            list.add(new LatestDto("CHF", Objects.requireNonNull(latestMono.block()).getRates().getCHF()));
            list.add(new LatestDto("SGD", Objects.requireNonNull(latestMono.block()).getRates().getSGD()));
            list.add(new LatestDto("PLN", Objects.requireNonNull(latestMono.block()).getRates().getPLN()));
            list.add(new LatestDto("BGN", Objects.requireNonNull(latestMono.block()).getRates().getBGN()));
            list.add(new LatestDto("TRY", Objects.requireNonNull(latestMono.block()).getRates().getTRY()));
            list.add(new LatestDto("CNY", Objects.requireNonNull(latestMono.block()).getRates().getCNY()));
            list.add(new LatestDto("NOK", Objects.requireNonNull(latestMono.block()).getRates().getNOK()));
            list.add(new LatestDto("NZD", Objects.requireNonNull(latestMono.block()).getRates().getNZD()));
            list.add(new LatestDto("ZAR", Objects.requireNonNull(latestMono.block()).getRates().getZAR()));
            list.add(new LatestDto("USD", Objects.requireNonNull(latestMono.block()).getRates().getUSD()));
            list.add(new LatestDto("MXN", Objects.requireNonNull(latestMono.block()).getRates().getMXN()));
            list.add(new LatestDto("ILS", Objects.requireNonNull(latestMono.block()).getRates().getILS()));
            list.add(new LatestDto("GBP", Objects.requireNonNull(latestMono.block()).getRates().getGBP()));
            list.add(new LatestDto("KRW", Objects.requireNonNull(latestMono.block()).getRates().getKRW()));
            list.add(new LatestDto("MYR", Objects.requireNonNull(latestMono.block()).getRates().getMYR()));
        for (LatestDto l: list) {
            if(l.getCurrencyValue()!=null){
                finalList.add(l);
            }
        }
        return finalList;
    }
    public List<ConvertDto> convertAndAddToListConvert(Mono<Convert> convertMono, List<ConvertDto> finalList) {
        Collection<ConvertDto>list = new LinkedList<>();
        list.add(new ConvertDto("CAD", convertMono.block().getRates().getCAD()));
        list.add(new ConvertDto("HKD", convertMono.block().getRates().getHKD()));
        list.add(new ConvertDto("ISK", convertMono.block().getRates().getISK()));
        list.add(new ConvertDto("PHP",convertMono.block().getRates().getPHP()));
        list.add(new ConvertDto("DKK",convertMono.block().getRates().getDKK()));
        list.add(new ConvertDto("HUF", convertMono.block().getRates().getHUF()));
        list.add(new ConvertDto("CZK", convertMono.block().getRates().getCZK()));
        list.add(new ConvertDto("AUD", convertMono.block().getRates().getAUD()));
        list.add(new ConvertDto("RON", convertMono.block().getRates().getRON()));
        list.add(new ConvertDto("SEK", convertMono.block().getRates().getSEK()));
        list.add(new ConvertDto("IDR", Objects.requireNonNull(convertMono.block()).getRates().getIDR()));
        list.add(new ConvertDto("INR", Objects.requireNonNull(convertMono.block()).getRates().getINR()));
        list.add(new ConvertDto("BRL", Objects.requireNonNull(convertMono.block()).getRates().getBRL()));
        list.add(new ConvertDto("RUB", Objects.requireNonNull(convertMono.block()).getRates().getRUB()));
        list.add(new ConvertDto("HRK", Objects.requireNonNull(convertMono.block()).getRates().getHRK()));
        list.add(new ConvertDto("JPY", Objects.requireNonNull(convertMono.block()).getRates().getJPY()));
        list.add(new ConvertDto("THB", Objects.requireNonNull(convertMono.block()).getRates().getTHB()));
        list.add(new ConvertDto("CHF", Objects.requireNonNull(convertMono.block()).getRates().getCHF()));
        list.add(new ConvertDto("SGD", Objects.requireNonNull(convertMono.block()).getRates().getSGD()));
        list.add(new ConvertDto("PLN", Objects.requireNonNull(convertMono.block()).getRates().getPLN()));
        list.add(new ConvertDto("BGN", Objects.requireNonNull(convertMono.block()).getRates().getBGN()));
        list.add(new ConvertDto("TRY", Objects.requireNonNull(convertMono.block()).getRates().getTRY()));
        list.add(new ConvertDto("CNY", Objects.requireNonNull(convertMono.block()).getRates().getCNY()));
        list.add(new ConvertDto("NOK", Objects.requireNonNull(convertMono.block()).getRates().getNOK()));
        list.add(new ConvertDto("NZD", Objects.requireNonNull(convertMono.block()).getRates().getNZD()));
        list.add(new ConvertDto("ZAR", Objects.requireNonNull(convertMono.block()).getRates().getZAR()));
        list.add(new ConvertDto("USD", Objects.requireNonNull(convertMono.block()).getRates().getUSD()));
        list.add(new ConvertDto("MXN", Objects.requireNonNull(convertMono.block()).getRates().getMXN()));
        list.add(new ConvertDto("ILS", Objects.requireNonNull(convertMono.block()).getRates().getILS()));
        list.add(new ConvertDto("GBP", Objects.requireNonNull(convertMono.block()).getRates().getGBP()));
        list.add(new ConvertDto("KRW", Objects.requireNonNull(convertMono.block()).getRates().getKRW()));
        list.add(new ConvertDto("MYR", Objects.requireNonNull(convertMono.block()).getRates().getMYR()));
        for (ConvertDto l: list) {
            if(l.getConvertName()!=null){
                finalList.add(l);
            }
        }
        return finalList;
    }
    public List<Currencies> getAllCurrencies(){
        List <Currencies> list = new ArrayList<>();
        list.add(new Currencies("CAD"));
        list.add(new Currencies("HKD"));
        list.add(new Currencies("ISK"));
        list.add(new Currencies("PHP"));
        list.add(new Currencies("DKK"));
        list.add(new Currencies("HUF"));
        list.add(new Currencies("CZK"));
        list.add(new Currencies("AUD"));
        list.add(new Currencies("RON"));
        list.add(new Currencies("SEK"));
        list.add(new Currencies("IDR"));
        list.add(new Currencies("INR"));
        list.add(new Currencies("BRL"));
        list.add(new Currencies("RUB"));
        list.add(new Currencies("HRK"));
        list.add(new Currencies("JPY"));
        list.add(new Currencies("THB"));
        list.add(new Currencies("CHF"));
        list.add(new Currencies("SGD"));
        list.add(new Currencies("PLN"));
        list.add(new Currencies("BGN"));
        list.add(new Currencies("TRY"));
        list.add(new Currencies("CNY"));
        list.add(new Currencies("NOK"));
        list.add(new Currencies("NZD"));
        list.add(new Currencies("ZAR"));
        list.add(new Currencies("USD"));
        list.add(new Currencies("MXN"));
        list.add(new Currencies("ILS"));
        list.add(new Currencies("GBP"));
        list.add(new Currencies("KRW"));
        list.add(new Currencies("MYR"));
        return list;
    }
}
