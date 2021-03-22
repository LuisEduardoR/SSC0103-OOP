/**
 * Classe que simula um jogo de Poker.
 * @author Luis Eduardo Rozante - 10734794
 *
 */
public class Poker {
	
	/**
	 * Quantidade de creditos com que o player comeca.
	 */
	public static final int creditosIniciais = 200;
	/**
	 * NUmero maximo de rodadas.
	 */
	public static final int numRodadas = 10;
	
	/**
	 * Rodada atual.
	 */
	public int rodadaAtual;
	
	/**
	 * Contem as cartas que serao usadas no jogo.
	 */
	public Baralho baralho;
	/**
	 * Avalia as cartas e guarda os creditos.
	 */
	public Mesa mesa;
	/**
	 * Contem as cartas atualmente retiradas pelo jogador.
	 */
	public Carta[] mao;
	
	/**
	 * Guarda as cartas da primeira devolucao, se ela ocorrer.
	 */
	public Carta[] devolucao1;
	/**
	 * Guarda as cartas da segunda devolucao, se ela ocorrer.
	 */
	public Carta[] devolucao2;
	
	
	/**
	 * Guarda se a mao atual foi confirmada.
	 */
	private boolean maoConfirmada;
	
	/**
	 * Cuida da interface do jogo.
	 */
	public GUI gui;
	
	/**
	 * Usado para controlar o fluxo do jogo, principalmente com relacao a interface.
	 */
	public enum estado { inicioJogo, iniciaRodada, realizaAposta, troca1, troca2, finalizaRodada, fimJogo };
	/**
	 * Guarda o estado atual do jogo.
	 */
	public estado estadoAtual;
	
	/**
	 * Construtor da classe.
	 */
	public Poker() {
		
		this.gui = new GUI(this);
					
		iniciaJogo();
		
	}
	
	/**
	 * Inicia um novo jogo.
	 */
	public void iniciaJogo() {
	
		this.rodadaAtual = 0;
		
		this.baralho = new Baralho();
		this.mesa = new Mesa(creditosIniciais);
		
		estadoAtual = estado.iniciaRodada;
		
		// Informa a quantidade de creditos iniciais.
		gui.atualizaConsole("Voce recebeu " + mesa.getCredits() + "$ creditos iniciais!");
		
		// Inicia uma rodada.
		proximaRodada();
		
	}
	
	/**
	 * Realiza a aposta e vai para o proximo estado do jogo.
	 * @param valor Valor a ser apostado.
	 */
	public void realizaAposta(int valor) {
	
		mesa.apostar(valor);
		
		gui.atualizaCreditos();
		gui.atualizaConsole("Você apostou: " + valor + "$ créditos!");
		
	}
	
	/**
	 * Confirma a mao atual.
	 */
	public void confirmarMao() {
		
		maoConfirmada = true;
		
	}
	
	/**
	 * Guarda uma mao para devolucao ao fim da rodada.
	 * @param d Numero da mao a ser guardada.
	 */
	public void guardarMao(int d) {
		
		if(d == 1) {
			
			devolucao1 = new Carta[5];
			
			for(int i = 0; i < 5; i++)
				devolucao1[i] = mao[i];
			
			
		} else {
			
			devolucao2 = new Carta[5];
			
			for(int i = 0; i < 5; i++)
				devolucao2[i] = mao[i];
			
		}
		
	}
	
	/**
	 * Avanca o estado do jogo executando o que eh necessario.
	 */
	public void proximoEstado() {
		
		if(estadoAtual == estado.iniciaRodada) {
			
			estadoAtual = estado.realizaAposta; // Atualiza o estado.
			gui.setTela("aposta"); // Atualiza a tela do jogo.
			
		} else if(estadoAtual == estado.realizaAposta) {
			
			mao = baralho.retirarMao(); // Retira uma mao do baralho.
			maoConfirmada = false; // Marca que a mao nao foi confirmada.
			
			estadoAtual = estado.troca1; // Atualiza o estado.
			gui.setTela("trocas"); // Atualiza a tela do jogo.
			
		} else if(estadoAtual == estado.troca1) {
			
			if(maoConfirmada) { // Se a mao foi confirmada avanca para o fim da rodada.
				
				estadoAtual = estado.finalizaRodada; // Atualiza o estado.
				gui.setTela("finalizaRodada"); // Atualiza a tela do jogo.
				
				// Realiza a jogada e printa o resultado.
				String msg = mesa.play(mao);
				gui.atualizaConsole(msg);
				
				// Atualzia os creditos do jogador.
				gui.atualizaCreditos();
				
				// Devolve a mao atual.
				baralho.devolverMao(mao);
				
			} else { // Se a mao nao foi confirmada vai para a proxima fase de trocas.
				
				estadoAtual = estado.troca2;
				gui.setTela("trocas");
				
			}
		} else if(estadoAtual == estado.troca2) { // Como nao a mais trocas continua para o fim da rodada.
			
			estadoAtual = estado.finalizaRodada; // Atualiza o estado.
			gui.setTela("finalizaRodada"); // Atualiza a tela do jogo.
			
			// Realiza a jogada e printa o resultado.
			String msg = mesa.play(mao);
			gui.atualizaConsole(msg);
			
			// Atualzia os creditos do jogador.
			gui.atualizaCreditos();
			
			// Devolve a mao atual.
			baralho.devolverMao(mao);
			
		}
	}
	
	/**
	 * Avanca para a proxima rodada.
	 */
	public void proximaRodada() {
		
		// Devolve as cartas trocadas para o baralho.
		baralho.devolverMao(devolucao1);
		baralho.devolverMao(devolucao2);
					
		int numCredits = mesa.getCredits();
		if(numCredits <= 0 || rodadaAtual == 10) { // Verifica se o jogo acabou.
			
			estadoAtual = estado.fimJogo;
			
			gui.setTela("finalizaJogo");
			
			if(numCredits > 0 || rodadaAtual == 10) 
				gui.atualizaConsole("O jogo acabou! Você finalizou com " + numCredits + "$ créditos!");
			else
				gui.atualizaConsole("O jogo acabou! Você não têm mais créditos!");
			
		} else {
			
			// Se o jogo nao acabou inicia uma nova rodada normalmente.
			estadoAtual = estado.iniciaRodada;
			
			// Atualiza a interface.
			rodadaAtual++;
			gui.atualizaRodada();
			gui.atualizaCreditos();
			
			gui.setTela("inicioRodada");
		
		}
	}
	
	public static void main(String[] args) {
	
		// Cria um novo jogo.
		Poker game = new Poker();
		
	}

}
