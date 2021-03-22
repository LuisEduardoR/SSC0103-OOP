/**
 * Classe que representa um controle remoto usao para controlar uma televisao.
 * @author Luis Eduardo Rozante - nUSP 1073494
 * 
 */
public class ControleRemoto {

	/**
	 * Aumenta o volume da televisão em 1 unidade.
	 * @param alvo A televisao a ser controlada.
	 */
	public void aumentarVolume(Televisao alvo) {
		
		alvo.setVolume(alvo.getVolume() + 1);
		
	}
	
	/**
	 * Diminui o volume da televisão em 1 unidade.
	 * @param alvo A televisao a ser controlada.
	 */
	public void diminuirVolume(Televisao alvo) {
		
		alvo.setVolume(alvo.getVolume() - 1);
		
	}
	
	/**
	 *  Aumenta o canal da televisão em 1 unidade.
	 * @param alvo A televisao a ser controlada.
	 */
	public void aumentarCanal(Televisao alvo) {
		
		alvo.setCanal(alvo.getCanal() + 1);
		
	}
	
	/**
	 * Diminui o canal da televisão em 1 unidade.
	 * @param alvo A televisao a ser controlada.
	 */
	public void diminuirCanal(Televisao alvo) {
		
		alvo.setCanal(alvo.getCanal() - 1);
		
	}
	
	/**
	 * Muda o canal da televisao para o canl desejado.
	 * @param alvo A televisao a ser controlada.
	 * @param canal O canal que se deseja ir.
	 */
	public void trocarCanal(Televisao alvo, int canal) {
		
		alvo.setCanal(canal);
		
	}
	
	/**
	 * Retorna o volume atual da televisao.
	 * @param alvo A televisao a ser consultada.
	 * @return O volume atual da televisao alvo.
	 */
	public int consultaVolume(Televisao alvo) {
		
		return alvo.getVolume();
		
	}
	
	/**
	 * Retorna o canal atual da televisao.
	 * @param alvo A televisao a ser consultada.
	 * @return O canal atual da televisao alvo.
	 */
	public int consultaCanal(Televisao alvo) {
		
		return alvo.getCanal();
		
	}
	
}
