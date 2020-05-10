package java1000.jungsuk.e1;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class BouncingBall extends Frame{
	final int BALL_SIZE=20;
	final int FRAME_WIDTH=400;
	final int FRAME_HEIGHT=300;
	
	final int TOP;
	final int BOTTOM;
	final int LEFT;
	final int RIGHT;
	
	
	final int SPEED=3;
	
	int x=100;
	int y=100;
	
	int xStep=SPEED;
	int yStep=SPEED;
	
	public BouncingBall(String title) {
		super(title);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setBounds(300,200,FRAME_WIDTH,FRAME_HEIGHT);
		setResizable(false);
		setVisible(true);
		
		Insets insets = getInsets();//Frame의 테두리의 두께를 얻어온다
		
		TOP=insets.top;
		LEFT=insets.left;
		RIGHT=FRAME_WIDTH-insets.right;
		BOTTOM=FRAME_HEIGHT-insets.bottom;
		
	}
	
	void start() {
		while(true) {
			x+=xStep;
			y+=yStep;
			
			
			
			if(x<LEFT)xStep=SPEED;
			if(x>RIGHT-BALL_SIZE)xStep=-SPEED;
			if(y>BOTTOM-BALL_SIZE)yStep=-SPEED;//이거두개이해안감
			if(y<TOP)yStep=SPEED;//
			
			repaint();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
			
		}
	}//start()
	
	public void paint(Graphics g) {//이건 언제호출되나?
		g.setColor(Color.red);
		g.fillOval(x, y, BALL_SIZE, BALL_SIZE);
	}
	
}


public class Ex13_8 {
	public static void main(String[] args) {
		new BouncingBall("Bouncing Ball").start();
	}
}
