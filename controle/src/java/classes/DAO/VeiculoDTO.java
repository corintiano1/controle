package classes.DAO;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VeiculoDTO {
    
    private String numero_rfid;
    private String placa;
    private String descricao;
    
    
    public boolean incluirVeiculo() throws SQLException {
       String sql =" insert into veiculo (numero_rfid, placa, descricao)";
       sql+= " values(?,?,?)";
       Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VeiculoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
           PreparedStatement  stm=con.prepareStatement(sql);
           stm.setString(1, this.numero_rfid);
           stm.setString(2, this.placa);
           stm.setString(3, this.descricao);
           stm.execute();
        } catch (SQLException ex) {
            System.out.println("Error "+ex.getMessage()+sql);
            return false;
        }
        return true;
    }
    public Boolean alterarVeiculo() throws SQLException {
       String sql =" UPDATE veiculo  ";
       sql+= "SET numero_rfid =?, ";
       sql+= "placa =?, ";
       sql+= "descricao = ? ";
       sql+=" WHERE numero_rfid=? ";
      
       Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VeiculoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
           PreparedStatement  stm=con.prepareStatement(sql);
           stm.setString(1, this.numero_rfid);
           stm.setString(2, this.placa);
           stm.setString(3, this.descricao);
           stm.execute();
        } catch (SQLException ex) {
            System.out.println("Error "+ex.getMessage()+sql);
            return false;
        }
        return true;
    }

    public boolean excluirVeiculo() throws SQLException {
       String sql =" DELETE FROM veiculo ";
       sql+= " WHERE numero_rfid = ? ";
       Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VeiculoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
           PreparedStatement  stm=con.prepareStatement(sql);
           stm.setString(1, this.numero_rfid);
           
           stm.execute();
        } catch (SQLException ex) {
            System.out.println("Error "+ex.getMessage()+sql);
            return false;
        }
        return true;
    }
        public VeiculoDTO consultarVeiculo(int pNumero_rfid) throws SQLException {
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VeiculoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "select  numero_rfid, placa, descricao";
               sql += "from veiculo ";
               sql += "where numero_rfid = ?";
        VeiculoDTO vei = null;
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, "pNumero_rfid");
            // executa a Query e guarda o resultado num elemento chamdo "Result Set"
            // o Result Set é uma classe da API JAVA que permite percorrermos uma consulta em um banco de dados. 
            // Ao ser inicializado, o Resultset coloca seu cursor na primeira linha do DataTable, 
            // o método next() permite que o ponteiro seja direcionado para a próxima linha caso exista. 
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                // para cada linha resgatada do ResultSet, instanciamos a classe novamente para "limpar" o conteúdo anterior dos atributos
                vei = new VeiculoDTO();
                vei.setNumero_rfid(numero_rfid);
                // o valor de cada atributo é obtido através de um get no ResultSet, sempre cuidando para usar o get associado ao tipo correto do atributo
                vei.setNumero_rfid(rs.getString("numero_rfid"));
                vei.setPlaca(rs.getString("placa"));
                vei.setDescricao(rs.getString("descricao"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        return vei;
    }

    public List<VeiculoDTO> consultarTodosVeiculo() throws SQLException {
        List<VeiculoDTO> lista = new ArrayList<>();
        Connection con = null;
        try {
            con = Conexao.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VeiculoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String  sql  = "select numero_rfid, placa, descricao ";
                sql += "from veiculo ";
                sql += "order by numero_rfid";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                VeiculoDTO vei = new VeiculoDTO();
                vei.setNumero_rfid(rs.getString("numero_rifd"));
                vei.setPlaca(rs.getString("placa"));
                vei.setDescricao(rs.getString("descricao"));
                
                lista.add(vei);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        return lista;
    }

    public String getNumero_rfid() {
        return numero_rfid;
    }

    public void setNumero_rfid(String numero_rfid) {
        this.numero_rfid = numero_rfid;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
}