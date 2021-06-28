/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade.resources;

import br.edu.uniacademia.enade.dao.ResultadoDAO;
import br.edu.uniacademia.enade.model.Resultado;
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
@Path("resultado")
public class ResultadoResource {

    //OK
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosResultado")
    public List<Resultado> TodosResultado() {

        List<Resultado> Resultado = ResultadoDAO.getInstance().buscarTodas();

        return Resultado;
    }

    //OK
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getResultado/{codigo}")
    public Resultado GetResultado(@PathParam("codigo") int codigo) {

        return ResultadoDAO.getInstance().buscar(codigo);
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{codigo}")
    public String Excluir(@PathParam("codigo") Integer codigo) {
        try {
            Resultado Resultado = new Resultado(codigo);
            ResultadoDAO.getInstance().remover(Resultado);
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
            ResultadoDAO.getInstance().removeAll();
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
    public String Cadastrar(Resultado Resultado) {
                
        Resultado r = new Resultado();
        try {
            r.setIdResultado(Resultado.getIdResultado());
            r.setProvaidProva(r.getProvaidProva());
            r.setUsuarioidUsuario(r.getUsuarioidUsuario());
            r.setValorObtido(r.getValorObtido());
            return "Registro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro " + e.getMessage();
        }
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String Alterar(Resultado Resultado) {
        Resultado r = new Resultado();
        try {
            r.setIdResultado(Resultado.getIdResultado());
            r.setProvaidProva(r.getProvaidProva());
            r.setUsuarioidUsuario(r.getUsuarioidUsuario());
            r.setValorObtido(r.getValorObtido());
            return ResultadoDAO.getInstance().atualizar(r).toString();
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