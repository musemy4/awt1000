package awt.ex1000.wordScramble;

import java.util.Arrays;

//strArr의 요소중 하나를 임의로 골라서 반환
//문자열을 섞어서 문제를 냄 
public class WordScrambleEx01 {
	
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
		String seed = getSeed(strArr);
		//System.out.println(seed);
		String question=getScrambledWord(seed);
		
		System.out.println("Question:"+question);
		System.out.println("Answer:"+seed);
	}
}
