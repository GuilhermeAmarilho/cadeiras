package App;

import View.Principal;

import java.sql.SQLException;

public class App {

    private static Principal telaPrincipal;
    
    public static void main(String[] args) throws SQLException{
        telaPrincipal = new Principal();
        telaPrincipal.setVisible(true);
        
        // Testes DAO
        
        //int a = 0;
        //Admin ad = new Admin();
        //Atendimento at = new Atendimento();
        //Cliente c = new Cliente();
        //Setor s = new Setor();
        
        //AdminDAO addao = new AdminDAO();
        //AtendimentoDAO atdao = new AtendimentoDAO();
        //ClienteDAO cdao = new ClienteDAO();
        //SetorDAO sdao = new SetorDAO();
        
        //sdao.LerConsulta(sdao.consultarSetores());    //Funcionando
        //s = sdao.buscaSetor(1);           //Funcionando

        //c = new Cliente("teste","t1","t1","123","123",s);
        //a = cdao.inserirCliente(c);       //Funcionando
        //c = cdao.buscaCliente(21);
        //c.setCpf("456");
        //a = cdao.alterarCliente(c);       //Funcionando
        //c = cdao.login("t1", "t1");       //Funcionando
        //c = cdao.login("t1", "t11");      //Funcionando
        //a = cdao.removerCliente(21);
        
        //ad = new Admin("Teste","t1","t1","111",s);
        //int a = addao.inserirAdmin(ad);   //Funcionando
        //ad = addao.buscaAdmin(1);         //Funcionando
        //ad.setCpf("789");
        //int a = addao.alterarAdmin(ad);   //Funcionando
        //ad = addao.login("t1", "t1");     //Funcionando
        //ad = addao.login("t1", "t2");     //Funcionando
        //int a = addao.removerAdmin(13);   //Funcionando
        
        //at = new Atendimento("PC positivo","43jhd139","Lorem Ipsum is simply ",0,s);  //Funcionou
        //at = atdao.buscaAtendimento(10);  //Funcionando
        //at.setUrgencia(1);
        //a = atdao.alterarAtendimento(at); //Funcionando
        //System.out.println(atdao.atendimentoSetor(1));
        //atdao.finalizarAtendimento(at.getIdAtendimento(), ad.getIdAdmin());    //Funcionando
        //a = atdao.removerAtendimento(10);
        
        //System.out.println(a);
        
        
        
    }


    
    
    
}
