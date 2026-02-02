package dev.java10x.MagicMechanicAI.controller;

import dev.java10x.MagicMechanicAI.model.Carro;
import dev.java10x.MagicMechanicAI.service.CarroService;
import dev.java10x.MagicMechanicAI.service.GeminiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PecasInteresseController {
    GeminiService gemini_service;
    CarroService carro_service;

    public PecasInteresseController(GeminiService gemini_service, CarroService carro_service) {
        this.gemini_service = gemini_service;
        this.carro_service = carro_service;
    }

    @GetMapping("/gerar/{id}")
    public Mono<ResponseEntity<String>> GeneratePeca(@PathVariable Long id) {
        Carro carro_encontrado = carro_service.ListarPorID(id);
        return gemini_service.GeneratePeca(carro_encontrado)
                .map(resposta_gemini -> ResponseEntity.ok(resposta_gemini)) //se existir uma peça, será retornado um ok, pois foi achado
                .defaultIfEmpty(ResponseEntity.noContent().build()); //se não existir uma peça, será retornado que não há conteúdo
    }
}
