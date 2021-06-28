package br.edu.uniacademia.enade.resources;

import br.edu.uniacademia.enade.dao.TipoQuestaoDAO;
import br.edu.uniacademia.enade.model.TipoQuestao;
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
@Path("tipoquestao")
public class TipoQuestaoResource {

    //OK
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosTipoQuestao")
    public List<TipoQuestao> TodosTipoQuestao() {

        List<TipoQuestao> tipoQuestao = TipoQuestaoDAO.getInstance().buscarTodas();

        return tipoQuestao;
    }

    //OK
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getTipoQuestao/{codigo}")
    public TipoQuestao GetTipoQuestao(@PathParam("codigo") int codigo) {

        return TipoQuestaoDAO.getInstance().buscar(codigo);
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{codigo}")
    public String Excluir(@PathParam("codigo") Integer codigo) {
        try {
            TipoQuestao tipoQuestao = new TipoQuestao(codigo);
            TipoQuestaoDAO.getInstance().remover(tipoQuestao);
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
            TipoQuestaoDAO.getInstance().removeAll();
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
    public String Cadastrar(TipoQuestao tipoQuestao) {
                
        TipoQuestao tp = new TipoQuestao();
        try {
            tp.setIdTipoQuestao(tipoQuestao.getIdTipoQuestao());
            tp.setNomeTipoQuestao(tipoQuestao.getNomeTipoQuestao());
            TipoQuestaoDAO.getInstance().persistir(tp);
            return "Registro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro " + e.getMessage();
        }
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String Alterar(TipoQuestao tipoQuestao) {
        TipoQuestao tp = new TipoQuestao();
        try {
            tp.setIdTipoQuestao(tipoQuestao.getIdTipoQuestao());
            tp.setNomeTipoQuestao(tipoQuestao.getNomeTipoQuestao());
            return TipoQuestaoDAO.getInstance().atualizar(tp).toString();
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
