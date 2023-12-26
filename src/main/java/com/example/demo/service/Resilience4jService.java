package com.example.demo.service;

import com.example.demo.web.client.Resilience4TestClient;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class Resilience4jService {

    private final Resilience4TestClient resilience4TestClient;

    @Retry(name = "customRetryConfig", fallbackMethod = "handleExecutionException")
    public void execute(final Boolean validUrl) throws Exception {

        log.info("Tentando executar o fluxo");

        if(validUrl) {
            resilience4TestClient.getvalidUrl();
        } else {
            throw new Exception("Erro ao fazer integracao com aplicacao B.");
        }
    }

    @Retry(name = "secondCustomRetryConfig", fallbackMethod = "handleExecutionException")
    public void executeSecondRetryConfig(final Boolean validUrl) throws Exception {

        log.info("Tentando executar o fluxo 2");

        if(validUrl) {
            resilience4TestClient.getvalidUrl();
        } else {
            throw new Exception("Erro ao fazer integracao com aplicacao B.");
        }
    }

    private void handleExecutionException (final Boolean validUrl, Exception e) {
        log.info("Metodo pós-falha executado");
        log.info("Parametro recebido no método: {}", validUrl);
        log.info("Mensagem de erro: {}", e.getMessage());
    }
}
