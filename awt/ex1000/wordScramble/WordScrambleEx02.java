package awt.ex1000.wordScramble;

import java.util.*;

//strArr의 요소중 하나를 임의로 골라서 반환
//문자열을 섞어서 문제를 냄 
public class WordScrambleEx02 {
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
		
		//System.out.println(str);
		//System.out.println(Arrays.toString(randomed));
		
		for(int i=0;i<str.length();i++) {
			int ran=(int)(Math.random()*str.length());
			int tmp = randomed[i];
			randomed[i] =randomed[ran];
			randomed[ran]=tmp;
		}
		
		//System.out.println(Arrays.toString(randomed));
		StringBuffer collect = new StringBuffer(str.length());
		
		for(int j=0;j<str.length();j++) {
			collect.append(str.charAt(randomed[j]));
		}
		
		//System.out.println(question);
		String question = collect.toString();
		return question;
	}
	
	
	public static void main(String[] args) {
		String[] strArr= {"change","love","hope","view","disappoint","happy"};
		//System.out.println(seed);
		
		while(true) {
			String seed = getSeed(strArr);
			String question=getScrambledWord(seed);
			System.out.println("@ Question:"+question);
			System.out.print("Your answer is(Q:Exit) >> ");
			String input=sc.nextLine();
			if(input.toLowerCase().equals("q")) {
				System.out.println("BYE BYE!");
				System.exit(0);
			}
			else if(input.equals(seed)) {
				System.out.println("YOU ARE GOOD!");
			} else {
				System.out.println("TRY AGAIN");
				System.out.println("Answer:"+seed);
			}
			
		}
	}
}
