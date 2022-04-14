package Lista;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
public class Contato {
	private String nome;
	private String sobrenome;
	private Date dataNascimento;
	private ArrayList<Telefone> telefones;
	private ArrayList<Email> emails;
	public Contato(String nome, String sobrenome, String data) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = gerarData(data);;
		this.telefones = new ArrayList<>();
		this.emails = new ArrayList<>();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	private static Date gerarData(String nascData) {
		SimpleDateFormat data = new SimpleDateFormat("MM/dd/yyyy");
		try {
			Date casdastroData = data.parse(nascData);
			return casdastroData;
		} 
		catch ( Exception ex) {
			JOptionPane.showMessageDialog(null, "Data invalida");
			return new Date();
		}	
	}
	// Interpretei diferente, cada contato tera seu metodo de inserir e remover numero e email, pois assim torna mais organizado e coerente
	// Adicionando
	public void adicionarEmail(Email email) {
		if(!this.emails.contains(email)) {
			this.emails.add(email);
			System.out.println("Email adicionado!");
		}else
			System.out.println("Email já cadastrado!");
	}
	public void adicionarTelefone(Telefone telefone) {
		if(!this.telefones.contains(telefone)) {
			this.telefones.add(telefone);
			System.out.println("Telefone adicionado!");
		}else
			System.out.println("Telefone já cadastrado!");
	}
	// Removendo		
	public void removerEmail(Email email) {
		if(this.emails.contains(email)) {
			this.emails.remove(email);		
			System.out.println("Email removido!");
		}else
			System.out.println("Email não encontrado!");
	}
	public void removerTelefone(Telefone telefone) {
		if(this.telefones.contains(telefone)) {
			this.telefones.remove(telefone);		
			System.out.println("Telefone removido!");
		}else
			System.out.println("Telefone não encontrado!");
	}
}

