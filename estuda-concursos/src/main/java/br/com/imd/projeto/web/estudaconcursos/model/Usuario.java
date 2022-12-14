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

    private String email;

    private String senha;

    @OneToMany(fetch = FetchType.LAZY)
    private List<ListaDeEstudos> listaDeEstudos;

    public Usuario() {

    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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

    public Usuario(int id, String nome, List<ListaDeEstudos> listaDeEstudos, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.listaDeEstudos = listaDeEstudos;
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", listaDeEstudos="
                + listaDeEstudos + "]";
    }

}
