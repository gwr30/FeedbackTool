package TestCollection;

//import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.Iterator;

public class Criteria_Sum extends Criteria{
	
	int[] input;
	Object myClassInstance;
	int input_length;
	int correct_answers;
	AnswerList answers;
	Answer ans;
	
	public Criteria_Sum(float w, int[] i, Object mci, Feedback f){
		super(w);//weight = w;
		input = i;
		//int input_length = i.length;
		myClassInstance = mci;
		//feedback =f;
		feedback = new Feedback();
		correct_answers=0;
		answers = new AnswerList();
		//String feedTemp;
	}

	
	public Answer testCriteria(Method currentMethod) //throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	{	
		//ArrayList result = new ArrayList();
		feedback.addFeedbackln("Checking sum criteria....");
			
		try{
				for(int i =0; i<input.length; i++){
					int target = sum(input[i]);
					
					
					int actual = (int)currentMethod.invoke(myClassInstance, input[i]);
					
					if ( target == actual){
						correct_answers++;
					}
					
					feedback.addFeedbackln(
							"Input was:  "+ input[i] +"\n"
							+ "Expected outcome was:  "+target + "\n"
							+ "Actual outcome was: "+actual+"\n"
						);
			
				}
				
				feedback.addFeedbackln(correct_answers + " out of " + (input.length) + " correct.");
				ans=new Answer(correct_answers, "",input.length, feedback.getFeedback());

				correct_answers = 0;
				feedback.clear();
			
		}
		catch (Exception e) {
			AdvicePopUp.showAdvice(AdviceStrings.methodAdvice());
			System.out.println(AdviceStrings.methodAdvice());
		}
		
		return ans;
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
