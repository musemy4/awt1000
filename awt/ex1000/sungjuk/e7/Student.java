package awt.ex1000.sungjuk.e7;

public class Student implements Comparable<Student>{
	
	final static int LEFT=0;
	final static int CENTER=1;
	final static int RIGHT=2;
	
	private String name;
	private int ban;
	private int no;
	private int kor;
	private int math;
	private int eng;
	private int total;
	
	private int schoolRank;
	private int classRank;
		
	
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
	public int getSchoolRank() {return schoolRank;}
	public void setSchoolRank(int schoolRank) {this.schoolRank = schoolRank;}
	public int getClassRank() {return classRank;}
	public void setClassRank(int classRank) {this.classRank = classRank;}


	@Override
	public String toString() {
		return format(""+name,5,LEFT)
				+format(""+ban,4,RIGHT)
				+format(""+no,4,RIGHT)
				+format(""+kor,6,RIGHT)
				+format(""+eng,6,RIGHT)
				+format(""+math,6,RIGHT)
				+format(""+total,8,RIGHT)
				+format(""+schoolRank,8,RIGHT)
				+format(""+classRank,8,RIGHT)
				;
	}
	
	public static String format(String str,int length,int alignment) {
		if(str==null)str="";
		int diff=length-str.length();
		
		//주어진 str의 길이보다 length의 값이 작으면 str을 length만큼만 남기고 잘라낸다
		if(diff<0)return str.substring(0,length);
		
		char[] source=str.toCharArray();
		char[] result=new char[length];
		
		//배열 result를 공백으로 채운다
		for(int i=0;i<result.length;i++)result[i]=' ';
	
		if(alignment==LEFT) {
			System.arraycopy(source, 0, result, 0, length-diff);
		} else if(alignment==RIGHT) {
			System.arraycopy(source, 0, result, diff, length-diff);
		} else if(alignment==CENTER) {
			System.arraycopy(source, 0, result, diff/2, length-diff);
		}
	
		return new String(result);
	}
}