package com.example.calculate.service;

import com.example.calculate.repository.ConvertRepository;
import com.example.calculate.repository.IConvertRepository;

public class ConvertService implements IConvertService{
    IConvertRepository repository = new ConvertRepository();
    @Override
    public float convert(float usd, float rate) {
        return repository.convert(usd, rate);
    }
}
