package br.edu.udesc.DAO;

import br.edu.udesc.Model.Categoria;
import br.edu.udesc.Model.Endereco;
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
public class DaoProduto {

    public void cadastrar(Object obj) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.createConnection();

        Produto p = (Produto) obj;

        String sqlRetornaChave = "SELECT id FROM public.tbcategoria where descricao = '"
                + p.getCategoria().getDescricao()
                + "'";

        PreparedStatement st = con.prepareStatement(sqlRetornaChave);
        ResultSet rs = st.executeQuery();
        int idcategoria = 0;
        while (rs.next()) {
            idcategoria = rs.getInt("id");
        }

        String sqlInsert = "INSERT INTO public.tbproduto(categoriaid,descricao,datavalidade,datafabricacao,preco,laboratorio,lote,quantidade,usocontinuo,controlado,titulo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con.setAutoCommit(true);

            PreparedStatement stm = con.prepareStatement(sqlInsert);
            stm.setInt(1,idcategoria);
            stm.setString(2, p.getDescricao());
            stm.setDate(3, (Date) p.getDatavalidade());
            stm.setDate(4, (Date) p.getDatafabricacao());
            stm.setDouble(5, p.getPreco());
            stm.setString(6, p.getLaboratorio());
            stm.setInt(7, p.getLote());
            stm.setInt(8, p.getQuantidade());
            stm.setBoolean(9, p.isUsocontinuo());
            stm.setBoolean(10, p.isControlado());
            stm.setString(11, p.getTitulo());
            stm.execute();
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

    public Produto getProduto(long id) throws SQLException, ClassNotFoundException {
        Produto p = new Produto();
        
        Connection con = Conexao.createConnection();
        
        String sqlSelect = "SELECT * FROM public.tbproduto WHERE id=" + id;
        
        PreparedStatement stmt = con.prepareStatement(sqlSelect);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            p.setId(rs.getInt("id"));
            p.setDescricao(rs.getString("descricao"));
            p.setDatavalidade(rs.getDate("datavalidade"));
            p.setDatafabricacao(rs.getDate("datafabricacao"));
            p.setPreco(rs.getDouble("preco"));
            p.setLaboratorio(rs.getString("laboratorio"));
            p.setLote(rs.getInt("lote"));
            p.setQuantidade(rs.getInt("quantidade"));
            p.setUsocontinuo(rs.getBoolean("usocontinuo"));
            p.setControlado(rs.getBoolean("controlado"));
            p.setTitulo(rs.getString("titulo"));
            int idcategoria = rs.getInt("categoriaid");
            
            PreparedStatement s = con.prepareStatement("Select * from public.tbcategoria where id = " + idcategoria);
            ResultSet r = s.executeQuery();
            while (r.next()) {
                Categoria c = new Categoria();
                c.setId(r.getInt("id"));
                c.setDescricao(r.getString("descricao"));       
                p.setCategoria(c);
            }
        }
        con.close();
        
        return p;
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
            p.setControlado(rs.getBoolean("controlado"));
            p.setTitulo(rs.getString("titulo"));
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
    
    public List<Produto> listarProdutosPedido(long pedidoId) throws SQLException, ClassNotFoundException {
        List<Produto> produtos = new ArrayList<>();
        Connection con = Conexao.createConnection();

        String sqlSelect = "SELECT * FROM public.tbproduto WHERE pedidoid = " + pedidoId;

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
            p.setControlado(rs.getBoolean("controlado"));
            p.setTitulo(rs.getString("titulo"));
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
    
    public List<Produto> listarTodosComFiltro(String sConteudo, String sFiltro) throws SQLException, ClassNotFoundException {
        List<Produto> produtos = new ArrayList<>();
        Connection con = Conexao.createConnection();
        String sqlSelect = "SELECT * FROM public.tbproduto WHERE " + sFiltro + " LIKE \'%" + sConteudo + "%\'";

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
            p.setControlado(rs.getBoolean("controlado"));
            p.setTitulo(rs.getString("titulo"));
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
