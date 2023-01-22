package org.example.jenkinsProject.service.impl;

import org.example.jenkinsProject.service.IFavoriteTopicService;
import org.example.jenkinsProject.utils.GlobalUserSettings;
import org.springframework.stereotype.Service;

@Service
public class FavoriteTopicServiceImpl implements IFavoriteTopicService {

    @Override
    public String getFavoriteTopic() {
        return GlobalUserSettings.getInstance().getFavoriteTopic();
    }

    @Override
    public void setFavoriteTopic(String favoriteTopic) {
        GlobalUserSettings.getInstance().setFavoriteTopic(favoriteTopic);
    }
}
