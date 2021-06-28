/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade.controller;


import br.edu.uniacademia.enade.dao.UsuarioDAO;
import br.edu.uniacademia.enade.model.Usuario;
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
public class UsuarioController implements Serializable {

    Usuario Usuario = new Usuario();
    List<Usuario> Usuarios = new ArrayList<>();

    public UsuarioController() {
        Usuarios = UsuarioDAO.getInstance().buscarTodas();
        Usuario = new Usuario();
    }

    public void gravar(ActionEvent actionEvent) {
        UsuarioDAO.getInstance().atualizar(Usuario);
        Usuarios = UsuarioDAO.getInstance().buscarTodas();
        Usuario = new Usuario();
    }

    public void remover(ActionEvent actionEvent) {
        UsuarioDAO.getInstance().remover(Usuario);
        Usuarios = UsuarioDAO.getInstance().buscarTodas();
        Usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public List<Usuario> getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(List<Usuario> Usuarios) {
        this.Usuarios = Usuarios;
    }

    public void onRowEdit(RowEditEvent event) {
        Usuario u = (Usuario) event.getObject();
        UsuarioDAO.getInstance().atualizar(u);
        Usuarios = UsuarioDAO.getInstance().buscarTodas();
        Usuario = new Usuario();
        FacesMessage msg = new FacesMessage("Editado", u.getIdUsuario().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<Usuario> event) {
        FacesMessage msg = new FacesMessage("Cancelado", event.getObject().getIdUsuario().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}