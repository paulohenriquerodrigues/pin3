    package br.edu.udesc.WebService;

import br.edu.udesc.DAO.DaoCategoria;
import br.edu.udesc.DAO.DaoProduto;
import br.edu.udesc.Model.Categoria;
import br.edu.udesc.Model.Produto;
import br.edu.udesc.Model.Usuario;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author paulohenrique
 */
@Path("Produto")
public class ProdutoResource {
    
    DaoProduto daoProduto = new DaoProduto();
    
    @Context
    private UriInfo context;
      
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> getTodasCategorias() throws SQLException, ClassNotFoundException {
        List<Produto> lProdutos = daoProduto.listarTodos();
        return lProdutos;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Produto getProduto(@PathParam("id") long id) throws SQLException, ClassNotFoundException {
        Produto p = daoProduto.getProduto(id);
        
        return p;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/conteudo={pConteudo}&filtro={pFiltro}")
    public List<Produto> getProdutoFiltrando(@PathParam("pConteudo") String sConteudo, @PathParam("pFiltro") String sFiltro) throws SQLException, ClassNotFoundException {
        List<Produto> lProdutos  = null;
        
        if(sConteudo.equals("")) {
            lProdutos = daoProduto.listarTodos(); 
        } else {
            lProdutos  = daoProduto.listarTodosComFiltro(sConteudo, sFiltro);
        }
        
        return lProdutos;
    }
//    
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/conteudo={pConteudo}&filtro={pFiltro}")
//    public Response getProdutoFiltrando(@PathParam("pConteudo") String sConteudo, @PathParam("pFiltro") String sFiltro) throws SQLException, ClassNotFoundException {
//        List<Produto> lProdutos  = null;
//        
//        if(sConteudo.equals("")) {
//            lProdutos = daoProduto.listarTodos(); 
//        } else {
//            lProdutos  = daoProduto.listarTodosComFiltro(sConteudo, sFiltro);
//        }
//        
//        return Response.status(Response.Status.CREATED)
//                .entity(lProdutos)
//                .build();
//    }
//    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putCategoria(Produto p) throws SQLException, ClassNotFoundException {
        daoProduto.cadastrar(p);
    }
    
}
