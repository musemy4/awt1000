package awt.ex1000.textTool;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

//중복된것 제거
public class TextToolEx8 extends Frame implements WindowListener {
	TextArea ta;
	TextField tfParam1, tfParam2;
	Panel pNorth,pSouth;
	Label lb1, lb2;
	
	String[] btnName = {
		"Undo",//btn[0]-작업이전 상태로 되돌림
		"짝수줄삭제",//btn[1]-짝수줄 삭제하는 기능	
		"문자삭제", //param1에 지정된 문자를 삭제하는 기능
		"trim",//라인의 앞뒤 공백을 제거
		"빈줄삭제",//빈 줄 삭제
		"접두사추가", //param1과 param2의 문자열을 각 라인의 앞뒤에 붙임
		"substring",//param1과 param2의 지정된 문자열을 제거
		"substring2",
		"distinct"//중복제거한 후 정렬해서 보여주기
	};
	
	Button[] btn = new Button[btnName.length];
	
	private final String CR_LF =System.getProperty("line.separator");//개행문자
	private String prevText=""; //textArea ta의 내용을 저장하기 위한 변수
	
	private void registerEventHandler() {
		addWindowListener(this);
		int n=0;
		btn[n++].addActionListener(new ActionListener() {//0.undo
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText(prevText);
			}
		});
		
