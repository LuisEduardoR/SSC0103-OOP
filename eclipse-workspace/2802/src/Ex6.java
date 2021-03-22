
public class Ex6 {

	public static void main(String[] args) throws Exception {
		
		System.out.println("Input various numbers, then input 0 to stop:");
		
		double d = -1;
		double max = -1000000000000000.0;
		double min = 1000000000000000.0;
		
		boolean inputEntered = false;
		
		while(d != 0) {
			
			d = EntradaTeclado.leDouble();
			if(d == 0) {
			
				if(inputEntered)
					System.out.println("The smallest value was " + min + "and the largest " + max + ". ");
				else
					System.out.println("No values where entered!");
				continue;
			}	
			
			if(!inputEntered)
				inputEntered = true;
			
			if(d < min)
				min = d;
			
			if(d > max)
				max = d;
			
		}

	}

}
