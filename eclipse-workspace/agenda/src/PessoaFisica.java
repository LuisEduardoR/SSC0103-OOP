
public class PessoaFisica extends Pessoa {
	
	protected int cpf;
	protected int nascimento;
	protected boolean casada;
	
	public PessoaFisica(String nome, String endereco, String email, int cpf, int nascimento, boolean casada) {
		
		super(nome, endereco, email);
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.casada = casada;
		
	}
	
	@Override
	public String toString() {
		
		return "nome: " + nome + "\nendereco: " + endereco + "\nemail: " + email + "\ncpf: " + cpf + "\nnascimento: " + nascimento + "\ncasado: " + casada + "\n";
		
	}

}
