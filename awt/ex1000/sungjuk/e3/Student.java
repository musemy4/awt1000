package awt.ex1000.sungjuk.e3;

public class Student implements Comparable<Student>{
	private String name;
	private int ban;
	private int no;
	private int kor;
	private int math;
	private int eng;
	private int total;
	
	public Student(String name, int classNo, int studentNo, int kor, int math, int eng) {
		this.name = name;
		this.ban = classNo;
		this.no = studentNo;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
		this.total=kor+math+eng;
	}


	@Override
	public int compareTo(Student o) {
		return (this.total-o.total)*-1;
	}

		
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getBan() {return ban;}
	public void setBan(int ban) {this.ban = ban;}
	public int getNo() {return no;}
	public void setNo(int no) {this.no = no;}
	public int getKor() {return kor;}
	public void setKor(int kor) {this.kor = kor;}
	public int getMath() {return math;}
	public void setMath(int math) {this.math = math;}
	public int getEng() {return eng;}
	public void setEng(int eng) {this.eng = eng;}
	public int getTotal() {return total;}
	public void setTotal(int total) {this.total = total;}

	@Override
	public String toString() {
		return name + "\t"+ban + "\t" + no + "\t" + kor
				+ "\t" + math + "\t" + eng + "\t" + total;
	}
	
}
