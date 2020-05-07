package awt.d0506.ch01;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Point{
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}

}


// 오목, 페인팅
public class Ex13_7 extends Frame implements MouseListener{
	final int LINE_NUM = 9;//줄은 9개
	final int LINE_WIDTH=30;
	final int BOARD_SIZE=LINE_WIDTH*(LINE_NUM-1);
	final int STONE_SIZE=(int)(LINE_WIDTH*0.9);
	
	final int x0;
	final int y0;
	
	final int FRAME_WIDTH;
	final int FRAME_HEIGHT;
	
	Image img=null;
	Graphics gImg=null;
	
	public Ex13_7(String title) {
		super(title);
		
		addMouseListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setBackground(new Color(216,174,71));
		setVisible(true);

		//frame의 크기
		Insets insets = getInsets();//보이기전까지는 모른다. 인셋이뭐여
		this.FRAME_WIDTH = BOARD_SIZE+LINE_WIDTH*2+insets.left+insets.right;
		this.FRAME_HEIGHT = BOARD_SIZE+LINE_WIDTH*2+insets.top+insets.bottom;
		this.x0=insets.left+LINE_WIDTH;
		this.y0=insets.top+LINE_WIDTH;
	
		setBounds(100,100,FRAME_WIDTH,FRAME_HEIGHT);
	
		img=createImage(FRAME_WIDTH,FRAME_HEIGHT);
		gImg=img.getGraphics();
		
		setResizable(false);
		
		drawBoard(gImg);
		
	}//생성자end 
	
	private void drawBoard(Graphics g) {
		for(int i=0;i<LINE_NUM;i++) {
			g.drawLine(x0, y0+i*LINE_WIDTH, x0+BOARD_SIZE, y0+i*LINE_WIDTH);//가로줄
			g.drawLine(x0+i*LINE_WIDTH, y0, x0+i*LINE_WIDTH, y0+BOARD_SIZE);//세로줄
		}
	}
	
	@Override
	public void paint(Graphics g) {
		if(img==null)return;
		//그림이 있으면
		g.drawImage(img,0,0,this);
		
	}
	
	public int setPoint(Point p) {//반올림해주는거
//		if(x%LINE_WIDTH>=LINE_WIDTH/2)return x+(LINE_WIDTH-(x%LINE_WIDTH));//넘을대
//		else return x-(x%LINE_WIDTH);
		return x0;
	}
	
	
	
	//돌 그리기 백돌, 흑돌 다 그린다
	public void drawStone(Color c,Point p) {
		Graphics2D g=(Graphics2D)this.gImg;
		g.setColor(c);
		g.fillOval(p.x, p.y, STONE_SIZE, STONE_SIZE);
		//g.setColor(Color.black);
		g.drawOval(p.x, p.y, STONE_SIZE, STONE_SIZE);//의미가 없나/
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Point p = new Point(e.getX(),e.getY());
		System.out.println(x0+","+y0);
		System.out.println("원래 x,y"+p.x+", "+p.y);
		
		//바둑의 중심으로 그려지게
		p.x=p.x-STONE_SIZE/2;
		p.y=p.y-STONE_SIZE/2;
		
		System.out.println("반올림후 x,y"+p.x+", "+p.y);
	  
		
		
		if(p.x<x0-STONE_SIZE||p.x>x0+BOARD_SIZE||p.y<y0||p.y>y0+BOARD_SIZE) {
			return;
		}
		if(e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK) {
			System.out.println("왼쪽클릭");
			//gImg.drawOval(x, y, STONE_SIZE, STONE_SIZE);
			drawStone(Color.black,p);
		}
		
		if(e.getModifiersEx()==MouseEvent.BUTTON3_DOWN_MASK) {
			System.out.println("오른쪽클릭");
			drawStone(Color.white,p);
		}
		repaint();
	}
	
	
	
	public static void main(String[] args) {
		new Ex13_7("OmokTest");
	}


	
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}



}
