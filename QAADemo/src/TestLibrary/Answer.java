package TestLibrary;

public class Answer {
	
	int level;
	int max;
	float weight;
	String methodName;
	String answerFeedback;
	
	
	public Answer(int l, String m){
		level=l;
		methodName=m;
		max=-1;
		
		
	}
	
	public Answer(int l, String m, int mx, float w){
		level=l;
		methodName=m;
		max=mx;
		weight =w;
		
	}
	
	public Answer(int l, String m, int mx, String f, float w){
		level=l;
		methodName=m;
		answerFeedback=f;
		max=mx;
		weight =w;
	}
	
	public String getName(){
		return methodName;
	}
	
	public void setName(String n){
		methodName = n;
	}
	
	public String getFeedback(){
		return answerFeedback;
	}
	
	public int getLevel(){
		return level;
	}
	
	public int getMax(){
		return max;
	}
	
	public float getWeight(){
		return weight;
	}
	public void setWeight(float f){
		weight = f;
	}
	
	public Boolean allCorrectBool(){
		if(level ==max){
			return true;
		}
		else return false;
	}
	
	public int allCorrectInt(){
		if(level == max){
			return 1;
		}
		else return 0;
	}


}
