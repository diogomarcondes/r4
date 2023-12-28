package com.example.demo.config.retry;

import com.example.demo.exception.IgnoredException;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * Configuracao via bean
 */
@Configuration
public class RetryRe4Config {

    @Autowired
    private RetryRegistry retryRegistry;

    @Bean
    public Retry buildRetryConfig() {
        RetryConfig customConfig = RetryConfig.custom()
                .maxAttempts(3)
                .waitDuration(Duration.ofSeconds(2))
                .retryExceptions(Exception.class) // Pra quais exceptions devemos aplicar o retry
                .ignoreExceptions(IgnoredException.class) // Quais exceptions devemos ignorar
                .build();

        return retryRegistry.retry("customRetryConfig", customConfig);
    }
}
