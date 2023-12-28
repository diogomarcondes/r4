package com.example.demo.config.retry.predicate;

import java.util.function.Predicate;

public class RetryCondition implements Predicate<String> {
    @Override
    public boolean test(String value) {
        System.out.println("Predicate executada");
        return value.length()>10;
    }
}