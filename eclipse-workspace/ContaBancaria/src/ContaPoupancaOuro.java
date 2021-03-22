/**
 * Classe que representa uma conta poupanca outo, onde os rendimentos sao 1.5 vezes a taxa.
 * @author Luis Eduardo Rozante - 10734794
 *
 */
public class ContaPoupancaOuro extends ContaPoupanca {
	
	public ContaPoupancaOuro(String nome, float saldo, int diaRendimento, float taxaRendimento) {
		
		super(nome, saldo, diaRendimento, taxaRendimento);
		
	}
	
	@Override
	public void atualiza(int dia) {
		
		if(dia == diaRendimento) {
			
			saldo *= (1 + (1.5f*taxaRendimento));
			
		}
		
	}
}
