package br.com.imd.projeto.web.estudaconcursos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.imd.projeto.web.estudaconcursos.model.ListaDeEstudos;


@Service
public interface ListaDeEstudosService {

    public ListaDeEstudos saveListaDeEstudos(ListaDeEstudos listaDeEstudos);

    public void removeListaDeEstudos(ListaDeEstudos listaDeEstudos);

    public ListaDeEstudos getListaDeEstudosById(Integer id);

    public List<ListaDeEstudos> getListListaDeEstudos();
}
