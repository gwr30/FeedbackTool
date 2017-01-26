package TestCollection;

import java.lang.reflect.Method;
import java.util.ArrayList;

abstract class Test {
	
	float maxScore;
	float currentScore;
	Feedback feedback;
	Class myclass;
	Method[] methods;


	public Test(){
		
		maxScore = 0;
		feedback = new Feedback();
		currentScore =0;
				
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
	
	abstract void run_test();
	

}
