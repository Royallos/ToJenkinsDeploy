package org.example.jenkinsProject.controller;

import org.example.jenkinsProject.service.IWelcomeTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PoliteHelloController {

    IWelcomeTextService welcomeTextService;

    @Autowired
    public PoliteHelloController(@Qualifier("welcomeTextDecorator") IWelcomeTextService decoratedWelcomeTextService) {
        this.welcomeTextService = decoratedWelcomeTextService;
    }
    @GetMapping("/hello/polite")
    public String greeting(Model viewModel) {
        viewModel.addAttribute("messageToPrint", welcomeTextService.generateWelcomeMessage().toString());
        return "hello";
    }
}
