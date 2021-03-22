package listaLigada;

/**
 * Classe que implementa uma ListaLigada.
 * @author Luis Eduardo ROzante de Freitas Pereira - 10734794
 *
 * @param <T> Tipo dos elementos da lista.
 */
public class ListaLigada<T> {

	/**
	 * Inicio da lista.
	 */
	private NoLista<T> ini;
	
	/**
	 * Tamanho da lsita.
	 */
	private int tam;
	
	/**
	 * Inicializa uma lsita ligada vazia.
	 */
	public ListaLigada() {
		
		this.ini = null;
		this.tam = 0;
		
	}
	
	/**
	 * Insere um elemento no final da lista.
	 * @param elemento Elemento a ser inserido.
	 */
	@SuppressWarnings("unchecked")
	public void pushBack(T elemento) {
		
		// Cria o novo no.
		NoLista<T> novoNo = new NoLista<T>();
		novoNo.setConteudo(elemento);
		
		// Caso a lista esteja vazia:
		if(ini == null) {
			
			// Insere o no no comeco e atualiza o inicio. 
			ini = novoNo;
			
		} else {
		
			// Encontra o ultimo elemento da lista.
			NoLista<T> cur = ini;
			
			while(cur.getProx() != null)
				cur = cur.getProx();
			
			// Insere o novo no.
			cur.setProx(novoNo);
			novoNo.setAnt(cur);
			
		}		
		
		tam++;
		
	}
	
	/**
	 * Insere um elemento no inicio da lista.
	 * @param elemento Elemento a ser inserido.
	 */
	public void pushFront(T elemento) {
	
		// Cria o novo no.
		NoLista<T> novoNo = new NoLista<T>();
		novoNo.setConteudo(elemento);
		
		// Caso a lista esteja vazia:
		if(ini == null) {
			
			// Insere o no no comeco e atualiza o inicio. 
			ini = novoNo;
			
		} else {
		
			// Guarda o rpimeiro elemento da lista.
			NoLista<T> cur = ini;
			
			// Coloca o novo no no comeco.
			ini = novoNo;
			
			// Aualiza o encadeamento.
			novoNo.setProx(cur);
			cur.setAnt(novoNo);
			
		}		
		
		tam++;
		
	}
	
	@SuppressWarnings("unchecked")
	/**
	 * Remove e retorna o ultimo elemento da lsita.
	 * @return O ultimo elemento.
	 */
	public T popBack() {
		
		// Encontra o ultimo no.
		NoLista<T> noAlvo = null;
		
		// Caso a lista esteja vazia:
		if(ini == null)
			return null;
		
		// Encontra o ultimo elemento da lista.
		noAlvo = ini;
		
		while(noAlvo.getProx() != null)
			noAlvo = noAlvo.getProx();
		
		// Remove o no e atualiza o encadeamento.
		if(noAlvo.getAnt() != null)
			noAlvo.getAnt().setProx(null);
		else // Caso so exista um no na lista remove-o e seta o inicio para null
			ini = null;		
	
		// Atualiza o tamanho da lista.
		tam--;
		
		// Retorna o conteudo.
		return (T) noAlvo.getConteudo();		
				
	}
	
	@SuppressWarnings("unchecked")
	/**
	 * Remove e retorna o primeiro elemento da lsita.
	 * @return O primeiro elemento.
	 */
	public T popFront() {
		
		// Pega o primeiro no.
		NoLista<T> noAlvo = ini;
		
		// Caso a lista esteja vazia:
		if(ini == null)
			return null;
		
		// Remove o no e atualiza o encadeamento.
		if(noAlvo.getProx() != null) {
			
			// Atualiza o encadeamento.
			ini = noAlvo.getProx();
			ini.setAnt(null);
			
		} else // Caso so exista um no na lista remove-o e seta o inicio para null
			ini = null;			
	
		// Atualiza o tamanho da lista.
		tam--;
		
		// Retorna o conteudo.
		return (T) noAlvo.getConteudo();
		
	}	
}
