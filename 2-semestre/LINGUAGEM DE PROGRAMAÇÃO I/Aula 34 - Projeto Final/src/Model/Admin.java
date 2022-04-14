package Model;

public class Admin {
    private int idAdmin;
    private String nome;
    private String login;
    private String senha;
    private String cpf;
    private Setor setor;
    
    public Admin(){
        this.idAdmin = 0;
        this.nome = null;
        this.login = null;
        this.senha = null;
        this.cpf  = null;
        this.setor = new Setor();
    }
    public Admin(String nome, String login, String senha, String cpf, Setor setor){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
        this.setor = setor;
    }
    public Admin(String nome, String login, String senha, String cpf){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
        this.setor = new Setor();
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "Admin{" + "idAdmin=" + idAdmin + ", nome=" + nome + ", login=" + login + ", senha=" + senha + ", cpf=" + cpf + ", setor=" + setor + '}';
    }
    
    
    
}
