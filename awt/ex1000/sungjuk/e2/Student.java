package awt.ex1000.sungjuk.e2;

public class Student implements Comparable<Student>{
	private String name;
	private int classNo;
	private int studentNo;
	private int kor;
	private int math;
	private int eng;
	private int total;
	
	public Student(String name, int classNo, int studentNo, int kor, int math, int eng) {
		this.name = name;
		this.classNo = classNo;
		this.studentNo = studentNo;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
		this.total=kor+math+eng;
	}


	@Override
	public int compareTo(Student o) {
		return (this.total-o.total)*-1;
	}

	@Override
	public String toString() {
		return name + "\t"+classNo + "\t" + studentNo + "\t" + kor
				+ "\t" + math + "\t" + eng + "\t" + total;
	}
}
