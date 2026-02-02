package dev.java10x.MagicMechanicAI.service;

import dev.java10x.MagicMechanicAI.dto.GeminiResponseDTO;
import dev.java10x.MagicMechanicAI.model.Carro;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.List;
import java.util.Map;

@Service
public class GeminiService {

    private final WebClient web_client;
    private final String api_key = System.getenv("API_KEY");

    public GeminiService(WebClient web_client) {
        this.web_client = web_client;
    }

    /*
   curl "https://generativelanguage.googleapis.com/v1beta/models/gemini-3-flash-preview:generateContent" \
  -H "x-goog-api-key: $GEMINI_API_KEY" \
  -H 'Content-Type: application/json' \
  -X POST \
  -d '{
    "contents": [
      {
        "parts": [
          {
            "text": "Explain how AI works in a few words"
          }
        ]
      }
    ]
  }'
  */

    public Mono GeneratePeca(Carro carro){
        String prompt = String.format(
                "Atue como um mecânico experiente. Tenho um %s %s %s %s %d. " +
                    "Quais são as melhores opções de pneu para esse carro? Responda em poucas palavras.",
                carro.getMarca(),
                carro.getModelo(),
                carro.getMotorizacao(),
                carro.getVersao(),
                carro.getAno()
        );

        Map<String, Object> request_body = Map.of(
                "contents", List.of(
                        Map.of("parts", List.of(
                                Map.of("text", prompt)
                        ))
                )
        );

        return this.web_client.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1beta/models/gemini-3-flash-preview:generateContent")
                        .queryParam("key", api_key)
                        .build())
                .header("Content-Type", "application/json")
                .bodyValue(request_body)
                .retrieve()
                .bodyToMono(GeminiResponseDTO.class)
                .map(resp -> resp.candidates().stream()
                        .findFirst()
                        .flatMap(c -> c.content().parts().stream().findFirst())
                        .map(GeminiResponseDTO.Part::text)
                        .orElse("Nenhuma resposta foi gerada")
                );
    }
}
