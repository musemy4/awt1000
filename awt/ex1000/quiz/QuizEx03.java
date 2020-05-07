package awt.ex1000.quiz;

import java.util.Scanner;

//Ex03. ������ ������ ���Ƿ� �ٲٰ� �������� ���Ƿ� �ٲ�� ��µǰ�
public class QuizEx03 {
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
                 "��ī�� ���ÿ�?`4`������`������`�ߵ���`��ī��",
                 "�ܿ��ϸ� �������°��� ���ÿ�?`4`����`�ᱹ��`�ø�`�ؾ`��ǳ��"
		};
	
	String[] quiz;
	String[] num;
	String[] newNum;
	int score=0;
	
	if(data.length<=0)return;
	shuffle(data);
	
	for(int i=0;i<data.length;i++) {
		//String[] split(String regex,int limit)�� ���
		//i���� ���ڸ� ������ �������� 2���� ������.
		quiz = data[i].split("`", 2);
		System.out.println((i+1)+" : "+quiz[0]);
		
		//�������ٸ� num�� ������
		num=quiz[1].split("`");
		
		int olddap=Integer.parseInt(num[0]);// ���ڴ�����
		String strDap=num[olddap];//�� ���ڰ� ����Ű�� str
		
		shuffle(num);
		for(int j=1;j<num.length;j++) {
			System.out.print((j)+"."+num[j]+" ");
		}	
		System.out.println();
		System.out.print("[��]> ");
		int anw=Integer.parseInt(sc.nextLine());
		
		if(num[anw].equals(strDap)) {
			score++;
			System.out.println("���پ�!");
		}
	}
	
	System.out.println("���䰳��/��ü���׼�: "+score+"/"+data.length);
	
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
