/**
 * Classe que representa o placar de um jogo de bozo.
 * @author Luis Eduardo Rozante
 *
 */
public class Placar {

	// Posicoes do placar.
	int[] positions;
	
	/**
	 * Construtor da classe, cria 10 posicoes e seta elas para vazias (-1).
	 */
	public Placar() {
		
		positions = new int[10];		
		for(int i = 0; i < 10; i++) {
			
			positions[i] = -1;
			
		}
	}
	
	
	/**
	 * Usada para testar a classe.
	 * @param args Nao utilizado.
	 */
	public static void main(String[] args) {
		
		// Cria um placar.
		Placar p = new Placar();
		System.out.println(p.toString());
		
		// Rola os dados.
		RolaDados rd = new RolaDados(5);
		int[] d = rd.rolar();
		System.out.println(rd.toString());
		
		// Tenta escolher a poiscao 6.
		p.add(6, d);
		System.out.println(p.toString());
		
	}

	/**
	 * Tenta adicionar uma jogada na posicao especificada.
	 * @param posicao A posicao em que se tentara adicionar.
	 * @param dados A jogada considerada.
	 * @throws IllegalArgumentException Caso a posicao passada seja invalida ou ja esteja ocupada.
	 */
 	public void add(int posicao, int[] dados) throws IllegalArgumentException {
 		
 		if(posicao <= 0 || posicao > 10)
 			throw new IllegalArgumentException("Posicao invalida!");
 		else if(positions[posicao-1] != -1)
			throw new IllegalArgumentException("Posicao ocupada!");
 		
 		
 		if(posicao == 1) {
 			
 			// Conta quantos 1s foram rolados e coloca a pontuacao na posicao.
 			int points = 0;
			for(int i = 0; i < dados.length; i++)
 				if(dados[i] == 1)
 					points++;
 			
 			positions[1-1] = points * 1;
 			
 		} else if(posicao == 2) {
 			
 		// Conta quantos 2s foram rolados e coloca a pontuacao na posicao.
 			int points = 0;
			for(int i = 0; i < dados.length; i++)
 				if(dados[i] == 2)
 					points++;
 			
 			positions[2-1] = points * 2;
 			
		} else if(posicao == 3) {
			
			// Conta quantos 3s foram rolados e coloca a pontuacao na posicao.
			int points = 0;
			for(int i = 0; i < dados.length; i++)
 				if(dados[i] == 3)
 					points++;
 			
 			positions[3-1] = points * 3;
			
		} else if(posicao == 4) {
		
			// Conta quantos 4s foram rolados e coloca a pontuacao na posicao.
			int points = 0;
			for(int i = 0; i < dados.length; i++)
 				if(dados[i] == 4)
 					points++;
 			
 			positions[4-1] = points * 4;
			
		} else if(posicao == 5) {
		
			// Conta quantos 5s foram rolados e coloca a pontuacao na posicao.
			int points = 0;
			for(int i = 0; i < dados.length; i++)
 				if(dados[i] == 5)
 					points++;
 			
 			positions[5-1] = points * 5;
			
		} else if(posicao == 6) {
		
			// Conta quantos 6s foram rolados e coloca a pontuacao na posicao.
			int points = 0;
			for(int i = 0; i < dados.length; i++)
 				if(dados[i] == 6)
 					points++;
 			
 			positions[6-1] = points * 6;
			
		} else if(posicao == 7) {
			
			// Detecta se houve uma full-hand e coloca os pontos na posicao.
			int[] count = new int[6];
			for(int i = 0; i < 6; i++)
				count[i] = 0;
			
			for(int i = 0; i < dados.length; i++) {
				
				count[dados[i] - 1]++;
				
			}
			
			boolean d = false; // Usado para detectar se ha 2 dados de um mesmo tipo.
			
			boolean t = false; // Usado para detectar se ha 3 dados de um mesmo tipo.
			for(int i = 0; i < 6; i++) {
				
				if(count[i] == 2)
					d = true;
				
				if(count[i] == 3)
					t = true;
				
			}
			
			if(d && t)
				positions[7-1] = 15;
			else
				positions[7-1] = 0;
		
		} else if(posicao == 8) {
		
			// Detecta se houve uma sequencia e coloca os pontos na posicao.
			int[] count = new int[6];
			for(int i = 0; i < 6; i++)
				count[i] = 0;
			
			for(int i = 0; i < dados.length; i++)
				count[dados[i] - 1]++;
			
			if(count[1] >= 1 && count[2] >= 1 && count[3] >= 1 && count[4] >= 1) {
				if(count[0] >= 1) {
					
					positions[8-1] = 20;
					return;
				}
				
				if(count[5] >= 1) {
					
					positions[8-1] = 20;
					return;
				}
			}
			
			positions[8-1] = 0;
		
		} else if(posicao == 9) {
			
			// Detecta se houve uma quadra e coloca os pontos na posicao.
			int[] count = new int[6];
			for(int i = 0; i < 6; i++)
				count[i] = 0;
			
			for(int i = 0; i < dados.length; i++) {
				
				count[dados[i] - 1]++;
				
			}
			
			for(int i = 0; i < 6; i++)
				if(count[i] >= 4) {
					
					positions[9-1] = 30;
					return;
				}
			
			positions[9-1] = 0;
			
		} else if(posicao == 10) {
		
			// Detecta se houve uma quina e coloca os pontos na posicao.
			int[] count = new int[6];
			for(int i = 0; i < 6; i++)
				count[i] = 0;
			
			for(int i = 0; i < dados.length; i++) {
				
				count[dados[i] - 1]++;
				
			}
			
			for(int i = 0; i < 6; i++)
				if(count[i] >= 5) {
					
					positions[10-1] = 40;
					return;
				}
			
			positions[10-1] = 0;
		
		}
 		
 	}
 	
