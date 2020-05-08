package awt.ex1000.textTool;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
public class TextToolEx2 extends Frame implements WindowListener {
	TextArea ta;
	TextField tfParam1, tfParam2;
	Panel pNorth,pSouth;
	Label lb1, lb2;
	
	String[] btnName = {
		"Undo",//btn[0]-작업이전 상태로 되돌림
		"짝수줄삭제"//btn[1]-짝수줄 삭제하는 기능	
	};
	
	Button[] btn = new Button[btnName.length];
	
	private final String CR_LF =System.getProperty("line.separator");//개행문자
	private String prevText=""; //textArea ta의 내용을 저장하기 위한 변수
	
	private void registerEventHandler() {
		addWindowListener(this);
		btn[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText(prevText);
			
			}
		});
		
		btn[1].addActionListener(new ActionListener() {//짝수줄 삭제-짝수줄을 삭제하는 기능
			@Override
			public void actionPerformed(ActionEvent e) {
				String curText = ta.getText();
				prevText=curText;
				StringBuffer sb=new StringBuffer();//작업결과저장
				
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
	}//end of registerEventHandler()
	
	
	//생성자
	public TextToolEx2(String title) {
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
			System.out.println("버튼생성!");
			pSouth.add(btn[i]);
		}
		
		add(pNorth,"North");
		add(ta,"Center");
		add(pSouth,"South");
		
		setBounds(100,100,600,300);
		ta.requestFocus();
		registerEventHandler();
		
		
	}//생성자 end
	
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
		TextToolEx2 win = new TextToolEx2("Text Tool");
		win.setVisible(true);
	
	}
}
