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

    public List<Produto> listarTodos() throws SQLException, ClassNotFoundException {
        List<Produto> produtos = new ArrayList<>();
        Connection con = Conexao.createConnection();

        String sqlSelect = "SELECT * FROM public.tbproduto";

        PreparedStatement stmt = con.prepareStatement(sqlSelect);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Produto p = new Produto();
            p.setId(rs.getInt("id"));
            p.setDescricao(rs.getString("descricao"));
            p.setDatavalidade(rs.getDate("datavalidade"));
            p.setDatafabricacao(rs.getDate("datafabricacao"));
            p.setPreco(rs.getDouble("preco"));
            p.setLaboratorio(rs.getString("laboratorio"));
            p.setLote(rs.getInt("lote"));
            p.setQuantidade(rs.getInt("quantidade"));
            p.setUsocontinuo(rs.getBoolean("usocontinuo"));
            
            int idcategoria = rs.getInt("categoriaid");
            
            PreparedStatement s = con.prepareStatement("Select * from public.tbcategoria where id = " + idcategoria);
            ResultSet r = s.executeQuery();
            while (r.next()) {
                Categoria c = new Categoria();
                c.setId(r.getInt("id"));
                c.setDescricao(r.getString("descricao"));       
                p.setCategoria(c);
            }
            
            if (p != null) {
                produtos.add(p);
            }
        }
        con.close();

        return produtos;

    }
}
