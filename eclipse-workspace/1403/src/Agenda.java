/**
 * Classe que representa uma agenda que contem elementos da classe Pessoa.
 * @author  Luis Eduardo Rozante - nUSP 1073494
 *
 */
public class Agenda {

	private Pessoa[] pessoas;
	private int numEntradas;
	
	/**
	 * Constructor da classe. Cria uma array com 10 posições e indica que a agenda está vazia.
	 */
	public Agenda() {
		
		pessoas = new Pessoa[10];
		numEntradas = 0;
		
	}
	
	/**
	 * Adiciona uma pessoa na agenda. Se a agenda estiver cheia nao adiciona a pessoa e imprime "Agenda cheia!".
	 * @param nome O nome da pessoa.
	 * @param idade A idade da pessoa.
	 * @param altura A altura da pessoa.
	 */
	public void armazenaPessoa(String nome, int idade, float altura) {
	
		boolean repetido = false;
		for(int i = 0; i < numEntradas; i++) {
		
			if(pessoas[i].getNome().equals(nome)) {
				System.out.println("A pessoa já está na lista!");
				return;
			}
			
		}
		
		if(numEntradas < 10) {
		
			pessoas[numEntradas] = new Pessoa(nome, idade, altura);
			numEntradas++;
			
		} else {
			System.out.println("Agenda cheia!");
		}
		
	}
	
	/**
	 * Remove uma pessoa da agenda e move as pessoas em seguida uma posicao para tras.
	 * @param nome O nome da pessoa a ser removida.
	 */
	public void removePessoa(String nome) {
		
		boolean encontrou = false;
		for(int i = 0; i < numEntradas; i++) {
			
			if(pessoas[i].getNome().equals(nome)) {
				encontrou = true;
			}
			
			if(encontrou && i + 1 < numEntradas) {
				
				pessoas[i] = pessoas[i+1];
				
			}
			
		}
		
		if(encontrou)
			numEntradas--;
		
	}
	
	/**
	 * Busca uma pessoa na agenda.
	 * @param nome O nome da pessoa a ser buscada.
	 * @return O indice da pessoa com o nome passado se ela estiver na lista ou -1 se elaao estiver.
	 */
	public int buscaPessoa(String nome) {
		
		for(int i = 0; i < numEntradas; i++) {
			
			if(pessoas[i].getNome().equals(nome)) {
				return i;
			}
			
		}
		
		return -1;
	}
	
	/**
	 * Imprime todas as pessoas na agenda.
	 */
	public void imprimeAgenda() {
		
		for(int i = 0; i < numEntradas; i++) {
			
			System.out.println(i + ":");
			pessoas[i].imprimeDados();
			System.out.print("\n");
			
		}

	}
	
	/**
	 * Imprime os dados de uma pessoa. Se a posicao passada estiver vazia imprime "Indice vazio!".
	 * @param i O indice da pessoa a ser impressa.
	 */
	public void imprimePessoa(int i) {
		
		if(i < numEntradas) {
			pessoas[i].imprimeDados();
		} else {
			System.out.println("Indice vazio!");
		}
		
	}
}
