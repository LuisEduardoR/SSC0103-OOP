package dicionario;

/**
 * Implementacao de um dicionario usando generics.
 * @author Luis Eduardo Rozante de Freitas Pereira
 *
 * @param <K> Tipo da chave.
 * @param <V> Tipo do valor.
 */
public class Dicionario <K, V> {

	/**
	 * Tamanho maximo do dicionario.
	 */
	private int size;
	/**
	 * Getter.
	 * @return O tamanho maximo do dicionario.
	 */
	public int getSize() { return size; }
	
	private int len;
	/**
	 * Getter.
	 * @return O tamanho atual do dicionario.
	 */
	public int getLength() { return len; }
	
	/**
	 * Array com as chaves.
	 */
	K key[];
	/**
	 * Array com os valores.
	 */
	V value[];
	
	/**
	 * Cria um dicionario com um tamamho maximo.
	 * @param size O tamanho maximo do dicionario.
	 */
	@SuppressWarnings("unchecked")
	public Dicionario(int size) {
		
		this.size = size;
		this.len = 0;
		
		key = (K[]) new Object[size];
		value = (V[]) new Object[size];
		
	}
	
	/**
	 * Adiciona insere um par chave/valor no dicionario. 
	 * @param key A chave
	 * @param value O valor
	 * @return True se a insercao foi bem sucedida, False se o dicionario esta cheio ou a cahve ja existe. 
	 */
	public boolean add(K key, V value) {
		
		if(this.len + 1 == this.size)
			return false;
		
		if(contains(key))
			return false;
		
		this.key[len] = key;
		this.value[len] = value;
		this.len++;
		
		return true;
		
	}
	
	/**
	 * Busca a chave e retorna o valor associado ou null se a chave nao existir.
	 * @param key A chave a ser buscada.
	 * @return
	 */
	public V get(K key) {

		for(int i = 0; i < this.len; i++) {
			
			if(key.equals(this.key[i]))
				return this.value[i];
			
		}
		
		return null;
		
	}
	
	/**
	 * Verifica se uma chave existe no dicionario.
	 * @param key A chave a ser buscada.
	 * @return True se a chave existe, False se a chave nao existe.
	 */
	public boolean contains(K key) {
		
		for(int i = 0; i < this.len; i++) {
			
			if(key.equals(this.key[i]))
				return true;
			
		}
		
		return false;
		
	}
	
	/**
	 * Verifica se um valor existe no dicionario.
	 * @param key O valor a ser buscado.
	 * @return True se o valor existe, False se o valor nao existe.
	 */
	public boolean containsValue(V value) {
		
		for(int i = 0; i < this.len; i++) {
			
			if(value.equals(this.value[i]))
				return true;
			
		}
		
		return false;
		
	}
	
	
}
