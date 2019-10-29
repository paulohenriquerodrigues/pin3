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
public class DaoUsuario {

    /*
        As linhas abaixo foram comentadas, pois no memento só é possivel cadastrar o um usuário sem endereco, por isso todos os 
        usuarios conectados tem o id de seu endereco setado com 1
    */
    public void cadastrar(Object obj) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.createConnection();

        
        java.sql.Date sqlDate = null;
        
        String sqlInsertUsuario = "INSERT INTO public.tbusuario(nome,cpf,email,administrador,datanascimento,telefone,enderecousuario,senha) VALUES (?,?,?,?,?,?,?,?)";
//        String sqlInsertEndereco = "INSERT INTO public.tbendereco(cidade,bairro,logradouro,numero,complemento,cep) VALUES (?, ?, ?, ?, ?, ?)";
        Usuario user = (Usuario) obj;
        try {
            con.setAutoCommit(true);

//            PreparedStatement stm = con.prepareStatement(sqlInsertEndereco);
//            stm.setString(1, user.getEndereco().getCidade());
//            stm.setString(2, user.getEndereco().getBairro());
//            stm.setString(3, user.getEndereco().getLogradouro());
//            stm.setInt(4, user.getEndereco().getNumero());
//            stm.setString(5, user.getEndereco().getComplemento());
//            stm.setString(6, user.getEndereco().getCep());
//            stm.execute();
//
//            String sqlRetornaChave = "SELECT max(id) FROM public.tbendereco where cidade = '" + user.getEndereco().getCidade()
//                    + "' and bairro = '" + user.getEndereco().getBairro()
//                    + "' and logradouro = '" + user.getEndereco().getLogradouro()
//                    + "' and numero =" + user.getEndereco().getNumero()
//                    + " and complemento = '" + user.getEndereco().getComplemento()
//                    + "' and cep = '" + user.getEndereco().getCep() + "'";
//
//            PreparedStatement st = con.prepareStatement(sqlRetornaChave);
//            ResultSet rs = st.executeQuery();
//            int idEndereco = 0;
//            while (rs.next()) {
//                idEndereco = rs.getInt("max");
//            }

            PreparedStatement stmt = con.prepareStatement(sqlInsertUsuario);
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getCpf());
            stmt.setString(3, user.getEmail());
            stmt.setBoolean(4, false);
            
            if(user.getDataNascimento() != null) {
                sqlDate = new java.sql.Date(user.getDataNascimento().getTime());
            }
            
            stmt.setDate(5, sqlDate);
            stmt.setString(6, user.getTelefone());
            stmt.setInt(7, 1);
            stmt.setString(8, user.getSenha());

            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("EXCESAO:");
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("ERRO");
                ex.printStackTrace();
            }
        }

    }

    public List<Usuario> listarTodosUsuarios() throws SQLException, ClassNotFoundException {
        List<Usuario> usuarios = new ArrayList<>();
        Connection con = Conexao.createConnection();

        String sqlSelect = "SELECT * FROM public.tbusuario";

        PreparedStatement stmt = con.prepareStatement(sqlSelect);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Usuario user = new Usuario();
            user.setId(rs.getInt("id"));
            user.setNome(rs.getString("nome"));
            user.setCpf(rs.getString("cpf"));
            user.setEmail(rs.getString("email"));
            user.setAdministrador(rs.getBoolean("administrador"));
            user.setDataNascimento(rs.getDate("datanascimento"));
            user.setTelefone(rs.getString("telefone"));
            user.setSenha(rs.getString("senha"));
            
            int idEndereco = rs.getInt("enderecousuario");

            PreparedStatement s = con.prepareStatement("Select * from public.tbendereco where id = " + idEndereco);
            ResultSet r = s.executeQuery();
            while (r.next()) {
                Endereco e = new Endereco();
                e.setId(r.getInt("id"));
                e.setCidade(r.getString("cidade"));
                e.setBairro(r.getString("bairro"));
                e.setLogradouro(r.getString("logradouro"));
                e.setNumero(r.getInt("numero"));
                e.setComplemento(r.getString("complemento"));
                e.setCep(r.getString("cep"));
                
                user.setEndereco(e);
            }
            if (user != null) {
                usuarios.add(user);
            }
        }
        con.close();

        return usuarios;

    }

    public static Usuario validaLogin(String email, String senha) throws SQLException, ClassNotFoundException {
        Usuario user = new Usuario();

        Connection con = Conexao.createConnection();

        String sqlSelect = "SELECT * FROM public.tbusuario where email='" + email + "' and senha = '" + senha + "'";
        PreparedStatement stmt = con.prepareStatement(sqlSelect);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            user.setId(rs.getInt("id"));
            user.setNome(rs.getString("nome"));
            user.setCpf(rs.getString("cpf"));
            user.setEmail(rs.getString("email"));
            user.setAdministrador(rs.getBoolean("administrador"));
            
//             java.util.Date d = new java.util.Date(rs.getDate("datanascimento").getTime());
             
            
            user.setDataNascimento(rs.getDate("datanascimento"));
            user.setTelefone(rs.getString("telefone"));
            user.getEndereco().setId(rs.getInt("enderecousuario"));
            
            PreparedStatement s = con.prepareStatement("Select * from public.tbendereco where id = " + user.getEndereco().getId());
            ResultSet r = s.executeQuery();
            while (r.next()) {
                user.getEndereco().setCidade(r.getString("cidade"));
                user.getEndereco().setBairro(r.getString("bairro"));
                user.getEndereco().setLogradouro(r.getString("logradouro"));
                user.getEndereco().setNumero(r.getInt("numero"));
                user.getEndereco().setComplemento(r.getString("complemento"));
                user.getEndereco().setCep(r.getString("cep"));
            }
        }
        con.close();

        if (user != null) {
            return user;
        } else {
            return null;
        }
    }
    
    public static Usuario retornaUsuario(int id) throws SQLException, ClassNotFoundException {
        Usuario user = new Usuario();

        Connection con = Conexao.createConnection();

        String sqlSelect = "SELECT * FROM public.tbusuario where id=" + id;
        PreparedStatement stmt = con.prepareStatement(sqlSelect);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            user.setId(rs.getInt("id"));
            user.setNome(rs.getString("nome"));
            user.setCpf(rs.getString("cpf"));
            user.setEmail(rs.getString("email"));
            user.setAdministrador(rs.getBoolean("administrador"));
            user.setDataNascimento(rs.getDate("datanascimento"));
            user.setTelefone(rs.getString("telefone"));
            user.getEndereco().setId(rs.getInt("enderecousuario"));

            PreparedStatement s = con.prepareStatement("Select * from public.tbendereco where id = " + user.getEndereco().getId());
            ResultSet r = s.executeQuery();
            while (r.next()) {
                user.getEndereco().setCidade(r.getString("cidade"));
                user.getEndereco().setBairro(r.getString("bairro"));
                user.getEndereco().setLogradouro(r.getString("logradouro"));
                user.getEndereco().setNumero(r.getInt("numero"));
                user.getEndereco().setComplemento(r.getString("complemento"));
                user.getEndereco().setCep(r.getString("cep"));
            }
        }
        con.close();

        if (user != null) {
            return user;
        } else {
            return null;
        }
    }
}
