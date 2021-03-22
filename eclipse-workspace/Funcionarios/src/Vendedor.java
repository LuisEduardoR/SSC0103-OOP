/**
 * Classe abstrata que representa um vendedor.
 * @author Luis Eduardo Rozante - 10734794
 *
 */
public class Vendedor extends Funcionario {

	protected double comissao;
	
	public double getComissao() {
		return comissao;
	}
	
	public Vendedor(String nome, String cpf, double salarioBase, double comissao) {
		
		super(nome, cpf, salarioBase);
		this.comissao = comissao;
		
	}
	
	@Override
	public double calculaSalario() {
		
		return salarioBase + comissao;
		
	}
	
}
