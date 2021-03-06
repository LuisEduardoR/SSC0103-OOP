/**
 * Classe que representa uma conta bancaria especial.
 * @author Luís Eduardo Rozante - 10734794
 *
 */
public class ContaEspecial extends ContaBancaria {

	protected float limite;
	
	public ContaEspecial(String nome, float saldo, float limite) {
		
		
		super(nome, saldo);
		this.limite = limite;
	}
	
	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	@Override
	public float saque(float valor) throws IllegalArgumentException {
		
		if(saldo + limite >= valor) {
			saldo -= valor;
			return valor;
		} else {
			
			throw new IllegalArgumentException("Limite Insuficiente");
			
		}
		
	}
	
	@Override
	public void atualiza(int dia) {
		
	}
	
}
