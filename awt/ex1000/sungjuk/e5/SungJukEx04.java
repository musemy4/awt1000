package awt.ex1000.sungjuk.e5;

import java.util.*;

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

public class SungJukEx04 {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>(); 
		
		// �̸�, ��, ��ȣ, ����, ����, ���� 
        list.add(new Student("���ü�", 3,2,100,100,100));
        list.add(new Student("���ڹ�", 3,1,90,100,80));
        list.add(new Student("�ڹٿ�", 3,3,70,100,100));
        list.add(new Student("ŷ��¯", 1,2,100,60,90));
        list.add(new Student("�ڹ�¯", 1,1,100,100,100));
        list.add(new Student("�ְ��", 1,3,100,80,60));
        list.add(new Student("ȫ�浿", 2,1,50,80,100));
        list.add(new Student("������", 2,3,70,80,100));
        list.add(new Student("������", 2,4,80,80,85));
        list.add(new Student("�̿���", 2,2,90,90,90));

        Collections.sort(list);
        caculateSchoolRank(list);
        calculateClassRank(list);
        printList(list);
        
	}
	
	public static void printList(List<Student> list) {
		System.out.println("�̸�\t��\t��ȣ\t����\t����\t����\t����\t����\t�ݵ��");
		System.out.println("======================================================================");
		
		for(Student s: list) {
			System.out.println(s);
		}
		System.out.println("======================================================================");
		
	}
	
	public static void calculateClassRank(List<Student> list) {
		
		
	}
	
	public static void caculateSchoolRank(List<Student> list) {
		int prevTotal=0; //������ó��
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
	}

}
