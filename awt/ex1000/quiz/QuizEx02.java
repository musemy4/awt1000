package awt.ex1000.quiz;

import java.util.Scanner;

//Ex02. �ڵ忡 ����� �Է��� �޾Ƽ� ���俩�θ� �Ǵ��Ͽ� �������� �������� ���
public class QuizEx02 {
	/*
	"���� �� Ű���尡 �ƴ� ����?`2`final`True`if`public",
     "���� �� �ڹ��� �����ڰ� �ƴ� ����?`5`&`|`++`!=`/`^",
     "���� �� �޼����� ��ȯ���� ������ �ǹ��ϴ� Ű�����?`1`void`null`false",
	 */
	
	static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		String[] data = {
				 "���� �� Ű���尡 �ƴ� ����?`2`final`True`if`public",
                 "���� �� �ڹ��� �����ڰ� �ƴ� ����?`5`&`|`++`!=`/`^",
                 "���� �� �޼����� ��ȯ���� ������ �ǹ��ϴ� Ű�����?`1`void`null`false",
		};
	
	String[] quiz;
	String[] num;
	int score=0;
	
	for(int i=0;i<data.length;i++) {
		//String[] split(String regex,int limit)�� ���
		quiz = data[i].split("`", 2);
		System.out.println((i+1)+" : "+quiz[0]);
		num=quiz[1].split("`");

		for(int j=1;j<num.length;j++) {
			System.out.print(j+"."+num[j]+" ");
		}	
		System.out.println();
		System.out.print("[��]> ");
		String anw=sc.nextLine();
		if(anw.equals(num[0]))score++;
	}
	
	System.out.println("���䰳��/��ü���׼�: "+score+"/"+data.length);
	
	
	
	}//main end

}
