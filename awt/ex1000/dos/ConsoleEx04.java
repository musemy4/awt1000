package awt.ex1000.dos;

import java.util.Scanner;

//����ڰ� �Է��� ��ɶ����� ������ �����ϴ� save(String input)�޼���� 
//�Է��ߴ� �̷��� �����ִ� history() �޼��带 �ϼ��ϼ���
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
			tmp=inputLine.split(" +");//���鿩������ �׳� �ϳ��� ħ************���..?
			
			for(String s : tmp) {
				System.out.println(s);
			}
			
		}
	}

}
