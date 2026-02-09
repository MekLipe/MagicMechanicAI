package dev.java10x.MagicMechanicAI.controller;

import dev.java10x.MagicMechanicAI.model.Carro;
import dev.java10x.MagicMechanicAI.service.CarroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carro")
@CrossOrigin(origins = "http://localhost:5173")
public class CarroController {

    private CarroService carro_service;

    public CarroController(CarroService carro_service) {
        this.carro_service = carro_service;
    }

    //GET
    @GetMapping("/Listar")
    public ResponseEntity<List<Carro>> Listar(){
        List<Carro> lista = carro_service.Listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/ListarID/{id}")
    public ResponseEntity<Carro> ListarPorID(@PathVariable Long id){
        Carro carro_encontrado = carro_service.ListarPorID(id);
        if (carro_encontrado != null)
        {
            return ResponseEntity.ok().body(carro_encontrado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(carro_encontrado);
    }

    //POST
    @PostMapping("/Criar")
    public ResponseEntity<Carro> Criar(@RequestBody Carro carro){
        Carro carro_salvo = carro_service.Salvar(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(carro_salvo);
    }

    //PUT
    @PutMapping("/Atualizar/{id}")
    public ResponseEntity<Carro> Atualizar(@RequestBody Carro carro, @PathVariable Long id){
        if (carro_service.ListarPorID(id) != null){
            carro_service.Alterar(carro, id);
            return ResponseEntity.ok(carro);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //DELETE
    @DeleteMapping("/Deletar/{id}")
    public ResponseEntity<Carro> Deletar(@PathVariable Long id){
        if (carro_service.ListarPorID(id) != null){
            carro_service.Deletar(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.notFound().build();
    }

}
