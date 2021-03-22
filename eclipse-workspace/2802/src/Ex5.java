
public class Ex5 {

	public static void main(String[] args) throws Exception  {

		System.out.println("Input a number: ");
		
		int n = EntradaTeclado.leInt();
		
		int i = n;
		if(n % 2 == 0) {
			i--;
		}
		
		for(; i >= 2; i-=2) {
			
			if(CheckForPrime(i)) {
				System.out.println(i + " is the first prime before " + n + "!");
				return;
			}
			
		}
	}

	private static boolean CheckForPrime(int p) {
		
		if(p == 1 || p % 2 == 0) {
			return false;
		}
		
		int i = 3;
		while(i*i <= p) {
			
			if(p % i == 0) {
				return false;
			}
			
			i+=2;
			
		}
		
		return true;
		
	}
	
}
