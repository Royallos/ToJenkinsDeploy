package org.example.jenkinsProject.service.impl;

import org.example.jenkinsProject.repository.IAppRepository;
import org.example.jenkinsProject.service.IWelcomeTextService;
import org.example.jenkinsProject.utils.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WelcomeTextServiceImpl implements IWelcomeTextService {

    IAppRepository appRepository;

    @Autowired
    public WelcomeTextServiceImpl(IAppRepository appRepository) {
        this.appRepository = appRepository;
    }

    @Override
    public void setUsername(String username) {
        appRepository.putVal(username);
    }

    @Override
    public StringBuilder generateWelcomeMessage() {
        StringBuilder resultMessageBuilder = new StringBuilder(CommonConstants.WELCOME_TEXT);
        return resultMessageBuilder.append(", ").append(appRepository.getVal());
    }
}
