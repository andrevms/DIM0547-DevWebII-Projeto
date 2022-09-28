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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeAlternativa(Alternativa alternativa) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Alternativa getAlternativaById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Alternativa> getListAlternativa() {
        // TODO Auto-generated method stub
        return null;
    }


    
}
