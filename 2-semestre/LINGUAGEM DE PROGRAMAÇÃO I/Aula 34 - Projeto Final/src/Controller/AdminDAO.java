
package Controller;

import BD.ConexaoBD;
import Model.Admin;
import Model.Setor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDAO {
    private Connection conexao;
    
    public AdminDAO(){
        this.conexao = ConexaoBD.conectar();
    }
    
    public int inserirAdmin(Admin a){
        int resultado = 0;
        try{
            String sql = ("insert into admin (nome, login, senha, cpf, idsetor) values (?,?,?,?,?)");
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1,a.getNome());
            stmt.setString(2,a.getLogin());
            stmt.setString(3,a.getSenha());
            stmt.setString(4,a.getCpf());
            stmt.setInt(5,a.getSetor().getIdSetor());
            resultado = stmt.executeUpdate();
        }
        catch(SQLException ex){
             System.out.println("Erro no cadastro!"+ex.getMessage());
        }
        return resultado;
    }
    
    public int removerAdmin(int id){
        int resultado = 0;
        try{
            String sql = ("delete from admin where idadmin = ?");
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setInt(1,id);
            
            resultado = stmt.executeUpdate();
        }
        catch(SQLException ex){
             System.out.println("Erro na remoção!"+ex.getMessage());
        }
        return resultado;
    }
    
    public int alterarAdmin(Admin a){
        int resultado = 0;
        try{
            String sql = ("update admin set nome = ?, login = ?, senha = ?, cpf = ?, idsetor = ? where idAdmin = ?");
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1,a.getNome());
            stmt.setString(2,a.getLogin());
            stmt.setString(3,a.getSenha());
            stmt.setString(4,a.getCpf());
            stmt.setInt(5,a.getSetor().getIdSetor());
            stmt.setInt(6,a.getIdAdmin());
            resultado = stmt.executeUpdate();
        }
        catch(SQLException ex){
             System.out.println("Erro ao Atualizar!"+ex.getMessage());
        }
        return resultado;
    }
    
    public Admin buscaAdmin(int id) throws SQLException {
        String sql = "select idadmin, nome, login, senha, cpf, idsetor from admin where idadmin = "+id;
        Statement stmt;
        ResultSet rs = null; 
        Admin a = new Admin();
        try {
            stmt = this.conexao.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {}  
        while(rs.next()){
            a.setIdAdmin(rs.getInt("idadmin"));
            a.setNome(rs.getString("nome"));
            a.setLogin(rs.getString("login"));
            a.setSenha(rs.getString("senha"));
            a.setCpf(rs.getString("cpf"));
                        
            SetorDAO sd = new SetorDAO();       
            Setor s = sd.buscaSetor(rs.getInt("idsetor"));
            a.setSetor(s);
        }
        return a;
    }
    
    public Admin login(String login, String senha) throws SQLException {
        String sql = "select idadmin, idsetor, nome, login, senha, cpf from admin where login = '"+login+"' and senha = '"+senha+"'";
        Statement stmt;
        ResultSet rs = null; 
        Admin a = new Admin();
        try {
            stmt = this.conexao.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {}  
        while(rs.next()){
            a.setIdAdmin(rs.getInt("idadmin"));
            a.setNome(rs.getString("nome"));
            a.setLogin(rs.getString("login"));
            a.setSenha(rs.getString("senha"));
            a.setCpf(rs.getString("cpf"));
            
            
            SetorDAO sd = new SetorDAO();       
            Setor s = sd.buscaSetor(rs.getInt("idsetor"));
            a.setSetor(s);
        }
        return a;
    }

}
