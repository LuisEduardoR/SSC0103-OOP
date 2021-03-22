/**
 * Classe abstrata que representa um gerente.
 * @author Luis Eduardo Rozante - 10734794
 *
 */
public class Gerente extends Funcionario {

	public Gerente(String nome, String cpf, double salarioBase) {
		
		super(nome, cpf, salarioBase);
		
	}
	
	@Override
	public double calculaSalario() {
		
		return salarioBase * 2;
		
	}
	
}
