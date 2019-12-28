package com.nowak.demo.controlers;

import com.nowak.demo.ops.LatestListOperations;
import com.nowak.demo.entities.User;
import com.nowak.demo.java_objects.LatestDto;
import com.nowak.demo.json_pojos.Latest;
import com.nowak.demo.models.UserModel;
import com.nowak.demo.service.UserService;
import com.nowak.demo.sub_service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import javax.print.attribute.standard.PresentationDirection;
import javax.validation.Valid;
import java.util.*;

@Controller
public class ViewController {
    private WebClient webClient;
    private List<LatestDto> latest;
    LatestListOperations latestListOperations;

    private String WEBSITE_URL = "https://api.exchangeratesapi.io";
    private String URL_BASE = "/latest?base=";
    private String URL_LATEST = "/latest";
    private String URL_SYMBOLS = "/latest?symbols=";
    private String URL_HISTORY_START = "/history?start_at=";
    private String URL_HISTORY_END = "&end_at=";

    @PostConstruct
    public void init() {
        webClient = WebClient.create(WEBSITE_URL);
        latest = new ArrayList();
        latestListOperations = new LatestListOperations();
    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserService userService;
    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping("/")
    public String getLandingPage() {
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("userModel", new UserModel());
        return "login-form";
    }

    @GetMapping("/home")
    public String showHome(Model model) {
        Mono<Latest> r = webClient.get().uri(WEBSITE_URL + URL_LATEST)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Latest.class);
        latest.clear();
        latest = latestListOperations.convertAndAddToList(r, latest);
        model.addAttribute("latestDto", latest);
        model.addAttribute("latestDate", Objects.requireNonNull(r.block()).getDate());
        model.addAttribute("latestBase", Objects.requireNonNull(r.block()).getBase());
        return "main";
    }

    @GetMapping("/register")
    public String getHomePage(@Valid @ModelAttribute("userModel") UserModel userModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login-form";
        }
        User user = null;
        user = userService.findByEmail(userModel.getEmail());
        if (user != null) {
            return "login-form";
        } else {
            User newUser = new User();
            newUser.setEmail(userModel.getEmail());
            newUser.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
            newUser.setPhoneNumber(userModel.getPhonenumber());
            newUser.setSubscriptionCollection(Collections.singletonList(subscriptionService.findBySubscription("ROLE_STANDARD")));
            userService.save(newUser);
        }
        return "login-form";
    }

    @GetMapping(value = "/currency/base/{base}")
    public String getByDate(@PathVariable("base") String base, Model model) {

        Mono<Latest> r = webClient.get()
                .uri(WEBSITE_URL + URL_BASE + base)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Latest.class);
        latest.clear();
        latest = latestListOperations.convertAndAddToList(r, latest);
        model.addAttribute("latestDto", latest);
        model.addAttribute("latestDate", Objects.requireNonNull(r.block()).getDate());
        model.addAttribute("latestBase", Objects.requireNonNull(r.block()).getBase());
        return "main";
    }
    @GetMapping(value = {"/currency/symbols/{symbols}",
            "/currency/symbols/{symbols}/{base}"})
    public String getBySymbols(@PathVariable Map<String, String> pathVariables, Model model) {

        String tempuri = null;
        if (pathVariables.containsKey("base")) {
            tempuri = WEBSITE_URL + URL_SYMBOLS + pathVariables.get("symbols") + "&base=" + pathVariables.get("base");
        } else {
            String symbols= pathVariables.get("symbols");
            if(symbols.equals("EUR")){
                model.addAttribute("error_message", "You cannot view currency which is specified as base!");
                return "main";
            }
            else
            tempuri = WEBSITE_URL + URL_SYMBOLS + pathVariables.get("symbols");
        }
        System.out.println(tempuri);
        Mono<Latest> latestMono= webClient.get()
                .uri(tempuri)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Latest.class);
        latest.clear();
        latestListOperations.convertAndAddToList(latestMono,latest);
        model.addAttribute("latestDto", latest);
        model.addAttribute("latestDate", Objects.requireNonNull(latestMono.block()).getDate());
        model.addAttribute("latestBase", Objects.requireNonNull(latestMono.block()).getBase());
        return "main";
    }
}
