package dev.java10x.MagicMechanicAI.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("https://generativelanguage.googleapis.com")
    private String gemini_url;

    @Bean
    public WebClient webClient(WebClient.Builder builder){
        return builder.baseUrl(gemini_url).build();
    }
}
