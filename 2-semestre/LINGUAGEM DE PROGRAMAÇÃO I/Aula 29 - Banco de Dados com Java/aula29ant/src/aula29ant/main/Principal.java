package aula29ant.main;

import aula29ant.dao.LivroDAO;
import aula29ant.model.Livro;

public class Principal {
    
    public static void main(String[] args) {
        //Livro livro = new Livro(5,"Assim falou Zaratustra", "Friedrich Nietzsche", "LPM", 100);        
        
        LivroDAO livroDAO = new LivroDAO();
        
        livroDAO.removerLivro(5);
        
//        int r = livroDAO.atualizarLivro(livro);
//        
//        if (r>0)
//            System.out.println("Atualização efetuada com sucesso.");
//        else
//            System.out.println("Erro no cadastro");
    }
    
}
