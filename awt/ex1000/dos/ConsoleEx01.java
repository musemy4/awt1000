package awt.ex1000.dos;

import java.util.Scanner;

public class ConsoleEx01 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		while(true) {
			String prompt=">> ";
			System.out.print(prompt);
			String inputLine=sc.nextLine();
			if(inputLine.toLowerCase().equals("q"))break;
			System.out.println(inputLine);
		}
	}

}
