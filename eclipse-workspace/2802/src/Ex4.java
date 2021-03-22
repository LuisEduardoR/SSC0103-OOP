
public class Ex4 {

	public static void main(String[] args) throws Exception  {

		System.out.println("Input a number: ");
		
		int p = EntradaTeclado.leInt();
		
		if(p == 1) {
			System.out.println("1 is not considered prime!");
			return;
		}
		
		if(p % 2 == 0) {
			System.out.println(p + " is not prime! It's smallest divisor is: 2");
			return;
		}
		
		int i = 3;
		while(i*i <= p) {
			
			if(p % i == 0) {
				System.out.println(p + " is not prime! It's smallest divisor is: " + i);
				return;
			}
			
			i+=2;
			
		}
		
		System.out.println(p + " is prime!");
	}
}
