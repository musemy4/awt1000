package awt.ex1000.quiz;

public class QuizEx01 {
	/*
	"���� �� Ű���尡 �ƴ� ����?`2`final`True`if`public",
     "���� �� �ڹ��� �����ڰ� �ƴ� ����?`5`&`|`++`!=`/`^",
     "���� �� �޼����� ��ȯ���� ������ �ǹ��ϴ� Ű�����?`1`void`null`false",
	 */
	
	
	public static void main(String[] args) {
		String[] data = {
				 "���� �� Ű���尡 �ƴ� ����?`2`final`True`if`public",
                 "���� �� �ڹ��� �����ڰ� �ƴ� ����?`5`&`|`++`!=`/`^",
                 "���� �� �޼����� ��ȯ���� ������ �ǹ��ϴ� Ű�����?`1`void`null`false",
		};
	
	String[] quiz;
	String[] num;
	
	for(int i=0;i<data.length;i++) {
		//String[] split(String regex,int limit)�� ���
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
