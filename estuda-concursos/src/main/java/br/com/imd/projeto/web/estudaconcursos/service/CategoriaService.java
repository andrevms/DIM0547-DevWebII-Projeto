package br.com.imd.projeto.web.estudaconcursos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.imd.projeto.web.estudaconcursos.model.Categoria;

@Service
public interface CategoriaService {

    public Categoria saveCategoria(Categoria categoria);

    public void removeCategoria(String id);

    public void atualizarCategoria(int id, String categoria);

    public Categoria getCategoriaByNome(String nome);

    public Categoria recuperarPorId(int id);

    public List<Categoria> getListCategoria();
}
