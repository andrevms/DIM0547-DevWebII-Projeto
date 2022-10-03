package br.com.imd.projeto.web.estudaconcursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.imd.projeto.web.estudaconcursos.model.Alternativa;
import br.com.imd.projeto.web.estudaconcursos.repository.AlternativaRepository;

@Component
public class AlternativaServiceImpl implements AltenativaService {

    @Autowired
    AlternativaRepository alternativaRepository;

    @Override
    public Alternativa saveAlternativa(Alternativa alternativa) {
        return alternativaRepository.save(alternativa);
    }

    @Override
    public void removeAlternativa(Alternativa alternativa) {
       alternativaRepository.deleteById(alternativa.getId());
    }

    @Override
    public Alternativa getAlternativaById(Integer id) {
        return alternativaRepository.findById(id).map(alt -> {
            return alt;
        }).orElseThrow(() -> null);
    }

    @Override
    public List<Alternativa> getListAlternativa() {
        return alternativaRepository.findAll();
    }


    
}
