package TestCollection;

import java.lang.reflect.Method;
import java.util.Iterator;

public class Summation_Test extends Test {
	
	
	Criteria_Sum first_criteria; 
	Criteria_Recursive second_criteria;
	Iterator<String> method_it;
	Class myclass;
	Method[] methods;
	AnswerList answers1, answers2;
	String highest_scoring_method;
	float tempScore = (float)0.0;
	
	public Summation_Test(Float maxScore, String packagename, String className, int[] input) throws InstantiationException, IllegalAccessException{
		
		super (maxScore);
		myclass = GetClass.getClass(packagename+"."+className, feedback);
		Object myClassInstance = myclass.newInstance();
		method_it = MethodInfo.methodListIterator(myclass, packagename, className ,feedback);
		methods = MethodInfo.declaredMethods(myclass);
		answers1 = new AnswerList();
		answers2 = new AnswerList();
		String classpath = "/"+packagename+"/"+className+".class";
		float weight1 = (float) 0.5;
		
		
		first_criteria = new Criteria_Sum(weight1, input, myClassInstance, feedback);
		
		//   "/"+packageName+"/"+className+".class"
		second_criteria = new Criteria_Recursive(weight1, feedback, classpath);
		
		
	}
	
	
	AnswerList run_test() {
		
		while(method_it.hasNext()){
			
			String currentMethodName = method_it.next();
			if(!currentMethodName.equals("<init>")){
				Method currentMethod = MethodInfo.findMethod(methods, currentMethodName);
				currentMethod.setAccessible(true);
				
				
				
				Answer result1 = first_criteria.testCriteria(currentMethod);
				result1.setName(currentMethodName);
				answers1.addAnswer(result1);
				
				Answer result2 = second_criteria.run_test(currentMethodName);
				result2.setName(currentMethodName);
				answers2.addAnswer(result2);
				
				
				tempScore=((result1.allCorrectInt()*first_criteria.getWeight())* maxScore)+
				((result2.allCorrectInt()*first_criteria.getWeight())* maxScore);
				if(tempScore>currentScore){
					currentScore=tempScore;
					highest_scoring_method = currentMethodName; 
				}
				
			}
		}
		//getScore(answers1);
		//getScore(answers2);
		System.out.println("SCORE = "+currentScore);
		return answers1;
		
	}
	
	void calcScore(AnswerList ans){
		Iterator ansIt1 = answers1.iterator();
		while(ansIt1.hasNext()){
			Answer current = (Answer) ansIt1.next();
			feedback.addFeedbackln(current.getName());
			feedback.addFeedbackln(current.getFeedback());
			currentScore=currentScore+(current.allCorrectInt()*first_criteria.getWeight())* maxScore;
		}
	}
	
	
	

}
