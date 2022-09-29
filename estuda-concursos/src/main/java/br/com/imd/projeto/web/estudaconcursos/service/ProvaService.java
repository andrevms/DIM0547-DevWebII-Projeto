package br.com.imd.projeto.web.estudaconcursos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.imd.projeto.web.estudaconcursos.model.Prova;

@Service
public interface ProvaService {

    public Prova saveProva(Prova prova);

    public void removeProva(Prova prova);

    public Prova getProvaById(Integer id);

    public List<Prova> getListProva();
}
