package com.example.demo.web.v1.controller;

import com.example.demo.service.Resilience4jService;
import com.example.demo.web.v1.controller.request.TestRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/resilitest")
@RequiredArgsConstructor
public class TestController {

        private final ApplicationContext context;


        @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Void> executeTransaction(final @RequestBody TestRequest testRequest) throws Exception {

            Resilience4jService resilience4jService = (Resilience4jService) context.getBean(testRequest.getFlowEnum().getValue());
            resilience4jService.execute(testRequest.getValidUrl());

            return ResponseEntity.ok().build();
        }
}
