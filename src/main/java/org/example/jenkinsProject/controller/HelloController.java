package org.example.jenkinsProject.controller;

import org.example.jenkinsProject.service.IWelcomeTextService;
import org.example.jenkinsProject.service.IFavoriteTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    IWelcomeTextService welcomeTextService;
    IFavoriteTopicService favoriteTopicService;

    @Autowired
    public HelloController(@Qualifier("welcomeTextServiceImpl") IWelcomeTextService welcomeTextService,
                           IFavoriteTopicService favoriteTopicService) {
        this.welcomeTextService = welcomeTextService;
        this.favoriteTopicService = favoriteTopicService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String greeting(Model viewModel) {
        viewModel.addAttribute("messageToPrint", welcomeTextService.generateWelcomeMessage().toString());
        viewModel.addAttribute("favoriteTopic", favoriteTopicService.getFavoriteTopic());
        System.out.println(favoriteTopicService.getFavoriteTopic());
        return "hello";
    }

    @PostMapping("/hello")
    public String setUser(@RequestParam(name = "userName") String userName, Model viewModel) {
        welcomeTextService.setUsername(userName);
        return greeting(viewModel);
    }
}
