package com.nowak.demo.controlers;

import com.nowak.demo.java_objects.ConvertDto;
import com.nowak.demo.json_pojos_conv.Convert;
import com.nowak.demo.objects.Currencies;
import com.nowak.demo.ops.LatestListOperations;
import com.sun.xml.bind.v2.TODO;
import org.springframework.http.MediaType;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class FrankfurterAPIController {
    //https://api.frankfurter.app/latest?amount=2.444&from=USD&to=PLN
    private WebClient webClient;
    private LatestListOperations latestListOperations;
    private  List<Currencies> currencies;
    private String FRANKFURTER_WEBSITE_URL = "https://api.frankfurter.app/latest?";
    private String SLASH = "/";
    private String AMOUNT = "amount=";
    private String FROM = "&from=";
    private String TO = "&to=";
    private List<ConvertDto> result;

    @PostConstruct
    public void init() {
        webClient = WebClient.create(FRANKFURTER_WEBSITE_URL);
        latestListOperations = new LatestListOperations();
        result = new ArrayList<>();
        currencies= new ArrayList<>();
    }

    @GetMapping(value = "/convert/{amount}/{from}/{to}")
    public String convertCurrencyPage(@PathVariable("amount") double amount,
                                      @PathVariable("from") String from,
                                      @PathVariable("to") String to,
                                      Model model) {
        String url;
        currencies = latestListOperations.getAllCurrencies();
        try {
            url = FRANKFURTER_WEBSITE_URL + AMOUNT + amount + FROM + from + TO + to;
            System.out.println(url);
            Mono<Convert> mono = webClient
                    .get()
                    .uri(url)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(Convert.class);

            result.clear();
            result = latestListOperations.convertAndAddToListConvert(mono, result);
            model.addAttribute("result", result);
            model.addAttribute("amount", Objects.requireNonNull(mono.block()).getAmount());
            model.addAttribute("convertDate", Objects.requireNonNull(mono.block()).getDate());
            model.addAttribute("convertBase", Objects.requireNonNull(mono.block()).getBase());

        } catch (Exception e) {
            model.addAttribute("error_message_convert", "Something went wrong. Check if input data are corrected.");
            model.addAttribute("currencies",currencies);
            return "main";
        }
        model.addAttribute("currencies",currencies);
        return "main";
    }
}
