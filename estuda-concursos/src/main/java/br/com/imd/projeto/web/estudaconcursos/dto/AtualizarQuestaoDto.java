package br.com.imd.projeto.web.estudaconcursos.dto;

public class AtualizarQuestaoDto {

    private int id;
    private String enunciado;

    public AtualizarQuestaoDto(int id, String enunciado) {
        this.id = id;
        this.enunciado = enunciado;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
