package com.nowak.demo;

import com.sun.deploy.security.SelectableSecurityManager;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeEditor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Past;
import java.util.Map;

@RestController
public class Controller {
    WebClient webClient;
    String WEBSITE_URL = "https://api.exchangeratesapi.io";
    String URL_BASE = "/latest?base=";
    String URL_LATEST = "/latest";
    String URL_SYMBOLS = "/latest?symbols=";

    @PostConstruct
    public void init() {
        webClient = WebClient.create(WEBSITE_URL);
    }

    @GetMapping(value = "/currency")
    public Mono<String> getAll(HttpServletRequest request) {
        return webClient.get()
                .uri(WEBSITE_URL + URL_LATEST)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);
    }

    @GetMapping(value = "/currency/base/{base}")
    public Mono<String> getByDate(@PathVariable("base") String base) {
        return webClient.get()
                .uri(WEBSITE_URL + URL_BASE + base)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(response -> response.bodyToMono(String.class));
    }

    @GetMapping(value = {"/currency/symbols/{symbols}",
            "/currency/symbols/{symbols}/{base}"})
    public Mono<String> getBySymbols(@PathVariable Map<String, String> pathVariables) {
        String tempuri = null;
        if (pathVariables.containsKey("base")) {
            tempuri = WEBSITE_URL + URL_SYMBOLS + pathVariables.get("symbols") + "&base=" + pathVariables.get("base");
        } else
            tempuri = WEBSITE_URL + URL_SYMBOLS + pathVariables.get("symbols");

        System.out.println(WEBSITE_URL + URL_SYMBOLS + pathVariables.get("symbols"));
        return webClient.get()
                .uri(tempuri)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(res -> res.bodyToMono(String.class));
    }
}
