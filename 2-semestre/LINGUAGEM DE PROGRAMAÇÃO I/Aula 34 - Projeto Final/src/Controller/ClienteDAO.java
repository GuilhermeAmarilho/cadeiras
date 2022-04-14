
package Controller;

import BD.ConexaoBD;
import Model.Atendimento;
import Model.Cliente;
import Model.Setor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDAO {
    private Connection conexao;
    
    public ClienteDAO(){
        this.conexao = ConexaoBD.conectar();
    }
    
    public int inserirCliente(Cliente c){
        int resultado = 0;
        try{
            String sql = ("insert into cliente (nome, login, senha, cpf, telefone, idsetor) values (?,?,?,?,?,?)");
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1,c.getNome());
            stmt.setString(2,c.getLogin());
            stmt.setString(3,c.getSenha());
            stmt.setString(4,c.getCpf());
            stmt.setString(5,c.getTelefone());
            stmt.setInt(6,c.getSetor().getIdSetor());
            resultado = stmt.executeUpdate();
        }
        catch(SQLException ex){
             System.out.println("Erro no cadastro!"+ex.getMessage());
        }
        return resultado;
    }
    
    public int removerCliente(int id){
        int resultado = 0;
        try{
            String sql = ("delete from cliente where idcliente = ?");
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setInt(1,id);
            
            resultado = stmt.executeUpdate();
        }
        catch(SQLException ex){
             System.out.println("Erro na remoção!"+ex.getMessage());
        }
        return resultado;
    }
    
    public int alterarCliente(Cliente c){
        int resultado = 0;
        try{
            String sql = ("update cliente set nome = ?, login = ?, senha = ?, cpf = ?, telefone = ?, idsetor = ? where idcliente = ?");
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1,c.getNome());
            stmt.setString(2,c.getLogin());
            stmt.setString(3,c.getSenha());
            stmt.setString(4,c.getCpf());
            stmt.setString(5,c.getTelefone());
            stmt.setInt(6,c.getSetor().getIdSetor());
            stmt.setInt(7,c.getIdCliente());
            resultado = stmt.executeUpdate();
        }
        catch(SQLException ex){
             System.out.println("Erro ao Atualizar!"+ex.getMessage());
        }
        return resultado;
    }
    
    public Cliente buscaCliente(int id) throws SQLException {
        String sql = "select idCliente, nome, login, senha, cpf, telefone, idsetor from cliente where idcliente = "+id;
        Statement stmt;
        ResultSet rs = null; 
        Cliente c = new Cliente();
        try {
            stmt = this.conexao.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {}  
        while(rs.next()){
            c.setIdCliente(rs.getInt("idcliente"));
            c.setNome(rs.getString("nome"));
            c.setLogin(rs.getString("login"));
            c.setSenha(rs.getString("senha"));
            c.setCpf(rs.getString("cpf"));
            c.setTelefone(rs.getString("telefone"));
            
            SetorDAO sd = new SetorDAO();       
            Setor s = sd.buscaSetor(rs.getInt("idsetor"));
            c.setSetor(s);
        }
        return c;
    }

    public Cliente login(String login, String senha) throws SQLException {
        String sql = "select idCliente, nome, login, senha, cpf, telefone, idsetor from cliente where login = '"+login+"' and senha = '"+senha+"'";
        Statement stmt;
        ResultSet rs = null; 
        Cliente c = new Cliente();
        try {
            stmt = this.conexao.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {} 
        while(rs.next()){
            c.setIdCliente(rs.getInt("idcliente"));
            c.setNome(rs.getString("nome"));
            c.setLogin(rs.getString("login"));
            c.setSenha(rs.getString("senha"));
            c.setCpf(rs.getString("cpf"));
            c.setTelefone(rs.getString("telefone"));
            
            SetorDAO sd = new SetorDAO();       
            Setor s = sd.buscaSetor(rs.getInt("idsetor"));
            c.setSetor(s);
        }
        return c;
    }

}
