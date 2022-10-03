package br.com.imd.projeto.web.estudaconcursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.imd.projeto.web.estudaconcursos.dto.AtualizarCategoriaDto;
import br.com.imd.projeto.web.estudaconcursos.model.Categoria;
import br.com.imd.projeto.web.estudaconcursos.service.CategoriaService;

@Controller
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("")
    public ModelAndView gerenciar() {
        var categorias = categoriaService.getListCategoria();
        var modelAndView = new ModelAndView("categoria/gerenciar");
        modelAndView.addObject("categorias", categorias);
        return modelAndView;
    }

    @GetMapping("/nova")
    public ModelAndView novaCategoria() {
        return new ModelAndView("categoria/nova-categoria");
    }

    @PostMapping("/nova")
    public ModelAndView cadastrarCategoria(RedirectAttributes redirectAttributes,
            @RequestParam("categoria") String categoria) {
        categoriaService.saveCategoria(new Categoria(categoria));
        redirectAttributes.addFlashAttribute("sucesso", "Categoria cadastrada com sucesso");
        return new ModelAndView("redirect:/categoria");
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarCategoria(@PathVariable("id") String id) {
        var categoria = categoriaService.recuperarPorId(Integer.parseInt(id));
        var modelAndView = new ModelAndView("categoria/editar-categoria");
        modelAndView.addObject("categoria", categoria);
        return modelAndView;
    }
    
    @PostMapping("")
    public ModelAndView atualizarCategoria(AtualizarCategoriaDto req, RedirectAttributes redirectAttributes) {
        categoriaService.atualizarCategoria(req.getId(), req.getCategoria());
        redirectAttributes.addFlashAttribute("sucesso", "Categoria atualizada com sucesso");
        return new ModelAndView("redirect:/categoria");
    }

    @GetMapping("/remover/{id}")
    public ModelAndView removerCategoria(RedirectAttributes redirectAttributes,
            @PathVariable("id") String id) {
        categoriaService.removeCategoria(id);
        redirectAttributes.addFlashAttribute("sucesso", "Categoria removida com sucesso");
        return new ModelAndView("redirect:/categoria");
    }
}
