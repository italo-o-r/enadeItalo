/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade.resources;

import br.edu.uniacademia.enade.dao.ProvaDAO;
import br.edu.uniacademia.enade.model.Prova;
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
@Path("prova")
public class ProvaResource {

    //OK
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosProva")
    public List<Prova> TodosProva() {

        List<Prova> Prova = ProvaDAO.getInstance().buscarTodas();

        return Prova;
    }

    //OK
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getProva/{codigo}")
    public Prova GetProva(@PathParam("codigo") int codigo) {

        return ProvaDAO.getInstance().buscar(codigo);
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{codigo}")
    public String Excluir(@PathParam("codigo") Integer codigo) {
        try {
            Prova Prova = new Prova(codigo);
            ProvaDAO.getInstance().remover(Prova);
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
            ProvaDAO.getInstance().removeAll();
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
    public String Cadastrar(Prova Prova) {
                
        Prova p = new Prova();
        try {
            p.setIdProva(Prova.getIdProva());
            p.setDataProva(p.getDataProva());
            ProvaDAO.getInstance().persistir(p);
            return "Registro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro " + e.getMessage();
        }
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String Alterar(Prova Prova) {
        Prova p = new Prova();
        try {
            p.setIdProva(Prova.getIdProva());
            p.setDataProva(p.getDataProva());
            return ProvaDAO.getInstance().atualizar(p).toString();
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