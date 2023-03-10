package org.example.jenkinsProject.service.welcomeDecorator;

import org.example.jenkinsProject.repository.IAppRepository;
import org.example.jenkinsProject.service.impl.WelcomeTextServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WelcomeTextDecorator extends WelcomeTextServiceImpl {

    @Autowired
    public WelcomeTextDecorator(IAppRepository appRepository) {
        super(appRepository);
    }

    @Override
    public StringBuilder generateWelcomeMessage() {
        return super.generateWelcomeMessage().append(". You are the most important user!");
    }
}
