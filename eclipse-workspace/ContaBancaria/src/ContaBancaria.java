/**
 * Classe abstrata que representa uma conta bancaria basica.
 * @author Luis Eduardo ROzante - 10734794
 *
 */
public abstract class ContaBancaria {

	public static int numeroDaConta = 0;
	
	protected String nome;
	protected int numeroConta;
	protected float saldo;
	
	public ContaBancaria(String nome, float saldo) {
		
		this.nome = nome;
		this.numeroConta = numeroDaConta;
		this.saldo = saldo;
		numeroDaConta++;
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public void deposita(float valor) {
		
		saldo += valor;
		
	}
	
	public abstract float saque(float valor) throws IllegalArgumentException;
	
	public abstract void atualiza(int dia);
}
