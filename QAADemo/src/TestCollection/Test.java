package TestCollection;

import java.util.ArrayList;

abstract class Test {
	
	float maxScore;
	float currentScore;
	Feedback feedback;


	public Test(){
		
		feedback = new Feedback();
		currentScore =0;
		maxScore = 0;
		
	}
	
	public Test(float f){
		
		feedback = new Feedback();
		currentScore =0;
		maxScore = f;
		
	}
	
	public void display_feedback(){
		AdvicePopUp.showAdvice(feedback.getFeedback());
	}
	
	public float getmaxScore(){
		return maxScore;
	}
	
	public void setmaxScore(float f){
		maxScore = f;
	}
	
	abstract AnswerList run_test();
	

}
