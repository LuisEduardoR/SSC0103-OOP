/**
 * Classe abstrata que representa uma conta poupanca.
 * @author Luis Eduardo Rozante - 10734794
 *
 */
public abstract class ContaPoupanca extends ContaBancaria {
	
	protected int diaRendimento;
	protected float taxaRendimento;
	
	public ContaPoupanca(String nome, float saldo, int diaRendimento, float taxaRendimento) {
		
		super(nome, saldo);
		this.diaRendimento = diaRendimento;
		this.taxaRendimento = taxaRendimento;
		
	}
	
	public int getDiaRendimento() {
		return diaRendimento;
	}
	public void setDiaRendimento(int diaRendimento) {
		this.diaRendimento = diaRendimento;
	}
	public float getTaxaRendimento() {
		return taxaRendimento;
	}
	public void setTaxaRendimento(float taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}
	
	public abstract void atualiza(int dia);
	
	@Override
	public float saque(float valor) throws IllegalArgumentException {
		
		if(saldo >= valor) {
			saldo -= valor;
			return valor;
		} else {
			
			throw new IllegalArgumentException("Saldo Insuficiente");
			
		}
		
	}

}
