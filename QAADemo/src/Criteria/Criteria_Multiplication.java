package Criteria;

import java.lang.reflect.Method;
import TestCollection.*;
import TestLibrary.*;

public class Criteria_Multiplication extends Criteria{

	int[][] input;
	Object myClassInstance;
	int input_length;
	int correct_answers;
	AnswerList answers;
	Answer ans;
	
	public Criteria_Multiplication(float w, int[][] i, Object mci, Feedback f){
		super(w); //weight
		input = i;
		myClassInstance = mci;
		feedback = new Feedback();
		correct_answers=0;
		answers = new AnswerList();
		
	}

	
	public Answer testCriteria(String methodName, Method currentMethod) //throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	{	
		
		feedback.addFeedbackln("Checking mult criteria....");
			
		try{
				for(int i =0; i<input.length; i++){
					int target = mult(input[i][0], input[i][1]);		
					int actual = (int)currentMethod.invoke(myClassInstance, input[i][0], input[i][1]);
					
					if ( target == actual){
						correct_answers++;
					}
					
					feedback.addFeedbackln(
							"Input was:  "+ input[i][0]+ " and " +input[i][1] +"<br>"
							+ "Expected outcome was:  " +target + "<br>"
							+ "Actual outcome was: "+actual+"<br>"
						);
			
				}
				
				feedback.addFeedbackln(correct_answers + " out of " + (input.length) + " correct.");
				ans=new Answer(correct_answers, methodName,input.length, feedback.getFeedback(), weight);

				correct_answers = 0;
				feedback.clear();
			
		}
		catch (Exception e) {
			feedback.addFeedbackln("Unable to invoke method with the given input.");
			ans=ans=new Answer(correct_answers, methodName,input.length, feedback.getFeedback(), (float)0);
			feedback.clear();
			
		}
		
		return ans;
	}
	
	
	
	 
	
	public int mult(int x, int y){
		 return x*y;
	 }
}
