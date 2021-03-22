
public class PessoaJuridica extends Pessoa {
	
	protected int cnpj;
	protected int inscricaoEstadual;
	protected String razaoSocial;
	
	public PessoaJuridica(String nome, String endereco, String email, int cnpj, int inscricaoEstadual, String razaoSocial) {
		
		super(nome, endereco, email);
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.razaoSocial = razaoSocial;
		
	}
	
	@Override
	public String toString() {
		
		return "nome: " + nome + "\nendereco: " + endereco + "\nemail: " + email + "\ncnpj: " + cnpj + "\ninscricao estadual: " + inscricaoEstadual + "\nrazao social: " + razaoSocial + "\n";
		
	}

}
