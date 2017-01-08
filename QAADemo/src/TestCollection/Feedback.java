package TestCollection;

public class Feedback {
	
	String feedback;
	
	public Feedback(){
		feedback = "";
	}

	
	public void addFeedback(String f){
		feedback = feedback +f;
	}
	
	public void addFeedbackln(String f){
		feedback = feedback + "\n"+f;
	}
	
	public String getFeedback(){
		return feedback;
	}
	
	public void setFeedback(String f){
		feedback = f;
	}
	

}
