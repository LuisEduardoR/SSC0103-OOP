
public class Agenda {

	private Pessoa[] pessoas;
	
	public static void main(String[] args) {
		
		

	}
	
	public void adicionaPessoa(Pessoa pessoa) {
		
		// Recria a lista de pessoas deixando um novo espaco.
		Pessoa[] newPessoas = new Pessoa[pessoas.length + 1];
		for(int i = 0; i < pessoas.length; i++)
			newPessoas[i] = pessoas[i];
		// Adiciona a nova pessoa.
		newPessoas[pessoas.length] = pessoa;
		
		pessoas = newPessoas;
		
	}
	
	public void removePessoa(String nome) {
		
		removePorIndice(buscaIndice(nome));
		
	}
	
	public void removePessoa(int cpf_cnpj) {
	
		removePorIndice(buscaIndice(cpf_cnpj));
		
	}
	
	private void removePorIndice(int pos) {
		
		if(pos == -1) 
			return;
		
		boolean achou = false;
		for(int i = 0; i < pessoas.length - 1; i++) {
			
			if(i == pos)
				achou = true;
			
			if(achou)
				pessoas[i] = pessoas[i + 1];
			
		}
		
		// Recria a lista de pessoas sem o espaco sobrando.
		Pessoa[] newPessoas = new Pessoa[pessoas.length - 1];
		for(int i = 0; i < pessoas.length - 1; i++)
			newPessoas[i] = pessoas[i];
		
		pessoas = newPessoas;
			
	}
	
	private int buscaIndice(String nome) {
		
		for(int i = 0; i < pessoas.length; i++)
			if(pessoas[i].nome.equals(nome))
				return i;
		
		return -1;
		
	}
	
	private int buscaIndice(int cpf_cnpj) {
		
		for(int i = 0; i < pessoas.length; i++) {
			if(pessoas[i] instanceof PessoaFisica) {
				PessoaFisica pFisica = (PessoaFisica) pessoas[i];
				if(pFisica.cpf == cpf_cnpj)
					return i;
			} else if(pessoas[i] instanceof PessoaJuridica) {
				PessoaJuridica pFisica = (PessoaJuridica) pessoas[i];
				if(pFisica.cnpj == cpf_cnpj)
					return i;
			}
		}
		return -1;
		
	}
	
	public Pessoa buscaPessoa(String nome) {
		
		for(int i = 0; i < pessoas.length; i++)
			if(pessoas[i].nome.equals(nome))
				return pessoas[i];
		
		return null;
		
	}
	
	public Pessoa buscaPessoa(int cpf_cnpj) {
		
		for(int i = 0; i < pessoas.length; i++) {
			if(pessoas[i] instanceof PessoaFisica) {
				PessoaFisica pFisica = (PessoaFisica) pessoas[i];
				if(pFisica.cpf == cpf_cnpj)
					return pessoas[i];
			} else if(pessoas[i] instanceof PessoaJuridica) {
				PessoaJuridica pFisica = (PessoaJuridica) pessoas[i];
				if(pFisica.cnpj == cpf_cnpj)
					return pessoas[i];
			}
		}
		return null;
		
	}
	
	public void ordenaAgenda() {
		
	}
	
	@Override
	public String toString() {
		
		String toStr = "";
		for(int i = 0; i < pessoas.length; i++)
			toStr += pessoas[i].toString() + '\n';
			
		return toStr;
		
	}

}