		btn[n++].addActionListener(new ActionListener() {//1.짝수줄 삭제-짝수줄을 삭제하는 기능
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
		
		btn[n++].addActionListener(new ActionListener() {//2.문자삭제-param1에 지정된 문자를 삭제
			@Override
			public void actionPerformed(ActionEvent e) {
				String curText =ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());
				prevText=curText;
				
			    /*
                1. TextField Param1의 값을 가져온다.(getText()사용)
                2. 반복문을 이용해서 curText를 한글자씩 읽어서
                   Param1에서 가져온 문자열에 포함되어 있는지 확인한다.
                   2.1 만일 포함되어 있으면 sb에 저장하고
                   2.2 포함되어 있지 않으면 sb에 저장하지 않는다.
                3. 작업이 끝난 후에 sb에 담긴 내용을 ta에 보여준다.(setText()사용)
			     */
			
				String param1 = tfParam1.getText();
				
				try (Scanner sc = new Scanner(curText)) {
					int lineN =0;
					while(sc.hasNextLine()) {
						String next= sc.nextLine(); 
						boolean flag=false;

						//한줄에 대한 작업
						for(int i=0;i<next.length();i++) {//한글자씩
							for(int j=0;j<param1.length();j++) {
								if(next.charAt(i)==param1.charAt(j)) {
									flag=true;//하나라도 발견되면
								}
							}
							if(flag==false) sb.append(next.charAt(i));
							flag=false;
						}
						sb.append(CR_LF);//한줄이 처리되면 개행
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
                 1. Scanner클래스와 반복문을 이용해서 curText를 라인단위로 읽는다.
                    (Scanner클래스의 hasNextLine(), nextLine()사용)
                 2. 읽어온 라인의 왼쪼공백과 오른쪽 공백을 제거한다.(String클래스의 trim()사용)
                 3. 작업이 끝난 후에 sb에 담긴 내용을 ta에 보여준다.(setText()사용)
				  */

				try (Scanner sc = new Scanner(curText)) {
					while(sc.hasNextLine()) {
						String next= sc.nextLine(); 
						sb.append(next.trim());
						sb.append(CR_LF);//한줄이 처리되면 개행
					}
				}
				ta.setText(sb.toString());
			}
		});
		
		btn[n++].addActionListener(new ActionListener() {//4.빈줄삭제
			@Override
			public void actionPerformed(ActionEvent e) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());
				prevText=curText;
				  /*
                1. Scanner클래스와 반복문을 이용해서 curText를 라인단위로 읽는다.
                   (Scanner클래스의 hasNextLine(), nextLine()사용)
                2. 읽어온 라인이 내용이 없는 빈 라인이면 sb에 저장하지 않는다.
                3. 작업이 끝난 후에 sb에 담긴 내용을 ta에 보여준다.(setText()사용)
				   */
				try (Scanner sc = new Scanner(curText)) {
					while(sc.hasNextLine()) {
						String next= sc.nextLine(); 
						if(next.equals(""))continue;
						sb.append(next).append(CR_LF);//한줄이 처리되면 개행
					}
				}
				ta.setText(sb.toString());
			}
		});
		
		btn[n++].addActionListener(new ActionListener() {//5.라인의 앞뒤에 붙이는 기능
			@Override
			public void actionPerformed(ActionEvent e) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());
				prevText=curText;
				
				String front = tfParam1.getText();
				String back = tfParam2.getText();
				try (Scanner sc = new Scanner(curText)) {
					while(sc.hasNextLine()) {
						String next= sc.nextLine(); 
						sb.append(front).append(next).append(back).append(CR_LF);//한줄이 처리되면 개행
					}
				}
				ta.setText(sb.toString());
			}
		});
		
		btn[n++].addActionListener(new ActionListener() {//6.문자열 제거
			@Override
			public void actionPerformed(ActionEvent e) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());
				prevText=curText;
				
				/*
                1. param1과 param2의 값을 가져온다.(getText()사용)
                2. Scanner클래스와 반복문을 이용해서 curText를 라인단위로 읽는다.
                   (Scanner클래스의 hasNextLine(), nextLine()사용)
                3. 읽어온 라인을 substring으로 자른다. - param1과 param2의 내용에 관계없이 길이만큼 자른다.
                   (param1의 문자열길이와 param2의 문자열 길이를 이용)
                4. 작업이 끝난 후에 sb에 담긴 내용을 ta에 보여준다.(setText()사용)
				 */
				String front =tfParam1.getText();
				String back =tfParam2.getText();
				try (Scanner sc = new Scanner(curText)) {
					while(sc.hasNextLine()) {
						String next= sc.nextLine(); 
						next=next.substring(front.length());
						next=next.substring(0, next.length()-back.length());
						
						sb.append(next);
						sb.append(CR_LF);
					}
				}
				ta.setText(sb.toString());
			}
		});
		
		btn[n++].addActionListener(new ActionListener() {//7.문자열제거2
			@Override
			public void actionPerformed(ActionEvent e) {
				 String curText = ta.getText();
                 StringBuffer sb = new StringBuffer(curText.length());

                 prevText = curText;

                /*
                1. param1과 param2의 값을 가져온다.(getText()사용)
                2. Scanner클래스와 반복문을 이용해서 curText를 라인단위로 읽는다.
                3. 각 라인에서 param1, param2과 일치하는 문자열의 위치를 찾는다.
                   (param1은 라인의 왼쪽끝부터, param2는 라인의 오른쪽끝부터 찾기 시작한다.)
                    param1과 param2로 둘러쌓인 부분을 sb에 저장한다.
                4. sb의 내용을 TextArea에 보여준다.
                */
                String front=tfParam1.getText();
                String back=tfParam2.getText();
                try (Scanner sc = new Scanner(curText)) {
					while(sc.hasNextLine()) {
						String next= sc.nextLine(); 
						int from = next.indexOf(front);
						int to=next.indexOf(back);
						
						from=(from==-1)?0:from+front.length();
						to=(to==-1)?next.length():to;
								
						if(from>to)return;
						
						sb.append(next.substring(from,to));
						sb.append(CR_LF);
					}
				}
				ta.setText(sb.toString());
			}
		});
		
		btn[n++].addActionListener(new ActionListener() {//8.중복정렬
			@Override
			public void actionPerformed(ActionEvent e) {
			      String curText = ta.getText();
                  StringBuffer sb = new StringBuffer(curText.length());
                  
                  prevText = curText;

                 /*
                    1. Scanner클래스와 반복문을 이용해서 curText를 라인단위로 읽어서 HashSet에 담는다.
                    2. HashSet의 내용을 ArrayList로 옮긴다음 정렬한다.(Collections의 sort()사용)
                    3. 정렬된 ArrayList의 내용을 sb에 저장한다.
                    4. sb에 저장된 내용을 TextArea에 보여준다.
                 */
				
                  HashSet<String> strSet= new HashSet<String>(); 

                  try (Scanner sc = new Scanner(curText)) {
  					while(sc.hasNextLine()) {
  						strSet.add(sc.nextLine());
  					}
  					
  					ArrayList<String> strs = new ArrayList<String>();
  					
  					int i=0;
  					for(Iterator<String> itr = strSet.iterator();itr.hasNext();) {
  						strs.add(itr.next());
  						sb.append(strs.get(i++)+CR_LF);
  					}
  					
  					System.out.println(sb.toString());
  				}  	
                  ta.setText(sb.toString());
			}
		});
		
	}//end of registerEventHandler()
	
	
	//생성자
	public TextToolEx8(String title) {
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
		TextToolEx8 win = new TextToolEx8("Text Tool");
		win.setVisible(true);
	
	}
}
