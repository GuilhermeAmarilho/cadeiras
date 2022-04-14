package Model;

public class Setor {
    private int idSetor;
    private String nome;
    public Setor(String nome){
        this.nome = nome;
        this.idSetor = 0;
    }
    public Setor(){
        this.nome = null;
        this.idSetor = 0;
    }
    public int getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(int idSetor) {
        this.idSetor = idSetor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return "Setor{" + "idSetor=" + idSetor + ", nome=" + nome + '}';
    }
}
