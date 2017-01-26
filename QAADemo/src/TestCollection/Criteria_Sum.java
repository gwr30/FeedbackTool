package TestCollection;


import java.lang.reflect.Method;


public class Criteria_Sum extends Criteria{
	
	int[] input;
	Object myClassInstance;
	int input_length;
	int correct_answers;
	AnswerList answers;
	Answer ans;
	
	public Criteria_Sum(float w, int[] i, Object mci, Feedback f){
		super(w); //weight
		input = i;
		myClassInstance = mci;
		feedback = new Feedback();
		correct_answers=0;
		answers = new AnswerList();
		
	}

	
	public Answer testCriteria(String methodName, Method currentMethod) //throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	{	
		
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
							+ "Expected outcome was:  " +target + "\n"
							+ "Actual outcome was: "+actual+"\n"
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
			//AdvicePopUp.showAdvice(AdviceStrings.methodAdvice());
			//System.out.println(AdviceStrings.methodAdvice());
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
