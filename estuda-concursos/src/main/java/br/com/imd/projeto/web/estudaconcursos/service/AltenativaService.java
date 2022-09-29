package br.com.imd.projeto.web.estudaconcursos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.imd.projeto.web.estudaconcursos.model.Alternativa;

@Service
public interface AltenativaService {
    public Alternativa saveAlternativa(Alternativa alternativa);

    public void removeAlternativa(Alternativa alternativa);

    public Alternativa getAlternativaById(Integer id);

    public List<Alternativa> getListAlternativa();
}
