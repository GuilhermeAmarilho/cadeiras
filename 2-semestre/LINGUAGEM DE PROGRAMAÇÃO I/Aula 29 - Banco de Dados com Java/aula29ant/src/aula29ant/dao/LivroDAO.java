package aula29ant.dao;

import aula29ant.bd.ConexaoBD;
import aula29ant.model.Livro;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    
    private Connection conexao;    
    
    public LivroDAO(){
        this.conexao = ConexaoBD.conectar();
    }
    
    //inserção de livro
    public int inserirLivro(Livro livro){
        int resultado = 0;
        try {
            
            String sql = "insert into livros (titulo, autor, editora, edicao) values (?,?,?,?)";
                        
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getEditora());
            stmt.setInt(4, livro.getEdicao());
            
            resultado = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Erro no cadastro. " + ex.getMessage());            
        }
        return resultado;
    }
    
    //consulta de livros
    public List<Livro> consultarLivros(){
        
        String sql = "select * from livros";
        List<Livro> livros = new ArrayList<>();
        
        Statement stmt;
        ResultSet rs = null;
        
        try {
            stmt = this.conexao.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {            
        }        
        return livros;            
    }
    
    //solução com ResultSet; mais simples; suscetível a erros
//    public ResultSet consultarLivros(){
//        
//        String sql = "select * from livros";
//        
//        Statement stmt;
//        ResultSet rs = null;
//        
//        try {
//            stmt = this.conexao.createStatement();
//            rs = stmt.executeQuery(sql);
//        } catch (SQLException ex) {            
//        }        
//        return rs;            
//    }
    
    
    
    
    //remoção de livro
    public int removerLivro(int id){
        String sql = "delete from livros where id=?";
        int resultado = 0;
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            resultado = stmt.executeUpdate();
        } catch (SQLException ex) {            
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    //atualização de livro
    public int atualizarLivro(Livro livro){
        int resultado = 0;
        try {
            
            String sql = "update livros set titulo=?, autor=?, editora=?, edicao=? where id=?";
                        
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getEditora());
            stmt.setInt(4, livro.getEdicao());
            stmt.setInt(5, livro.getId());
            
            resultado = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
        return resultado;
    }
    
}
