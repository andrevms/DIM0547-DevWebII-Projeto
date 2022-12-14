package br.com.imd.projeto.web.estudaconcursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.imd.projeto.web.estudaconcursos.model.Questao;
import br.com.imd.projeto.web.estudaconcursos.repository.QuestaoRepository;

@Component
public class QuestaoServiceImpl implements QuestaoService {
    @Autowired
    QuestaoRepository questaoRepository;

    @Override
    public Questao saveQuestao(Questao questao) {
        return questaoRepository.save(questao);
    }

    @Override
    public void removeQuestao(String id) {
        questaoRepository.deleteById(Integer.parseInt(id));
    }

    @Override
    public Questao getQuestaoById(Integer id) {
        return questaoRepository.findById(id).map(questao -> {
            return questao;
        }).orElseThrow(() -> null);
    }

    @Override
    public List<Questao> getListQuestao() {
       return questaoRepository.findAll();
    }

    public void atualizarQuestaoEnunciado(int id, String enunciado) {
        var cat = questaoRepository.getReferenceById(id);
        cat.setEnunciado(enunciado);
        questaoRepository.save(cat);
    }
}
