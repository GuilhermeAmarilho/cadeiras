package aula28;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    private static final String USUARIO = "root";
    private static final String SENHA = "1fc!2022";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";

    public static Connection conectar(){
        Connection conn = null;

        try {
                        
            Class.forName(DRIVER);            
            conn = DriverManager.getConnection(URL, USUARIO, SENHA);            
            
        } catch (ClassNotFoundException e) {
            System.out.println("Erro de conexão: driver não encontrado");
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erro de conexão: parâmetros inválidos");
        }

        return conn;
    }
}