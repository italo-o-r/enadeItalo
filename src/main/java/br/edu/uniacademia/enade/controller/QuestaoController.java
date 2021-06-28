/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade.controller;

import br.edu.uniacademia.enade.dao.QuestaoDAO;
import br.edu.uniacademia.enade.model.Questao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author COREI7
 */
@Named
@ViewScoped
public class QuestaoController implements Serializable {

    Questao questao = new Questao();
    List<Questao> questoes = new ArrayList<>();

    public QuestaoController() {
        questoes = QuestaoDAO.getInstance().buscarTodas();
        questao = new Questao();
    }

    public void gravar(ActionEvent actionEvent) {
        QuestaoDAO.getInstance().atualizar(questao);
        questoes = QuestaoDAO.getInstance().buscarTodas();
        questao = new Questao();
    }

    public void remover(ActionEvent actionEvent) {
        QuestaoDAO.getInstance().remover(questao);
        questoes = QuestaoDAO.getInstance().buscarTodas();
        questao = new Questao();
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public void onRowEdit(RowEditEvent event) {
        Questao q = (Questao) event.getObject();
        QuestaoDAO.getInstance().atualizar(q);
        questoes = QuestaoDAO.getInstance().buscarTodas();
        questao = new Questao();
        FacesMessage msg = new FacesMessage("Editado", q.getIdQuestao().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<Questao> event) {
        FacesMessage msg = new FacesMessage("Cancelado", event.getObject().getIdQuestao().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
