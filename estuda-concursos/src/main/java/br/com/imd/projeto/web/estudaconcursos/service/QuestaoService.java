package br.com.imd.projeto.web.estudaconcursos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.imd.projeto.web.estudaconcursos.model.Questao;

@Service
public interface QuestaoService {
    public Questao saveQuestao(Questao questao);

    public void removeQuestao(Questao questao);

    public Questao getQuestaoById(Integer id);

    public List<Questao> getListQuestao();
}
