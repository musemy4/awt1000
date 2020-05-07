package awt.ex1000.sungjuk.e7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//�ڸ���������ϱ�
class ClassTotalComparator implements Comparator<Student>{
	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getBan()!=o2.getBan())//���� �ٸ��� ���������ݼ�����
			return o1.getBan()-o2.getBan();
		
		return (o1.getTotal()-o2.getTotal())*-1; 
	}
}

class ClassStudentComparator implements Comparator<Student>{
	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getBan()!=o2.getBan())//���� �ٸ��� ���������ݼ�����
			return o1.getBan()-o2.getBan();
		
		return o1.getNo()-o2.getNo(); 
	}
}

public class SungJukEx07 {
	final static int LEFT=0;
	final static int CENTER=1;
	final static int RIGHT=2;
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>(); 
	
		// �̸�, ��, ��ȣ, ����, ����, ���� 
//        list.add(new Student("���ü�", 3,2,100,100,100));
//        list.add(new Student("���ڹ�", 3,1,90,100,80));
//        list.add(new Student("�ڹٿ�", 3,3,70,100,100));
//        list.add(new Student("ŷ��¯", 1,2,100,60,90));
//        list.add(new Student("�ڹ�¯", 1,1,100,100,100));
//        list.add(new Student("�ְ��", 1,3,100,80,60));
//        list.add(new Student("ȫ�浿", 2,1,50,80,100));
//        list.add(new Student("������", 2,3,70,80,100));
//        list.add(new Student("������", 2,4,80,80,85));
//        list.add(new Student("�̿���", 2,2,90,90,90));

		Scanner sc0=new Scanner(System.in);
		String st = ">> ";
		System.out.print(st);
		String inputLine = sc0.nextLine().trim();
		
		if(inputLine.toLowerCase().equals("q"))return;
		
		System.out.println(inputLine);
		String[] tmp = inputLine.split(" +");
		Scanner sc = null;
		
		try {
			sc= new Scanner(new File(tmp[2]));//E:/students.txt
		} catch (FileNotFoundException e) {
			System.out.println(args[0]+"- �����Ͻ� ������ ã���� �����ϴ�");
			System.exit(0);
		}
		String strs=null;
		while(sc.hasNext()) {
			strs=sc.nextLine();
			Scanner strSc = new Scanner(strs);
			Scanner is=	strSc.useDelimiter(",");
			list.add(new Student(is.next(),
					Integer.parseInt(is.next().trim()),
					Integer.parseInt(is.next().trim()),
					Integer.parseInt(is.next().trim()),
					Integer.parseInt(is.next().trim()),
					Integer.parseInt(is.next().trim())));
		}
		
		
		
        Collections.sort(list);
        calculateSchoolRank(list);//�����ű��
        
        System.out.println();

        Collections.sort(list, new ClassTotalComparator());
        
        
        calculateClassRank(list);//�ݵ���ű��
        printList(list);
        
	}
	
	public static void printList(List<Student> list) {
		
		//System.out.println("�̸�   ��   ��ȣ   ����   ����   ����   ����   ����   �ݵ��");
		System.out.println(Format.format("�̸�",5,LEFT)
				+Format.format("��",5,RIGHT)
				+Format.format("��ȣ",5,RIGHT)
				+Format.format("����",8,RIGHT)
				+Format.format("����",8,RIGHT)
				+Format.format("����",8,RIGHT)
				+Format.format("����",8,RIGHT)
				+Format.format("����",10,RIGHT)
				+Format.format("�ݵ��",12,RIGHT));
		
		System.out.println("========================================================");
		
		for(Student s: list) {
			System.out.println(s);
		}
		System.out.println("=========================================================");
		
	}
	
	//������ó���� ����
	public static void calculateClassRank(List<Student> list) {
		int prevTotal=0;
		int prevBan=0;
		int rank=0;
		
		for(int i=0;i<list.size();i++) {
			if(prevBan!=list.get(i).getBan()) {//���� �޶�����
				rank=0; //���� �ʱ�ȭ
				prevTotal=0;
				prevBan=list.get(i).getBan();
			}
			
			if(prevTotal!=list.get(i).getTotal()) {//������ �ٸ���
				prevTotal=list.get(i).getTotal();
				list.get(i).setClassRank(++rank);
			} else {
				list.get(i).setClassRank(list.get(i-1).getClassRank());
				++rank;
			}
			
			
		}//for end
		
	}//calculateClassRank end
	
	//������ó���� ����
	public static void calculateSchoolRank(List<Student> list) {
		int prevTotal=0; 
		int rank=0;
		
		for(int i=0;i<list.size();i++) {//���ĵǾ��ֱ⶧����
			if(prevTotal!=list.get(i).getTotal()) {//������ �ٸ��� �۴ٴ¾���
				prevTotal=list.get(i).getTotal();
				list.get(i).setSchoolRank(++rank);
			}else {
				list.get(i).setSchoolRank(list.get(i-1).getSchoolRank());
				++rank;
			}
		}
	}//ca

}
