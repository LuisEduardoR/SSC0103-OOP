package listaLigada;

/**
 * Classe auxiliar que representa um no da ListaLigada.
 * @author Luis Eduardo ROzante de Freitas Pereira - 10734794
 *
 * @param <T> Tipo do primeiro elemento do par.
 */
public class NoLista<T> {

	/**
	 * Conteudo do no.
	 */
	private T conteudo;
	/**
	 * Getter do no.
	 * @return O conteudo do no.
	 */
	public T getConteudo() {
		return conteudo;
	}
	/**
	 * Setter do no.
	 * @param conteudo COunteudo a ser colocado no no.
	 */
	public void setConteudo(T conteudo) {
		this.conteudo = conteudo;
	}
	
	/**
	 * Guarda o proximo no da lista.
	 */
	private NoLista prox;
	/**
	 * Retorna o proximo no da lista.
	 * @return O proximo no da lista.
	 */
	public NoLista getProx() {
		return prox;
	}
	/**
	 * Seta o proximo no da lista.
	 * @param ant O valor a ser setado.
	 */
	public void setProx(NoLista prox) {
		this.prox = prox;
	}
	
	/**
	 * Guarda o no anterior na lista.
	 */
	private NoLista ant;
	/**
	 * Retorna no anterior na lista.
	 * @return O no anterior na lista.
	 */
	public NoLista getAnt() {
		return ant;
	}
	/**
	 * Seta o no anterior na lista.
	 * @param ant O valor a ser setado.
	 */
	public void setAnt(NoLista ant) {
		this.ant = ant;
	}
	
	/**
	 * Constructor da classe.
	 */
	public NoLista() {
		
		this.conteudo = null;
		this.prox = null;
		this.ant = null;
		
	}
	
}
