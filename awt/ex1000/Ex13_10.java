package java1000.jungsuk.e3;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
	
	final int SPEED=30;
	int xStep= SPEED;
	int yStep= SPEED;

	public BouncingBall(String title) {
		super(title);
		
		x=FRAME_WIDTH/2-BALL_SIZE;
		y=FRAME_HEIGHT/2-BALL_SIZE;
		
		setVisible(true);
		setBounds(300,200,FRAME_WIDTH,FRAME_HEIGHT);
		
		Insets insets=getInsets();
		TOP=insets.top;
		LEFT=insets.left;
		BOTTOM=FRAME_HEIGHT-insets.bottom;
		RIGHT=FRAME_WIDTH-insets.right;
		
		registerEventHandler();
		setResizable(false);
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
		while(true) {
			repaint();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
			
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.pink);
		g.fillOval(x, y, BALL_SIZE, BALL_SIZE);
	}
	
}//Bouncing ball end




public class Ex13_10 {
	public static void main(String[] args) {
		new BouncingBall("BOUNCIN BALL!!!").start();
	}
}
