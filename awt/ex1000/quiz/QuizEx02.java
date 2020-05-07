package awt.ex1000.quiz;

import java.util.Scanner;

//Ex02. 코드에 사용자 입력을 받아서 정답여부를 판단하여 마지막에 최종점수 출력
public class QuizEx02 {
	/*
	"다음 중 키워드가 아닌 것은?`2`final`True`if`public",
     "다음 중 자바의 연산자가 아닌 것은?`5`&`|`++`!=`/`^",
     "다음 중 메서드의 반환값이 없음을 의미하는 키워드는?`1`void`null`false",
	 */
	
	static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		String[] data = {
				 "다음 중 키워드가 아닌 것은?`2`final`True`if`public",
                 "다음 중 자바의 연산자가 아닌 것은?`5`&`|`++`!=`/`^",
                 "다음 중 메서드의 반환값이 없음을 의미하는 키워드는?`1`void`null`false",
		};
	
	String[] quiz;
	String[] num;
	int score=0;
	
	for(int i=0;i<data.length;i++) {
		//String[] split(String regex,int limit)을 사용
		quiz = data[i].split("`", 2);
		System.out.println((i+1)+" : "+quiz[0]);
		num=quiz[1].split("`");

		for(int j=1;j<num.length;j++) {
			System.out.print(j+"."+num[j]+" ");
		}	
		System.out.println();
		System.out.print("[답]> ");
		String anw=sc.nextLine();
		if(anw.equals(num[0]))score++;
	}
	
	System.out.println("정답개수/전체문항수: "+score+"/"+data.length);
	
	
	
	}//main end

}
