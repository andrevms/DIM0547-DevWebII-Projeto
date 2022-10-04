package br.com.imd.projeto.web.estudaconcursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.imd.projeto.web.estudaconcursos.dto.AtualizarAlternativaDto;
import br.com.imd.projeto.web.estudaconcursos.dto.AtualizarCategoriaDto;
import br.com.imd.projeto.web.estudaconcursos.service.AlternativaService;

@Controller
@RequestMapping("alternativa")
public class AlternativaController {
    
    @Autowired
    @Qualifier("alternativaServiceImpl")
    AlternativaService alternativaService;

    @GetMapping("")
    public ModelAndView gerenciar() {
        var alternativas = alternativaService.getListAlternativa();
        var modelAndView = new ModelAndView("alternativa/gerenciar");
        modelAndView.addObject("alternativas", alternativas);
        return modelAndView;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarAlternativa(@PathVariable("id") String id) {
        var alternativa = alternativaService.getAlternativaById(Integer.parseInt(id));
        var modelAndView = new ModelAndView("alternativa/editar-alternativa");
        modelAndView.addObject("alt", alternativa);
        return modelAndView;
    }

    @PostMapping("")
    public ModelAndView atualizarAlternativa(AtualizarAlternativaDto req, RedirectAttributes redirectAttributes) {
        alternativaService.atualizarAlternativa(req.getId(), req.getAlternativa());
        redirectAttributes.addFlashAttribute("sucesso", "Alternativa atualizada com sucesso");
        return new ModelAndView("redirect:/alternativa");
    }

    @GetMapping("/remover/{id}")
    public ModelAndView removerCategoria(RedirectAttributes redirectAttributes,
            @PathVariable("id") String id) {
        alternativaService.removeAlternativa(id);
        redirectAttributes.addFlashAttribute("sucesso", "Alternativa removida com sucesso");
        return new ModelAndView("redirect:/alternativa");
    }
}

