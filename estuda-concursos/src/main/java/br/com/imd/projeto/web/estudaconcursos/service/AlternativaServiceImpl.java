package br.com.imd.projeto.web.estudaconcursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.imd.projeto.web.estudaconcursos.model.Alternativa;
import br.com.imd.projeto.web.estudaconcursos.repository.AlternativaRepository;

@Component
public class AlternativaServiceImpl implements AlternativaService {

    @Autowired
    AlternativaRepository alternativaRepository;

    @Override
    public Alternativa saveAlternativa(Alternativa alternativa) {
        return alternativaRepository.save(alternativa);
    }

    @Override
    public void removeAlternativa(String id) {
       alternativaRepository.deleteById(Integer.parseInt(id));
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

    @Override
    public void atualizarAlternativa(int id, String alt) {
      var cat = alternativaRepository.getReferenceById(id);
      cat.setAlternativa(alt);
      alternativaRepository.save(cat);
    }
    
}
