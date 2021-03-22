/**
 * Classe que representa um dado de n faces que pode ser rolado.
 * @author Luis Eduardo Rozante - 10734794
 *
 */
public class Carta {

	// Guarda o numero de lados do dado.
	private int id;
	
	/**
	 * Construtor da classe, cria um dado de n lados e seta o valor rolado incicialmente para 1.
	 * @param n O numero de dados.
	 */
	public Carta(int id) {
		
		this.id = id;
		
	}
	
	/**
	 * Retorna o id da carta.
	 * @return O id da carta.
	 */
	public int getId() {
		
		return id;
		
	}
		
		
	/**
	 * Retorna o naupe da carta.
	 * @return O naipe da carta.
	 */
	public int getNaipe() {
		
		return (id % 4) + 1;
		
	}
	
	/**
	 * Retorna o numero da carta.
	 * @return O numero da carta.
	 */
	public int getNum() {
		
		return (id / 4) + 1;
		
	}
	
	@Override
	/**
	 * Cria uma representacao "ASCII-art" da carta.
	 * * @return Representacao da carta.
	 */
  	public String toString() {
  		
		if(getNum() == 1) {
			if(getNaipe() == 1)
				return "+-----+\n|♠   E|\n|  A  |\n|E   ♠|\n+-----+\n";
			else if(getNaipe() == 2)
				return "+-----+\n|♣   P|\n|  A  |\n|P   ♣|\n+-----+\n";
			else if(getNaipe() == 3)
				return "+-----+\n|♥   C|\n|  A  |\n|C   ♥|\n+-----+\n";
			else
				return "+-----+\n|♦   O|\n|  A  |\n|O   ♦|\n+-----+\n";
		} else if(getNum() > 1 && getNum() < 10 ) {			
			if(getNaipe() == 1)
				return "+-----+\n|♠   E|\n|  " + getNum() + "  |\n|E   ♠|\n+-----+\n";
			else if(getNaipe() == 2)
				return "+-----+\n|♣   P|\n|  " + getNum() + "  |\n|P   ♣|\n+-----+\n";
			else if(getNaipe() == 3)
				return "+-----+\n|♥   C|\n|  " + getNum() + "  |\n|C   ♥|\n+-----+\n";
			else
				return "+-----+\n|♦   O|\n|  " + getNum() + "  |\n|O   ♦|\n+-----+\n";
		} else if(getNum() == 10) {
			if(getNaipe() == 1)
				return "+-----+\n|♠   E|\n|  10 |\n|E   ♠|\n+-----+\n";
			else if(getNaipe() == 2)
				return "+-----+\n|♣   P|\n|  10 |\n|P   ♣|\n+-----+\n";
			else if(getNaipe() == 3)
				return "+-----+\n|♥   C|\n|  10 |\n|C   ♥|\n+-----+\n";
			else
				return "+-----+\n|♦   O|\n|  10 |\n|O   ♦|\n+-----+\n";
  		} else if(getNum() == 11) {			
  			if(getNaipe() == 1)
				return "+-----+\n|♠   E|\n|  J  |\n|E   ♠|\n+-----+\n";
			else if(getNaipe() == 2)
				return "+-----+\n|♣   P|\n|  J  |\n|P   ♣|\n+-----+\n";
			else if(getNaipe() == 3)
				return "+-----+\n|♥   C|\n|  J  |\n|C   ♥|\n+-----+\n";
			else
				return "+-----+\n|♦   O|\n|  J  |\n|O   ♦|\n+-----+\n";
  		} else if(getNum() == 12) {			
  			if(getNaipe() == 1)
				return "+-----+\n|♠   E|\n|  Q  |\n|E   ♠|\n+-----+\n";
			else if(getNaipe() == 2)
				return "+-----+\n|♣   P|\n|  Q  |\n|P   ♣|\n+-----+\n";
			else if(getNaipe() == 3)
				return "+-----+\n|♥   C|\n|  Q  |\n|C   ♥|\n+-----+\n";
			else
				return "+-----+\n|♦   O|\n|  Q  |\n|O   ♦|\n+-----+\n";
  		} else {			
  			if(getNaipe() == 1)
				return "+-----+\n|♠   E|\n|  K  |\n|E   ♠|\n+-----+\n";
			else if(getNaipe() == 2)
				return "+-----+\n|♣   P|\n|  K  |\n|P   ♣|\n+-----+\n";
			else if(getNaipe() == 3)
				return "+-----+\n|♥   C|\n|  K  |\n|C   ♥|\n+-----+\n";
			else
				return "+-----+\n|♦   O|\n|  K  |\n|O   ♦|\n+-----+\n";
  		}
  	}
}
