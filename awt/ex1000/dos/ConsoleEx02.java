package awt.ex1000.dos;

import java.util.Scanner;

public class ConsoleEx02_1 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String[] tmp;
		while(true) {
			String prompt=">> ";
			System.out.print(prompt);
			String inputLine=sc.nextLine().trim();
			
			if(inputLine.toLowerCase().equals("q"))break;
			
			System.out.println(inputLine);
			tmp=inputLine.split(" +");//공백여러개도 그냥 하나로 침************어떻게..?
			
			for(String s : tmp) {
				System.out.println(s);
			}
			
		}
	}

}
