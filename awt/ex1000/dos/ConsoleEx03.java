package awt.ex1000.dos;

import java.util.LinkedList;
import java.util.Scanner;

public class ConsoleEx03 {
	static Scanner sc = new Scanner(System.in);
	static String[] argArr; //입력한 매개변수를 담기위한 문자열배열
	static LinkedList<String> q= new LinkedList<String>(); //사용자가 입력한 내용을 저장할 큐(queue)
	static final int MAX_SIZE = 5;
	
	public static void main(String[] args) {
		while(true) {
			String prompt=">> ";
			System.out.print(prompt);
			String input=sc.nextLine();//화면으로부터 라인단위로 입력받는다
			
			save(input);//고냥 다 자동 저장됨
			
			input=input.trim();
			argArr=input.split(" +");
			
			String command=argArr[0].trim();
			if("".equals(command))continue;//1.아무것도 입력안되었을시
			
			command=command.toLowerCase();
			if(command.equals("q"))System.exit(0);
			else if(command.equals("history")) {//2.history라고 입력되면
				history();
			} else {
				for(int i=0;i<argArr.length;i++)
				System.out.println(argArr[i]);//0.일반출력
			}
		}
	}
	
	static void save(String in) {
		if(in==null||"".equals(in))return;
		if(q.size()==MAX_SIZE)q.removeFirst();
		q.add(in);
	}
	
	static void history() {
		for(int i=0;i<MAX_SIZE;i++) {
			System.out.println((i+1)+". "+q.get(i));
		}
	}

}
