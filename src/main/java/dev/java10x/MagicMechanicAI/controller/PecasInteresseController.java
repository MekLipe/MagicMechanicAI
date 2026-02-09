package dev.java10x.MagicMechanicAI.controller;
import dev.java10x.MagicMechanicAI.dto.PecaDTO;
import dev.java10x.MagicMechanicAI.model.Carro;
import dev.java10x.MagicMechanicAI.service.CarroService;
import dev.java10x.MagicMechanicAI.service.GeminiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class PecasInteresseController {
    GeminiService gemini_service;
    CarroService carro_service;

    public PecasInteresseController(GeminiService gemini_service, CarroService carro_service) {
        this.gemini_service = gemini_service;
        this.carro_service = carro_service;
    }

    @PostMapping("/gerar/{id}")
    public Mono<ResponseEntity<String>> GeneratePeca(@PathVariable Long id, @RequestBody PecaDTO request) {
        Carro carro_encontrado = carro_service.ListarPorID(id);
        return gemini_service.GeneratePeca(carro_encontrado, request.peca())
                .map(resposta_gemini -> ResponseEntity.ok(resposta_gemini)) //se existir uma peça, será retornado um ok, pois foi achado
                .defaultIfEmpty(ResponseEntity.noContent().build()); //se não existir uma peça, será retornado que não há conteúdo
    }
}
