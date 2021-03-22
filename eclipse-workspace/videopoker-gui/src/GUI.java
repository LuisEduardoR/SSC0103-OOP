import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Classe que implementa a interface grafica e a interacao dessa com o jogo.
 * @author Luís Eduardo Rozante - 10734794
 *
 */
@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener{
	

	/**
	 * Guarda uma referencia para o jogo sendo jogado.
	 */
	private Poker game;
	
	/**
	 * Painel principal.
	 */
	JPanel mainPanel;
	
	/**
	 * Painel superior contendo os creditos e o numero da rodada.
	 */
	JPanel topPanel;
	/**
	 * Label com o numero de craditos do jogador.
	 */
	JLabel creditosLabel;
	/**
	 * Label com o numero da rodada atual.
	 */
	JLabel rodadaLabel;
	
	/**
	 * Painel que guarda a area relacionada ao jogo e suas fases.
	 */
	JPanel gamePanel;
	
	JPanel startPanel;
	
	JPanel apostasPanel;
	JTextField apostaField;
	
	JPanel cardPanel;
	JButton handButton;
	JCheckBox[] cartas;
	
	JPanel roundEndPanel;
	JLabel[] cartasEnd;
	
	JPanel gameEndPanel;
	
	JPanel consolePanel;
	JLabel console;
	
	private ImageIcon[] cardImages;
	private ImageIcon selectedImage;
	
	/**
	 * Construtor para a classe.
	 * @param game Jogo que esta sendo jogado.
	 */
	public GUI (Poker game) {
		
		// Cria a janela principal.
		super("Video Poker");
		
		this.game = game;
		
		this.setSize(640, 320);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		
		// Obtem uma referencia ao painel principal.
		mainPanel = (JPanel) this.getContentPane();
		
		// Cria o painel de superior.
		topPanel = new JPanel(new BorderLayout());
		
		// Cria as labels e as coloca no painel, uma de cada lado.
		creditosLabel = new JLabel();
		topPanel.add(creditosLabel, BorderLayout.WEST);
		
		rodadaLabel = new JLabel();
		topPanel.add(rodadaLabel, BorderLayout.EAST);
		
		// Adiciona esse painel ao topo principal.
		mainPanel.add(topPanel, BorderLayout.NORTH);
		
		// Cria o painel do jogo.
		gamePanel = new JPanel(new BorderLayout());
		
		// Cria os paineis das diferentes fases do jogo.
		criaPainelInicioRodada();
		criaPainelApostas();
		criaPainelCartas();
		criaPainelFimRodada();	
		criaPainelFimJogo();
		
		// Adiciona o painel do jogo ao painel principal.
		mainPanel.add(gamePanel, BorderLayout.CENTER);
		
		// Cria o painel do console.
		consolePanel = new JPanel();
		
		console = new JLabel("Confirmar Mão");
		consolePanel.add(console);
		
		mainPanel.add(consolePanel, BorderLayout.SOUTH);
		
		// Gera os icones para as cartas.
		geraIconesCartas();
		
		// Mostra a janela do jogo.
		this.setVisible(true);
		
	}
	
	/**
	 * Carrega e cria os icones para gerar as cartas. OBS: eh necessário que a pasta "res" que contem as imagens cartas, esteja no mesmo diretorio 
	 * que o arquivo GUI.class gerado apos a compilacao.
	 */
	private void geraIconesCartas() {
		
		// Gera as imagems das cartas.
		cardImages = new ImageIcon[52];
		
		BufferedImage img = null;
		for(int i = 0; i < 52; i++) {
			
			try {
				
				// Carrega a imagem.
				img = ImageIO.read(getClass().getClassLoader().getResource("res/card" + i + ".png"));
				
				// Muda o tamanho da imagem para o tamanho apropriado.
		        BufferedImage resizedImg = new BufferedImage(120, 200, img.getType());
		        Graphics2D g2d = resizedImg.createGraphics();
		        g2d.drawImage(img, 0, 0, 120, 200, null);
		        g2d.dispose();
		        
		        // Cria o icone a partir da imagem.
				cardImages[i] = new ImageIcon(resizedImg);

				
			} catch (Exception e) {
				
				System.out.println("Falha no carregamento da imagem para a carta " + i + ": " + e.getMessage());
				
			}
		}
		
		try {
			
			// Carrega a imagem.
			img = ImageIO.read(getClass().getClassLoader().getResource("res/back.png"));
			
			// Muda o tamanho da imagem para o tamanho apropriado.
	        BufferedImage resizedImg = new BufferedImage(120, 200, img.getType());
	        Graphics2D g2d = resizedImg.createGraphics();
	        g2d.drawImage(img, 0, 0, 120, 200, null);
	        g2d.dispose();
	        
	        // Cria o icone a partir da imagem.
	        selectedImage = new ImageIcon(resizedImg);

			
		} catch (Exception e) {
			
			System.out.println("Falha no carregamento da imagem para o verso da carta: " + e.getMessage());
			
		}
		
	}
	
	/**
	 * Cria o painel no inicio de cada rodada.
	 */
	private void criaPainelInicioRodada() {

		startPanel = new JPanel(new FlowLayout());
		
		// Cria o botao de iniciar.
		JButton botaoInicio = new JButton("Iniciar rodada");
		botaoInicio.addActionListener(this);
		botaoInicio.setActionCommand("iniciarRodada");
		
		startPanel.add(botaoInicio, BorderLayout.SOUTH);
		
	}
	
	/**
	 * Cria o painel onde se fazem apsotas.
	 */
	private void criaPainelApostas() {
		
		apostasPanel = new JPanel();
		
		// Cria o campo que recebe as apostas.
		apostasPanel.add(new JLabel("Insira sua aposta:"), BorderLayout.NORTH);
		apostaField = new JTextField(50);
		apostasPanel.add(apostaField);
		
		// Cria o botao de confirmar.
		JButton botaoApostar = new JButton("Apostar");
		botaoApostar.addActionListener(this);
		botaoApostar.setActionCommand("relizarAposta");
		
		apostasPanel.add(botaoApostar, BorderLayout.SOUTH);
		
	}
	
	/**
	 * Cria o painel de selecao de cartas.
	 */
	private void criaPainelCartas() {
		
		cardPanel = new JPanel(new BorderLayout());
		
		cardPanel.add(new JLabel("Sua mão: "), BorderLayout.NORTH);
		
		// Adiciona o painel que mostrara a mao.
		JPanel hand = new JPanel(new GridLayout(1, 5));
		
		cartas = new JCheckBox[5];
		for(int i = 0; i < 5; i++) {
			
			cartas[i] = new JCheckBox();
			cartas[i].addActionListener(this);
			cartas[i].setActionCommand("checkCarta");
			hand.add(cartas[i]);
			
		}
		
		cardPanel.add(hand, BorderLayout.CENTER);
		
		// Adiciona o botao de trocar cartas ou confirmar mao.
		handButton = new JButton("Confirmar mão");
		handButton.addActionListener(this);
		handButton.setActionCommand("confirmar_trocarMao");
		cardPanel.add(handButton, BorderLayout.SOUTH);
		
	}

	/**
	 * Cria o painel do final de cada rodada.
	 */
	public void criaPainelFimRodada() {
		
		roundEndPanel = new JPanel(new BorderLayout());
		
		JLabel endText = new JLabel("Fim da Rodada!");
		
		roundEndPanel.add(endText, BorderLayout.NORTH);
		
		// Adiciona o painel que mostrara a mao.
		JPanel hand = new JPanel(new GridLayout(1, 5));
		
		cartasEnd = new JLabel[5];
		for(int i = 0; i < 5; i++) {
			
			cartasEnd[i] = new JLabel();
			hand.add(cartasEnd[i]);
			hand.add(cartasEnd[i]);
			
		}
		
		roundEndPanel.add(hand, BorderLayout.CENTER);
		
		// Adiciona o botao de finalizar rodada
		JButton continueButton = new JButton("Finalizar Rodada");
		continueButton.addActionListener(this);
		continueButton.setActionCommand("finalizarRodada");
		roundEndPanel.add(continueButton, BorderLayout.SOUTH);
		
	}
	
	/**
	 * Cria o painel do final do jogo.
	 */
	private void criaPainelFimJogo() {
		
		gameEndPanel = new JPanel(new FlowLayout());
		
		// Adiciona o botao de reiniciar jogo
		JButton newButton = new JButton("Novo Jogo");
		newButton.addActionListener(this);
		newButton.setActionCommand("novoJogo");
		
		gameEndPanel.add(newButton, BorderLayout.SOUTH);
		
		// Adiciona o botao de finalizar jogo
		JButton endButton = new JButton("Finalizar Jogo");
		endButton.addActionListener(this);
		endButton.setActionCommand("finalizarJogo");
		
		gameEndPanel.add(endButton, BorderLayout.SOUTH);
	

	}
	
	/**
	 * Atualiza o numero de creditos na interface.
	 */
	public void atualizaCreditos() {
		
		creditosLabel.setText("Creditos atuais: " + game.mesa.getCredits() + "$");
		
	}
	
	/**
	 * Atualiza o numero da rodada na interface.
	 */
	public void atualizaRodada() {
		
		rodadaLabel.setText("Rodada: " + game.rodadaAtual + " ");
		
	}
	
	/**
	 * Atualiza o texto do console.
	 * @param Texto a ser usado.
	 */
	public void atualizaConsole (String msg) {
		
		console.setText(msg);
		
	}
	
	/**
	 * Muda a tela atual do jogo.
	 * @param tela Nome da tela a ser usada.
	 */
	public void setTela(String tela) {

		if(tela.equals("inicioRodada")) {
			
			roundEndPanel.setVisible(false);
			gameEndPanel.setVisible(false);
			
			gamePanel.remove(roundEndPanel);
			gamePanel.remove(gameEndPanel);
			gamePanel.add(startPanel);
			
			startPanel.setVisible(true);
			
			
		} else if(tela.equals("aposta")) {
			
			startPanel.setVisible(false);
			
			gamePanel.remove(startPanel);
			gamePanel.add(apostasPanel);
			
			apostasPanel.setVisible(true);
			
		} else if(tela.equals("trocas")) {
			
			apostasPanel.setVisible(false);
			
			gamePanel.remove(startPanel);
			gamePanel.add(cardPanel);
			
			for(int i = 0; i < 5; i++) {
				
				cartas[i].setSelected(false);
				cartas[i].setIcon(cardImages[game.mao[i].getId()]);
				
			}
			
			handButton.setText("Confirmar Mão");
			
			cardPanel.setVisible(true);
			
		} else if(tela.equals("finalizaRodada")) {
			
			cardPanel.setVisible(false);
			
			gamePanel.remove(cardPanel);
			gamePanel.add(roundEndPanel);
			
			for(int i = 0; i < 5; i++) {
				
				cartasEnd[i].setIcon(cardImages[game.mao[i].getId()]);
				
			}
			
			roundEndPanel.setVisible(true);
			
		} else if (tela.equals("finalizaJogo")) {
			
			roundEndPanel.setVisible(false);
			
			gamePanel.remove(roundEndPanel);
			gamePanel.add(gameEndPanel);
			
			gameEndPanel.setVisible(true);
			
		}
	}
	
	/**
	 * Realiza as ações da interface.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("iniciarRodada")) { // Inicia a rodada.
			
			game.proximoEstado();
			atualizaConsole("Rodada " + game.rodadaAtual + " iniciada.");
			
		} else if("relizarAposta".equals(e.getActionCommand())) { // Tenta realizar uma aposta.
			
			int valor = -1;
				
			try {
				valor = Integer.parseInt(apostaField.getText());
			} catch (NumberFormatException excpt) { // Informa um erro se o valor nao puder ser convertido.
			
				valor = -1;
				atualizaConsole("Entrada inválida! Tente novamente!");
				return;
			}
		
			if(valor <= 0) { // Informa um erro se o valor eh menor ou igual a 0.
				
				atualizaConsole("Valor inválido! A aposta tem que ser maior que 0$!");
				
			} else if (game.mesa.getCredits() < valor) { // Informa um erro se nao ha creditos suficientes.
				
				atualizaConsole("Valor inválido! Créditos insuficientes!");
				
			} else { // Se a aposta eh valida:
				
				game.realizaAposta(valor); // Realiza a aposta.
				game.proximoEstado(); // Avanca para o proximo estado.
				
			}
			
		} else if(e.getActionCommand().equals("checkCarta")) {
			
			int changedCards = 0; // Conta quantas cartas estao marcadas para serem trocadas.
			
			for(int i = 0; i < 5; i++) { // Atualiza as imagens das cartas.
					
				if(cartas[i].isSelected()) {
					
					cartas[i].setIcon(selectedImage);
					changedCards++;
					
				} else {
					
					cartas[i].setIcon(cardImages[game.mao[i].getId()]);
					
				}
				
			}
			
			if(changedCards == 0) // Muda o texto do bota se alguma carta esta para ser trocada ou nao.
				handButton.setText("Confirmar Mão");
			else
				handButton.setText("Trocar Cartas");
			
			
		} else if(e.getActionCommand().equals("confirmar_trocarMao")) { // COnfirma ou troca a mao do jogador.
			
			int changedCards = 0; // Conta quantas cartas estao marcadas para serem trocadas.
			
			boolean[] trocar = new boolean[5]; // Guarda que cartas devem ser trocadas.
			
			for(int i = 0; i < 5; i++) { // Verifica quantas e quais cartas devem ser trocadas.
					
				if(cartas[i].isSelected()) {
					
					trocar[i] = true;
					changedCards++;
					
				} else {
					
					trocar[i] = false;
				}
				
			}
			
			if(changedCards != 0) { // Troca as cartas marcadas.
				
				if(game.estadoAtual == Poker.estado.troca1) {
					
					game.guardarMao(1); // Marca as cartas que tem que ser devolvidas.
					game.mao = game.baralho.retirarMao(game.mao, trocar); // Troca as cartas.
					
				} else if(game.estadoAtual == Poker.estado.troca2) {
					
					game.guardarMao(2); // Marca as cartas que tem que ser devolvidas.
					game.mao = game.baralho.retirarMao(game.mao, trocar); // Troca as cartas.
					
					game.confirmarMao(); // Como nao ha mais cartas confirma a mao.
					
				}
				
			} else { // Se nenhuma carta esta marcada confirma a mao.
				
				game.confirmarMao();
				
			}
			
			game.proximoEstado(); // Avanca o estado do jogo.
			
		} else if(e.getActionCommand().equals("finalizarRodada")) { // Finaliza a rodada.
			
			game.proximaRodada();
			
		} else if(e.getActionCommand().equals("novoJogo")) { // Inicia um novo jogo.
			
			game.iniciaJogo();
			
		} else if(e.getActionCommand().equals("finalizarJogo")) { // Finaliza o jogo.
			
			System.exit(0);
			
		}
		
	}
}
