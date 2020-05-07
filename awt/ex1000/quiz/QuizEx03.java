package awt.ex1000.quiz;

import java.util.Scanner;

//Ex03. 문제의 순서를 임의로 바꾸고 선택지도 임의로 바뀌어 출력되게
public class QuizEx03 {
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
                 "피카츄를 고르시오?`4`라이츄`꼬북이`야도란`피카츄",
                 "겨울하면 생각나는것을 고르시오?`4`수박`콩국수`냉면`붕어빵`선풍기"
		};
	
	String[] quiz;
	String[] num;
	String[] newNum;
	int score=0;
	
	if(data.length<=0)return;
	shuffle(data);
	
	for(int i=0;i<data.length;i++) {
		//String[] split(String regex,int limit)을 사용
		//i줄의 문자를 질문과 다지선다 2개로 나눈다.
		quiz = data[i].split("`", 2);
		System.out.println((i+1)+" : "+quiz[0]);
		
		//다지선다를 num에 나눈다
		num=quiz[1].split("`");
		
		int olddap=Integer.parseInt(num[0]);// 숫자답추출
		String strDap=num[olddap];//그 숫자가 가르키는 str
		
		shuffle(num);
		for(int j=1;j<num.length;j++) {
			System.out.print((j)+"."+num[j]+" ");
		}	
		System.out.println();
		System.out.print("[답]> ");
		int anw=Integer.parseInt(sc.nextLine());
		
		if(num[anw].equals(strDap)) {
			score++;
			System.out.println("정다압!");
		}
	}
	
	System.out.println("정답개수/전체문항수: "+score+"/"+data.length);
	
	}//main end

	static void shuffle(String[] data) {
		for(int i=1;i<data.length;i++) {
			int j=(int)(Math.random()*(data.length-1)+1);
			String tmp = data[i];
			data[i]=data[j];
			data[j]=tmp;
		}
	}
}
