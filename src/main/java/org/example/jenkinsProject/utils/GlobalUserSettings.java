package org.example.jenkinsProject.utils;

public class GlobalUserSettings {

    private String favoriteTopic = CommonConstants.DEFAULT_USER_FAVORITE_TOPIC;
    private static final GlobalUserSettings userSettings = new GlobalUserSettings();

    public static GlobalUserSettings getInstance() {
        return userSettings;
    }

    public String getFavoriteTopic() {
        return favoriteTopic;
    }

    public void setFavoriteTopic(String favoriteTopic) {
        this.favoriteTopic = favoriteTopic;
    }
}
