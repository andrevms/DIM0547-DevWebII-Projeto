package br.com.imd.projeto.web.estudaconcursos.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.imd.projeto.web.estudaconcursos.model.Categoria;
import br.com.imd.projeto.web.estudaconcursos.service.CategoriaService;

@RestController
@RequestMapping("api/categoria")
public class CategoriaRestController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> find() {
        return categoriaService.getListCategoria();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria save(@RequestBody Categoria categoria) {
        return categoriaService.saveCategoria(categoria);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id,
                       @RequestBody Categoria categoria) {
        try {
            categoriaService.atualizarCategoria(id, categoria.getCategoria());
        } catch (Exception e) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada");
        }
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable String id) {
        try {
            categoriaService.removeCategoria(id);
        } catch (Exception e) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada");
        }
    }

}
