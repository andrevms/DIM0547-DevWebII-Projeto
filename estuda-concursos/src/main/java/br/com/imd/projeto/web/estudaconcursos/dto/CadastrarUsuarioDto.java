package br.com.imd.projeto.web.estudaconcursos.dto;

import br.com.imd.projeto.web.estudaconcursos.model.Usuario;

public class CadastrarUsuarioDto {
    String nome;
    String email;
    String senha;
    String confirmarSenha;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
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
    public String getConfirmarSenha() {
        return confirmarSenha;
    }
    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    public boolean senhaEConfirmacaoConferem() {
        if (this.senha.trim().equals(confirmarSenha.trim())) {
            return true;
        } else {
            return false;
        }
    }

    public Usuario paraUsuario() {
        return new Usuario(this.nome, this.email, this.confirmarSenha);
    }
    @Override
    public String toString() {
        return "CadastrarUsuarioDto [nome=" + nome + ", email=" + email + ", senha=" + senha + ", confirmarSenha="
                + confirmarSenha + "]";
    }
    
    
}
