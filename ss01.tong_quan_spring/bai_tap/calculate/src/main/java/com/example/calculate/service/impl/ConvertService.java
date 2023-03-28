package com.example.calculate.service.impl;

import com.example.calculate.service.IConvertService;

public class ConvertService implements IConvertService {
    @Override
    public float convert(float usd, float rate) {
        float result = usd * rate;
        return result;
    }
}
