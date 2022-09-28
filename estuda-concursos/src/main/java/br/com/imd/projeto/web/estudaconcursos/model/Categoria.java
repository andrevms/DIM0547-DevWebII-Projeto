package br.com.imd.projeto.web.estudaconcursos.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria {
    
    @Id
    @Column(name = "categoria_id", length = 50)
    private String categoria;


    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<Questao> questoes;

    //Constructor
    public Categoria(String categoria) {
        this.categoria = categoria;
    }

    //Getter's
    public String getCategoria() {
        return categoria;
    }

    //Setter's
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
}
