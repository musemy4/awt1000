package java1000.jungsuk.e2;

import java.awt.*;
import java.awt.event.*;
import java.util.*;




class BouncingBall extends Frame{
	final int BALL_SIZE=20;
	final int FRAME_WIDTH=400;
	final int FRAME_HEIGHT=300;
	
	final int TOP;
	final int BOTTOM;
	final int LEFT;
	final int RIGHT;
	
	ArrayList balls = new ArrayList();
	
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
		new BallGenerator().start();
		
		while(true) {
			int size= balls.size();
			
			for(int i=0;i<size;i++) {
				Ball b =(Ball)balls.get(i);
				
				b.x+=b.xStep;
				b.y+=b.yStep;
			
				if(b.x<=LEFT) {
					b.x=LEFT;
					b.xStep=-b.xStep;
				}
				if(b.x>=RIGHT-Ball.SIZE) {
					b.x=RIGHT-Ball.SIZE;
					b.xStep=-b.xStep;
				}
				if(b.y<=TOP) {
					b.y=TOP;
					b.yStep=-b.yStep;
				}
				if(b.y>=BOTTOM-Ball.SIZE) {
					b.y=BOTTOM-Ball.SIZE;
					b.yStep=-b.yStep;
				}
				
			}
					
			repaint();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
			
		}
	}//start()
	
	public void paint(Graphics g) {//이건 언제호출되나?
		g.drawString("Number of balls: "+balls.size(), 20, 50);
		g.setColor(Color.red);
		
		int size= balls.size();
		
		for(int i=0;i<size;i++) {
			Ball b =(Ball)balls.get(i);
			g.fillOval(b.x, b.y, Ball.SIZE, Ball.SIZE);
		}
	}
	
	class BallGenerator extends Thread{
		@Override
		public void run() {
			while(true) {
				int x=(int)(Math.random()*(RIGHT-LEFT))+LEFT;
				int y=(int)(Math.random()*(BOTTOM-TOP))+TOP;
				
				balls.add(new Ball(x,y));
				
				try {
					Thread.sleep(3*1000);
				} catch (InterruptedException e) {}
			}
		}
	}
	
	
	class Ball{
		int x=100;
		int y=100;
		
		static final int SIZE=30;
		
		final int SPEED=5;
		int xStep=SPEED;
		int yStep=SPEED;
		
		public Ball(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	
	
}//class BouncingBall end


public class Ex13_9 {
	public static void main(String[] args) {
		new BouncingBall("Bouncing Ball").start();
	}
}
