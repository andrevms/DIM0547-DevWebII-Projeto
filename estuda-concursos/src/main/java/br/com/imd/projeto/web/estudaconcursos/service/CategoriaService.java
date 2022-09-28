package br.com.imd.projeto.web.estudaconcursos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.imd.projeto.web.estudaconcursos.model.Categoria;

@Service
public interface CategoriaService {

    public Categoria saveCategoria(Categoria categoria);

    public void removeCategoria(Categoria categoria);

    public Categoria getCategoriaByNome(String nome);

    public List<Categoria> getListCategoria();
}
