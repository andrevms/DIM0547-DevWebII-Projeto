package br.com.imd.projeto.web.estudaconcursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.imd.projeto.web.estudaconcursos.model.Categoria;
import br.com.imd.projeto.web.estudaconcursos.repository.CategoriaRepository;

@Component
public class CategoriaServiceImpl  implements CategoriaService{
    
    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public Categoria saveCategoria(Categoria categoria) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeCategoria(Categoria categoria) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Categoria getCategoriaByNome(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Categoria> getListCategoria() {
        // TODO Auto-generated method stub
        return null;
    }
}
