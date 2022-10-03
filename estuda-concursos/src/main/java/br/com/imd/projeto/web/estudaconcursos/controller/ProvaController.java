package br.com.imd.projeto.web.estudaconcursos.controller;

import br.com.imd.projeto.web.estudaconcursos.dto.RequisicaoAdicionarProvaDto;
import br.com.imd.projeto.web.estudaconcursos.model.Prova;
import br.com.imd.projeto.web.estudaconcursos.repository.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("prova")
public class ProvaController {

    @Autowired
    private ProvaRepository provaRepository;

    @GetMapping("minhas-provas")
    public String minhasProvas(RequisicaoAdicionarProvaDto requisicao, Model model) {
        List<Prova> provas = provaRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("provas", provas);
        return "prova/minhas-provas";
    }

    @PostMapping("adicionar")
    public String adicionar(@Valid RequisicaoAdicionarProvaDto requisicao, BindingResult result) {
        if(result.hasErrors()) {
            return "prova/minhas-provas";
        }

        Prova prova = requisicao.toProva();
        provaRepository.save(prova);

        return "redirect:/prova/minhas-provas";
    }

}
