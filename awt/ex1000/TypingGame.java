package awt.ex1000;

import java.util.Scanner;
import java.util.Vector;

//WordGenerator가 주기적으로 단어를 추가하면, 사용자는 화면입력을 통해서 단어들을 제거해나가는 예제


public class TypingGame {
	static Scanner sc = new Scanner(System.in);
	static int interval;
	static int score;
	Vector<String> words = new Vector<String>();
	String[] data= {"피카츄","라이츄","파이리","꼬북이","버터플","야도란","피존투","또가스","모래두지","이브이","뮤츠"};
	
	WordGenerator wg= new WordGenerator();
	
	public static void main(String[] args) {
		System.out.println("난이도를 선택하세요");
		System.out.println("게임도중 '그만'을 입력하시면 멈춥니다");
		System.out.print("1.Easy 2.Medium 3.Hard 4.Dead>>");
		int level=Integer.parseInt(sc.nextLine());
		
		switch(level) {
			case 1: interval= 4*1000;break;
			case 2: interval= 2*1000;break;
			case 3: interval= 1000;break;
			case 4: interval= 500;break;
			
			default: System.out.println("잘못된 선택으로 종료합니다");System.exit(0);
		}
		
		
		TypingGame game = new TypingGame();
		game.wg.start();
		
		Vector<String> words = game.words; 
		
		while(true) {
					
			String input = sc.nextLine().trim();
			
			if(input.equals("그만")) {
				game.wg.interrupt();//인터럽트 걸었음
				System.out.println("인터럽트 걸음!");
				System.out.println("==== 수고하셨습니다 ====");
				System.out.println("total Score:"+score);
				System.out.println("==================");
				System.out.println("시스템 자원정리");
				System.out.println("스레드 종료");
				break;
			}
			
			int idx=words.indexOf(input);
			if(idx !=-1) {
				System.out.println(" ++10점!");
				score+=10;
				words.remove(idx);
			} 
		}//while끝
		
	}

	
	//이너클래스로 만드넹
	class WordGenerator extends Thread{
		@Override
		public void run() {
			while(true) {
				
				//랜덤하게 형성됨
				int idx=(int)(Math.random()*data.length);
				words.add(data[idx]);
				
				System.out.println(">> "+words);

				try {
					Thread.sleep(interval);
					//this.isInterrupted()
				} catch (InterruptedException e) {

					System.out.println("wordGenerator 인터럽트걸림");
					break;
				}
			}
			
		}
	}
}
