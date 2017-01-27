package TestCollection;

import java.lang.reflect.Method;

public class Criteria_Fibonacci extends Criteria{
	
	int[] input;
	Object myClassInstance;
	int input_length;
	int correct_answers;
	AnswerList answers;
	Answer ans;
	
	public Criteria_Fibonacci(float w, int[] i, Object mci, Feedback f){
		super(w); //weight
		input = i;
		myClassInstance = mci;
		feedback = new Feedback();
		correct_answers=0;
		answers = new AnswerList();
		
	}

	
	public Answer testCriteria(String methodName, Method currentMethod) 
	{	
		
		feedback.addFeedbackln("Checking sum criteria....");
			
		try{
				for(int i =0; i<input.length; i++){
					int target = fibonacci(input[i]);					
					int actual = (int)currentMethod.invoke(myClassInstance, input[i]);
					
					if ( target == actual){
						correct_answers++;
					}
					
					feedback.addFeedbackln(
							"Input was:  "+ input[i] +"<br>"
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
			ans=ans=new Answer(correct_answers, methodName,input.length, feedback.getFeedback(), weight);
			
		}
		
		return ans;
	}
	
	
	
	 
	
	public int fibonacci(int n)  {
	    if(n == 0)
	        return 0;
	    else if(n == 1)
	      return 1;
	   else
	      return fibonacci(n - 1) + fibonacci(n - 2);
	}
	 

}