package awt.ex1000.sungjuk.e6;

public class Format {
	final static int LEFT=0;
	final static int CENTER=1;
	final static int RIGHT=2;
	
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
