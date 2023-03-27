package com.example.dictionary.service;

import com.example.dictionary.repository.ITranslateRepository;
import com.example.dictionary.repository.TranslateRepository;

public class TranslateService implements ITranslateService {
    ITranslateRepository repository = new TranslateRepository();
    @Override
    public String translate(String englishWord) {
        return repository.translate(englishWord);
    }
}
