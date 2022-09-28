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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeUsuario(Usuario usuario) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Usuario getUsuarioById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Usuario> getListUsuario() {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}