 	/**
 	 * Retorna a pontuacao.
 	 * @return A pontuacao.
 	 */
 	public int	getScore() {
 		
 		int sum = 0;
 		for(int i = 0; i < 10; i++) {
 			
 			if(positions[i] != -1)
 				sum += positions[i];
 			
 		}
 		
 		return sum;
 		
 	}
 	
 	@Override
 	/**
	 * Cria uma representacao "ASCII-art" do placar do jogo de bozo em formato de String.
	 */
 	public String toString() {
 		
 		String s = "";
 		
 		// Line 1.
 		if(positions[1-1] == -1) s += " (1) ";
 		else s += "  " + positions[1-1] + "  ";
 		s += '|';
 		
 		if(positions[7-1] == -1) s += " (7) ";
 		else if(positions[7-1] == 0) s += "  0  ";
 		else s += "  15 ";
 		s += '|';
 		
 		if(positions[4-1] == -1) s += " (4) ";
 		else s += "  " + positions[4-1] + "  ";
 		s += '\n';
 	
 		s += "-----+-----+-----\n";
 		
 		// Line 2.
 		if(positions[2-1] == -1) s += " (2) ";
 		else s += "  " + positions[2-1] + "  ";
 		s += '|';
 		
 		if(positions[8-1] == -1) s += " (8) ";
 		else if(positions[8-1] == 0) s += "  0  ";
 		else s += "  20 ";
 		s += '|';
 		
 		if(positions[5-1] == -1) s += " (5) ";
 		else s += "  " + positions[5-1] + "  ";
 		s += '\n';
 		
 		s += "-----+-----+-----\n";
 		
 		// Line 3.
 		if(positions[3-1] == -1) s += " (3) ";
 		else s += "  " + positions[3-1] + "  ";
 		s += '|';
 		
 		if(positions[9-1] == -1) s += " (9) ";
 		else if(positions[9-1] == 0) s += "  0  ";
 		else s += "  30 ";
 		s += '|';
 		
 		if(positions[6-1] == -1) s += " (6) ";
 		else s += "  " + positions[6-1] + "  ";
 		s += '\n';
 		
 		s += "-----+-----+-----\n";
 		
 		// Line 4.
 		s += "     |";
 		if(positions[10-1] == -1) s += " (10)";
 		else if(positions[10-1] == 0) s += "  0  ";
 		else s += "  40 ";
 		s += "|     \n";
 	
 		
 		s += "     +-----+\n";
 		
 		return s;
 		
 	}
 	
}
