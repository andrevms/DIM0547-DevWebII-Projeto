package br.com.imd.projeto.web.estudaconcursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.imd.projeto.web.estudaconcursos.service.AltenativaService;

@Controller
@RequestMapping("alternativa")
public class AlternativaController {
    
    @Autowired
    @Qualifier("alternativaServiceImpl")
    AltenativaService altenativaService;

    @GetMapping("")
    public ModelAndView gerenciar() {
        var alternativas = altenativaService.getListAlternativa();
        var modelAndView = new ModelAndView("alternativa/gerenciar");
        modelAndView.addObject("alternativas", alternativas);
        return modelAndView;
    }
}
