package awt.ex1000.dos;

import java.util.Scanner;

//사용자가 입력한 명령라인의 내용을 저장하는 save(String input)메서드와 
//입력했던 이력을 보여주는 history() 메서드를 완성하세요
public class ConsoleEx04 {
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
