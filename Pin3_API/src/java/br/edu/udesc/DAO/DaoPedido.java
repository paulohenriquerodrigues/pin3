package br.edu.udesc.DAO;

import br.edu.udesc.Model.Categoria;
import br.edu.udesc.Model.Endereco;
import br.edu.udesc.Model.Pedido;
import br.edu.udesc.Model.Produto;
import br.edu.udesc.Model.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulohenrique
 */
public class DaoPedido {
    
    DaoUsuario usuarioDao = new DaoUsuario();
    
    private DaoEndereco daoEndereco = new DaoEndereco();
    private DaoProduto  daoProduto  = new DaoProduto();

    public void cadastrar(Object obj) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.createConnection();

        Pedido p = (Pedido) obj;
        
        String sqlInsert = "INSERT INTO public.tbpedido(usuarioid,enderecoid,cartaoid,boletoid,status) VALUES (?,?,?,?,?)";
        try {
            con.setAutoCommit(true);

            PreparedStatement stm = con.prepareStatement(sqlInsert);
            stm.setInt(1,p.getUsuario().getId());
            stm.setInt(2, p.getEndereco().getId());
            stm.setInt(3, p.getCartao().getId());
            stm.setInt(4, p.getBoleto().getId());
            stm.setString(5, p.getStatus());
            stm.execute();
            
            
            for(int i=0; i < p.getProdutos().size(); i++){
            
            String sql = "INSERT INTO public.tbitenspedido (pedidoid, produtoid) VALUES (?,?);";
                
            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1,p.getUsuario().getId());
            s.setInt(2, p.getProdutos().get(i).getId());
            s.execute();
                
            }
            
            
        } catch (SQLException ex) {
            System.out.println("excesao");
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("erro");
            }
        }

    }

    public List<Pedido> listarTodos() throws SQLException, ClassNotFoundException {
        List<Pedido> pedidos = new ArrayList<>();
        Connection con = Conexao.createConnection();

        String sqlSelect = "SELECT * FROM tbpedido";

        PreparedStatement stmt = con.prepareStatement(sqlSelect);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            
            Pedido p = new Pedido();
            p.setId(rs.getInt("id"));
            p.setStatus(rs.getString("status"));
            
            
            p.setProdutos(daoProduto.listarProdutosPedido(p.getId()));
            
            
            p.setUsuario(usuarioDao.retornaUsuario(rs.getInt("usuarioid")));
            p.setEndereco(p.getUsuario().getEndereco());
            
            if (p != null) {
                pedidos.add(p);
            }
        }
        
        con.close();

        return pedidos;
    }
    
    public List<Pedido> listarPedidosUsuario(long usuId) throws SQLException, ClassNotFoundException {
        List<Pedido> pedidos = new ArrayList<>();
        Connection con = Conexao.createConnection();
        
        String sqlSelect = "SELECT * FROM tbpedido WHERE usuarioid = " + usuId;
        
        PreparedStatement stmt = con.prepareStatement(sqlSelect);
        ResultSet rs =  stmt.executeQuery();
        
        while(rs.next()) {
            Pedido p = new Pedido();
            p.setId(rs.getInt("id"));
            p.setStatus(rs.getString("status"));
            
            
            p.setProdutos(daoProduto.listarProdutosPedido(p.getId()));
            p.setUsuario(usuarioDao.retornaUsuario((int)usuId));
            p.setEndereco(p.getUsuario().getEndereco());
            
            if (p != null) {
                pedidos.add(p);
            }
        }
        
        con.close();
        
        return pedidos;
    }
}
