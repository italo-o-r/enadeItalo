/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade.controller;

import br.edu.uniacademia.enade.dao.ResultadoDAO;
import br.edu.uniacademia.enade.model.Resultado;
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
public class ResultadoController implements Serializable {

    Resultado Resultado = new Resultado();
    List<Resultado> Resultados = new ArrayList<>();

    public ResultadoController() {
        Resultados = ResultadoDAO.getInstance().buscarTodas();
        Resultado = new Resultado();
    }

    public void gravar(ActionEvent actionEvent) {
        ResultadoDAO.getInstance().atualizar(Resultado);
        Resultados = ResultadoDAO.getInstance().buscarTodas();
        Resultado = new Resultado();
    }

    public void remover(ActionEvent actionEvent) {
        ResultadoDAO.getInstance().remover(Resultado);
        Resultados = ResultadoDAO.getInstance().buscarTodas();
        Resultado = new Resultado();
    }

    public Resultado getResultado() {
        return Resultado;
    }

    public void setResultado(Resultado Resultado) {
        this.Resultado = Resultado;
    }

    public List<Resultado> getResultados() {
        return Resultados;
    }

    public void setResultados(List<Resultado> Resultados) {
        this.Resultados = Resultados;
    }

    public void onRowEdit(RowEditEvent event) {
        Resultado q = (Resultado) event.getObject();
        ResultadoDAO.getInstance().atualizar(q);
        Resultados = ResultadoDAO.getInstance().buscarTodas();
        Resultado = new Resultado();
        FacesMessage msg = new FacesMessage("Editado", q.getIdResultado().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<Resultado> event) {
        FacesMessage msg = new FacesMessage("Cancelado", event.getObject().getIdResultado().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}