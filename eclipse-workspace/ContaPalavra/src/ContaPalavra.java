import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class ContaPalavra {

	private HashMap<String, Integer> cont;
	
	public ContaPalavra() {
		
		this.cont = new HashMap<String, Integer>();
		
	}
	
	public void conta(String path) {
		
		File arq = new File(path);
		Scanner scan = null;
		try {
			scan = new Scanner(arq);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			return;
		}
		
		while (scan.hasNext()) {
			
			String s = (String) scan.next().replaceAll("[^A-Za-z]", "").toLowerCase();
			if(s.length() == 0)
				continue;
				
			if(cont.containsKey(s)) {
				int wCount = cont.get(s);
				wCount++;
				
				cont.put(s, wCount);
				
			} else {
			
				cont.put(s, 1);
				
			}
		}
		
		scan.close();
		
	}
	
	public void printContador() {
		
		TreeSet<String> sortedKeys = new TreeSet<String>(cont.keySet());
		for(String key : sortedKeys)
			System.out.println(key + ":" + cont.get(key));
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("Input file path:");
		Scanner ioScan = new Scanner(System.in);
		String path = ioScan.next();
		ioScan.close();
		
		ContaPalavra c = new ContaPalavra();
		c.conta(path);
		c.printContador();

	}

}
