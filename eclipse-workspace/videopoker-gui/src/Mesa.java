/**
 * Classe que representa o placar de um jogo de poker controlando as fichas e as apostas.
 * @author Luis Eduardo Rozante - 10734794
 *
 */
public class Mesa {

	// Posicoes do placar.
	int creditos;
	int aposta;
	
	/**
	 * Construtor da classe, inicia com 200 creditos e sem aposta.
	 */
	public Mesa(int cInit) {
		
		creditos = cInit;		
		aposta = 0;
	}

	public void apostar(int qnt) throws IllegalArgumentException {
		
		// Caso uma aposta tenha sido feita devolve os creditos.
		if(aposta != 0) {
			
			creditos += aposta;
			aposta = 0;
			
		}
		
		// Retorna um erro se o jogador nao tiver os creditos necessarios.
		if(qnt <= 0) 
			throw new IllegalArgumentException("Quantidade de creditos invalida!");
		else if (qnt > creditos) 
			throw new IllegalArgumentException("Quantidade de creditos insuficiente! Voce so tem " + creditos + " creditos!");
		
		// Faz a aposta.
		aposta = qnt;
		creditos -= qnt;
		
	}
	
	/**
	 * Tenta fazer uma jogada.
	 * @param mao A mao para realziar a jogada.
	 * @return Uma string contendo uma descricao da jogada.
	 */
 	public String play(Carta[] mao) {
 		
 		// Conta quantas cartas de cada tipo.
 		int[] countCartas = new int[13];
 		for(int i = 0; i < 13; i++)
 			countCartas[i] = 0;
 		for(int i = 0; i < mao.length; i++)		
 			countCartas[mao[i].getNum()-1]++;
 		
 		// Conta o numero de pares.
 		boolean[] pares = new boolean[13];
 		for(int i = 0; i < 13; i++) {
 			pares[i] = false;
 			if(countCartas[i] >= 2) pares[i] = true;
 		}
 	 		
		// Conta o numero de pares.
 		boolean[] trincas = new boolean[13];
 		for(int i = 0; i < 13; i++) {
 			trincas[i] = false;
 			if(countCartas[i] >= 3) trincas[i] = true;
 		}
 		
 		// Conta quantas cartas de cada naipe.
 		int[] countNaipes = new int[4];
 		for(int i = 0; i < 4; i++)
 			countNaipes[i] = 0;
 		for(int i = 0; i < mao.length; i++)		
 			countNaipes[mao[i].getNaipe()-1]++;
 		
 		// Detecta se todas as cartas tem o mesmo naipe.
 		boolean flush = false;
 		for(int i = 0; i < 4; i++)	
 			if(countNaipes[i] >= 5)	
 				flush = true;
 		
 		// Detecta se as cartas formam uma sequencia.
 	 	boolean straight = false;
 	 	boolean royal = false;
 	 	for(int i = 0; i < 9; i++) {
 	 		
 	 		if(countCartas[i] == 1 && countCartas[i+1] == 1 && countCartas[i+2] == 1 && countCartas[i+3] == 1 && countCartas[i+4] == 1) {
 	 			straight = true;
 	 			break;
 	 		}
 	 		
 	 	}
 	 	
 	 	// Detecta se as cartas formam um royal straight.
 		if(countCartas[0] == 1 && countCartas[12] == 1 && countCartas[11] == 1 && countCartas[10] == 1 && countCartas[9] == 1) {
 			
 			straight = true;
 			royal = true;
 			
 		}
 	 	
 	 	
 		// Checa se houve royal straight flush
 		if(straight && flush && royal) {
 			
 			String res = "";
  			res = "Você conseguiu formar um royal straight flush e recebeu " + (200 * aposta) + " créditos(s) de prêmio!";
  			creditos += aposta + (200 * aposta);
  			aposta = 0;
  	 		return res;
  			
  		}
 		
 		// Checa se houve straight flush
 		if(straight && flush) {
 			
 			String res = "";
  			res = "Você conseguiu formar um straight flush e recebeu " + (100 * aposta) + " créditos(s) de prêmio!";
  			creditos += aposta + (100 * aposta);
  			aposta = 0;
  	 		return res;
  			
  		}
 	 	
 		
 		// Checa se houveram quadras.
 		for(int i = 0; i < 13; i++) {
 			if(countCartas[i] >= 4) {
 				
 				String res = "";
 	 			res = "Você conseguiu formar uma quadra e recebeu " + (50 * aposta) + " créditos(s) de prêmio!";
 	 			creditos += aposta + (50 * aposta);
 	 			aposta = 0;
 	 	 		return res;
 	 	 		
 			}
 		}
 	 	
 		// Checa se houve full hand.
 		boolean hasPar = false, hasTrinca = false;
 		for(int i = 0; i < 13; i++) {	
 			if(trincas[i])
 				hasTrinca = true;
 			else if (pares[i])
 				hasPar = true;
 		}
 		if(hasPar && hasTrinca) {
 				
			String res = "";
 			res = "Você conseguiu formar uma full hand e recebeu " + (20 * aposta) + " créditos(s) de prêmio!";
 			creditos += aposta + (20 * aposta);
 			aposta = 0;
 	 		return res;
 	 	 		
 		}	
 		
 		//Flush
		if(flush) {
			
			String res = "";
 			res = "Você conseguiu formar um flush e recebeu " + (10 * aposta) + " créditos(s) de prêmio!";
 			creditos += aposta + (10 * aposta);
 			aposta = 0;
 	 		return res;
 			
 		}
 		
		//Straight
		if(straight) {
			
			String res = "";
 			res = "Você conseguiu formar um straight e recebeu " + (5 * aposta) + " créditos(s) de prêmio!";
 			creditos += aposta + (5 * aposta);
 			aposta = 0;
 	 		return res;
 			
 		}
 		
 		// Checa se houveram trincas.
		for(int i = 0; i < 13; i++) {
			if(trincas[i]) {
					
				String res = "";
				res = "Você conseguiu formar uma trinca e recebeu " + (2 * aposta) + " créditos(s) de prêmio!";
				creditos += aposta + (2 * aposta);
				aposta = 0;
		 		return res;
		 	 		
			}
		}
 	 		
 		// Checa se houveram dois pares.
		int numPares = 0;
		for(int i = 0; i < 13; i++)
			if(pares[i])
				numPares++;
		if(numPares >= 2) {
 			String res = "";
 			res = "Você conseguiu formar dois pares e recebeu " + aposta + " créditos(s) de prêmio!";
 			creditos += aposta + aposta;
 			aposta = 0;
 	 		return res;
		}

 		aposta = 0;
	 	return "Você não consegui formar nada e perdeu sua aposta!";
 	}
 	
 	/**
 	 * Retorna os creditos.
 	 * @return Os creditos.
 	 */
 	public int getCredits() {
 		
 		return creditos;
 		
 	}
 	
 	@Override
 	public String toString() {
 		
 		return "Creditos:" + creditos;
 		
 	}
 	
}
