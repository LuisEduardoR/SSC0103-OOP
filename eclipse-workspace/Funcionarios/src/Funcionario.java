/**
 * Classe abstrata que representa um funcionario.
 * @author Luis Eduardo Rozante - 10734794
 *
 */
public abstract class Funcionario {

	public static boolean verificaCPF(String cpf) {
		
		if(cpf.length() != 14)
			return false;
		
		if (cpf.charAt(3) != '.')
			return false;
		
		if (cpf.charAt(7) != '.')
			return false;
		
		if (cpf.charAt(11) != '-')
			return false;
		
		for(int i = 0; i < cpf.length(); i++) {
			
			if(i != 3 && i != 7 && i != 11) {
				
				if(cpf.charAt(i) != 'x' && cpf.charAt(i) != 'X' && !(cpf.charAt(i) >= '0' && cpf.charAt(i) <= '9'))
					return false;
					
			}
		}
		
		return true;
		
	}
	
	protected String nome;
	protected String cpf;
	protected double salarioBase;
	
	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public double getSalarioBase() {
		return salarioBase;
	}
	
	public Funcionario(String nome, String cpf, double salarioBase) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.salarioBase = salarioBase;
		
	}

	public abstract double calculaSalario();
	
	@Override
	public String toString() {
		
		return "(" + cpf + ") nome: " + nome + " - salario: " + calculaSalario() + "\n";
		
	}
	
}
