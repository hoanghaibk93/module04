package com.example.email.repository.impl;

import com.example.email.repository.IEmailRepository;

public class EmailRepository implements IEmailRepository {

    @Override
    public String[] getLanguages() {
        return new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
    }

    @Override
    public int[] getPageSize() {
        return new int[]{5, 10, 15, 20, 100};
    }
}
