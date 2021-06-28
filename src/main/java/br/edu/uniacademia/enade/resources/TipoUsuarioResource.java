/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade.resources;

import br.edu.uniacademia.enade.dao.TipoUsuarioDAO;
import br.edu.uniacademia.enade.model.TipoUsuario;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author
 */
@Path("tipousuario")
public class TipoUsuarioResource {

    //OK
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosTipoUsuario")
    public List<TipoUsuario> TodosTipoUsuario() {

        List<TipoUsuario> tipoUsuario = TipoUsuarioDAO.getInstance().buscarTodas();

        return tipoUsuario;
    }

    //OK
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getTipoUsuario/{codigo}")
    public TipoUsuario GetTipoUsuario(@PathParam("codigo") int codigo) {

        return TipoUsuarioDAO.getInstance().buscar(codigo);
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{codigo}")
    public String Excluir(@PathParam("codigo") Integer codigo) {
        try {
            TipoUsuario tipoUsuario = new TipoUsuario(codigo);
            TipoUsuarioDAO.getInstance().remover(tipoUsuario);
            return "Registro excluido com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    //OK
    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluirTodos")
    public String ExcluirTodos() {
        try {
            TipoUsuarioDAO.getInstance().removeAll();
            return "Todos os registro excluidos com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    //OK
    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String Cadastrar(TipoUsuario tipoUsuario) {
                
        TipoUsuario tu = new TipoUsuario();
        try {
            tu.setIdTipoUsuario(tipoUsuario.getIdTipoUsuario());
            tu.setNomeTipoUsuario(tipoUsuario.getNomeTipoUsuario());
            TipoUsuarioDAO.getInstance().persistir(tu);
            return "Registro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro " + e.getMessage();
        }
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String Alterar(TipoUsuario tipoUsuario) {
        TipoUsuario tu = new TipoUsuario();
        try {
            tu.setIdTipoUsuario(tipoUsuario.getIdTipoUsuario());
            tu.setNomeTipoUsuario(tipoUsuario.getNomeTipoUsuario());
            return TipoUsuarioDAO.getInstance().atualizar(tu).toString();
        } catch (Exception e) {
            return "Erro ao cadastrar um registro " + e.getMessage();
        }
    }

    //OK
    @GET
    public Response ping() {
        return Response
                .ok("ping")
                .build();
    }
}