/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade.resources;

import br.edu.uniacademia.enade.dao.QuestaoDAO;
import br.edu.uniacademia.enade.model.Questao;
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
@Path("questao")
public class QuestaoResource {

    //OK
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosQuestao")
    public List<Questao> TodosQuestao() {

        List<Questao> Questao = QuestaoDAO.getInstance().buscarTodas();

        return Questao;
    }

    //OK
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getQuestao/{codigo}")
    public Questao GetQuestao(@PathParam("codigo") int codigo) {

        return QuestaoDAO.getInstance().buscar(codigo);
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{codigo}")
    public String Excluir(@PathParam("codigo") Integer codigo) {
        try {
            Questao Questao = new Questao(codigo);
            QuestaoDAO.getInstance().remover(Questao);
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
            QuestaoDAO.getInstance().removeAll();
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
    public String Cadastrar(Questao Questao) {
                
        Questao q = new Questao();
        try {
            q.setIdQuestao(Questao.getIdQuestao());
            q.setDescricaoQuestao(q.getDescricaoQuestao());
            q.setAlternativaA(q.getAlternativaA());
            q.setAlternativaB(q.getAlternativaB());
            q.setAlternativaC(q.getAlternativaC());
            q.setAlternativaD(q.getAlternativaD());
            q.setAlternativaE(q.getAlternativaE());
            q.setEstadoQuestao(q.getEstadoQuestao());
            q.setQuestaoCorreta(q.getQuestaoCorreta());
            QuestaoDAO.getInstance().persistir(q);
            return "Registro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro " + e.getMessage();
        }
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String Alterar(Questao Questao) {
        Questao q = new Questao();
        try {
            q.setIdQuestao(Questao.getIdQuestao());
            q.setDescricaoQuestao(q.getDescricaoQuestao());
            q.setAlternativaA(q.getAlternativaA());
            q.setAlternativaB(q.getAlternativaB());
            q.setAlternativaC(q.getAlternativaC());
            q.setAlternativaD(q.getAlternativaD());
            q.setAlternativaE(q.getAlternativaE());
            q.setEstadoQuestao(q.getEstadoQuestao());
            q.setQuestaoCorreta(q.getQuestaoCorreta());
            return QuestaoDAO.getInstance().atualizar(q).toString();
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
