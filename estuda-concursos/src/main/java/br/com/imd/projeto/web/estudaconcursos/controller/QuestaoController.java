package br.com.imd.projeto.web.estudaconcursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.imd.projeto.web.estudaconcursos.dto.AtualizarQuestaoDto;
import br.com.imd.projeto.web.estudaconcursos.model.Alternativa;
import br.com.imd.projeto.web.estudaconcursos.model.Questao;
import br.com.imd.projeto.web.estudaconcursos.service.AlternativaService;
import br.com.imd.projeto.web.estudaconcursos.service.QuestaoService;

@Controller
@RequestMapping("questao")
public class QuestaoController {

    @Autowired
    @Qualifier("questaoServiceImpl")
    QuestaoService questaoService;

    @Autowired
    @Qualifier("alternativaServiceImpl")
    AlternativaService alternativaService;

    @GetMapping("")
    public ModelAndView gerenciar() {
        var questoes = questaoService.getListQuestao();
        var modelAndView = new ModelAndView("questao/gerenciar");
        modelAndView.addObject("questoes", questoes);
        return modelAndView;
    }

    @GetMapping("/addAlternativa/{id}")
    public ModelAndView novaAlternativa(RedirectAttributes redirectAttributes,
            @PathVariable("id") String id) {
        var questao = questaoService.getQuestaoById(Integer.parseInt(id));
        var modelAndView = new ModelAndView("questao/nova-Alternativa");
        modelAndView.addObject("questao", questao);
        return modelAndView;
    }

    @PostMapping("/addAlternativa")
    public ModelAndView adicionaAlternativaQuestao(RedirectAttributes redirectAttributes,
            @RequestParam("enunciado") String enunciado, 
            @RequestParam("id") String id) {
        
        Alternativa alt = alternativaService.saveAlternativa (
            new Alternativa(enunciado, questaoService.getQuestaoById(Integer.parseInt(id)))
            );
        Questao q = questaoService.getQuestaoById(Integer.parseInt(id));
        q.getAlternativas().add(alt);
        questaoService.saveQuestao(q);
        redirectAttributes.addFlashAttribute("sucesso", "Alternativa adicionada com sucesso");
        return new ModelAndView("redirect:/questao");
    }

    @GetMapping("/nova")
    public ModelAndView novaQuestao() {
        return new ModelAndView("questao/nova-questao");
    }

    @PostMapping("/nova")
    public ModelAndView cadastrarQuestao(RedirectAttributes redirectAttributes,
            @RequestParam("enunciado") String enunciado) {
        questaoService.saveQuestao(new Questao(enunciado));
        redirectAttributes.addFlashAttribute("sucesso", "Questão cadastrada com sucesso");
        return new ModelAndView("redirect:/questao");
    }

    @GetMapping("/remover/{id}")
    public ModelAndView removerCategoria(RedirectAttributes redirectAttributes,
            @PathVariable("id") String id) {
        questaoService.removeQuestao(id);
        redirectAttributes.addFlashAttribute("sucesso", "Questao removida com sucesso");
        return new ModelAndView("redirect:/questao");
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarQuestao(@PathVariable("id") String id) {
        var questao = questaoService.getQuestaoById(Integer.parseInt(id));
        var modelAndView = new ModelAndView("questao/editar-questao");
        modelAndView.addObject("questao", questao);
        return modelAndView;
    }

    @PostMapping("")
    public ModelAndView atualizarQuestao(AtualizarQuestaoDto req, RedirectAttributes redirectAttributes) {
        questaoService.atualizarQuestaoEnunciado(req.getId(), req.getEnunciado());
        redirectAttributes.addFlashAttribute("sucesso", "Questão atualizada com sucesso");
        return new ModelAndView("redirect:/questao");
    }

}
