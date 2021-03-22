/**
 * 
 * @author Luís Eduardo Rozante - nUSP 1073494
 * Classe que controla um elevador.
 */

public class Elevador {

	private int andarAtual;
	private int totalAndares;
	private int capacidadeUsada;
	private int capacidadeTotal;
	
	/**
	 *  Inicializa o elevador (o elevador sempre começa vazio e no terreo).
	 * @param capacidade A capaidade do elevador.
	 * @param andares O numero de andares do predio (sem o terreo).
	 */
	public Elevador(int capacidade, int andares) {
		
		totalAndares = andares;
		capacidadeTotal = capacidade;
		
		andarAtual = 0;
		capacidadeUsada = 0;
		
	}
	
	/**
	 * @return the andarAtual
	 */
	public int getAndarAtual() {
		return andarAtual;
	}

	/**
	 * @param andarAtual the andarAtual to set
	 */
	public void setAndarAtual(int andarAtual) {
		this.andarAtual = andarAtual;
	}

	/**
	 * @return the totalAndares
	 */
	public int getTotalAndares() {
		return totalAndares;
	}

	/**
	 * @param totalAndares the totalAndares to set
	 */
	public void setTotalAndares(int totalAndares) {
		this.totalAndares = totalAndares;
	}

	/**
	 * @return the capacidadeUsada
	 */
	public int getCapacidadeUsada() {
		return capacidadeUsada;
	}

	/**
	 * @param capacidadeUsada the capacidadeUsada to set
	 */
	public void setCapacidadeUsada(int capacidadeUsada) {
		this.capacidadeUsada = capacidadeUsada;
	}

	/**
	 * @return the capacidadeTotal
	 */
	public int getCapacidadeTotal() {
		return capacidadeTotal;
	}

	/**
	 * @param capacidadeTotal the capacidadeTotal to set
	 */
	public void setCapacidadeTotal(int capacidadeTotal) {
		this.capacidadeTotal = capacidadeTotal;
	}
	
	/**
	 *  Acrescenta uma pessoa ao elevador se houver espaço.
	 */
	public void Entra() {
		
		if(capacidadeUsada < capacidadeTotal) {
			
			capacidadeUsada++;
			
		}
		
	}
	
	/**
	 *  Remove uma pessoa do elevador se houverem pessoas dentro.
	 */
	public void Sai() {
		
		if(capacidadeUsada > 0) {
			
			capacidadeUsada--;
			
		}
		
	}
	
	/**
	 *  Leva o elevador ao andar de cima se ele ja nao estiver no topo.
	 */
	public void Sobe() {
		
		if(andarAtual < totalAndares) {
			
			andarAtual++;
			
		}
		
	}
	
	/**
	 *  Leva o elevador ao andar de baixo se ele ja nao estiver no terreo.
	 */
	public void Desce() {
		
		if(andarAtual > 0) {
			
			andarAtual--;
			
		}		
	}
}
