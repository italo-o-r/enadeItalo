/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade.controller;

import br.edu.uniacademia.enade.dao.ProvaDAO;
import br.edu.uniacademia.enade.model.Prova;
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
public class ProvaController implements Serializable {

    Prova Prova = new Prova();
    List<Prova> provas = new ArrayList<>();

    public ProvaController() {
        provas = ProvaDAO.getInstance().buscarTodas();
        Prova = new Prova();
    }

    public void gravar(ActionEvent actionEvent) {
        ProvaDAO.getInstance().atualizar(Prova);
        provas = ProvaDAO.getInstance().buscarTodas();
        Prova = new Prova();
    }

    public void remover(ActionEvent actionEvent) {
        ProvaDAO.getInstance().remover(Prova);
        provas = ProvaDAO.getInstance().buscarTodas();
        Prova = new Prova();
    }

    public Prova getProva() {
        return Prova;
    }

    public void setProva(Prova Prova) {
        this.Prova = Prova;
    }

    public List<Prova> getProvas() {
        return provas;
    }

    public void setProvas(List<Prova> provas) {
        this.provas = provas;
    }

    public void onRowEdit(RowEditEvent event) {
        Prova p = (Prova) event.getObject();
        ProvaDAO.getInstance().atualizar(p);
        provas = ProvaDAO.getInstance().buscarTodas();
        Prova = new Prova();
        FacesMessage msg = new FacesMessage("Editado", p.getIdProva().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<Prova> event) {
        FacesMessage msg = new FacesMessage("Cancelado", event.getObject().getIdProva().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}