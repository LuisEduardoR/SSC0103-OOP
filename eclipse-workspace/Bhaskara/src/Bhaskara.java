
public class Bhaskara {

	public static void main(String args[]) {
		
		double a = 0;
		double b = 0;
		double c = 0;
		
		boolean success;
		
		System.out.println("Enter coeficient 'a':");
		success = false;
		while(!success) {
			try { a = EntradaTeclado.leDouble(); } catch (Exception e) {	
				System.out.println("Invalid value for coeficient 'a'! Try again:");
				continue;
			}
			success = true;
		}
		
		System.out.println("Enter coeficient 'b':");
		success = false;
		while(!success) {
			try { b = EntradaTeclado.leDouble(); } catch (Exception e) {	
				System.out.println("Invalid value for coeficient 'b'! Try again:");
				continue;
			}
			success = true;
		}
		
		System.out.println("Enter coeficient 'c':");
		success = false;
		while(!success) {
			try { c = EntradaTeclado.leDouble(); } catch (Exception e) {	
				System.out.println("Invalid value for coeficient 'c'! Try again:");
				continue;
			}
			success = true;
		}
		
		System.out.println("The equation is: " + a + "x^2 + " + b + "x + " + c);
		
		if(a == 0) {
			
			System.out.println("This equation is not of second degree!");
			return;
			
		}
		
		double delta = (b * b) - (4.0f * a *c);;
		
		System.out.println("The delta is: " + delta);
		
		if(delta < 0) {
			
			System.out.println("This equation has complex roots!");
			return;
			
		}
			
		double x1 = (-b + Math.sqrt(delta)) / (2.0f * a);
		double x2 = (-b - Math.sqrt(delta)) / (2.0f * a);
		
		System.out.println("The solutions for this equation are: " + x1 + " and " + x2);		
	
	}	
}
