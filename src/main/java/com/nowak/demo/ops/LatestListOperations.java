package com.nowak.demo.ops;

import com.nowak.demo.java_objects.LatestDto;
import com.nowak.demo.json_pojos.Latest;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;

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
}
