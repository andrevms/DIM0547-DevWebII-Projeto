package br.com.imd.projeto.web.estudaconcursos.controller;

import br.com.imd.projeto.web.estudaconcursos.dto.AtualizarProvaDto;
import br.com.imd.projeto.web.estudaconcursos.dto.RequisicaoAdicionarProvaDto;
import br.com.imd.projeto.web.estudaconcursos.model.Prova;
import br.com.imd.projeto.web.estudaconcursos.service.ProvaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("prova")
public class ProvaController {

    @Autowired
    @Qualifier("provaServiceImpl")
    ProvaService provaService;


    @GetMapping("")
    public ModelAndView gerenciar() {
        var provas = provaService.getListProva();
        var modelAndView = new ModelAndView("prova/gerenciar");
        modelAndView.addObject("provas", provas);
        return modelAndView;
    }


    @GetMapping("minhas-provas")
    public String minhasProvas(RequisicaoAdicionarProvaDto requisicao, Model model) {
        List<Prova> provas = provaService.getListProva();
        model.addAttribute("provas", provas);
        return "prova/minhas-provas";
    }

    @GetMapping("/nova")
    public ModelAndView novaProva() {
        return new ModelAndView("prova/nova-prova");
    }

    @PostMapping("/nova")
    public ModelAndView cadastrarProva(RedirectAttributes redirectAttributes,
                                           @RequestParam("prova") String prova) {
        provaService.saveProva(new Prova(prova));
        redirectAttributes.addFlashAttribute("sucesso", "Prova cadastrada com sucesso");
        return new ModelAndView("redirect:/prova");
    }

    @PostMapping("adicionar")
    public String adicionar(@Valid RequisicaoAdicionarProvaDto requisicao, BindingResult result) {
        if(result.hasErrors()) {
            return "prova/minhas-provas";
        }

        Prova prova = requisicao.toProva();
        provaService.saveProva(prova);

        return "redirect:/prova/minhas-provas";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarProva(@PathVariable("id") int id) {
        var prova = provaService.getProvaById(id);
        var modelAndView = new ModelAndView("prova/editar-nome-prova");
        modelAndView.addObject("prova", prova);
        return modelAndView;
    }

    @PostMapping("")
    public ModelAndView atualizarProva(AtualizarProvaDto req, RedirectAttributes redirectAttributes) {
        provaService.atualizarProva(req.getId(), req.getProva());
        redirectAttributes.addFlashAttribute("sucesso", "Prova atualizada com sucesso");
        return new ModelAndView("redirect:/prova");
    }

    @GetMapping("/remover/{id}")
    public ModelAndView removerProva(RedirectAttributes redirectAttributes,
                                         @PathVariable("id") int id) {
        provaService.removeProvaById(id);
        redirectAttributes.addFlashAttribute("sucesso", "Prova removida com sucesso");
        return new ModelAndView("redirect:/prova");
    }

}
