package classes.DAO;

import classes.DTO.Cadastro_associadoDTO;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cadastro_associadoDAO {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;
    ArrayList<Cadastro_associadoDTO> lista = new ArrayList<>();

    public void incluirAssociado(Cadastro_associadoDTO objcadastra) throws ClassNotFoundException, SQLException, SQLException {

        String sql = " insert into associado (nome_completo,cpf,telefone,email) ";
        sql += " values(?,?,?,?)";
        con = new Conexao().conexao();

        try {

            stm.setString(1, objcadastra.getCpf());
            stm.setString(2, objcadastra.getNome_completo());
            stm.setString(3, objcadastra.getTelefone());
            stm.setString(4, objcadastra.getEmail());
            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage() + sql);

        }
    }

    public void alterarassociado(Cadastro_associadoDTO objcadastra) throws ClassNotFoundException, SQLException {
        String sql = " UPDATE associado  ";
        sql += "SET nome_completo =?, ";
        sql += "cpf =?, ";
        sql += "telefone = ? ";
        sql += "email = ? ";
        sql += " WHERE cpf =?";
        con = new Conexao().conexao();
        try {
            stm.setString(1, objcadastra.getNome_completo());
            stm.setString(2, objcadastra.getCpf());
            stm.setString(3, objcadastra.getTelefone());
            stm.setString(4, objcadastra.getEmail());
            stm.execute();
            System.out.println("Deu certo");
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage() + sql);
        }
    }

    public void excluirassociado(Cadastro_associadoDTO objcadastra) throws ClassNotFoundException, SQLException {
        String sql = " DELETE FROM associado ";
        sql += " WHERE cpf = ? ";
        con = new Conexao().conexao();
        try {

            stm.setString(1, objcadastra.getCpf());
            stm.execute();
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage() + sql);
        }

    }

    public ArrayList<Cadastro_associadoDTO> pesquisarAssociado() throws ClassNotFoundException, SQLException {

        String sql = " select nome_completo, cpf, telefone, email";
        sql += " from associado ";
        sql += "where cpf = ? ";
        con = new Conexao().conexao();
        try {

            stm = con.prepareStatement(sql);
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                Cadastro_associadoDTO objcadastraDTO = new Cadastro_associadoDTO();
                objcadastraDTO.setNome_completo(rs.getString("nome_completo"));
                objcadastraDTO.setCpf(rs.getString("cpf"));
                objcadastraDTO.setTelefone(rs.getString("telefone"));
                objcadastraDTO.setEmail(rs.getString("email"));

                lista.add(objcadastraDTO);
            }
        } catch (SQLException e) {
        }

        return lista;
    }

}
