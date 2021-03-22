/**
 * Classe que contem e pode rolar um determinado numero de dados.
 * @author Luís Eduardo Rozante
 *
 */
public class RolaDados {	
	
	// Array com os dados.
	private Dado[] dados;
	
	/**
	 * Construtor da classe.
	 * @param n O numero de dados a ser usado.
	 */
	public RolaDados(int n) {
		
		dados = new Dado[n];
		for(int i = 0; i < n; i++)
			dados[i] = new Dado();
		
	}
	
	/**
	 * Usada para testar a classe.
	 * @param args Nao utilizado.
	 */
	public static void main(String[] args) {
		
		RolaDados rd = new RolaDados(5);
		rd.rolar();
		
		System.out.println("First roll:");
		System.out.println(rd.toString());
		
		boolean[] b = new boolean[5];
		for(int i = 0; i < 5; i++)
			b[i] = false;
		
		b[3] = true;
		b[4] = true;
		
		rd.rolar(b);
		
		System.out.println("Re-rooling 4 and 5:");
		System.out.println(rd.toString());
		
		rd.rolar("1 2");
		
		System.out.println("Re-rooling 2 and 3:");
		System.out.println(rd.toString());
		
	}

	/**
	 * Rola todos os dados.
	 * @return Os resultados dos dados.
	 */
	public int[] rolar() {
		
		// Rola todos os dados.
		int[] res = new int[dados.length];
		for(int i = 0; i < dados.length; i++)
			res[i] = dados[i].rolar();
		
		return res;
		
	}

	/**
	 * Rola os dados marcados.
	 * @param quais Os dados marcadas como true serão roladas os outros nao.
	 * @return Os resultados dos dados, dados que não foram rolados retornarao seu valor antigo.
	 */
	int[] rolar(boolean[] quais) {
		
		// Rola os dados marcados como true.
		int[] res = new int[dados.length];
		for(int i = 0; i < dados.length; i++)
			if(quais[i])
				res[i] = dados[i].rolar();
			else
				res[i] = dados[i].getLado();
				
		return res;
		
	}

	/**
	 * Rola os dados com os numeros marcados na string.
	 * @param s
	 * @return
	 */
	int[] rolar(String s) {
	
		// Se não a nada na string nao rola nenhum dado.
		if(s == null || s.isEmpty()) {
			boolean[] quais = new boolean[dados.length];
			for(int i = 0; i < dados.length; i++)
				quais[i] = false;
				
			return rolar(quais);
		}
			
		
		// Extrai os numeros da string passada.
		int[] target = new int[dados.length];
		String[] parts = s.split(" ");
		for(int i = 0; i < parts.length; i++)
			target[i] = Integer.parseInt(parts[i]) - 1;
			
		// Cria uma array booleana a partir dos numeros.
		boolean[] quais = new boolean[dados.length];
		for(int i = 0; i < dados.length; i++)
			quais[i] = false;
		for(int i = 0; i < dados.length && i < parts.length; i++) {
			if(target[i] < dados.length)
				quais[target[i]] = true;;
		}
		
		// Chama a funcao de rolar com a array de booleans.
		return rolar(quais);
		
	}

	@Override
	/**
	 * Cria uma representacao "ASCII-art" das faces dos dados rolados em formato de String.
	 */
  	public String toString() {
		
		String[] line = new String[5];
		for(int i = 0; i < 5; i++)
			line[i] = "";
		
		// Gera uma linha de cada vez.
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < dados.length; j++) // Combina a primeira linha de cada vez.
				line[i] += dados[j].toString().substring(i * 6, i * 6 + 5) + " ";
		
		// Cria uma linha de cabecalho com o numero de cada dado.
		String header = "";
		for(int i = 1; i <= dados.length; i++) {
			if(dados.length < 10)
				header += i + "     ";
			else if(dados.length < 10)
				header += i + "    ";
			else
				header += i + "   ";
		}
		header += "\n";
		
		// Combina as linhas.
		String s = header;
		for(int i = 0; i < 5; i++)
			s += line[i] + "\n";
		
		return s;
		
	}
}
