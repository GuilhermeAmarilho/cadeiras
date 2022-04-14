package Lista;

public class CadernoDeContatos {
	public static void main(String[] args) {
		Email e = new Email("gui@aa.com","email pessoal");
		Email e2 = new Email("teste@teste.com","email de teste");
		Telefone t = new Telefone("+55 53 9 8765-4321", "Numero pessoal");
		Telefone t2 = new Telefone("+12 34 5 6789-9876", "Numero teste");
		Contato c = new Contato("Guilherme", "Amarilho", "02/27/2001");
		c.adicionarEmail(e);
		c.adicionarEmail(e2);
		c.removerEmail(e2);
		c.adicionarTelefone(t);
		c.adicionarTelefone(t2);
		c.removerTelefone(t);
		Agenda a = new Agenda();
		a.adicionarContato(c);
		a.listarContatos();
		a.listarContato(0);
	}
}
