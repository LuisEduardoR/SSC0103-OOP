
public class Mulher extends Pessoa {
	
	public Mulher (double peso, double altura, int idade) {
		
		super(peso, altura, idade);
		
	}
	
	public String classificaIMC() {
		
		double imc = computaIMC();
		
		if(imc <= 18.5) {
			return "Abaixo do peso";
		} else if(imc <= 24.9) {
			return "Peso normal";
		} else if(imc <= 29.9) {
			return "Sobrepeso";
		} else if(imc <= 34.9) {
			return "Obesidade de Grau 1";
		} else if(imc < 39.9) {
			return "Obesidade de Grau 2";
		} else {
			return "Obesidade de Grau 3";
		}
		
	}

}
