package awt.ex1000.dos;

import java.util.Scanner;

//사용자가 입력한 명령라인의 내용을 저장하는 save(String input)메서드와 
//입력했던 이력을 보여주는 history() 메서드를 완성하세요
public class ConsoleEx03 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String[] tmp;
		while(true) {
			String prompt=">> ";
			System.out.print(prompt);
			String inputLine=sc.nextLine().trim();
			
			if(inputLine.toLowerCase().equals("q"))break;
			
			System.out.println(inputLine);
			tmp=inputLine.split(" ");//널포함************
			String[] tilt=new String[tmp.length];//크기만 생성
			int size=0;
			for(int i=0;i<tmp.length;i++) {
				//System.out.println(i+" : "+tmp[i]);
				if(tmp[i].length()<1)continue;//공백이면 넘어가 - null도 아니고 " "도 아니다
				else{
					tilt[size++]=tmp[i];
				}
			}
			
			String[] weArr = new String[size];
			for(int j=0;j<size;j++) {
				System.out.println(tilt[j]);
				weArr[j]=tilt[j];
			}
		}
	}

}
