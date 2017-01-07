package TestCollection;

public class Answer {
	
	int level;
	String methodName;
	
	public Answer(int l, String m){
		level=l;
		methodName=m;
	}
	
	public String getName(){
		return methodName;
	}
	
	public int getLevel(){
		return level;
	}

}
