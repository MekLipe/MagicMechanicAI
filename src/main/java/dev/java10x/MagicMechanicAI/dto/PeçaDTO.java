package dev.java10x.MagicMechanicAI.dto;

import dev.java10x.MagicMechanicAI.model.TipoQualidade;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class PeçaDTO {

    private Long id;
    private String nome;
    private String fabricante;
    private String codigo_original;
    private String categoria;
    private TipoQualidade qualidade;
    private List<String> compatibilidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCodigo_original() {
        return codigo_original;
    }

    public void setCodigo_original(String codigo_original) {
        this.codigo_original = codigo_original;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public TipoQualidade getQualidade() {
        return qualidade;
    }

    public void setQualidade(TipoQualidade qualidade) {
        this.qualidade = qualidade;
    }

    public List<String> getCompatibilidade() {
        return compatibilidade;
    }

    public void setCompatibilidade(List<String> compatibilidade) {
        this.compatibilidade = compatibilidade;
    }
}
