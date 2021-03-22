
public class Ex3 {

	public static void main(String[] args) throws Exception {
		
		System.out.println("Input a number: ");
		
		int x = EntradaTeclado.leInt();
		
		for(int i = x; i > 0; i--) {
			for(int j = x; j > 0; j--) {
				
				if(j <= i)
					System.out.printf("*");
				else
					System.out.printf(" ");
				
			}
			System.out.printf("\n");
		}

	}

}
