package org.example.jenkinsProject.repository.impl;

import org.example.jenkinsProject.repository.IAppRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AppRepository implements IAppRepository {

    private final List<String> stringStorage = new ArrayList<String>() {{
        add("guest");
    }};

    @Override
    public void putVal(String value) {
        this.stringStorage.clear();
        this.stringStorage.add(value);
    }

    @Override
    public String getVal() {
        return this.stringStorage.get(0);
    }

}
