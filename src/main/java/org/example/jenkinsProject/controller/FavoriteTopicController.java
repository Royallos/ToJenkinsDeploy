package org.example.jenkinsProject.controller;

import org.example.jenkinsProject.service.IFavoriteTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FavoriteTopicController {

    IFavoriteTopicService favoriteTopicService;
    @Autowired
    public FavoriteTopicController(IFavoriteTopicService favoriteTopicService) {
        this.favoriteTopicService = favoriteTopicService;
    };

    @RequestMapping(value = "hello/favoriteTopic", method = RequestMethod.POST)
    public String setFavoriteTopic(@RequestParam(name = "favoriteTopic") String favoriteTopic, Model viewModel) {
        favoriteTopicService.setFavoriteTopic(favoriteTopic);
        viewModel.addAttribute("favoriteTopic", favoriteTopicService.getFavoriteTopic());
        return "hello";
    }
}
