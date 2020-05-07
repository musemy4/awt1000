package awt.ex1000.quiz;

public class QuizEx01 {
	/*
	"다음 중 키워드가 아닌 것은?`2`final`True`if`public",
     "다음 중 자바의 연산자가 아닌 것은?`5`&`|`++`!=`/`^",
     "다음 중 메서드의 반환값이 없음을 의미하는 키워드는?`1`void`null`false",
	 */
	
	
	public static void main(String[] args) {
		String[] data = {
				 "다음 중 키워드가 아닌 것은?`2`final`True`if`public",
                 "다음 중 자바의 연산자가 아닌 것은?`5`&`|`++`!=`/`^",
                 "다음 중 메서드의 반환값이 없음을 의미하는 키워드는?`1`void`null`false",
		};
	
	String[] quiz;
	String[] num;
	
	for(int i=0;i<data.length;i++) {
		//String[] split(String regex,int limit)을 사용
		quiz = data[i].split("`", 2);
		System.out.println(i+" : "+quiz[0]);
		num=quiz[1].split("`");

		for(int j=1;j<num.length;j++) {
			System.out.print(j+"."+num[j]+" ");
		}	
		System.out.println();
	}
	
	
	
	
	}//main end

}
