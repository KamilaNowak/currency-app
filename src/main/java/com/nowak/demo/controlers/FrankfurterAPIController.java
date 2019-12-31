package com.nowak.demo.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;

@Controller
public class FrankfurterAPIController {
    //https://api.frankfurter.app/latest?amount=2.444&from=USD&to=PLN
    private WebClient webClient;
    private String FRANKFURTER_WEBSITE_URL = "https://api.frankfurter.app/";
    private String SLASH = "/";

    @PostConstruct
    public void init() {
        webClient = WebClient.create(FRANKFURTER_WEBSITE_URL);
    }
}
