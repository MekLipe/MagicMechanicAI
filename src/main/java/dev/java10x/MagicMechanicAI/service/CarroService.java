package dev.java10x.MagicMechanicAI.service;

import dev.java10x.MagicMechanicAI.model.Carro;
import dev.java10x.MagicMechanicAI.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    private CarroRepository repository;

    public CarroService(CarroRepository repository) {
        this.repository = repository;
    }

    //CRIAR
    public Carro Salvar(Carro carro){
        return repository.save(carro);
    }

    //LISTAR
    public List<Carro> Listar(){
        return repository.findAll();
    }

    //LISTAR POR ID
    public Carro ListarPorID(Long id){
        Optional<Carro> carro_encontrado = repository.findById(id);
        return carro_encontrado.orElse(null);
    }

    //ALTERAR
    public Carro Alterar(Carro carro_atualizado, Long id){
        Optional<Carro> carro_existente = repository.findById(id);
        if (carro_existente.isPresent()){
            carro_atualizado.setId(id);
            return repository.save(carro_atualizado);
        }
        return null;
    }

    //Testar o Deletar() com o objeto Carro como parâmetro, se não setiver dando certo, trocar o parametro para receber apenas o ID
    //DELETAR
    public void Deletar(Long id){
        repository.deleteById(id);
    }
}
