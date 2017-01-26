package TestCollection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Summation_Test extends Test {
	
	
	Criteria first_criteria; 
	Criteria second_criteria;
	Iterator<String> method_it;
	//AnswerList answers1, answers2;
	String highest_scoring_method;
	float tempScore = (float)0.0;
	//AnswerCandidates candidates;
	//ArrayList<Criteria> criterion;
	
	//Iterator candIt;

	
	public Summation_Test(Float maxScore, String packagename, String className, int[] input) throws InstantiationException, IllegalAccessException{
		
		super (maxScore,packagename,className);
		//myclass = GetClass.getClass(packagename+"."+className, feedback);
		//Object myClassInstance = myclass.newInstance();
		//method_it = MethodInfo.methodListIterator(myclass, packagename, className ,feedback);
		//methods = MethodInfo.declaredMethods(myclass);
		//String classpath = "/"+packagename+"/"+className+".class";
		float weight1 = (float) 0.5;
		//candidates = new AnswerCandidates();
		
		first_criteria = new Criteria_Sum(weight1, input, myClassInstance, feedback);
		second_criteria = new Criteria_Recursive(weight1, feedback, classpath);
		
		criterion= new ArrayList<Criteria>();
		criterion.add(first_criteria);
		criterion.add(second_criteria);
		
	}
	
	
	/*void run_test() {
		
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
		
	}*/
	
	/*void calcScore(AnswerList ans){
		Iterator ansIt1 = answers1.iterator();
		while(ansIt1.hasNext()){
			Answer current = (Answer) ansIt1.next();
			feedback.addFeedbackln(current.getName());
			feedback.addFeedbackln(current.getFeedback());
			currentScore=currentScore+(current.allCorrectInt()*first_criteria.getWeight())* maxScore;
		}
	}*/
	
	
	

}
