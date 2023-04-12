package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

     Connection con = null;
    public Connection  conexao() throws ClassNotFoundException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/estacionamento?user=root&password";
            con = DriverManager.getConnection(url);
        } catch (SQLException e) {
            
        }
        return con;
    }
}

