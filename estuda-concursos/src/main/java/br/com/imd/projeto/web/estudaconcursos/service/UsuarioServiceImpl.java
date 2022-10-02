package br.com.imd.projeto.web.estudaconcursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.imd.projeto.web.estudaconcursos.model.Usuario;
import br.com.imd.projeto.web.estudaconcursos.repository.UsuarioRepository;

@Component
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void removeUsuario(Usuario usuario) {
       usuarioRepository.delete(usuario);
    }

    @Override
    public Usuario getUsuarioById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Usuario> getListUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public boolean login(String email, String senha) {
        var usuario = usuarioRepository.getUsuarioByLogin(email, senha);
        if (usuario.size() > 0) return true;
        return false;
    }    
    
}
