package TestLibrary;

public class Feedback {
	
	String feedback;
	Boolean open = true;
	
	public Feedback(){
		feedback = "";
	}

	
	public void addFeedback(String f){
		if(open ==true){feedback = feedback +f;}
	}
	
	public void addFeedbackln(String f){
		if (open == true){feedback = feedback + "<br>"+f;}
	}
	
	public String getFeedback(){
		return feedback;
	}
	
	public void setFeedback(String f){
		feedback = f;
	}
	
	public void clear(){
		feedback = "";
	}
	
	public void close(){
		open = false;
	}
	

}
