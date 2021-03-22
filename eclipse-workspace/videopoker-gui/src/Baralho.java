/**
 * Classe que representa um baralho.
 * @author Luís Eduardo Rozante - 10734794
 *
 */
public class Baralho {	
	
	// Array com os dados.
	public Carta[] cartas;
	// Guarda as cartas que estao no baralho.
	private boolean[] presenca;
	
	/**
	 * Construtor da classe.
	 * @param n O numero de dados a ser usado.
	 */
	public Baralho() {
		
		cartas = new Carta[52];
		presenca = new boolean[52];
		for(int i = 0; i < 52; i++) {
			cartas[i] = new Carta(i);
			presenca[i] = true;
		}
		
	}
	
	/**
	 * Usada para testar a classe.
	 * @param args Nao utilizado.
	 */
	public static void main(String[] args) {
		
		Baralho b = new Baralho();

		Carta[] m = b.retirarMao();
		System.out.println(b.geraString(m));
		System.out.println(b.getTamanho());
		
		b.devolverMao(m);
		System.out.println(b.getTamanho());

		
	}

	/**
	 * Retira novamente as cartas marcadas.
	 * @param atual A mao atual para ser devolvida.
	 * @param quais As cartas a serem retiradas.
	 * @return A nova mao.
	 */
	Carta[] retirarMao(Carta[] atual, boolean[] quais) {
		
		for(int i = 0; i < 5; i++)	
			if(quais[i]) atual[i] = retiraCarta();			
		
		return atual;
		
	}

	/**
	 * Retira novamente as cartas nas posicoes passadas na string.
	 * @param atual A mao atual para ser devolvida.
	 * @param s A string com as cartas.
	 * @return A mao nova.
	 */
	Carta[] retirarMao(Carta[] atual, String s) {
		
		
		// Se não ha nada na string nao alterasse as cartas.
		if(s == null || s.isEmpty())
			return atual;
		
		// Extrai os numeros da string passada.
		int[] target = new int[5];
		String[] parts = s.split(" ");
		for(int i = 0; i < parts.length; i++)
			target[i] = Integer.parseInt(parts[i]) - 1;
			
		// Cria uma array booleana a partir dos numeros.
		boolean[] quais = new boolean[5];
		for(int i = 0; i < 5; i++)
			quais[i] = false;
		for(int i = 0; i < 5 && i < parts.length; i++) {
			if(target[i] < 5) {
				quais[target[i]] = true;
			}
		}
		
		return retirarMao(atual, quais);
		
	}

	/**
	 * Retira uma mao de 5 cartas.
	 * @param mao A mao retirada.
	 */
	Carta[] retirarMao() {
	
		Carta[] mao = new Carta[5];
		
		for(int i = 0; i < 5; i++)		
			mao[i] = retiraCarta();
		
		return mao;
		
	}
	
	/**
	 * Retira uma carta do baralho.
	 * @return A carta retirada.
	 */
	Carta retiraCarta() {
		
			int id = Random.getInstance().getRandInt(0, 52);

			boolean overf = false;
			while(presenca[id] == false) {
				
				id++;
				
				if(id == 52 && !overf) {
					id = 0;
					overf = true;
				} else if (id == 52 && overf) {
					return null;
				}
			
			}
			
			presenca[id] = false;
			return cartas[id];
		
	}
	
	/**
	 * Returna a mao para o baralho.
	 * @param mao A mao para retornar.
	 */
	void devolverMao(Carta[] mao) {
	
		if(mao == null) return;
		
		for(int i = 0; i < mao.length; i++)
			devolverCarta(mao[i]);
		
	}
	
	/**
	 * Devolve uma carta para o baralho.
	 * @param carta A carta para devolver.
	 */
	void devolverCarta(Carta carta) {
	
		if(carta == null) return;
		
		presenca[carta.getId()] = true;
		
	}
	
	/**
	 * Retorna o numero de cartas ainda presentes no baralho.
	 * @return O numero de cartas no baralho.
	 */
	int getTamanho() {
		
		int count = 0;
		
		for(int i = 0; i < 52; i++)
			if(presenca[i])
				count++;
		
		return count;
		
	}
	
	
	/**
	 * Cria uma representacao "ASCII-art" de uma mao de cartas.
	 * @param mao
	 * @return
	 */
  	public String geraString(Carta[] mao) {
		
		String[] line = new String[5];
		for(int i = 0; i < 5; i++)
			line[i] = "";
		
		// Gera uma linha de cada vez.
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < mao.length; j++) // Combina a primeira linha de cada carta.
				line[i] += mao[j].toString().substring(i * 8, i * 8 + 7) + " ";
		
		// Cria uma linha de cabecalho com o numero de cada carta.
		String header = "";
		for(int i = 1; i <= mao.length; i++) {
			if(mao.length < 10)
				header += i + "       ";
			else if(mao.length < 10)
				header += i + "      ";
			else
				header += i + "     ";
		}
		header += "\n";
		
		// Combina as linhas.
		String s = header;
		for(int i = 0; i < 5; i++)
			s += line[i] + "\n";
		
		return s;
		
	}
}
