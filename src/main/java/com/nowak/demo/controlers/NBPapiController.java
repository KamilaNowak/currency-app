package com.nowak.demo.controlers;

import com.nowak.demo.java_objects.GoldDto;
import com.nowak.demo.json_pojos.Gold;
import com.nowak.demo.objects.Currencies;
import com.nowak.demo.ops.LatestListOperations;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class NBPapiController {
    private WebClient webClient;
    private  List<Currencies> currencies;
    private List<GoldDto> goldDtoList;
    private LatestListOperations latestListOperations;
    private String NBP_WEBSITE_URL = "http://api.nbp.pl/api/cenyzlota";
    private String FORMAT_JSON = "?format=json";
    private String SLASH = "/";


    @PostConstruct
    public void init() {
        webClient = WebClient.create(NBP_WEBSITE_URL);
        goldDtoList = new ArrayList<>();
        currencies= new ArrayList<>();
        latestListOperations= new LatestListOperations();
    }

    @GetMapping(value = {"/gold", "/gold/{date}", "/gold/{date}/{endDate}"})
    public String getAll(@PathVariable Map<String, String> datePathVariables,
                         HttpServletRequest request, Model model) {
        String url;
        if (datePathVariables.containsKey("date") && datePathVariables.containsKey("endDate")) {
            url = NBP_WEBSITE_URL + SLASH + datePathVariables.get("date")
                    + SLASH + datePathVariables.get("endDate") + FORMAT_JSON;
        } else if (datePathVariables.containsKey("date") && !datePathVariables.containsKey("endDate")) {
            url = NBP_WEBSITE_URL + SLASH + datePathVariables.get("date") + FORMAT_JSON;
        } else {
            url = NBP_WEBSITE_URL + FORMAT_JSON;
        }
        try {
            Mono<Gold[]> goldMono = webClient.get()
                    .uri(url)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(Gold[].class);

            goldDtoList.clear();
            for (int i = 0; i < goldMono.block().length; i++) {
                GoldDto goldDto = new GoldDto(goldMono.block()[i].getData(),
                        Objects.requireNonNull(Objects.requireNonNull(goldMono.block())[i].getCena()));
                goldDtoList.add(goldDto);
            }
        }
         catch (Exception e){
            model.addAttribute("error_message_gold","Something went wrong. Please check if input data are correct.");
             currencies = latestListOperations.getAllCurrencies();
             model.addAttribute("currencies",currencies);
            return "main";
         }
        currencies = latestListOperations.getAllCurrencies();
        model.addAttribute("currencies",currencies);
        model.addAttribute("goldDtoList", goldDtoList);
        return "main";
    }


}
