    package br.edu.udesc.WebService;

import br.edu.udesc.DAO.DaoEndereco;
import br.edu.udesc.Model.Endereco;
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

/**
 * REST Web Service
 *
 * @author paulohenrique
 */
@Path("Endereco")
public class EnderecoResource {
    
    HashMap<String, Endereco> sessoes;
    DaoEndereco daoUsuario = new DaoEndereco();

    @Context
    private UriInfo context;

    public EnderecoResource() {
        sessoes = new HashMap<String, Endereco>();
    }
        
//    @GET
//    @Path("/buscar")
//    public Usuario getVerificaSeExisteUsuario(@QueryParam("email") String email, 
//                                              @QueryParam("senha") String senha){        
//        System.out.println(email + " " + senha);        
//        Usuario encontrou = (Usuario)DaoUsuario.verificaSeExisteUsuario(email, senha);
//        if (encontrou != null){
//            Sessoes.getInstance().insereNaSessao(encontrou);
//        }
//        return encontrou;
//    }   
    

    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putEndereco(Endereco endereco) throws SQLException, ClassNotFoundException {
        daoUsuario.cadastrar(endereco);
    }
}
