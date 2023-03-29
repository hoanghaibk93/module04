package com.example.email.service.impl;

import com.example.email.repository.IEmailRepository;
import com.example.email.repository.impl.EmailRepository;
import com.example.email.service.IEmailService;

public class EmailService implements IEmailService {
    private IEmailRepository repository = new EmailRepository();
    @Override
    public String[] getLanguages() {
        return repository.getLanguages();
    }

    @Override
    public int[] getPageSize() {
        return repository.getPageSize();
    }
}
