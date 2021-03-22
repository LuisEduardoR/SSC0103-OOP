
public class Ex1 {

	public static void main(String[] args) throws Exception {

		System.out.println("Input a number: ");
		
		double d = EntradaTeclado.leDouble();
		
		double xi = 1;
		double xii;
		
		// Finds a good initial value;
		while(xi*xi <= d) {
			if(xi*xi == d) {
				System.out.printf("The sqrt of " + d + " is " + xi + "!");
				return;
			}
			xi++;
		}		
		xi--;
		
		xii = xi + 1234.0;
		
		while(Abs(xi - xii) > 0.00000001) {
			
			xi = xii;
			xii = (xi + (d/xi)) / 2;
		}
		
		System.out.printf("The sqrt of " + d + " is " + xii + "!");
		
	}
	
	// Returns an absolute value.
	private static double Abs(double a) {
		
		if(a < 0)
			return -a;
		
		return a;
		
	}
}
