/**
 * Classe que administra a folha salarial de uma empresa.
 * @author Luis Eduardo Rozante - 10734794
 *
 */
public class Empresa {

	public static int numFuncionarios;
	private Funcionario[] funcionarios;
	
	public Empresa (int maxSize) {
		
		funcionarios = new Funcionario[maxSize];
		numFuncionarios = 0;
		
	}
	
	public void ContrataGerente(String nome, String cpf, double salarioBase) {
		
		Gerente novoGerente = new Gerente(nome, cpf, salarioBase);
		funcionarios[numFuncionarios] = novoGerente;
		numFuncionarios++;
		
	}
	
	public void ContrataAssistente(String nome, String cpf, double salarioBase) {
		
		Assistente novoAssistente = new Assistente(nome, cpf, salarioBase);
		funcionarios[numFuncionarios] = novoAssistente;
		numFuncionarios++;
		
	}
	
	public void ContrataVendedor(String nome, String cpf, double salarioBase, double comissao) {
		
		Vendedor novoVendedor = new Vendedor(nome, cpf, salarioBase, comissao);
		funcionarios[numFuncionarios] = novoVendedor;
		numFuncionarios++;
		
	}
	
	public Funcionario AchaFuncionario(String cpf) {
		
		for(int i = 0; i < numFuncionarios; i++) {
			
			if(funcionarios[i].getCpf().equals(cpf)) {
				
				return funcionarios[i];
				
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		
		Empresa empresa = new Empresa(256);
		
		int input = -1;
		
		while(input != 0) {
			
			System.out.println("================================\n1) Contratar um Funcionario\n2) Verificar um Funcionario\n3) Gerar Folha de Pagamentos\n0) Sair\n================================");
			input = EntradaTeclado.leInt();
			
			if(input == 1) {
				
				System.out.println("================================\n> Insira o nome:");
				String nome = EntradaTeclado.leString();
				
				String cpf = "";
				while(!Funcionario.verificaCPF(cpf)) {
					System.out.println("================================\n> Insira o cpf (xxx.xxx.xxx-xx):");
					cpf = EntradaTeclado.leString();
				}
				System.out.println("================================\n> Insira o salario base:");
				double salarioBase = EntradaTeclado.leDouble();
				
				input = -1;
				while(input != 1 && input != 2 && input != 3) {
					System.out.println("================================\n> Insira o cargo:\n1) Gerente\n2) Assistente\n3) Vendedor");
					input = EntradaTeclado.leInt();
				}
				
				if(input == 1) {
					
					empresa.ContrataGerente(nome, cpf, salarioBase);
					
				} else if(input == 2) {
					
					empresa.ContrataAssistente(nome, cpf, salarioBase);
					
				} else if (input == 3) {
					
					System.out.println("================================\n> Insira a Comissao:");
					double comissao = EntradaTeclado.leDouble();
					
					empresa.ContrataVendedor(nome, cpf, salarioBase, comissao);
					
				}
			} else if (input == 2) {
				
				String cpf = "";
				while(!Funcionario.verificaCPF(cpf)) {
					System.out.println("================================\n> Insira o cpf (xxx.xxx.xxx-xx):");
					cpf = EntradaTeclado.leString();
				}
				
				Funcionario funcionario = empresa.AchaFuncionario(cpf);
				
				if(funcionario != null)
					System.out.println(funcionario.toString());
				else
					System.out.println("Funcionario com cpf " + cpf + " nao encontrado!");
				
			} else if(input == 3) {
				
				for(int i = 0; i < empresa.numFuncionarios; i++) {
					
					if(empresa.funcionarios[i] != null)
						System.out.println(empresa.funcionarios[i].toString());
					
				}				
			}			
		}
	}
}