package awt.ex1000.textTool;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

//�յ� ������ �����ϴ� ��ư "trim"�� ������ �����ϴ� ����� "���ٻ���" ��ư
public class TextToolEx4 extends Frame implements WindowListener {
	TextArea ta;
	TextField tfParam1, tfParam2;
	Panel pNorth,pSouth;
	Label lb1, lb2;
	
	String[] btnName = {
		"Undo",//btn[0]-�۾����� ���·� �ǵ���
		"¦���ٻ���",//btn[1]-¦���� �����ϴ� ���	
		"���ڻ���", //param1�� ������ ���ڸ� �����ϴ� ���
		"trim",//������ �յ� ������ ����
		"���ٻ���"//�� �� ����
	};
	
	Button[] btn = new Button[btnName.length];
	
	private final String CR_LF =System.getProperty("line.separator");//���๮��
	private String prevText=""; //textArea ta�� ������ �����ϱ� ���� ����
	
	private void registerEventHandler() {
		addWindowListener(this);
		int n=0;
		btn[n++].addActionListener(new ActionListener() {//0.undo
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText(prevText);
			}
		});
		
		btn[n++].addActionListener(new ActionListener() {//1.¦���� ����-¦������ �����ϴ� ���
			@Override
			public void actionPerformed(ActionEvent e) {
				String curText = ta.getText();
				prevText=curText;
				StringBuffer sb=new StringBuffer();
				
				try (Scanner sc = new Scanner(curText)) {
					int lineN =0;
					while(sc.hasNextLine()) {
						String next= sc.nextLine();
						//System.out.println(next);
						if(lineN%2==0)sb.append(next+CR_LF);
						lineN++;
					}
				}
				ta.setText(sb.toString());
			}
		});
		
		btn[n++].addActionListener(new ActionListener() {//2.���ڻ���-param1�� ������ ���ڸ� ����
			@Override
			public void actionPerformed(ActionEvent e) {
				String curText =ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());
				prevText=curText;
				
			    /*
                1. TextField Param1�� ���� �����´�.(getText()���)
                2. �ݺ����� �̿��ؼ� curText�� �ѱ��ھ� �о
                   Param1���� ������ ���ڿ��� ���ԵǾ� �ִ��� Ȯ���Ѵ�.
                   2.1 ���� ���ԵǾ� ������ sb�� �����ϰ�
                   2.2 ���ԵǾ� ���� ������ sb�� �������� �ʴ´�.
                3. �۾��� ���� �Ŀ� sb�� ��� ������ ta�� �����ش�.(setText()���)
			     */
			
				String param1 = tfParam1.getText();
				
				try (Scanner sc = new Scanner(curText)) {
					int lineN =0;
					while(sc.hasNextLine()) {
						String next= sc.nextLine(); 
						boolean flag=false;

						//���ٿ� ���� �۾�
						for(int i=0;i<next.length();i++) {//�ѱ��ھ�
							for(int j=0;j<param1.length();j++) {
								if(next.charAt(i)==param1.charAt(j)) {
									flag=true;//�ϳ��� �߰ߵǸ�
								}
							}
							if(flag==false) sb.append(next.charAt(i));
							flag=false;
						}
						sb.append(CR_LF);//������ ó���Ǹ� ����
						lineN++;
					}
				}
				ta.setText(sb.toString());
			}
		});
		
		btn[n++].addActionListener(new ActionListener() {//3.trim
			@Override
			public void actionPerformed(ActionEvent e) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());
				prevText=curText;
				 /*
                 1. ScannerŬ������ �ݺ����� �̿��ؼ� curText�� ���δ����� �д´�.
                    (ScannerŬ������ hasNextLine(), nextLine()���)
                 2. �о�� ������ ���ɰ���� ������ ������ �����Ѵ�.(StringŬ������ trim()���)
                 3. �۾��� ���� �Ŀ� sb�� ��� ������ ta�� �����ش�.(setText()���)
				  */

				try (Scanner sc = new Scanner(curText)) {
					while(sc.hasNextLine()) {
						String next= sc.nextLine(); 
						sb.append(next.trim());
						sb.append(CR_LF);//������ ó���Ǹ� ����
					}
				}
				ta.setText(sb.toString());
			}
		});
		
		btn[n++].addActionListener(new ActionListener() {//4.���ٻ���
			@Override
			public void actionPerformed(ActionEvent e) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());
				prevText=curText;
				  /*
                1. ScannerŬ������ �ݺ����� �̿��ؼ� curText�� ���δ����� �д´�.
                   (ScannerŬ������ hasNextLine(), nextLine()���)
                2. �о�� ������ ������ ���� �� �����̸� sb�� �������� �ʴ´�.
                3. �۾��� ���� �Ŀ� sb�� ��� ������ ta�� �����ش�.(setText()���)
				   */
				try (Scanner sc = new Scanner(curText)) {
					while(sc.hasNextLine()) {
						String next= sc.nextLine(); 
						if(next.equals(""))continue;
						sb.append(next).append(CR_LF);//������ ó���Ǹ� ����
					}
				}
				ta.setText(sb.toString());
			}
		});
		
		
		
	}//end of registerEventHandler()
	
	
	//������
	public TextToolEx4(String title) {
		super(title);
		lb1 = new Label("param1:",Label.RIGHT);
		lb2 = new Label("param2:",Label.RIGHT);
		tfParam1=new TextField(15);
		tfParam2=new TextField(15);
		
		ta= new TextArea();
		pNorth = new Panel();
		pSouth = new Panel();
		
		
		pNorth.setLayout(new FlowLayout());
		pNorth.add(lb1);
		pNorth.add(tfParam1);
		pNorth.add(lb2);
		pNorth.add(tfParam2);
		
		pSouth.setLayout(new GridLayout(2,10));
		
		for(int i=0;i<btn.length;i++) {
			btn[i] = new Button(btnName[i]);
			pSouth.add(btn[i]);
		}
		
		add(pNorth,"North");
		add(ta,"Center");
		add(pSouth,"South");
		
		setBounds(100,100,600,300);
		ta.requestFocus();
		registerEventHandler();
		
		
	}//������ end
	
	@Override
	public void windowClosing(WindowEvent e) {
		e.getWindow().setVisible(false);
		e.getWindow().dispose();
		System.exit(0);
	}
	@Override
	public void windowOpened(WindowEvent e) {}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}

	public static void main(String[] args) {
		TextToolEx4 win = new TextToolEx4("Text Tool");
		win.setVisible(true);
	
	}
}
