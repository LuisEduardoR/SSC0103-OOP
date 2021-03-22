/**
 * Classe que representa uma televisao.
 * @author Luís Eduardo Rozante - nUSP 1073494
 * 
 */
public class Televisao {

	private int volume;
	/**
	 * @return the volume
	 */
	public int getVolume() {
		return volume;
	}

	/**
	 * @param volume the volume to set (will be limited between 0 and 100)
	 */
	public void setVolume(int volume) {
		
		if(volume <= 100 && volume > 0)
			this.volume = volume;
	}

	private int canal;
	/**
	 * @return the canal
	 */
	public int getCanal() {
		return canal;
	}

	/**
	 * @param canal the canal to set (will be limited to numbers greater than 0);
	 */
	public void setCanal(int canal) {
		if(canal > 0)
			this.canal = canal;
	}

	/**
	 * Constructor da classe (inicializa a televisão para o canl 1 e 50% do volume).
	 */
	public Televisao() {
		
		volume = 50;
		canal = 1;
		
	}
}
