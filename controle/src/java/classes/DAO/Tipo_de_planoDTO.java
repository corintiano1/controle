package classes.DAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre_s_lima
 */
public class Tipo_de_planoDTO {

    private String semanal;
    private String quinzenal;
    private String mensal;
    private int valor;

    public boolean incluirtipo_de_plano() throws ClassNotFoundException, SQLException, SQLException {

        String sql = " insert into tipo_de_plano (semanal,quinzenal,mensal,valor) ";
        sql += " values(?,?,?,?)";
        java.sql.Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, this.semanal);
            stm.setString(2, this.quinzenal);
            stm.setString(3, this.mensal);
            stm.execute();
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage() + sql);
            return false;
        }
        return true;
    }

    public void alterartipo_de_plano() throws ClassNotFoundException, SQLException {
        String sql = " UPDATE tipo_de_plano ";
        sql += "SET semanal =?, ";
        sql += "quinzenal =?, ";
        sql += "mensal = ? ";
        sql += " WHERE valor =?";
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, this.semanal);
            stm.setString(2, this.quinzenal);
            stm.setString(3, this.mensal);
            stm.setInt(4, this.valor);
            stm.execute();
            System.out.println("Deu certo");
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage() + sql);
        }
    }

    public boolean excluirtipo_de_plano() throws ClassNotFoundException {
        String sql = " DELETE FROM  tipo_de_plano";
        sql += " WHERE valor = ? ";
        Connection con = null;
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, this.valor);
            stm.execute();
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage() + sql);
            return false;
        }
        return true;
    }

    public Tipo_de_planoDTO consultartipo_de_plano(int pvalor) {
        Connection con = null;
        String sql = " select semanal, quinzenal, mensal, valor";
        sql += " from tipo_de_plano ";
        sql += "where valor = ? ";
        Tipo_de_planoDTO tipo = null;
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, pvalor);
            ResultSet rst = stm.executeQuery();
            if (rst.next()) {
                tipo = new Tipo_de_planoDTO();
                tipo.setSemanal("semanal");
                tipo.setquinzenal("quinzenal");
                tipo.setMensal(rst.getString("mensal"));
                tipo.setValor(rst.getInt("valor"));
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage() + sql);
        }
        return tipo;
    }

    public List<Tipo_de_planoDTO> consultartipo_de_plano() {
        List<Tipo_de_planoDTO> lista = new ArrayList<>();
        Connection con = null;
        String sql = " select semanal, quinzenal, mensal, valor";
        sql += " from tipo_de_plano ";
        sql += " order by valor";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rst = stm.executeQuery();
            while (rst.next()) {
                Tipo_de_planoDTO tipo = new Tipo_de_planoDTO();
                tipo.setSemanal(rst.getString("semanal"));
                tipo.setquinzenal(rst.getString("quinzenal"));
                tipo.setMensal(rst.getString("mensal"));
                tipo.setValor(rst.getInt(valor));
                lista.add(tipo);
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage() + sql);
        }
        return lista;
    }

    public String getquinzenal() {
        return quinzenal;
    }

    public void setquinzenal(String quinzenal) {
        this.quinzenal = quinzenal;
    }

    public String getSemanal() {
        return semanal;
    }

    public void setSemanal(String semanal) {
        this.semanal = semanal;
    }

    public String getMensal() {
        return mensal;
    }

    public void setMensal(String mensal) {
        this.mensal = mensal;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

}
