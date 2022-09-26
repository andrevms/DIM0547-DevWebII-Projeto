package br.com.imd.projeto.web.estudaconcursos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="alternativa")
public class Alternativa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String alternativa;

    @ManyToOne
    @JoinColumn(name="quiz_id", nullable=false)
    private Questao questao;

    //Contrutor

    public Alternativa() {
    }

    public Alternativa(String alternativa) {
        this.alternativa = alternativa;
    }

    public Alternativa(Integer id, String alternativa) {
        this.id = id;
        this.alternativa = alternativa;
    }

    //Getter's & Setter's
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(String alternativa) {
        this.alternativa = alternativa;
    }

    
}
