package br.com.imd.projeto.web.estudaconcursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.imd.projeto.web.estudaconcursos.model.Prova;
import br.com.imd.projeto.web.estudaconcursos.repository.ProvaRepository;

@Component
public class ProvaServiceImpl implements ProvaService {
    @Autowired
    ProvaRepository provaRepository;

    @Override
    public Prova saveProva(Prova prova) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeProva(Prova prova) {
        // TODO Auto-generated method stub

    }

    @Override
    public Prova getProvaById(Integer id) {
        return provaRepository.findById(id).map(prova -> {
            return prova;
        }).orElseThrow(() -> null);
    }

    @Override
    public List<Prova> getListProva() {
        return provaRepository.findAll();
    }
}
