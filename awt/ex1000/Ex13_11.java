package java1000.jungsuk.e4;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

//빨간공과 회색공이 충돌하면 중단되는 프로그램
class BouncingBall extends Frame{
	final int BALL_SIZE=15;
	final int FRAME_WIDTH=400;
	final int FRAME_HEIGHT=300;
	
	final int TOP;
	final int BOTTOM;
	final int LEFT;
	final int RIGHT;
	
	int x;
	int y;
	
	final int SPEED=5;
	boolean isPlaying = true;
	ArrayList balls = new ArrayList();//볼들

	public BouncingBall(String title) {
		super(title);
		
		x=FRAME_WIDTH/2-BALL_SIZE/2;
		y=FRAME_HEIGHT/2-BALL_SIZE/2;
		
		setVisible(true);
		setResizable(false);
		setBounds(300,200,FRAME_WIDTH,FRAME_HEIGHT);
		
		Insets insets=getInsets();
		TOP=insets.top;
		LEFT=insets.left;
		BOTTOM=FRAME_HEIGHT-insets.bottom;
		RIGHT=FRAME_WIDTH-insets.right;
		
		registerEventHandler();
	}
	
	void registerEventHandler() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(!isPlaying)return;
				
				int key=e.getKeyCode();
				if(key==KeyEvent.VK_UP) {
					y-=SPEED;
					if(y<=TOP)y=TOP;
				} else if(key==KeyEvent.VK_DOWN) {
					y+=SPEED;
					if(y>=BOTTOM-BALL_SIZE)y=BOTTOM-BALL_SIZE;
				} else if(key==KeyEvent.VK_LEFT) {
					x-=SPEED;
					if(x<=LEFT)x=LEFT;
				} else if(key==KeyEvent.VK_RIGHT) {
					x+=SPEED;
					if(x>=RIGHT-BALL_SIZE)x=RIGHT-BALL_SIZE;
				}
			}
		});
	}
	
	void start() {
		new BallGenerator().start();
		
		while(isPlaying) {
			int size=balls.size();
			
			for(int i=0;i<size;i++) {
				Ball b =(Ball)balls.get(i);
				b.x+=b.xStep;
				b.y+=b.yStep;
				
				if(b.x<=LEFT) {
					b.x=LEFT;
					b.xStep=-b.xStep;
				}
				if(b.x>=RIGHT-b.size) {
					b.x=RIGHT-b.size;
					b.xStep=-b.xStep;
				}
				if(b.y<=TOP) {
					b.y=TOP;
					b.yStep=-b.yStep;
				}
				if(b.y>=BOTTOM-b.size) {
					b.y=BOTTOM-b.size;
					b.yStep=-b.yStep;
				}
				if(collisionCheck(b)) {
					isPlaying=false;
					break;
				}
				
			}
			
			repaint();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
			
		}
	}
	
	boolean collisionCheck(Ball b) {
		double dx=(b.x+b.size/2)-(x+BALL_SIZE/2);
		double dy=(b.y+b.size/2)-(y+BALL_SIZE/2);
		
		int distance=(int)(Math.sqrt(dx*dx+dy*dy));
		return distance<(b.size+BALL_SIZE)/2;
	}
	
	
	public void paint(Graphics g) {
		g.drawString("Number of balls: "+balls.size(),20,50);
		
		g.setColor(Color.pink);
		g.fillOval(x, y, BALL_SIZE, BALL_SIZE);
		
		g.setColor(Color.red);
		
		int size=balls.size();
		
		for(int i=0;i<size;i++) {
			Ball b = (Ball)balls.get(i);
			g.fillOval(b.x, b.y, b.size, b.size);
		}
	}
	
	class BallGenerator extends Thread{
		@Override
		public void run() {
			while(isPlaying) {
				int x=(int)(Math.random()*(RIGHT-LEFT-Ball.MAX_SIZE))+LEFT;
				int y=(int)(Math.random()*(BOTTOM-TOP-Ball.MAX_SIZE))+TOP;
				
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
		int size=15;
		
		static final int MAX_SIZE=30;
		static final int MIN_SIZE=10;
		
		final int SPEED=5;
		int xStep=SPEED;
		int yStep=SPEED;
		
		Ball(int x, int y) {
			this(x,y,(int)(Math.random()*(MAX_SIZE-MIN_SIZE))+MIN_SIZE);
		}
		
		Ball(int x, int y, int size){
			this.x=x;
			this.y=y;
			this.size=size;
		}
	}
	
	
}//Bouncing ball end




public class Ex13_11 {
	public static void main(String[] args) {
		new BouncingBall("BOUNCIN BALL!!!").start();
	}
}
