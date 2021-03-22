/**
 * Classe que representa um dado de n faces que pode ser rolado.
 * @author Luis Eduardo ROzante
 *
 */
public class Dado {

	// Guarda o numero de lados do dado.
	private int lados;
	// Guarda o ultimo lado rolado.
	private int lado_rolado;
	
	/**
	 * Construtor da classe, cria um dado de 6 lados e seta o valor rolado incicialmente para 1.
	 */
	public Dado() {
		
		lados = 6;
		lado_rolado = 1;
		
	}
	
	/**
	 * Construtor da classe, cria um dado de n lados e seta o valor rolado incicialmente para 1.
	 * @param n O numero de dados.
	 */
	public Dado(int n) {
		
		lados = n;
		lado_rolado = 1;
		
	}
	
	/**
	 * Usada para testar a classe.
	 * @param args Nao utilizado.
	 */
	public static void main(String[] args) {
		
		Dado d5 = new Dado(5);
		d5.rolar();
		
		Dado d20 = new Dado(20);
		d20.rolar();
		
		System.out.println("Rolling d5:");
		System.out.println(d5.toString());
		
		System.out.println("Rolling d20:");
		System.out.println(d20.toString());
		
		System.out.println("Showing d20 again:");
		System.out.println(d20.toString());
		
	}
	
	/**
	 * Rola o dado.
	 * @return O valor rolado.
	 */
	public int rolar() {
		
		lado_rolado = 1 + Random.getInstance().getRandInt(lados);
		return lado_rolado;
		
	}
	
	/**
	 * Retorna o ultimo valor rolado.
	 * @return O ultimo valor rolado.
	 */
	public int getLado() {
		
		return lado_rolado;
		
	}
	
	@Override
	/**
	 * Cria uma representacao "ASCII-art" da face rolada do dado em formato de String.
	 */
  	public String toString() {
  		
		if(lados > 6) {
			
			if(lado_rolado < 10)
				return "+---+\n|   |\n| " + lado_rolado + " |\n|   |\n+---+\n";
	  		else if(lado_rolado < 100)
				return "+---+\n|   |\n| " + lado_rolado + "|\n|   |\n+---+\n";
	  		else
				return "+---+\n|   |\n|" + lado_rolado + "|\n|   |\n+---+\n";
			
		} else {
		
	  		if(lado_rolado == 1) 			
	  			return "+---+\n|   |\n| x |\n|   |\n+---+\n";
	  		else if(lado_rolado == 2) 			
	  			return "+---+\n|x  |\n|   |\n|  x|\n+---+\n";
	  		else if(lado_rolado == 3) 			
	  			return "+---+\n|x  |\n| x |\n|  x|\n+---+\n";
	  		else if(lado_rolado == 4) 			
	  			return "+---+\n|x x|\n|   |\n|x x|\n+---+\n";
	  		else if(lado_rolado == 5) 			
	  			return "+---+\n|x x|\n| x |\n|x x|\n+---+\n";
	  		else	
	  			return "+---+\n|xxx|\n|   |\n|xxx|\n+---+\n";
  		
		}
  		
  	}
	
}
