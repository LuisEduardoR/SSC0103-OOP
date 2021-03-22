/**
 * Classe que simula um jogo de Bozo.
 * @author Luis Eduardo Rozante - 10734794
 *
 */
public class Poker {
	
	private static int creditosIniciais = 200;
	private static int numRodadas = 10;
	
	/**
	 * Executa um jogo de Poker virtual.
	 * @param args Nao utilizado.
	 * @throws java.io.IOException Caso alguma entrada do teclado seja invalida.
	 */
	public static void main(String[] args) throws java.io.IOException {
		
		// Cria o baralho.
		Baralho baralho = new Baralho();
		// Cria o placar que guarda as apostas.
		Placar placar = new Placar(creditosIniciais);
		// A mao com as cartas.
		Carta[] mao;
		
		// Usado para guardar se operacoes obtiveram sucesso.
		boolean success;
		
		System.out.println("Voce recebeu " + placar.getCredits() + " creditos iniciais!");
		
		// Executa as rodas.
		int rodadaAtual = 1;
		while(rodadaAtual <= numRodadas && placar.getCredits() > 0) {
			
			System.out.println("Pressione ENTER para iniciar a rodada...");
			EntradaTeclado.leString();
			
			System.out.println("==========\nRodada " + rodadaAtual + "\n==========\n");
			
			success = false;	
			System.out.print("Entre sua aposta: ");
			while (!success) {
				
				try { 
					int aposta = EntradaTeclado.leInt();
					placar.apostar(aposta);
					success = true;
				} catch (IllegalArgumentException e) {
					
					success = false;
					System.out.print(e.getMessage() + " Tente denovo: ");
					
				}
			}
			
			mao = baralho.retirarMao();			
			System.out.println("\nSua mão:\n\n" + baralho.geraString(mao));
			
			
			// Permite que o jogador re-role os dados até duas vezes.
			String trocar = "";
			int rerolar = 0;
			Carta[] primeiraMaoDescartada = null;
			Carta[] segundaMaoDescartada = null;
			while(rerolar < 2) {
				
				// Recebe os dados que deve ser rolados novamente.
				System.out.print("Entre as cartas que deseja trocar apenas pressione ENTER para manter todas: ");
				success = false;
				while(!success) {			
					try {
						trocar = EntradaTeclado.leString();
						success = true;
					} catch (Exception e) {
						success = false;
						System.out.print(e.getMessage() + " Tente denovo: ");
					}
				}
				
				// Detecta que nenhuma carta foi escolhida e continua o jogo.
				if(trocar == null || trocar.isEmpty()) {
					System.out.println("Voce escolheu manter todas as cartas!\n");
					break;
				}
				
				// Guarda a mão descartada.
				if(rerolar == 0) {
					primeiraMaoDescartada = new Carta[5];
					for(int i = 0; i < 5; i++)
						primeiraMaoDescartada[i] = mao[i];
					
				} else {
					segundaMaoDescartada = new Carta[5];
					for(int i = 0; i < 5; i++)
						segundaMaoDescartada[i] = mao[i];
				}
				
				// Troca as cartas.
				mao = baralho.retirarMao(mao, trocar);
				System.out.println('\n' + baralho.geraString(mao));
				rerolar++;
			
			}
			
			// Faz a jogada.
			System.out.println("Realizando jogada...");
			
			String res = placar.play(mao);
			// Printa o resultado.
			System.out.println(res + '\n');
			
			System.out.println("Rodada finalizada! Agora voce tem " + placar.getCredits() + " credito(s)!");
			
			// Devolve as cartas retiradas.
			baralho.devolverMao(mao);
			if(primeiraMaoDescartada != null)
				baralho.devolverMao(primeiraMaoDescartada);
			if(segundaMaoDescartada != null)
				baralho.devolverMao(segundaMaoDescartada);

			rodadaAtual++;
		}
	
		// Da o resultado final do jogo.
		if(placar.getCredits() > 0)
			System.out.println("\nO jogo acabou! Creditos finais: " + placar.getCredits());
		else
			System.out.println("\nO jogo acabou! Voce nao tem mais creditos!");
		
	}

}
