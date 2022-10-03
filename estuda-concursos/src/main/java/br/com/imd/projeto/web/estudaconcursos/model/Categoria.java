package br.com.imd.projeto.web.estudaconcursos.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String categoria;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<Questao> questoes;

    // Constructor
    
    public Categoria(String categoria) {
        this.categoria = categoria;
    }

    public Categoria() {
    }

    // Getter's
    public String getCategoria() {
        return categoria;
    }

    // Setter's
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Categoria [id=" + id + ", categoria=" + categoria + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

}
