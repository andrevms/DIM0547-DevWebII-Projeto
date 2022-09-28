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
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @OneToMany(fetch = FetchType.LAZY)
    private List<ListaDeEstudos> listaDeEstudos;

    public Usuario() {
      
    }

    public Usuario(String nome, List<ListaDeEstudos> listaDeEstudos) {
        this.nome = nome;
        this.listaDeEstudos = listaDeEstudos;
    }
    
    public Usuario(int id, String nome, List<ListaDeEstudos> listaDeEstudos) {
        this.id = id;
        this.nome = nome;
        this.listaDeEstudos = listaDeEstudos;
    }

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

    public List<ListaDeEstudos> getListaDeEstudos() {
        return listaDeEstudos;
    }

    public void setListaDeEstudos(List<ListaDeEstudos> listaDeEstudos) {
        this.listaDeEstudos = listaDeEstudos;
    }

    
}
