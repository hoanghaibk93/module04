package com.example.calculate.repository;

public class ConvertRepository implements IConvertRepository {
    @Override
    public float convert(float usd, float rate) {
        float result = usd * rate;
        return result;
    }
}
