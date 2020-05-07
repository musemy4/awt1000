package awt.ex1000.sungjuk.e5;

import java.util.*;

class ClassTotalComparator implements Comparator<Student>{
	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getBan()!=o2.getBan())//반이 다르면 오름차순반순으로
			return o1.getBan()-o2.getBan();
		
		return (o1.getTotal()-o2.getTotal())*-1; 
	}
}

class ClassStudentComparator implements Comparator<Student>{
	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getBan()!=o2.getBan())//반이 다르면 오름차순반순으로
			return o1.getBan()-o2.getBan();
		
		return o1.getNo()-o2.getNo(); 
	}
}

public class SungJukEx04 {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>(); 
		
		// 이름, 반, 번호, 국어, 수학, 영어 
        list.add(new Student("남궁성", 3,2,100,100,100));
        list.add(new Student("왕자바", 3,1,90,100,80));
        list.add(new Student("자바왕", 3,3,70,100,100));
        list.add(new Student("킹왕짱", 1,2,100,60,90));
        list.add(new Student("자바짱", 1,1,100,100,100));
        list.add(new Student("최고수", 1,3,100,80,60));
        list.add(new Student("홍길동", 2,1,50,80,100));
        list.add(new Student("일지매", 2,3,70,80,100));
        list.add(new Student("변강쇠", 2,4,80,80,85));
        list.add(new Student("이원구", 2,2,90,90,90));

        Collections.sort(list);
        caculateSchoolRank(list);
        calculateClassRank(list);
        printList(list);
        
	}
	
	public static void printList(List<Student> list) {
		System.out.println("이름\t반\t번호\t국어\t수학\t영어\t총점\t석차\t반등수");
		System.out.println("======================================================================");
		
		for(Student s: list) {
			System.out.println(s);
		}
		System.out.println("======================================================================");
		
	}
	
	public static void calculateClassRank(List<Student> list) {
		
		
	}
	
	public static void caculateSchoolRank(List<Student> list) {
		int prevTotal=0; //동점자처리
		int rank=0;
		
		for(int i=0;i<list.size();i++) {//정렬되어있기때문에
			if(prevTotal!=list.get(i).getTotal()) {//총점이 다르면 작다는얘기다
				prevTotal=list.get(i).getTotal();
				list.get(i).setSchoolRank(++rank);
			}else {
				list.get(i).setSchoolRank(list.get(i-1).getSchoolRank());
				++rank;
			}
		}
	}

}
