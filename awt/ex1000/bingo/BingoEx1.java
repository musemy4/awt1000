package java1000;

import java.awt.*;
import java.awt.event.*;

public class BingoEx1 extends Frame{
	final int SIZE=5;//빙고판의 크기
	int bingoCnt=0; //완성된 라인수
	
	Button[] btnArr = null;
	boolean[][] bArr = new boolean[SIZE][SIZE];//빙고판 체크여부 확인을 위한 배열
	String[] values = {
            "A","B","C","D","E",
            "F","G","H","I","J",
            "K","L","M","N","O",
            "P","Q","R","S","T",
            "U","V","W","X","Y",
            "Z","a","b","c","d",
            "e","f","g","h","i",
            "j","k","l","m","n",
            "o","p","q","r","s",
            "t","u","v","w","x",
            "y","z"
      };


	public BingoEx1() {
		this("Bingo Game ver1.0");
	}

	public BingoEx1(String title) {
		super(title);
		
		setLayout(new GridLayout(SIZE,SIZE));
		
		MyEventHandler handler = new MyEventHandler();
		addWindowListener(handler);
		
		btnArr = new Button[SIZE*SIZE];
		
		shuffle();
		
		for(int i=0;i<SIZE*SIZE;i++) {
			btnArr[i] = new Button(values[i]);
			btnArr[i].setBackground(new Color(252,251,229));
			add(btnArr[i]);
			btnArr[i].addActionListener(handler);
		}
		
		
		setBounds(500,200,300,300);
		setVisible(true);
		setResizable(false);
		
	}
	
	void shuffle() {
		for(int i=0;i<values.length;i++) {
			int tmp=(int)(Math.random()*values.length);
			String str=values[tmp];
			values[tmp]=values[i];
			values[i]=str;
		}
	}
	
	void print() {//배열 bArr을 출력
		
		for(int i=0;i<bArr.length;i++) {
			for(int j=0;j<bArr.length;j++) {
				System.out.print(bArr[i][j]?"O":"X");//true||false값을 가지고있음
			}
			System.out.println();
		}
		System.out.println("---------------------");
	}
	
	boolean checkBingo() {
		bingoCnt = 0;
		int garoCnt=0;
		int seroCnt=0;
		int crossCnt1=0;//오하방향
		int crossCnt2=0;//왼하방향
		
		
		for(int i=0;i<SIZE;i++) {//O의 갯수(true의 갯수)
			for(int j=0;j<SIZE;j++) {
				if(i==j&&bArr[i][j]) {//오하방향
					crossCnt1++;
					if(crossCnt1%5==0) {
						for(int k=0;k<SIZE;k++) {
							btnArr[k*SIZE+k].setForeground(Color.gray);
						}
					}
				}
				if(i+j==SIZE-1&&bArr[i][j]) {//왼하방향
					crossCnt2++;
					if(crossCnt2%5==0) {
						for(int k=0;k<SIZE;k++) {
							btnArr[k*(SIZE)+(SIZE-1-k)].setForeground(Color.gray);;
						}
					}
				}
				
				if(bArr[i][j]) {
					garoCnt++;
					if(garoCnt%5==0) {
						for(int k=0;k<SIZE;k++) {
							btnArr[i*SIZE+k].setForeground(Color.gray);
						}
					}
				}
				if(bArr[j][i]) {
					seroCnt++;
					if(seroCnt%5==0) {
						for(int k=0;k<SIZE;k++) {
							btnArr[k*SIZE+i].setForeground(Color.gray);
						}
					}
					
				}
			}
			
			if(garoCnt==SIZE)bingoCnt++;
			garoCnt=0;
			if(seroCnt==SIZE)bingoCnt++;
			seroCnt=0;
		}
		
		if(crossCnt1==SIZE)bingoCnt++;
		if(crossCnt2==SIZE)bingoCnt++;
		
		System.out.println("BingoCount : "+bingoCnt);
		
		return bingoCnt>=SIZE;
	}
	
	public static void main(String[] args) {
		BingoEx1 win = new BingoEx1("Bingo Game Ver 1.0");
		win.setVisible(true);
	}

	//내부클래스
	class MyEventHandler extends WindowAdapter implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Button btn =(Button)e.getSource();
			System.out.println("turn:"+btn.getLabel());//라벨의 내용을 콘솔에 출력
			
			for(int i=0;i<btnArr.length;i++) {
				if(btnArr[i]==btn) {
					bArr[i/SIZE][i%SIZE]=true;//********wow
					break;
				}
			}
			
			btn.setBackground(new Color(230,230,207));
			if(checkBingo()) {
				System.out.println("** Bingo~~!! **");
			}
			print();
			
		}
		
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			e.getWindow().dispose();
			System.exit(0);
		}
	}
}