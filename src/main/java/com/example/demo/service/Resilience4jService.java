package com.example.demo.service;

public interface Resilience4jService {

    void execute(final Boolean validUrl) throws Exception;
}
