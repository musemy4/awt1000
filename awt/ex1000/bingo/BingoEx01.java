package awt.ex1000.bingo;

import java.awt.*;
import java.awt.event.*;
class MyEventHandler extends WindowAdapter implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		Button btn =(Button)e.getSource();
		
	}
	
}

public class BingoEx01 extends Frame{
	final int SIZE = 5; //�������� ũ��
	int bingoCnt=0; //�ϼ��� ������ ��
	
	Button[] btnArr=null;
	boolean[][] bArr = new boolean[SIZE][SIZE];
	
	public BingoEx01() {
		this("Bingo Game Ver1.0");
	}
	
	public BingoEx01(String title) {
		super(title);
		
		setLayout(new GridLayout(SIZE,SIZE));
		
		MyEventHandler handler = new MyEventHandler(); 
		addWindowListener(handler);
		
		btnArr = new Button[SIZE*SIZE];//25���� �� �з�

		for(int i=0;i<SIZE*SIZE;i++) {
			btnArr[i]=new Button(i+1+"");
			add(btnArr[i]);
			btnArr[i].addActionListener(handler);
		}
		
		setBounds(500,200,300,300);
		setVisible(true);
		
		
		
	}//�����ڳ�
	public void windowClosing(WindowEvent e) {
		e.getWindow().setVisible(false);
		e.getWindow().dispose();
		System.exit(0);
	}
	
	
	public static void main(String[] args) {
		BingoEx01 win = new BingoEx01("Bingo game ver 1.0");
	}
}
