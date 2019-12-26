package com.nowak.demo.controlers;

import net.minidev.json.JSONObject;
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
public class APIController {
    private WebClient webClient;
    private String WEBSITE_URL = "https://api.exchangeratesapi.io";
    private String URL_BASE = "/latest?base=";
    private String URL_LATEST = "/latest";
    private String URL_SYMBOLS = "/latest?symbols=";
    private String URL_HISTORY_START ="/history?start_at=";
    private String URL_HISTORY_END ="&end_at=";

    @PostConstruct
    public void init() {
        webClient = WebClient.create(WEBSITE_URL);
    }

    @GetMapping(value = "/currency")
    public Mono<JSONObject> getAll(HttpServletRequest request) {
        return webClient.get()
                .uri(WEBSITE_URL + URL_LATEST)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(JSONObject.class);
    }

    @GetMapping(value = "/currency/base/{base}")
    public Mono<JSONObject> getByDate(@PathVariable("base") String base) {
        return webClient.get()
                .uri(WEBSITE_URL + URL_BASE + base)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(response -> response.bodyToMono(JSONObject.class));
    }

    @GetMapping(value = {"/currency/symbols/{symbols}",
            "/currency/symbols/{symbols}/{base}"})
    public Mono<JSONObject> getBySymbols(@PathVariable Map<String, String> pathVariables) {
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
                .flatMap(res -> res.bodyToMono(JSONObject.class));
    }

    //https://api.exchangeratesapi.io/history?start_at=2018-01-01&end_at=2018-09-01&symbols=ILS,PLN&base=GBP
    @GetMapping(value ={ "/currency/date/{date}/{symbols}/{base}",
                        "/currency/date/{date}/{symbols}",
                        "/currency/date/{date}"})
    public Mono<JSONObject> getCurrencyByDate(@PathVariable Map<String,String> pathVariablesmap){
        String tempUrl=null;
        if(pathVariablesmap.containsKey("base")){
            tempUrl=WEBSITE_URL+URL_HISTORY_START
                    +pathVariablesmap.get("date")
                    +URL_HISTORY_END+ pathVariablesmap.get("date")
                    +"&symbols="+pathVariablesmap.get("symbols")
                    +"&base="+pathVariablesmap.get("base");
        }
        else if(!pathVariablesmap.containsKey("base") && pathVariablesmap.containsKey("symbols")){
            tempUrl=WEBSITE_URL+URL_HISTORY_START
                    +pathVariablesmap.get("date")
                    +URL_HISTORY_END+ pathVariablesmap.get("date")
                    +"&symbols="+pathVariablesmap.get("symbols");
        }
        else  if(!pathVariablesmap.containsKey("base") && !pathVariablesmap.containsKey("symbols")){
            tempUrl = WEBSITE_URL + URL_HISTORY_START
                    + pathVariablesmap.get("date")
                    + URL_HISTORY_END + pathVariablesmap.get("date");
        }
        return webClient.get()
                .uri(tempUrl)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(response ->response.bodyToMono(JSONObject.class));
    }
}
