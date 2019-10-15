    package br.edu.udesc.WebService;

import br.edu.udesc.DAO.DaoCategoria;
import br.edu.udesc.Model.Categoria;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author paulohenrique
 */
@Path("Categoria")
public class CategoriaResource {
    
    DaoCategoria daoCatedoria = new DaoCategoria();
    
    @Context
    private UriInfo context;
      
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTodasCategorias() throws SQLException, ClassNotFoundException {
        List<Categoria> lCategoria = daoCatedoria.listarTodas();
        return Response.status(Response.Status.CREATED)
                       .header("Access-Control-Allow-Origin", "http://localhost:3000")
                       .entity(lCategoria)
                       .build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putCategoria(Categoria cat) throws SQLException, ClassNotFoundException {
        daoCatedoria.cadastrar(cat);
    }
}
