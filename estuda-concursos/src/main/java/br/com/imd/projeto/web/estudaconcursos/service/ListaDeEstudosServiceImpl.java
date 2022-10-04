package br.com.imd.projeto.web.estudaconcursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.imd.projeto.web.estudaconcursos.model.ListaDeEstudos;
import br.com.imd.projeto.web.estudaconcursos.repository.ListaDeEstudosRepository;

@Component
public class ListaDeEstudosServiceImpl implements ListaDeEstudosService {

    @Autowired
    ListaDeEstudosRepository listaDeEstudosRepository;

    @Override
    public ListaDeEstudos saveListaDeEstudos(ListaDeEstudos listaDeEstudos) {
        return listaDeEstudosRepository.save(listaDeEstudos);
    }

    @Override
    public void removeListaDeEstudos(ListaDeEstudos listaDeEstudos) {
        // TODO Auto-generated method stub
    }

    @Override
    public ListaDeEstudos getListaDeEstudosById(Integer id) {
        return listaDeEstudosRepository.findById(id).map(lista -> {
            return lista;
        }).orElseThrow(() -> null);
    }

    @Override
    public List<ListaDeEstudos> getListListaDeEstudos() {
        return listaDeEstudosRepository.findAll();
    }
    
}
