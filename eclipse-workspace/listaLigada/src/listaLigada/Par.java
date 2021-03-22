package listaLigada;

/**
 * Classe que implementa um par similar a std::pair da linguagem c++.
 * @author Luis Eduardo ROzante de Freitas Pereira - 10734794
 *
 * @param <T> Tipo do primeiro elemento do par.
 * @param <U> Tipo do segundo elemento do par.
 */
public class Par <T, U> {

	/**
	 * Primeiro elemento.
	 */
	private T primeiro;
	/**
	 * Getter de 'primeiro'.
	 * @return O valor do primeiro elemento.
	 */
	public T getPrimeiro() {
		return primeiro;
	}
	/**
	 * Setter de 'primeiro'.
	 * @param value O valor para setar o primeiro elemento.
	 */
	public void setPrimeiro(T value) {
		this.primeiro = value;
	}
	
	/**
	 * Segundo elemento.
	 */
	private U segundo;
	/**
	 * Getter de 'segundo'.
	 * @return O valor do segundo elemento.
	 */
	public U getSegundo() {
		return segundo;
	}
	/**
	 * Setter de 'segundo'.
	 * @param value O valor para setar o segundo elemento.
	 */
	public void setSegundo(U value) {
		this.segundo = value;
	}
	
	/**
	 * Constructor da classe.
	 * @param p Valor para o primeiro elemento.
	 * @param s Valor para o segundo elemento.
	 */
	public Par (T p, U s ) {
		
		this.primeiro = p;
		this.segundo = s;
		
	}
	
}
