package dev.java10x.MagicMechanicAI.controller;

import dev.java10x.MagicMechanicAI.model.PeçaItem;
import dev.java10x.MagicMechanicAI.service.PeçaItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/peça")
public class PeçaItemController {

    private PeçaItemService peça_service;

    public PeçaItemController(PeçaItemService peça_service) {
        peça_service = peça_service;
    }

    //GET


    //POST
    public ResponseEntity<PeçaItem> criar(@RequestBody PeçaItem peça){
        PeçaItem peça_salva = peça_service.Salvar(peça);
        return ResponseEntity.ok(peça_salva);
    }

    //PUT


    //DELETE


}
