package awt.ex1000.wordScramble;

import java.util.*;

//strArr�� ����� �ϳ��� ���Ƿ� ��� ��ȯ
//���ڿ��� ��� ������ �� 
public class WordScramble {
	static Scanner sc=new Scanner(System.in);
	static String getSeed(String[] strArr) {
		int idx = (int)(Math.random()*strArr.length);
		return strArr[idx];
	}
	
	static String getScrambledWord(String str) {
		int[] randomed=new int[str.length()];
		for(int f=0;f<str.length();f++) {
			randomed[f]=f;
		}
		
		
		for(int i=0;i<str.length();i++) {
			int ran=(int)(Math.random()*str.length());
			int tmp = randomed[i];
			randomed[i] =randomed[ran];
			randomed[ran]=tmp;
		}
		
		StringBuffer collect = new StringBuffer(str.length());
		
		for(int j=0;j<str.length();j++) {
			collect.append(str.charAt(randomed[j]));
		}
		
		String question = collect.toString();
		return question;
	}
	
	static char[] gethint(char[] h,int i,String seed) {
		//�� _ó���ϰ�
		for(int j=0;j<seed.length();j++) {
			h[j]='_';
		}

		for(int k=0;k<i;k++) {//i���� ���������Ѵ�
			int s=(int)(Math.random()*seed.length());//���������� ����~
			h[s]=seed.charAt(s);
		}
		return h;
	}
	
	public static void main(String[] args) {
		String[] strArr= {"change","love","hope","view","disappoint","happy"};
		System.out.println("=== GAME START ===");
		while(true) {
			String seed = getSeed(strArr);
			String question=getScrambledWord(seed);
			char[] hint = new char[seed.length()];
			
			System.out.println();
			System.out.println("@ Question:"+question);
			System.out.print("Your answer is(Q:Exit) >> ");
			String input=sc.nextLine();
			
			if(input.toLowerCase().equals("q")) {
				System.out.println("BYE BYE!");
				System.exit(0);
			} else {//������ �����Ѵ�
				if(input.equals(seed))System.out.println("YOU ARE GOOD!");
				else {
					int i=0;
					while(true) {
						i++;
						if(i==seed.length()) {
							System.out.println("NO MORE HINT!!");
							System.out.println("Answer was:"+seed);
							break;
						}
						
						System.out.println("TRY AGAIN!");
						hint = gethint(hint,i,seed);
						System.out.print(i+") hint ");
						System.out.println(hint);
										
						System.out.print(">> ");
						input=sc.nextLine();
						
						if(input.equals(seed)) {//���߸�
							System.out.println("GOOD JOB!");
							break;
							
						}else if(input.toLowerCase().equals("q")) {
							System.out.println("Answer was:"+seed);
							System.out.println("BYE BYE!");
							System.exit(0);
						}
						
					}
				}
				
			}
		}
	}
}
