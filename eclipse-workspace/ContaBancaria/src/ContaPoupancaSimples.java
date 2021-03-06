/**
 * Classe que representa uma conta poupanca simples.
 * @author Luis Eduardo Rozante - 10734794
 *
 */
public class ContaPoupancaSimples extends ContaPoupanca {
	
	public ContaPoupancaSimples(String nome, float saldo, int diaRendimento, float taxaRendimento) {
		
		super(nome, saldo, diaRendimento, taxaRendimento);
		
	}
	
	@Override
	public void atualiza(int dia) {
		
		if(dia == diaRendimento) {
			
			saldo *= (1 + taxaRendimento);
			
		}
		
	}
}
