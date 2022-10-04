package br.com.imd.projeto.web.estudaconcursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.imd.projeto.web.estudaconcursos.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Categoria findByCategoria(String name);

}
