/**
 * Classe que contem os dados de uma pessoa.
 * @author  Luis Eduardo Rozante - nUSP 1073494
 *
 */
public class Pessoa {

	private String nome;
	private int idade;
	private float altura;
	
	/**
	 * Constructor da classe.
	 * @param nome O nome da pessoa.
	 * @param idade A idade da pessoa.
	 * @param altura A altura da pessoa.
	 */
	public Pessoa(String nome, int idade, float altura) {
		
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
		
	}
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the idade
	 */
	public int getIdade() {
		return idade;
	}
	/**
	 * @param idade the idade to set
	 */
	public void setIdade(int idade) {
		this.idade = idade;
	}
	/**
	 * @return the altura
	 */
	public float getAltura() {
		return altura;
	}
	/**
	 * @param altura the altura to set
	 */
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	/**
	 * Impreme os dados da pessoa.
	 */
	public void imprimeDados() {
		
		System.out.println("Nome: " + nome);
		System.out.println("Idade: " + idade);
		System.out.println("Altura: " + altura);
		
	}
	
}
