/**
 * Classe que administra um conjunto de contas.
 * @author Luis Eduardo Rozante - 10734794
 *
 */
public class Contas {

	public static int numContas;
	private ContaBancaria[] contas;
	
	public Contas (int maxSize) {
		
		contas = new ContaBancaria[maxSize];
		numContas = 0;
		
	}
	
	public void CriaContaPoupancaSimples(String nome, float saldo, int dia, float taxa) {
		
		ContaPoupancaSimples novaConta = new ContaPoupancaSimples(nome, saldo, dia, taxa);
		contas[numContas] = novaConta;
		numContas++;
		
	}
	
	public void CriaContaPoupancaOuro(String nome, float saldo, int dia, float taxa) {
		
		ContaPoupancaOuro novaConta = new ContaPoupancaOuro(nome, saldo, dia, taxa);
		contas[numContas] = novaConta;
		numContas++;
		
	}
	
	public void CriaContaEspecial(String nome, float saldo, float limite) {
		
		ContaEspecial novaConta = new ContaEspecial(nome, saldo, limite);
		contas[numContas] = novaConta;
		numContas++;
		
	}
	
	public ContaBancaria AchaConta(int numero) {
		
		for(int i = 0; i < numContas; i++) {
			
			if(contas[i].getNumeroConta() == numero) {
				
				return contas[i];
				
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		
		Contas cont = new Contas(256);
		
		int input = -1;
		
		while(input != 0) {
			
			System.out.println("================================\n1) Criar uma conta\n2) Saque\n3) Deposito\n4) Atualizar poupanca\n5) Consultar Saldos\n0) Sair\n================================");
			input = EntradaTeclado.leInt();
			
			if(input == 1) {
				
				String nome = "";
				float saldo = 0;
				
				System.out.println("================================\n> Insira o nome e o saldo inicial:");
				nome = EntradaTeclado.leString();
				saldo = (float)EntradaTeclado.leDouble();
				
				input = -1;
				while(input != 1 && input != 2) {
					System.out.println("================================\n> Insira o tipo da conta:\n1) Poupanca\n2) Especial");
					input = EntradaTeclado.leInt();
				}
				if(input == 1) {
					
					System.out.println("================================\n> Insira o dia do rendimento e a taxa:");
					int dia = EntradaTeclado.leInt();
					float taxa = (float)EntradaTeclado.leDouble();
					
					input = -1;
					while(input != 1 && input != 2) {
						System.out.println("================================\n> Insira o tipo da poupanca:\n1) Simples\n2) Ouro");
						input = EntradaTeclado.leInt();
					}
					
					if(input == 1)
						cont.CriaContaPoupancaSimples(nome, saldo, dia, taxa);
					else if (input == 2)
						cont.CriaContaPoupancaOuro(nome, saldo, dia, taxa);
					
				} else if (input == 2) {
					
					System.out.println("================================\n> Insira o limite:");
					float limite = (float)EntradaTeclado.leDouble();
					
					cont.CriaContaEspecial(nome, saldo, limite);
					
				}
				
			} else if(input == 2) {
				
				System.out.println("================================\n> Insira o numero da conta e o valor:");
				int numConta = EntradaTeclado.leInt();
				float valor = (float)EntradaTeclado.leDouble();
				
				ContaBancaria conta = cont.AchaConta(numConta);
				
				if(conta != null) {
				
					float saque = 0;
					try {
						saque = conta.saque(valor);
					} catch (IllegalArgumentException e) {
					
						saque = 0;
						System.out.println(e.getMessage() + '!');
						
					}
					
					System.out.println("Voce sacou: " + saque);
				
				} else {
					
					System.out.println("Conta n??o encontrada!");
					
				}
			} else if(input == 3) {
				
				System.out.println("================================\n> Insira o numero da conta e o valor:");
				int numConta = EntradaTeclado.leInt();
				float valor = (float)EntradaTeclado.leDouble();
				
				ContaBancaria conta = cont.AchaConta(numConta);
				
				
				if(conta != null) {
				
					conta.deposita(valor);
					
					System.out.println("Voce depositou: " + valor);
				
				} else {
					
					System.out.println("Conta n??o encontrada!");
					
				}
			} else if(input == 4) {
			
				System.out.println("================================\n> Insira o dia:");
				int dia = EntradaTeclado.leInt();
				
				int atualizadas = 0;
				for(int i = 0; i < Contas.numContas; i++) {
					
					ContaBancaria conta = cont.AchaConta(i);
					
					if(conta instanceof ContaPoupanca) {
						
						ContaPoupanca poupanca = (ContaPoupanca) conta; 
						
						if(poupanca.getDiaRendimento() == dia) {
						
							poupanca.atualiza(dia);
							atualizadas++;
							
						}
					}
				}
				
				System.out.println(atualizadas + " poupancas renderam!");
				
			} else if(input == 5) {
				
				for(int i = 0; i < Contas.numContas; i++) {
					
					ContaBancaria conta = cont.AchaConta(i);
					System.out.println(conta.getNumeroConta() + "- Saldo: " + conta.getSaldo());
					
				}				
			}			
		}
	}
}