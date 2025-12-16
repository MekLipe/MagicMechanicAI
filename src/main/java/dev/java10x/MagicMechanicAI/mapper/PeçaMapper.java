package dev.java10x.MagicMechanicAI.mapper;

import dev.java10x.MagicMechanicAI.dto.PeçaDTO;
import dev.java10x.MagicMechanicAI.model.PeçaItem;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class PeçaMapper {
    
    public PeçaDTO map(PeçaItem peça_model){
        PeçaDTO peçaDTO = new PeçaDTO();
        peçaDTO.setId(peça_model.getId());
        peçaDTO.setFabricante(peça_model.getFabricante());
        peçaDTO.setCodigo_original(peça_model.getCodigo_original());
        peçaDTO.setCategoria(peça_model.getCategoria());
        peçaDTO.setQualidade(peça_model.getQualidade());
        if (peça_model.getCompatibilidade() != null){
            List<String> lista_compatibilidade = peça_model.getCompatibilidade()
                    .stream().toList();
            peçaDTO.setCompatibilidade(lista_compatibilidade);
        }
        return peçaDTO;
    }

    public PeçaItem map(PeçaDTO peçaDTO){
        PeçaItem peça_model = new PeçaItem();
        peça_model.setId(peçaDTO.getId());
        peça_model.setFabricante(peçaDTO.getFabricante());
        peça_model.setCodigo_original(peçaDTO.getCodigo_original());
        peça_model.setCategoria(peçaDTO.getCategoria());
        peça_model.setQualidade(peçaDTO.getQualidade());
        if (peçaDTO.getCompatibilidade() != null){
            List<String> lista_compatibilidade = peçaDTO.getCompatibilidade()
                    .stream().toList();
            peça_model.setCompatibilidade(lista_compatibilidade);
        }
        return peça_model;
    }
}