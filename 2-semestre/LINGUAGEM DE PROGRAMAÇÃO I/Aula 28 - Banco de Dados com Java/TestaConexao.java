package aula28;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaConexao {
    
    public static void main(String[] args) {
        
        Connection conexao = ConexaoBD.conectar();
        
//        try {
//            Statement stmt = conexao.createStatement();
//            
//            String sql = "insert into livros (autor, titulo, editora, edicao) "
//                    + "values "
//                    + "("
//                    + "'Gustavo Sovrani',"
//                    + "'Prefiro Java',"
//                    + "'IFC',"
//                    + "10"
//                    + ")";
//            
//            int n = stmt.executeUpdate(sql);
//            
//            if (n > 0)
//                System.out.println("O cadastro foi realizado com sucesso");
//            else
//                System.out.println("Erro no cadastro");
//            
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }

        Statement stmt;
        try {
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery("select * from livros where edicao=1");
            
            while (rs.next()){
                System.out.println("Autor: " + rs.getString("autor"));
                System.out.println("Título: " + rs.getString("titulo"));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        
    }
    
}
