/**
 * Class que simula um jogo de Bozo.
 * @author Luis Eduardo Rozante
 *
 */
public class Bozo {
	
	/**
	 * Executa um jogo de Bozo.
	 * @param args Nao utilizado.
	 * @throws java.io.IOException Caso alguma entrada do teclado seja invalida.
	 */
	public static void main(String[] args) throws java.io.IOException {
		
		// Cria o copo com os dados.
		RolaDados copo = new RolaDados(5);
		// Cria o placar.
		Placar placar = new Placar();
		// Usado para guardar o resultado da ultima rolada.
		int[] dados;
		
		// Executa as rodas.
		int rodada_atual = 1;
		while(rodada_atual <= 10) {
			
			System.out.println("Pressione ENTER para iniciar a rodada...");
			EntradaTeclado.leString();
			
			System.out.println("==========\nRodada " + rodada_atual + "\n==========\n");

			// Faz a primeira rolagem.
			dados = copo.rolar();
			System.out.println(copo.toString());
			
			// Permite que o jogador re-role os dados até duas vezes.
			String rolar_denovo = "";
			int rerolar = 0;
			while(rerolar < 2) {
				
				// Recebe os dados que deve ser rolados novamente.
				System.out.print("Entre os dados que quer rolar de novo ou apenas pressione ENTER para manter todos: ");
				rolar_denovo = EntradaTeclado.leString();
				
				// Detecta que nenhum dados foi escolhido e passa para o posicionamento no placar.
				if(rolar_denovo == null || rolar_denovo.isEmpty()) {
					System.out.println("Voce escolheu manter todos os dados!\n");
					break;
				}
				
				// Rola os dados denovo.
				dados = copo.rolar(rolar_denovo);
				System.out.println('\n' + copo.toString());
				rerolar++;
			
			}
			
			System.out.println(placar.toString());
			
			// Posiciona a jogada no placar.
			boolean success = false;	
			System.out.print("Entre a posicao que quer colocar o resultado: ");
			while (!success) {
			
				int pos = EntradaTeclado.leInt();
				
				try { 
					placar.add(pos, dados); 
					success = true;
				} catch (IllegalArgumentException e) {
					
					success = false;
					System.out.print(e.getMessage() + " Tente denovo: ");
					
				}
				
			}
			
			// Printa o placar atualizado.
			System.out.println('\n' + placar.toString());
			
			rodada_atual++;
		}
	
		System.out.println("O jogo acabou! Pontuacao final: " + placar.getScore());
		
	}

}
