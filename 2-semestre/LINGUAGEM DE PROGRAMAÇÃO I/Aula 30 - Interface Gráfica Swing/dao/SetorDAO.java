/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aula30JavaSwing.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Aula30JavaSwing.model.Setor;
import Aula30JavaSwing.bd.ConexaoBD;
import java.sql.SQLException;

/**
 *
 * @author guilherme
 */
public class SetorDAO {
    private Connection conexao;
    
    public SetorDAO(){
        this.conexao = ConexaoBD.conectar();
    }
    
    public void inserirProduto(Setor setor){
        try{
            String sql = ("insert into setor (nome) values ('"+setor.getNome()+"')");
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.execute();
            
        }
        catch(SQLException ex){
             System.out.println("Erro no cadastro!"+ex.getMessage());
        }
    }
}
