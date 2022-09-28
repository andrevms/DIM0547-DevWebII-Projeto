package br.com.imd.projeto.web.estudaconcursos.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ListaDeEstudos")
public class ListaDeEstudos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Questao> questoes;

    // Constructors
    public ListaDeEstudos() {
    }

    public ListaDeEstudos(String nome) {
        this.nome = nome;
    }

    public ListaDeEstudos(String nome, List<Questao> questoes) {
        this.nome = nome;
        this.questoes = questoes;
    }

    // Getter's & Setter's
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

}
