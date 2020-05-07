package awt.ex1000;

import java.util.Scanner;
import java.util.Vector;

//WordGenerator�� �ֱ������� �ܾ �߰��ϸ�, ����ڴ� ȭ���Է��� ���ؼ� �ܾ���� �����س����� ����


public class TypingGame {
	static Scanner sc = new Scanner(System.in);
	static int interval;
	static int score;
	Vector<String> words = new Vector<String>();
	String[] data= {"��ī��","������","���̸�","������","������","�ߵ���","������","�ǰ���","�𷡵���","�̺���","����"};
	
	WordGenerator wg= new WordGenerator();
	
	public static void main(String[] args) {
		System.out.println("���̵��� �����ϼ���");
		System.out.println("���ӵ��� '�׸�'�� �Է��Ͻø� ����ϴ�");
		System.out.print("1.Easy 2.Medium 3.Hard 4.Dead>>");
		int level=Integer.parseInt(sc.nextLine());
		
		switch(level) {
			case 1: interval= 4*1000;break;
			case 2: interval= 2*1000;break;
			case 3: interval= 1000;break;
			case 4: interval= 500;break;
			
			default: System.out.println("�߸��� �������� �����մϴ�");System.exit(0);
		}
		
		
		TypingGame game = new TypingGame();
		game.wg.start();
		
		Vector<String> words = game.words; 
		
		while(true) {
					
			String input = sc.nextLine().trim();
			
			if(input.equals("�׸�")) {
				game.wg.interrupt();//���ͷ�Ʈ �ɾ���
				System.out.println("���ͷ�Ʈ ����!");
				System.out.println("==== �����ϼ̽��ϴ� ====");
				System.out.println("total Score:"+score);
				System.out.println("==================");
				System.out.println("�ý��� �ڿ�����");
				System.out.println("������ ����");
				break;
			}
			
			int idx=words.indexOf(input);
			if(idx !=-1) {
				System.out.println(" ++10��!");
				score+=10;
				words.remove(idx);
			} 
		}//while��
		
	}

	
	//�̳�Ŭ������ �����
	class WordGenerator extends Thread{
		@Override
		public void run() {
			while(true) {
				
				//�����ϰ� ������
				int idx=(int)(Math.random()*data.length);
				words.add(data[idx]);
				
				System.out.println(">> "+words);

				try {
					Thread.sleep(interval);
					//this.isInterrupted()
				} catch (InterruptedException e) {

					System.out.println("wordGenerator ���ͷ�Ʈ�ɸ�");
					break;
				}
			}
			
		}
	}
}
