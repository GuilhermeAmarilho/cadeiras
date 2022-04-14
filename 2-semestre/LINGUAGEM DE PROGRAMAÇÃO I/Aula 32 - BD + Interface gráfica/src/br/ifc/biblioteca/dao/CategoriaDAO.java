package br.ifc.biblioteca.dao;

import br.ifc.biblioteca.bd.ConexaoBD;
import br.ifc.biblioteca.model.Categoria;
import br.ifc.biblioteca.model.Livro;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    
    private Connection conexao;    
    
    public CategoriaDAO(){
        this.conexao = ConexaoBD.conectar();
    }
    
    //consulta de categoria
    public List<Categoria> consultarCategorias(){
        
        String sql = "select * from categorias";
        List<Categoria> categorias = new ArrayList<>();
        
        Statement stmt;
        ResultSet rs = null;
        Categoria categoria = null;
        try {
            stmt = this.conexao.createStatement();
            rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
                
                categorias.add(categoria);
            }
            
        } catch (SQLException ex) {            
        }        
        return categorias;            
    }
    
}
