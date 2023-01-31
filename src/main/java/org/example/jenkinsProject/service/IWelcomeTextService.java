package org.example.jenkinsProject.service;

public interface IWelcomeTextService {
    void addUser(String username);
    StringBuilder generateWelcomeMessage();
}
