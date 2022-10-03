package br.com.imd.projeto.web.estudaconcursos.dto;

import br.com.imd.projeto.web.estudaconcursos.model.Prova;

import javax.validation.constraints.NotBlank;

public class RequisicaoAdicionarProvaDto {

    @NotBlank
    private String provaNome;

    public String getProvaNome() {
        return provaNome;
    }

    public void setProvaNome(String provaNome) {
        this.provaNome = provaNome;
    }

    public Prova toProva() {
        Prova prova = new Prova();
        prova.setProvaNome(provaNome);
        return prova;
    }

}
