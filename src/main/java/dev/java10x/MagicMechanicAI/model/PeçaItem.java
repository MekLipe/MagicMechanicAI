package dev.java10x.MagicMechanicAI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Peça_Item")
@NoArgsConstructor
@AllArgsConstructor
public class PeçaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, name = "Nome")
    private String nome;

    @Column(nullable = false, name = "Fabricante")
    private String fabricante;

    @Column(nullable = true,name = "Codigo_Original")
    private String codigo_original;

    @Column(nullable = false, name = "Categoria")
    private String categoria;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,name = "Qualidade")
    private TipoQualidade qualidade;

    @Column(nullable = true, name = "Compatibilidade")
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
