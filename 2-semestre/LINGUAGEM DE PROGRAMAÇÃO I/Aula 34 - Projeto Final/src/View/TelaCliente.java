package View;

import Controller.AtendimentoDAO;
import Controller.ClienteDAO;
import Model.Atendimento;
import Model.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaCliente extends javax.swing.JFrame {
    private static int idCliente;   
    ClienteDAO cdao = new ClienteDAO();
    Cliente c = new Cliente();
    
    public TelaCliente(int idCliente) throws SQLException {
        initComponents();
        this.idCliente = idCliente;
        c = cdao.buscaCliente(idCliente);
        this.dados(c);
        this.construirTabela(c.getSetor().getIdSetor());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        tituloData = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jLabel1 = new javax.swing.JLabel();
        nomeData = new javax.swing.JLabel();
        loginData = new javax.swing.JLabel();
        cpfData = new javax.swing.JLabel();
        setorData = new javax.swing.JLabel();
        AlterarDados = new javax.swing.JButton();
        telData = new javax.swing.JLabel();
        excluirConta = new javax.swing.JButton();
        labelChamados = new javax.swing.JLabel();
        equipamentoAtendimento10 = new javax.swing.JLabel();
        labelProdutoAtendimento1 = new javax.swing.JLabel();
        labelDataAtendimento1 = new javax.swing.JLabel();
        labelStatusAtendimento1 = new javax.swing.JLabel();
        produtoAtendimento1 = new javax.swing.JLabel();
        dataAtendimento1 = new javax.swing.JLabel();
        statusAtendimento1 = new javax.swing.JLabel();
        produtoAtendimento2 = new javax.swing.JLabel();
        produtoAtendimento3 = new javax.swing.JLabel();
        produtoAtendimento4 = new javax.swing.JLabel();
        produtoAtendimento5 = new javax.swing.JLabel();
        dataAtendimento2 = new javax.swing.JLabel();
        dataAtendimento3 = new javax.swing.JLabel();
        dataAtendimento4 = new javax.swing.JLabel();
        dataAtendimento5 = new javax.swing.JLabel();
        statusAtendimento2 = new javax.swing.JLabel();
        statusAtendimento3 = new javax.swing.JLabel();
        statusAtendimento4 = new javax.swing.JLabel();
        statusAtendimento5 = new javax.swing.JLabel();
        attTabela = new javax.swing.JButton();
        finalizarSessao = new javax.swing.JButton();
        criarChamado = new javax.swing.JButton();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 0, 0));

        tituloData.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        tituloData.setText("Olá");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Seus dados");

        nomeData.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        nomeData.setText("Nome:");

        loginData.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        loginData.setText("Login:");

        cpfData.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cpfData.setText("Cpf: ");

        setorData.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        setorData.setText("Setor:");

        AlterarDados.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        AlterarDados.setText("Alterar Dados");
        AlterarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarDadosActionPerformed(evt);
            }
        });

        telData.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        telData.setText("Tel:");

        excluirConta.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        excluirConta.setText("Remover Conta");
        excluirConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirContaActionPerformed(evt);
            }
        });

        labelChamados.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelChamados.setText("Chamados recentes no seu setor");

        equipamentoAtendimento10.setText(".");

        labelProdutoAtendimento1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        labelProdutoAtendimento1.setText("Produto");

        labelDataAtendimento1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        labelDataAtendimento1.setText("Data");

        labelStatusAtendimento1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        labelStatusAtendimento1.setText("Status");

        produtoAtendimento1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        produtoAtendimento1.setText("Produto");

        dataAtendimento1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        dataAtendimento1.setText("Data");

        statusAtendimento1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        statusAtendimento1.setText("Status");

        produtoAtendimento2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        produtoAtendimento2.setText("Produto");

        produtoAtendimento3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        produtoAtendimento3.setText("Produto");

        produtoAtendimento4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        produtoAtendimento4.setText("Produto");

        produtoAtendimento5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        produtoAtendimento5.setText("Produto");

        dataAtendimento2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        dataAtendimento2.setText("Data");

        dataAtendimento3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        dataAtendimento3.setText("Data");

        dataAtendimento4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        dataAtendimento4.setText("Data");

        dataAtendimento5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        dataAtendimento5.setText("Data");

        statusAtendimento2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        statusAtendimento2.setText("Status");

        statusAtendimento3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        statusAtendimento3.setText("Status");

        statusAtendimento4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        statusAtendimento4.setText("Status");

        statusAtendimento5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        statusAtendimento5.setText("Status");

        attTabela.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        attTabela.setText("Atualizar tabela");
        attTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attTabelaActionPerformed(evt);
            }
        });

        finalizarSessao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        finalizarSessao.setText("Finalizar sessão");
        finalizarSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarSessaoActionPerformed(evt);
            }
        });

        criarChamado.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        criarChamado.setText("Realizar chamado!");
        criarChamado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarChamadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeData, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(loginData, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cpfData, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(telData, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(setorData, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(excluirConta, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(finalizarSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AlterarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(produtoAtendimento4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(produtoAtendimento3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(produtoAtendimento2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(produtoAtendimento1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelProdutoAtendimento1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(produtoAtendimento5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dataAtendimento4, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dataAtendimento5, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dataAtendimento3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dataAtendimento2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelDataAtendimento1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dataAtendimento1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(statusAtendimento5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(statusAtendimento4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(statusAtendimento3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(statusAtendimento2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(statusAtendimento1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelStatusAtendimento1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(criarChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(attTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(175, 175, 175))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelChamados)
                        .addGap(169, 169, 169))))
            .addGroup(layout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(tituloData, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(equipamentoAtendimento10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloData)
                    .addComponent(equipamentoAtendimento10))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelChamados)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelProdutoAtendimento1)
                            .addComponent(labelDataAtendimento1)
                            .addComponent(labelStatusAtendimento1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(produtoAtendimento1)
                            .addComponent(dataAtendimento1)
                            .addComponent(statusAtendimento1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(produtoAtendimento2)
                            .addComponent(dataAtendimento2)
                            .addComponent(statusAtendimento2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(produtoAtendimento3)
                            .addComponent(dataAtendimento3)
                            .addComponent(statusAtendimento3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(produtoAtendimento4)
                            .addComponent(dataAtendimento4)
                            .addComponent(statusAtendimento4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(produtoAtendimento5)
                            .addComponent(dataAtendimento5)
                            .addComponent(statusAtendimento5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(nomeData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loginData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cpfData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(telData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(setorData)))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AlterarDados)
                        .addGap(44, 44, 44)
                        .addComponent(excluirConta)
                        .addGap(44, 44, 44)
                        .addComponent(finalizarSessao))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(attTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(criarChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void attTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attTabelaActionPerformed
        ClienteDAO cd = new ClienteDAO(); 
        try {
            int idsetor = cd.buscaCliente(this.idCliente).getSetor().getIdSetor();
            this.construirTabela(idsetor);
        } catch (SQLException ex) {
            Logger.getLogger(TelaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_attTabelaActionPerformed

    private void criarChamadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criarChamadoActionPerformed
        this.dispose();
        CriarAtendimento ca;
        try {
            ca = new CriarAtendimento(idCliente);
            ca.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(TelaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_criarChamadoActionPerformed

    private void finalizarSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarSessaoActionPerformed
        this.dispose();
        new Principal().setVisible(true);
    }//GEN-LAST:event_finalizarSessaoActionPerformed

    private void excluirContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirContaActionPerformed
        ClienteDAO cd = new ClienteDAO();
        cd.removerCliente(this.idCliente);
        this.dispose();
        new Principal().setVisible(true);
    }//GEN-LAST:event_excluirContaActionPerformed

    private void AlterarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarDadosActionPerformed
        this.dispose();
        AlterarCliente aa = null;
        try {
            aa = new AlterarCliente(idCliente);
        } catch (SQLException ex) {
            Logger.getLogger(TelaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        aa.setVisible(true);
    }//GEN-LAST:event_AlterarDadosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaCliente(idCliente).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AlterarDados;
    private javax.swing.JButton attTabela;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel cpfData;
    private javax.swing.JButton criarChamado;
    private javax.swing.JLabel dataAtendimento1;
    private javax.swing.JLabel dataAtendimento2;
    private javax.swing.JLabel dataAtendimento3;
    private javax.swing.JLabel dataAtendimento4;
    private javax.swing.JLabel dataAtendimento5;
    private javax.swing.JLabel equipamentoAtendimento10;
    private javax.swing.JButton excluirConta;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton finalizarSessao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelChamados;
    private javax.swing.JLabel labelDataAtendimento1;
    private javax.swing.JLabel labelProdutoAtendimento1;
    private javax.swing.JLabel labelStatusAtendimento1;
    private javax.swing.JLabel loginData;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private javax.swing.JLabel nomeData;
    private javax.swing.JLabel produtoAtendimento1;
    private javax.swing.JLabel produtoAtendimento2;
    private javax.swing.JLabel produtoAtendimento3;
    private javax.swing.JLabel produtoAtendimento4;
    private javax.swing.JLabel produtoAtendimento5;
    private javax.swing.JLabel setorData;
    private javax.swing.JLabel statusAtendimento1;
    private javax.swing.JLabel statusAtendimento2;
    private javax.swing.JLabel statusAtendimento3;
    private javax.swing.JLabel statusAtendimento4;
    private javax.swing.JLabel statusAtendimento5;
    private javax.swing.JLabel telData;
    private javax.swing.JLabel tituloData;
    // End of variables declaration//GEN-END:variables
    
    public void dados(Cliente c){
        this.tituloData.setText("Olá "+c.getNome());
        this.nomeData.setText("Nome: "+c.getNome());
        this.loginData.setText("Login: "+c.getLogin());
        
        String cpf = c.getCpf();
        for(int i = cpf.length(); i <= 11; i++){ //caso tenha vindo com valores a menos
            cpf+="0";
        }
        
        cpf = cpf.substring(0,3)+"."+cpf.substring(3,6)+"."+cpf.substring(6,9)+"-"+cpf.substring(10);
        this.cpfData.setText("CPF: "+cpf);
        
        String tel = c.getTelefone();
        for(int i = tel.length(); i <= 11; i++){ //caso tenha vindo com valores a menos
            tel+="0";
        }
        
        tel = "("+tel.substring(0,2)+") "+tel.substring(2,3)+" "+tel.substring(3,7)+"-"+tel.substring(7);
        this.telData.setText("Tel: "+tel);
        this.setorData.setText("Setor: "+c.getSetor().getNome());
    }
    
    public void construirTabela(int idSetor) throws SQLException{                
        AtendimentoDAO ad = new AtendimentoDAO();
        ArrayList <Atendimento> a = ad.atendimentoSetor(idSetor);
        if(a.size()>4){
            produtoAtendimento1.setText(a.get(0).getTipoEquipamento());
            dataAtendimento1.setText(a.get(0).getHoraChamado());
            if(a.get(0).getStatus()==1)
                statusAtendimento1.setText("Finalizado!");
            if(a.get(0).getStatus()==0)
                statusAtendimento1.setText("Em espera");
            produtoAtendimento2.setText(a.get(1).getTipoEquipamento());
            dataAtendimento2.setText(a.get(1).getHoraChamado());
            if(a.get(1).getStatus()==1)
                statusAtendimento2.setText("Finalizado!");
            if(a.get(1).getStatus()==0)
                statusAtendimento2.setText("Em espera");
            produtoAtendimento3.setText(a.get(2).getTipoEquipamento());
            dataAtendimento3.setText(a.get(2).getHoraChamado());
            if(a.get(2).getStatus()==1)
                statusAtendimento3.setText("Finalizado!");
            if(a.get(2).getStatus()==0)
                statusAtendimento3.setText("Em espera");
            produtoAtendimento4.setText(a.get(3).getTipoEquipamento());
            dataAtendimento4.setText(a.get(3).getHoraChamado());
            if(a.get(3).getStatus()==1)
                statusAtendimento4.setText("Finalizado!");
            if(a.get(3).getStatus()==0)
                statusAtendimento4.setText("Em espera");
            produtoAtendimento5.setText(a.get(4).getTipoEquipamento());
            dataAtendimento5.setText(a.get(4).getHoraChamado());
            if(a.get(4).getStatus()==1)
                statusAtendimento5.setText("Finalizado!");
            if(a.get(4).getStatus()==0)
                statusAtendimento5.setText("Em espera");
        }
        if(a.size()==4){
            produtoAtendimento1.setText(a.get(0).getTipoEquipamento());
            dataAtendimento1.setText(a.get(0).getHoraChamado());
            if(a.get(0).getStatus()==1)
                statusAtendimento1.setText("Finalizado!");
            if(a.get(0).getStatus()==0)
                statusAtendimento1.setText("Em espera");
            produtoAtendimento2.setText(a.get(1).getTipoEquipamento());
            dataAtendimento2.setText(a.get(1).getHoraChamado());
            if(a.get(1).getStatus()==1)
                statusAtendimento2.setText("Finalizado!");
            if(a.get(1).getStatus()==0)
                statusAtendimento2.setText("Em espera");
            produtoAtendimento3.setText(a.get(2).getTipoEquipamento());
            dataAtendimento3.setText(a.get(2).getHoraChamado());
            if(a.get(2).getStatus()==1)
                statusAtendimento3.setText("Finalizado!");
            if(a.get(2).getStatus()==0)
                statusAtendimento3.setText("Em espera");
            produtoAtendimento4.setText(a.get(3).getTipoEquipamento());
            dataAtendimento4.setText(a.get(3).getHoraChamado());
            if(a.get(3).getStatus()==1)
                statusAtendimento4.setText("Finalizado!");
            if(a.get(3).getStatus()==0)
                statusAtendimento4.setText("Em espera");
            produtoAtendimento5.setText("");dataAtendimento5.setText("");statusAtendimento5.setText("");
        }
        if(a.size()==3){
            produtoAtendimento1.setText(a.get(0).getTipoEquipamento());
            dataAtendimento1.setText(a.get(0).getHoraChamado());
            if(a.get(0).getStatus()==1)
                statusAtendimento1.setText("Finalizado!");
            if(a.get(0).getStatus()==0)
                statusAtendimento1.setText("Em espera");
            produtoAtendimento2.setText(a.get(1).getTipoEquipamento());
            dataAtendimento2.setText(a.get(1).getHoraChamado());
            if(a.get(1).getStatus()==1)
                statusAtendimento2.setText("Finalizado!");
            if(a.get(1).getStatus()==0)
                statusAtendimento2.setText("Em espera");
            produtoAtendimento3.setText(a.get(2).getTipoEquipamento());
            dataAtendimento3.setText(a.get(2).getHoraChamado());
            if(a.get(2).getStatus()==1)
                statusAtendimento3.setText("Finalizado!");
            if(a.get(2).getStatus()==0)
                statusAtendimento3.setText("Em espera");
            produtoAtendimento4.setText("");dataAtendimento4.setText("");statusAtendimento4.setText("");
            produtoAtendimento5.setText("");dataAtendimento5.setText("");statusAtendimento5.setText("");
        }
        if(a.size()==2){
            produtoAtendimento1.setText(a.get(0).getTipoEquipamento());
            dataAtendimento1.setText(a.get(0).getHoraChamado());
            if(a.get(0).getStatus()==1)
                statusAtendimento1.setText("Finalizado!");
            if(a.get(0).getStatus()==0)
                statusAtendimento1.setText("Em espera");
            produtoAtendimento2.setText(a.get(1).getTipoEquipamento());
            dataAtendimento2.setText(a.get(1).getHoraChamado());
            if(a.get(1).getStatus()==1)
                statusAtendimento2.setText("Finalizado!");
            if(a.get(1).getStatus()==0)
                statusAtendimento2.setText("Em espera");
            produtoAtendimento3.setText("");dataAtendimento3.setText("");statusAtendimento3.setText("");
            produtoAtendimento4.setText("");dataAtendimento4.setText("");statusAtendimento4.setText("");
            produtoAtendimento5.setText("");dataAtendimento5.setText("");statusAtendimento5.setText("");
        }
        if(a.size()==1){
            produtoAtendimento1.setText(a.get(0).getTipoEquipamento());
            dataAtendimento1.setText(a.get(0).getHoraChamado());
            if(a.get(0).getStatus()==1)
                statusAtendimento1.setText("Finalizado!");
            if(a.get(0).getStatus()==0)
                statusAtendimento1.setText("Em espera");
            produtoAtendimento2.setText("");dataAtendimento2.setText("");statusAtendimento2.setText("");
            produtoAtendimento3.setText("");dataAtendimento3.setText("");statusAtendimento3.setText("");
            produtoAtendimento4.setText("");dataAtendimento4.setText("");statusAtendimento4.setText("");
            produtoAtendimento5.setText("");dataAtendimento5.setText("");statusAtendimento5.setText("");
        }
        if(a.size()<1){
            labelProdutoAtendimento1.setText("");labelDataAtendimento1.setText("");labelStatusAtendimento1.setText("");
            produtoAtendimento1.setText("");dataAtendimento1.setText("");statusAtendimento1.setText("");
            produtoAtendimento2.setText("");dataAtendimento2.setText("");statusAtendimento2.setText("");
            produtoAtendimento3.setText("");dataAtendimento3.setText("");statusAtendimento3.setText("");
            produtoAtendimento4.setText("");dataAtendimento4.setText("");statusAtendimento4.setText("");
            produtoAtendimento5.setText("");dataAtendimento5.setText("");statusAtendimento5.setText("");
            labelChamados.setText("Seu setor não possui chamadas em aberto");
        }
    }
    
}
