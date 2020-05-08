package awt.ex1000.textTool;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
public class TextToolEx1 extends Frame implements WindowListener {
	TextArea ta;
	TextField tfParam1, tfParam2;
	Panel pNorth,pSouth;
	Label lb1, lb2;
	
	String[] btnName = {
		"¦���ٻ���"//btn[0]-¦���� �����ϴ� ���	
	};
	
	Button[] btn = new Button[btnName.length];
	
	private final String CR_LF =System.getProperty("line.separator");//���๮��
	
	private void registerEventHandler() {
		addWindowListener(this);
		
		btn[0].addActionListener(new ActionListener() {//¦���� ����-¦������ �����ϴ� ���
			@Override
			public void actionPerformed(ActionEvent e) {
			  /*
                1. TextArea ta�� �ؽ�Ʈ�� �����´�.(getText()���)
                2. �۾��� ����� ������ StringBuffer sb�� �����Ѵ�.
                3. ScannerŬ������ �ݺ����� �̿��ؼ� 1���� ������  �ؽ�Ʈ�� ���δ����� �д´�.
                   (ScannerŬ������ hasNextLine(), nextLine()���)
                4. ���ǹ��� ����ؼ� ¦������ ��쿡�� sb�� ��´�.
                5. �۾��� ���� �Ŀ� sb�� ��� ������ ta�� �����ش�.(setText()���)
              */

				StringBuffer sb=new StringBuffer();//�۾��������
				Scanner sc= new Scanner(ta.getText());
				int lineN =0;
				while(sc.hasNextLine()) {
					String next= sc.nextLine();
					//System.out.println(next);
					if(lineN%2==0)sb.append(next+CR_LF);
					lineN++;
				}
				
				ta.setText(sb.toString());
			}
		});
	}//end of registerEventHandler()
	
	
	//������
	public TextToolEx1(String title) {
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
		TextToolEx1 win = new TextToolEx1("Text Tool");
		win.setVisible(true);
	}
}
