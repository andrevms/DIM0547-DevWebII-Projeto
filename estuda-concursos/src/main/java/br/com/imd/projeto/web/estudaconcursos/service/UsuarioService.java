package br.com.imd.projeto.web.estudaconcursos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.imd.projeto.web.estudaconcursos.dto.CadastrarUsuarioDto;
import br.com.imd.projeto.web.estudaconcursos.model.Usuario;

@Service
public interface UsuarioService {
    
    public Usuario saveUsuario(Usuario usuario);

    public void removeUsuario(Usuario usuario);

    public Usuario getUsuarioById(Integer id);

    public List<Usuario> getListUsuario();

    public boolean login(String email, String senha);
    
}
