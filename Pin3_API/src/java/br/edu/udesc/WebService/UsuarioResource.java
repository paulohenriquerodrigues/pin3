    package br.edu.udesc.WebService;

import br.edu.udesc.DAO.DaoEndereco;
import br.edu.udesc.DAO.DaoUsuario;
import br.edu.udesc.Model.Sessoes;
import br.edu.udesc.Model.Usuario;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author paulohenrique
 */
@Path("Usuario")
public class UsuarioResource {
    
    HashMap<String, Usuario> sessoes;
    DaoUsuario daoUsuario = new DaoUsuario();
    DaoEndereco daoEndereco = new DaoEndereco();

    @Context
    private HttpServletResponse resServilet;

    public UsuarioResource() {
        sessoes = new HashMap<String, Usuario>();
    }
        
    @GET
    @Path("/login")
    public Usuario getVerificaSeExisteUsuario(@QueryParam("email") String email, 
                                              @QueryParam("senha") String senha) throws SQLException, ClassNotFoundException{        
        System.out.println(email + " " + senha);        
        Usuario encontrou = (Usuario)DaoUsuario.validaLogin(email, senha);
        if (encontrou != null){
            Sessoes.getInstance().insereNaSessao(encontrou);
        }
        
        return encontrou;
    }   
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getTodosUsuarios() throws SQLException, ClassNotFoundException {
        List<Usuario> lUsuarios = daoUsuario.listarTodosUsuarios();
        return lUsuarios;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
        daoUsuario.cadastrar(usuario);
        return Response.status(Response.Status.OK).build();
    }
}
