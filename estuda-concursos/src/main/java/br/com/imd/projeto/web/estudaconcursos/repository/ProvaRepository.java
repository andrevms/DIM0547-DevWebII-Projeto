package br.com.imd.projeto.web.estudaconcursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.imd.projeto.web.estudaconcursos.model.Prova;

public interface ProvaRepository extends JpaRepository<Prova, Integer> {
    
}
