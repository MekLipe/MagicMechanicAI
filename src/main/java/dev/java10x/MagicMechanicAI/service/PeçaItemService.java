package dev.java10x.MagicMechanicAI.service;

import dev.java10x.MagicMechanicAI.model.PeçaItem;
import dev.java10x.MagicMechanicAI.repository.PeçaItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeçaItemService {

    private PeçaItemRepository repository;

    public PeçaItemService(PeçaItemRepository repository) {
        this.repository = repository;
    }

    //CRIAR
    public PeçaItem Salvar(PeçaItem peça){
        return repository.save(peça);
    }

    //LISTAR
    public List<PeçaItem> Listar(){
        return repository.findAll();
    }

    //LISTAR POR ID
    public PeçaItem ListarPorID(Long id){
        Optional<PeçaItem> peça_encontrada = repository.findById(id);
        return peça_encontrada.orElse(null);
    }

    //ALTERAR
    public PeçaItem Alterar(PeçaItem peça_atualizada, Long id){
        Optional<PeçaItem> peça_existente = repository.findById(id);
        if (peça_existente.isPresent()){
            return repository.save(peça_atualizada);
        }
        return null;
    }


    //DELETAR
}
