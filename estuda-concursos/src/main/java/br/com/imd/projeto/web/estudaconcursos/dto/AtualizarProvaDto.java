package br.com.imd.projeto.web.estudaconcursos.dto;

public class AtualizarProvaDto {
    private int id;
    private String prova;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProva() {
        return prova;
    }

    public void setProva(String prova) {
        this.prova = prova;
    }

    @Override
    public String toString() {
        return "AtualizarProvaDto [id=" + id + ", prova=" + prova + "]";
    }
}
