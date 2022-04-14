package Model;

public class Cliente {
    private int idCliente;
    private String nome;
    private String login;
    private String senha;
    private String cpf;
    private String telefone;
    private Setor setor;
    
    public Cliente(){
        this.idCliente = 0;
        this.nome = null;
        this.login = null;
        this.senha = null;
        this.cpf  = null;
        this.telefone = null;
        this.setor = new Setor();
    }
    public Cliente(String nome, String login, String senha, String cpf, String telefone, Setor setor){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
        this.telefone = telefone;
        this.setor = setor;
        this.idCliente = 0;
    }
    public Cliente(String nome, String login, String senha, String cpf, String telefone){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
        this.telefone = telefone;
        this.setor = new Setor();
        this.idCliente = 0;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nome=" + nome + ", login=" + login + ", senha=" + senha + ", cpf=" + cpf + ", telefone=" + telefone + ", setor=" + setor.getNome() + '}';
    }
    
}
