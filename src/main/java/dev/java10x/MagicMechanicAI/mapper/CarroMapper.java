package dev.java10x.MagicMechanicAI.mapper;

import dev.java10x.MagicMechanicAI.dto.CarroDTO;
import dev.java10x.MagicMechanicAI.model.Carro;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarroMapper {
    
    public CarroDTO map(Carro carro_model){
        CarroDTO carroDTO = new CarroDTO();
        carroDTO.setId(carro_model.getId());
        carroDTO.setMarca(carro_model.getMarca());
        carroDTO.setModelo(carro_model.getModelo());
        carroDTO.setAno(carro_model.getAno());
        carroDTO.setVersao(carro_model.getVersao());
        return carroDTO;
    }

    public Carro map(CarroDTO carroDTO){
        Carro carro_model = new Carro();
        carro_model.setId(carroDTO.getId());
        carro_model.setMarca(carroDTO.getMarca());
        carro_model.setModelo(carroDTO.getModelo());
        carro_model.setAno(carroDTO.getAno());
        carro_model.setVersao(carroDTO.getVersao());
        return carro_model;
    }
}