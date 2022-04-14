package Aula30JavaSwing.main;


import Aula30JavaSwing.dao.ProdutoDAO;
import Aula30JavaSwing.model.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author guilherme
 */
public class Principal {
    public static void main(String[] args) throws SQLException{
        Produto prod = new Produto(4, "uva verde",9.90);
        ProdutoDAO pDAO = new ProdutoDAO();
        
        // int r = pDAO.inserirProduto(prod);
        // if(r>0)
        //     System.out.println("Cadastro concluido!");
        // else
        //     System.out.println("Erro ao fazer cadastro");
        
        // int r = pDAO.removerProduto(19);
        // if(r>0)
        //     System.out.println("Remoção concluida!");
        // else
        //     System.out.println("Erro ao fazer a remoção");

        // prod.setIdproduto(18);
        // prod.setNome("uva verde e marrom");
        
        // int r = pDAO.AlterarProduto(prod);
        // if(r>0)
        //     System.out.println("Alteração concluida!");
        // else
        //     System.out.println("Erro ao fazer a alteração");
        
        ResultSet rs = pDAO.consultarProdutos();
        System.out.println("####### Começo da lista ######");
        while(rs.next()){
            System.out.println("Código: "+rs.getInt("idproduto")+" - Nome: "+rs.getString("nome") + " - Preço: " + rs.getDouble("preco") + " - IdSetor: "+rs.getInt("idsetor"));
            System.out.println("----------------------------------------------------");
        }
    }
}
