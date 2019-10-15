    package br.edu.udesc.WebService;

import br.edu.udesc.DAO.DaoEndereco;
import br.edu.udesc.DAO.DaoUsuario;
import br.edu.udesc.Model.Sessoes;
import br.edu.udesc.Model.Usuario;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
    private UriInfo context;

    public UsuarioResource() {
        sessoes = new HashMap<String, Usuario>();
    }
        
    @GET
    @Path("/login")
    public Response getVerificaSeExisteUsuario(@QueryParam("email") String email, 
                                              @QueryParam("senha") String senha) throws SQLException, ClassNotFoundException{        
        System.out.println(email + " " + senha);        
        Usuario encontrou = (Usuario)DaoUsuario.validaLogin(email, senha);
        if (encontrou != null){
            Sessoes.getInstance().insereNaSessao(encontrou);
        }
        
        return Response.status(Response.Status.CREATED)
                .header("Access-Control-Allow-Origin", "http://localhost:3000")
                .entity(encontrou)
                .build();
    }   
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTodosUsuarios() throws SQLException, ClassNotFoundException {
        List<Usuario> lUsuarios = daoUsuario.listarTodosUsuarios();
        return Response.status(Response.Status.CREATED)
                .header("Access-Control-Allow-Origin", "http://localhost:3000")
                .entity(lUsuarios)
                .build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
        daoUsuario.cadastrar(usuario);
    }
}
