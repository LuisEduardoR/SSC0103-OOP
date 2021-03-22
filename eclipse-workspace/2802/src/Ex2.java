
public class Ex2 {

	public static void main(String[] args) throws Exception {
		
		System.out.println("Input a number: ");
		
		int x = EntradaTeclado.leInt();
		
		for(int i = x; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				System.out.printf("*");
			}
			System.out.printf("\n");
		}

	}

}
