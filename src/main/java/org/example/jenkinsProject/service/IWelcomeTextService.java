package org.example.jenkinsProject.service;

public interface IWelcomeTextService {
    void setUsername(String username);
    StringBuilder generateWelcomeMessage();
}
