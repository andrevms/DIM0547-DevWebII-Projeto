package br.com.imd.projeto.web.estudaconcursos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "questao")
public class Questao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String enunciado;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "resposta_id")
    private Alternativa resposta;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "alternativas_questoes", 
    joinColumns = @JoinColumn(name = "questao_id"), 
    inverseJoinColumns = @JoinColumn(name = "alternativa_id"))
    private List<Alternativa> alternativas;

    @ManyToMany(mappedBy = "questoes")
    private List<Prova> provas;
    
    public Questao() {
    }

    public Questao(Integer id, String enunciado) {
        this.id = id;
        this.enunciado = enunciado;
    }

    public Questao(String enunciado) {
        this.enunciado = enunciado;
    }

    public Questao(Integer id, String enunciado, Categoria categoria, Alternativa resposta,
            List<Alternativa> alternativas) {
        this.id = id;
        this.enunciado = enunciado;
        this.categoria = categoria;
        this.resposta = resposta;
        this.alternativas = alternativas;
    }

    // Getter's
    public Integer getId() {
        return id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Alternativa getResposta() {
        return resposta;
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    // Setter's
    public void setId(Integer id) {
        this.id = id;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setResposta(Alternativa resposta) {
        this.resposta = resposta;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

}
