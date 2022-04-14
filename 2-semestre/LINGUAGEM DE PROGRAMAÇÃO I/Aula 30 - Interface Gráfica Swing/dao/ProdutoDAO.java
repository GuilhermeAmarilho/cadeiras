/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aula30JavaSwing.dao;
import Aula30JavaSwing.model.Produto;
import Aula30JavaSwing.bd.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author guilherme
 */
public class ProdutoDAO {
    private Connection conexao;
    
    public ProdutoDAO(){
        this.conexao = ConexaoBD.conectar();
    }
    
    public int inserirProduto(Produto produto){
        int resultado = 0;
        try{
            String sql = ("insert into produto (nome,preco,idsetor) values (?,?,?)");
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1,produto.getNome());;
            stmt.setDouble(2,produto.getPreco());
            stmt.setInt(3,produto.getIdsetor());
            resultado = stmt.executeUpdate();
            
        }
        catch(SQLException ex){
             System.out.println("Erro no cadastro!"+ex.getMessage());
        }
        return resultado;
    }
    
    public int removerProduto(int id){
        int resultado = 0;
        try{
            String sql = ("delete from produto where idproduto = ?");
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setInt(1,id);
            
            resultado = stmt.executeUpdate();
        }
        catch(SQLException ex){
             System.out.println("Erro na remoção!"+ex.getMessage());
        }
        return resultado;
    }
    
    public int alterarProduto(Produto produto){
        int resultado = 0;
        try{
            String sql = ("update produto set nome = ?, preco = ?, idsetor = ? where idproduto = ?");
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1,produto.getNome());
            stmt.setDouble(2,produto.getPreco());
            stmt.setInt(3,produto.getIdsetor());
            stmt.setInt(4,produto.getIdproduto());
            resultado = stmt.executeUpdate();
        }
        catch(SQLException ex){
             System.out.println("Erro ao Atualizar!"+ex.getMessage());
        }
        return resultado;
    }
    
    public ResultSet consultarProdutos(){
       
       String sql = "select idproduto, nome, preco, idsetor from produto";
       
       Statement stmt;
       ResultSet rs = null;
       
       try {
           stmt = this.conexao.createStatement();
           rs = stmt.executeQuery(sql);
       } catch (SQLException ex) {            
       }        
       return rs;            
   }
    
}
