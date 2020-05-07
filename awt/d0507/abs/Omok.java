package awt.d0507;

import java.awt.*;
import java.awt.event.*;

class Point{
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

// ����, ������
public class Omok extends Frame implements MouseListener{
	final int LINE_NUM = 9;//���� 9��
	final int LINE_WIDTH=30;
	final int BOARD_SIZE=LINE_WIDTH*(LINE_NUM-1);
	final int STONE_SIZE=(int)(LINE_WIDTH*0.9);
	
	final int x0;
	final int y0;
	
	final int FRAME_WIDTH;
	final int FRAME_HEIGHT;
	
	Image img=null;
	Graphics gImg=null;
	
	public Omok(String title) {
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

		//frame�� ũ��
		Insets insets = getInsets();//���̱��������� �𸥴�. �μ��̹���
		this.FRAME_WIDTH = BOARD_SIZE+LINE_WIDTH*2+insets.left+insets.right;
		this.FRAME_HEIGHT = BOARD_SIZE+LINE_WIDTH*2+insets.top+insets.bottom;
		this.x0=insets.left+LINE_WIDTH;
		this.y0=insets.top+LINE_WIDTH;
	
		setBounds(100,100,FRAME_WIDTH,FRAME_HEIGHT);
	
		img=createImage(FRAME_WIDTH,FRAME_HEIGHT);
		gImg=img.getGraphics();
		
		setResizable(false);
		
		drawBoard(gImg);
		
	}//������end 
	
	private void drawBoard(Graphics g) {
		for(int i=0;i<LINE_NUM;i++) {
			g.drawLine(x0, y0+i*LINE_WIDTH, x0+BOARD_SIZE, y0+i*LINE_WIDTH);//������
			g.drawLine(x0+i*LINE_WIDTH, y0, x0+i*LINE_WIDTH, y0+BOARD_SIZE);//������
		}
	}
	
	@Override
	public void paint(Graphics g) {
		if(img==null)return;
		//�׸��� ������
		g.drawImage(img,0,0,this);
		
	}

	public int setPoint(Point p) {//�ݿø����ִ°�
		int x=p.x;
		int y=p.y;
//		if(x%LINE_WIDTH>=LINE_WIDTH/2)return x+(LINE_WIDTH-(x%LINE_WIDTH));//������
//		else return x-(x%LINE_WIDTH);
		return x0;
	}
	
	
	
	//�� �׸��� �鵹, �浹 �� �׸���
	public void drawStone(Color c,Point p) {
		Graphics2D g=(Graphics2D)this.gImg;
		g.setColor(c);
		g.fillOval(p.x, p.y, STONE_SIZE, STONE_SIZE);
		//g.setColor(Color.black);//���� ���̻�
		g.drawOval(p.x, p.y, STONE_SIZE, STONE_SIZE);//
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Point p = new Point(e.getX(),e.getY());
		System.out.println(x0+","+y0);
		System.out.println("���� x,y"+p.x+", "+p.y);
		
		//�ٵ��� �߽����� �׷�����
		p.x=p.x-STONE_SIZE/2;
		p.y=p.y-STONE_SIZE/2;
		
		System.out.println("�ݿø��� x,y"+p.x+", "+p.y);
	  
		
		
		if(p.x<x0-STONE_SIZE||p.x>x0+BOARD_SIZE||p.y<y0||p.y>y0+BOARD_SIZE) {
			return;
		}
		if(e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK) {
			System.out.println("����Ŭ��");
			//gImg.drawOval(x, y, STONE_SIZE, STONE_SIZE);
			drawStone(Color.black,p);
		}
		
		if(e.getModifiersEx()==MouseEvent.BUTTON3_DOWN_MASK) {
			System.out.println("������Ŭ��");
			drawStone(Color.white,p);
		}
		repaint();
	}
	
	
	
	public static void main(String[] args) {
		new Omok("OmokTest");
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