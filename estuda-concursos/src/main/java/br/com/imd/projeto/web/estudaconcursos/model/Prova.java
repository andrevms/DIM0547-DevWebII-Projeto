package br.com.imd.projeto.web.estudaconcursos.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "prova")
public class Prova {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "prova_nome")
    private String provaNome;

    @ManyToMany
    @JoinTable(name = "questoes_provas", joinColumns = @JoinColumn(name = "prova_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "questao_id", referencedColumnName = "id"))
    private List<Questao> questoes;

    public Prova() {
    }

    public Prova(String provaNome) {
        this.provaNome = provaNome;
    }

    public Prova(Integer id, String provaNome) {
        this.id = id;
        this.provaNome = provaNome;
    }

    public Prova(Integer id, String provaNome, List<Questao> questoes) {
        this.id = id;
        this.provaNome = provaNome;
        this.questoes = questoes;
    }

    // Getter's
    public Integer getId() {
        return id;
    }

    public String getProvaNome() {
        return provaNome;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    // Setter's
    public void setId(Integer id) {
        this.id = id;
    }

    public void setProvaNome(String provaNome) {
        this.provaNome = provaNome;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

}
