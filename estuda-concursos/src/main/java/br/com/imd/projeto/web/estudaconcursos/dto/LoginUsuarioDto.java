package br.com.imd.projeto.web.estudaconcursos.dto;

public class LoginUsuarioDto {
    String email;
    String senha;
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
    @Override
    public String toString() {
        return "LoginUsuarioDto [email=" + email + ", senha=" + senha + "]";
    }
}
