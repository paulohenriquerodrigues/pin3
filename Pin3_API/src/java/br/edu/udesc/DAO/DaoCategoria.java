package br.edu.udesc.DAO;

import br.edu.udesc.Model.Categoria;
import br.edu.udesc.Model.Endereco;
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
public class DaoCategoria {

    public void cadastrar(Object obj) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.createConnection();

        String sqlInsert = "INSERT INTO public.tbcategoria(descricao) VALUES (?)";
        Categoria cat = (Categoria) obj;
        try {
            con.setAutoCommit(true);

            PreparedStatement stm = con.prepareStatement(sqlInsert);
            stm.setString(1, cat.getDescricao());
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

    public List<Categoria> listarTodas() throws SQLException, ClassNotFoundException {
        List<Categoria> categorias = new ArrayList<>();
        Connection con = Conexao.createConnection();

        String sqlSelect = "SELECT * FROM public.tbcategoria";

        PreparedStatement stmt = con.prepareStatement(sqlSelect);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Categoria cat = new Categoria();
            cat.setId(rs.getInt("id"));
            cat.setDescricao(rs.getString("descricao"));

            if (cat != null) {
                categorias.add(cat);
            }
        }
        con.close();

        return categorias;

    }
}
