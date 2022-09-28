package br.com.imd.projeto.web.estudaconcursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.imd.projeto.web.estudaconcursos.model.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Integer>{
    
}
