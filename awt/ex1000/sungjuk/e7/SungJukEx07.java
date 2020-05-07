package awt.ex1000.sungjuk.e7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//자리맞춰출력하기
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

public class SungJukEx07 {
	final static int LEFT=0;
	final static int CENTER=1;
	final static int RIGHT=2;
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>(); 
	
		// 이름, 반, 번호, 국어, 수학, 영어 
//        list.add(new Student("남궁성", 3,2,100,100,100));
//        list.add(new Student("왕자바", 3,1,90,100,80));
//        list.add(new Student("자바왕", 3,3,70,100,100));
//        list.add(new Student("킹왕짱", 1,2,100,60,90));
//        list.add(new Student("자바짱", 1,1,100,100,100));
//        list.add(new Student("최고수", 1,3,100,80,60));
//        list.add(new Student("홍길동", 2,1,50,80,100));
//        list.add(new Student("일지매", 2,3,70,80,100));
//        list.add(new Student("변강쇠", 2,4,80,80,85));
//        list.add(new Student("이원구", 2,2,90,90,90));

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
			System.out.println(args[0]+"- 지정하신 파일을 찾을수 없습니다");
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
        calculateSchoolRank(list);//석차매기기
        
        System.out.println();

        Collections.sort(list, new ClassTotalComparator());
        
        
        calculateClassRank(list);//반등수매기기
        printList(list);
        
	}
	
	public static void printList(List<Student> list) {
		
		//System.out.println("이름   반   번호   국어   수학   영어   총점   석차   반등수");
		System.out.println(Format.format("이름",5,LEFT)
				+Format.format("반",5,RIGHT)
				+Format.format("번호",5,RIGHT)
				+Format.format("국어",8,RIGHT)
				+Format.format("영어",8,RIGHT)
				+Format.format("수학",8,RIGHT)
				+Format.format("총점",8,RIGHT)
				+Format.format("석차",10,RIGHT)
				+Format.format("반등수",12,RIGHT));
		
		System.out.println("========================================================");
		
		for(Student s: list) {
			System.out.println(s);
		}
		System.out.println("=========================================================");
		
	}
	
	//동점자처리를 위한
	public static void calculateClassRank(List<Student> list) {
		int prevTotal=0;
		int prevBan=0;
		int rank=0;
		
		for(int i=0;i<list.size();i++) {
			if(prevBan!=list.get(i).getBan()) {//반이 달라지면
				rank=0; //순위 초기화
				prevTotal=0;
				prevBan=list.get(i).getBan();
			}
			
			if(prevTotal!=list.get(i).getTotal()) {//총점이 다르면
				prevTotal=list.get(i).getTotal();
				list.get(i).setClassRank(++rank);
			} else {
				list.get(i).setClassRank(list.get(i-1).getClassRank());
				++rank;
			}
			
			
		}//for end
		
	}//calculateClassRank end
	
	//동점자처리를 위한
	public static void calculateSchoolRank(List<Student> list) {
		int prevTotal=0; 
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
	}//ca

}
