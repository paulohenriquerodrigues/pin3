package br.edu.udesc.DAO;

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
public class DaoEndereco {

    public void cadastrar(Object obj) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.createConnection();

        String sqlInsertEndereco = "INSERT INTO public.tbendereco(cidade,bairro,logradouro,numero,complemento,cep) VALUES (?, ?, ?, ?, ?, ?)";
        Endereco end = (Endereco) obj;
        try {
            con.setAutoCommit(true);

            PreparedStatement stm = con.prepareStatement(sqlInsertEndereco);
            stm.setString(1, end.getCidade());
            stm.setString(2, end.getBairro());
            stm.setString(3, end.getLogradouro());
            stm.setInt(4, end.getNumero());
            stm.setString(5, end.getComplemento());
            stm.setString(6, end.getCep());
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
}
