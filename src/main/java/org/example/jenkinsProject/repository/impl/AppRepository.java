package org.example.jenkinsProject.repository.impl;

import org.example.jenkinsProject.repository.IAppRepository;
import org.example.jenkinsProject.utils.CommonConstants;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AppRepository implements IAppRepository {

    //  It will be used as list later. Now it can be replaced with String

    private final List<String> stringStorage = new ArrayList<String>() {{
        add(CommonConstants.DEFAULT_USER_NAME);
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
