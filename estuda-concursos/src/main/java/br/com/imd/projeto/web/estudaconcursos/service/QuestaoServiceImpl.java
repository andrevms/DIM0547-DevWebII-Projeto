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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeQuestao(Questao questao) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Questao getQuestaoById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Questao> getListQuestao() {
        // TODO Auto-generated method stub
        return null;
    }

    
    
}