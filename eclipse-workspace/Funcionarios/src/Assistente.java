/**
 * Classe abstrata que representa um assistente.
 * @author Luis Eduardo Rozante - 10734794
 *
 */
public class Assistente extends Funcionario {

	public Assistente(String nome, String cpf, double salarioBase) {
		
		super(nome, cpf, salarioBase);
		
	}
	
	@Override
	public double calculaSalario() {
		
		return salarioBase;
		
	}
	
}
