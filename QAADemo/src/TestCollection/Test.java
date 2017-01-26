package TestCollection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

abstract class Test {
	
	float maxScore;
	float currentScore;
	Feedback feedback;
	Class myclass;
	Method[] methods;
	Iterator<String> method_it;
	String packageName;
	String className;
	Object myClassInstance;
	String classpath;
	AnswerCandidates candidates;
	ArrayList<Criteria> criterion;
	Iterator candIt;


	public Test(Float mxScore, String pname, String cname)throws InstantiationException, IllegalAccessException{
		
		maxScore = mxScore;
		packageName = pname;
		String className = cname;
		myclass = GetClass.getClass(packageName+"."+className, feedback);
		myClassInstance = myclass.newInstance();
		method_it = MethodInfo.methodListIterator(myclass, packageName, className ,feedback);
		methods = MethodInfo.declaredMethods(myclass);
		classpath = "/"+packageName+"/"+className+".class";
		feedback = new Feedback();
		currentScore =0;
		candidates = new AnswerCandidates();
				
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
	
void run_test() {
		
		while(method_it.hasNext()){
			
			String currentMethodName = method_it.next();
			Answer results;
			
			if(!currentMethodName.equals("<init>")){
				Method currentMethod = MethodInfo.findMethod(methods, currentMethodName);
				currentMethod.setAccessible(true);
				
				Method_Test_Results mtr = new Method_Test_Results(currentMethodName);
				Iterator<Criteria> critIt = criterion.iterator();
				
				while(critIt.hasNext()){
					
					Criteria current = critIt.next();
					results = current.testCriteria(currentMethodName, currentMethod);
					mtr.addAnswer(results);
				}					
				candidates.addResult(mtr);
				
			}
		}
		
		candIt = candidates.iterator();
		while (candIt.hasNext()){
			Method_Test_Results currAn = (Method_Test_Results) candIt.next();
			feedback.addFeedbackln(currAn.getFeedback().getFeedback());
			String scr = Float.toString(currAn.getRanking());
			feedback.addFeedbackln("Score is : "+scr);
		}
		//return answers1;
		
	}
	

}
