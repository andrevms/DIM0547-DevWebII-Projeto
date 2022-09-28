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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeListaDeEstudos(ListaDeEstudos listaDeEstudos) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ListaDeEstudos getListaDeEstudosById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ListaDeEstudos> getListListaDeEstudos() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
