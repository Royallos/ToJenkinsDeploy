package org.example.jenkinsProject.service.impl;

import org.example.jenkinsProject.model.User;
import org.example.jenkinsProject.repository.IUserRepo;
import org.example.jenkinsProject.service.IWelcomeTextService;
import org.example.jenkinsProject.utils.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WelcomeTextServiceImpl implements IWelcomeTextService {

    IUserRepo appRepository;

    @Autowired
    public WelcomeTextServiceImpl(IUserRepo appRepository) {
        this.appRepository = appRepository;
    }

    @Override
    public void addUser(String username) {
        User user = new User();
        user.setUserName(username);

        appRepository.save(user);
    }

    @Override
    public StringBuilder generateWelcomeMessage() {
        StringBuilder resultMessageBuilder = new StringBuilder(CommonConstants.WELCOME_TEXT);
        return resultMessageBuilder.append(", ").append(appRepository.findById(0L)
                .isPresent() ? appRepository.findById(0L).get().getUserName() : "guest");
    }
}
