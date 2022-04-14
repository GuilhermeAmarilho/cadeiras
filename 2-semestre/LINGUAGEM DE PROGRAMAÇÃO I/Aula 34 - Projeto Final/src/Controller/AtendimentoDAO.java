package Controller;

import BD.ConexaoBD;
import Model.Admin;
import Model.Atendimento;
import Model.Setor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AtendimentoDAO {
    private Connection conexao;
    
    public AtendimentoDAO(){
        this.conexao = ConexaoBD.conectar();
    }
    
    public int inserirAtendimento(Atendimento a){
        int resultado = 0;
        try{
            String sql = ("insert into atendimento (tipoequipamento, idequipamento, descricao, urgencia, setoratendimento) values (?,?,?,?,?)");
        
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            System.out.println(a);
            stmt.setString(1,a.getTipoEquipamento());
            stmt.setString(2,a.getIdEquipamento());
            stmt.setString(3,a.getDescricao());
            stmt.setInt(4,a.getUrgencia());
            stmt.setInt(5,a.getSetorAtendimento().getIdSetor());
            resultado = stmt.executeUpdate();
        }
        catch(SQLException ex){
             System.out.println("Erro no cadastro!"+ex.getMessage());
        }
        return resultado;
    }
    
    public int removerAtendimento(int id){
        int resultado = 0;
        try{
            String sql = ("delete from atendimento where idatendimento = ?");
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setInt(1,id);
            
            resultado = stmt.executeUpdate();
        }
        catch(SQLException ex){
             System.out.println("Erro na remoção!"+ex.getMessage());
        }
        return resultado;
    }
    
    public int alterarAtendimento(Atendimento a){
        int resultado = 0;
        try{//Hora e cliente que fez o chamado não podem ser mudados
            String sql = ("update atendimento set tipoequipamento = ?, idequipamento = ?, descricao = ?, urgencia = ?, status = ? where idatendimento = ?");
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1,a.getTipoEquipamento());
            stmt.setString(2,a.getIdEquipamento());
            stmt.setString(3,a.getDescricao());
            stmt.setInt(4,a.getUrgencia());
            stmt.setInt(5,a.getStatus());
            stmt.setInt(6,a.getIdAtendimento());
            resultado = stmt.executeUpdate();
        }
        catch(SQLException ex){
             System.out.println("Erro ao Atualizar!"+ex.getMessage());
        }
        return resultado;
    }
    
    public int finalizarAtendimento(int idAdmin, int idAtendimento){
        int resultado = 0;
        try{
            String sql = ("update atendimento set status = 1, idAdmin=? where idAtendimento = ?");
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setInt(1, idAdmin);
            stmt.setInt(2, idAtendimento);
            resultado = stmt.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println("Erro ao Atualizar!"+ex.getMessage());
        }
        return resultado;
    }
    
    public Atendimento buscaAtendimento(int id) throws SQLException {
        String sql = "select idAtendimento, tipoequipamento, idequipamento, descricao, urgencia, "
                + "setorAtendimento, horachamado, idadmin, status from atendimento where idAtendimento = "+id;
        Statement stmt;
        ResultSet rs = null; 
        Atendimento a = new Atendimento();
        try {
            stmt = this.conexao.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {}  
        while(rs.next()){
            a.setIdAtendimento(rs.getInt("idatendimento"));
            a.setTipoEquipamento(rs.getString("tipoequipamento"));
            a.setIdEquipamento(rs.getString("idequipamento"));
            a.setDescricao(rs.getString("descricao"));
            a.setUrgencia(rs.getInt("urgencia"));
            
            SetorDAO sd = new SetorDAO();       
            Setor s = sd.buscaSetor(rs.getInt("setorAtendimento"));
            a.setSetorAtendimento(s);
            
            a.setHoraChamado(rs.getString("horachamado"));
                       
            AdminDAO admdao = new AdminDAO();
            Admin adm = admdao.buscaAdmin(rs.getInt("idadmin"));
            a.setAdminResponsavel(adm);
            
            a.setStatus(rs.getInt("status"));
        }
        return a;
    }
    
    public ArrayList atendimentoSetor(int id) throws SQLException {
        ArrayList<Atendimento> lista = new ArrayList<>();
        String sql = "select * from atendimento where setorAtendimento = "+id+" and status = 0 order by horachamado desc";
        Statement stmt;
        ResultSet rs = null; 
        Atendimento a = new Atendimento();
        try {
            stmt = this.conexao.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {}  
        while(rs.next()){
            a = new Atendimento();
            a.setIdAtendimento(rs.getInt("idatendimento"));
            a.setTipoEquipamento(rs.getString("tipoequipamento"));
            
            SetorDAO sd = new SetorDAO();       
            Setor s = sd.buscaSetor(id);
            a.setSetorAtendimento(s);
            a.setHoraChamado(rs.getString("horaChamado"));
            a.setStatus(rs.getInt("status"));
            
            lista.add(a); 
        }
        return lista;        
    }

}
