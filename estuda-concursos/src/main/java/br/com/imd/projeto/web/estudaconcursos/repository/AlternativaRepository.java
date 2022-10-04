package br.com.imd.projeto.web.estudaconcursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.imd.projeto.web.estudaconcursos.model.Alternativa;

public interface AlternativaRepository extends JpaRepository<Alternativa, Integer> {

}
