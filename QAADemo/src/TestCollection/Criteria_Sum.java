package TestCollection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Criteria_Sum extends Criteria{
	
	int[] input;
	Object myClassInstance;
	int input_length = input.length;
	int correct_answers;
	
	Criteria_Sum(float w, int[] i, Object mci, Feedback f){
		weight = w;
		input = i;
		myClassInstance = mci;
		feedback = f;
		correct_answers=0;
	}

	
	public boolean testCriteria(Method currentMethod) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		feedback.addFeedbackln("Checking sum criteria....");
		for(int i =0; i<input.length; i++){
			int target = sum(input[i]);
			int actual = (int)currentMethod.invoke(myClassInstance, input[i]);
			
			if ( target == actual){
				correct_answers++;
			}
			else
			{
				feedback.addFeedbackln(
					"\n\nInput was:  "+ input[i] +"\n"
					+ "Expected outcome was:  "+target + "\n"
					+ "Actual outcome was: "+actual+"\n"
				);
			}
		}
		
		feedback.addFeedbackln(correct_answers + " out of " + input_length + " correct.");
		
		if (correct_answers == input_length){
			return true;
		}
		else return false;
	}
	
	
	
	 
	
	public int sum(int x){
		 if(x<=0){
			 return 0;
		 }
		 else{
			 return x + (sum(x-1));
		 }
	 }

}
