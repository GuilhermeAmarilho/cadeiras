package Lista;
import java.util.ArrayList;
public class Agenda {
	private ArrayList<Contato> contatos;
	public Agenda() {
		this.contatos = new ArrayList<>();
	}
	public void adicionarContato(Contato contato) {
		if(!this.contatos.contains(contato)) {
			this.contatos.add(contato);
			System.out.println("Contato adicionado!");
		}else
			System.out.println("Contato já cadastrado!");
	}
	public void removerContato(Contato contato) {
		if(this.contatos.contains(contato)) {
			this.contatos.remove(contato);		
			System.out.println("Contato removido!");
		}else
			System.out.println("Contato não encontrado!");
	}
	public void atualizarContato(Contato contato, int i) {
		this.contatos.get(i).setDataNascimento(contato.getDataNascimento());
		this.contatos.get(i).setNome(contato.getNome());
		this.contatos.get(i).setSobrenome(contato.getSobrenome());
		System.out.println("Contato alterado!");
	}
	public void listarContatos() {
		System.out.println("##### Lista de contatos #####");
		for(Contato c : this.contatos) {
			System.out.println("==============");
			System.out.println("Nome: "+c.getNome());
			System.out.println("Sobrenome: "+c.getSobrenome());
			System.out.println("Data de nascimento: "+c.getDataNascimento());
		}
		System.out.println("##### Fim da lista #####");
	}
	public void listarContato(int i) {
		System.out.println("##### Listagem do contato #####");
		System.out.println("Nome: "+this.contatos.get(i).getNome());
		System.out.println("Sobrenome: "+this.contatos.get(i).getSobrenome());
		System.out.println("Data de nascimento: "+this.contatos.get(i).getDataNascimento());	
	}
	
}
