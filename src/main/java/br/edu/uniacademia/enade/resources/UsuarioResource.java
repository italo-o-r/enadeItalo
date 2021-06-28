/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade.resources;

import br.edu.uniacademia.enade.dao.UsuarioDAO;
import br.edu.uniacademia.enade.model.Usuario;
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
@Path("usuario")
public class UsuarioResource {

    //OK
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosUsuario")
    public List<Usuario> TodosUsuario() {

        List<Usuario> Usuario = UsuarioDAO.getInstance().buscarTodas();

        return Usuario;
    }

    //OK
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getUsuario/{codigo}")
    public Usuario GetUsuario(@PathParam("codigo") int codigo) {

        return UsuarioDAO.getInstance().buscar(codigo);
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{codigo}")
    public String Excluir(@PathParam("codigo") Integer codigo) {
        try {
            Usuario Usuario = new Usuario(codigo);
            UsuarioDAO.getInstance().remover(Usuario);
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
            UsuarioDAO.getInstance().removeAll();
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
    public String Cadastrar(Usuario Usuario) {
                
        Usuario u = new Usuario();
        try {
            u.setIdUsuario(u.getIdUsuario());
            u.setNome(u.getNome());
            u.setEmail(u.getEmail());
            u.setSenha(u.getSenha());
            UsuarioDAO.getInstance().persistir(u);
            return "Registro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro " + e.getMessage();
        }
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String Alterar(Usuario Usuario) {
        Usuario u = new Usuario();
        try {
            u.setIdUsuario(u.getIdUsuario());
            u.setNome(u.getNome());
            u.setEmail(u.getEmail());
            u.setSenha(u.getSenha());
            return UsuarioDAO.getInstance().atualizar(u).toString();
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