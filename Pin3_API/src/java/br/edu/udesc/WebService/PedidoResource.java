
package br.edu.udesc.WebService;

import br.edu.udesc.DAO.DaoPedido;
import br.edu.udesc.Model.Pedido;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.media.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Drew
 */
@Path("Pedido")
public class PedidoResource {
  
    private DaoPedido daoPedido;
    
    @Context
    private UriInfo context;
    
    public PedidoResource() {
        this.daoPedido = new DaoPedido();
    }
    
    @GET
    @Path("/pedidos")
    public Response getPedidosUsuario(@QueryParam("usuid") long id) throws SQLException, ClassNotFoundException {
        System.out.println("Usuario id: " + id);
        List<Pedido> lPedidos = daoPedido.listarPedidosUsuario(id);
        return Response.status(Response.Status.CREATED)
                .header("Access-Control-Allow-Origin", "http://localhost:3000")
                .entity(lPedidos)
                .build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTodosPedidos() throws SQLException, ClassNotFoundException {
        List<Pedido> lPedidos = daoPedido.listarTodos();
        return Response.status(Response.Status.CREATED)
                .header("Access-Control-Allow-Origin", "http://localhost:3000")
                .entity(lPedidos)
                .build();
    }
}
