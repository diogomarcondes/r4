package com.example.demo.web.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "r4client", url = "https://google.com/")
public interface Resilience4TestClient {

    @RequestMapping(method = RequestMethod.GET, produces = "text/html")
    String getvalidUrl();
}