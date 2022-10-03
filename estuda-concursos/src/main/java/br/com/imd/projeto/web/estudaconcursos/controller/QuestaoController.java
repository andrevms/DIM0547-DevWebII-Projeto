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

import br.com.imd.projeto.web.estudaconcursos.dto.AtualizarCategoriaDto;
import br.com.imd.projeto.web.estudaconcursos.dto.AtualizarQuestaoDto;
import br.com.imd.projeto.web.estudaconcursos.model.Questao;
import br.com.imd.projeto.web.estudaconcursos.service.QuestaoService;

@Controller
@RequestMapping("questao")
public class QuestaoController {
    
    @Autowired
    @Qualifier("questaoServiceImpl")
    QuestaoService questaoService;

    @GetMapping("")
    public ModelAndView gerenciar() {
        var questoes = questaoService.getListQuestao();
        var modelAndView = new ModelAndView("questao/gerenciar");
        modelAndView.addObject("questoes", questoes);
        return modelAndView;
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
