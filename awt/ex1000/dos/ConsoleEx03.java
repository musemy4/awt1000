package awt.ex1000.dos;

import java.util.Scanner;

//����ڰ� �Է��� ��ɶ����� ������ �����ϴ� save(String input)�޼���� 
//�Է��ߴ� �̷��� �����ִ� history() �޼��带 �ϼ��ϼ���
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
			tmp=inputLine.split(" ");//������************
			String[] tilt=new String[tmp.length];//ũ�⸸ ����
			int size=0;
			for(int i=0;i<tmp.length;i++) {
				//System.out.println(i+" : "+tmp[i]);
				if(tmp[i].length()<1)continue;//�����̸� �Ѿ - null�� �ƴϰ� " "�� �ƴϴ�
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
