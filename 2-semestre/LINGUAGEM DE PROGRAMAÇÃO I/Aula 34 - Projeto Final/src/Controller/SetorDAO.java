package Controller;

import BD.ConexaoBD;
import Model.Setor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SetorDAO {
    private Connection conexao;
    
    public SetorDAO(){
        this.conexao = ConexaoBD.conectar();
    }
    
    public ResultSet consultarSetores(){
       String sql = "select idsetor, nome from setor";
       Statement stmt;
       ResultSet rs = null;
       try {
           stmt = this.conexao.createStatement();
           rs = stmt.executeQuery(sql);
       } catch (SQLException ex) {}        
       return rs;            
    }
    
    public Setor buscaSetor(int id) throws SQLException {
        String sql = "select idsetor, nome from setor where idsetor = "+id;
        Statement stmt;
        ResultSet rs = null; 
        Setor s = new Setor();
        try {
            stmt = this.conexao.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {}  
        while(rs.next()){
            s.setIdSetor(rs.getInt("idsetor"));
            s.setNome(rs.getString("nome"));
        }
        return s;
    }
    
    public void LerConsulta(ResultSet rs) throws SQLException{
        System.out.println("-*-*-*-*-*-* Começo da lista *-*-*-*-*-*-");
        while(rs.next()){
            System.out.println("ID = "+rs.getInt("idsetor")+" / Nome = "+rs.getString("nome"));
            System.out.println("_________________");
        }
        System.out.println("_._._._._._ Fim da lista _._._._._._");
    }
    
}
