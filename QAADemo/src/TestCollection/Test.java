/*
 * This class provides the common elements that make up a test. 
 * Tests are made up of a number of criteria that are checked agains the 
 * methods in a class. A weighting system is uesed to determine which class fufils 
 * the criteria most succesfully, with weaker methods being discarded. This allows 
 * students to have multiple methods in a class and allows them to name these methods 
 * whatever they wish.
 */

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


	public Test(Float mxScore, String pname, String cname){
		
		maxScore = mxScore;
		packageName = pname;
		className = cname;
		feedback = new Feedback();
		//attempts to get an instance of the given class. 
		//Adds feedback via the try catch block if unsucessful.
		try{
			myclass = GetClass.getClass(packageName+"."+className, feedback);
			myClassInstance = myclass.newInstance();
			//attempts to get a list of method objects and their names from the given class. 
			//Adds feedback via the try catch block if unsucessful.
			try{
				method_it = MethodInfo.methodListIterator(myclass, packageName, className ,feedback);
				methods = MethodInfo.declaredMethods(myclass);
			}
			catch(Exception e){
				
			}
				
			classpath = "/"+packageName+"/"+className+".class";
			//Set up a new feedback object that allows feedback to persist and be passed among 
			//the various classes of the feedback tool.
			feedback = new Feedback();
			currentScore =0;
			candidates = new AnswerCandidates();
			
		}
		catch(Exception e){
			feedback.addFeedbackln("Unable to find class of name " + className);
			feedback.close();
		}
				
	}
	

	//Getter and setter methods
	public String display_feedback(){
		return feedback.getFeedback();
	}
	
	public float getmaxScore(){
		return maxScore;
	}
	
	public void setmaxScore(float f){
		maxScore = f;
	}

	//This method takes the methods in a given class and tests them 
	//against all the given criteria. It compares the results, keeping the strongest and discarding
	//weaker ones.
	void run_test() {
		
		try{
			//Go through each method in a class
			while(method_it.hasNext()){
				
				String currentMethodName = method_it.next();
				Answer results;
				
				if(!currentMethodName.equals("<init>")){
					Method currentMethod = MethodInfo.findMethod(methods, currentMethodName);
					currentMethod.setAccessible(true);
					
					//Create an object that can hold multiple results of a methods tests 
					//against the various criteria.
					Method_Test_Results mtr = new Method_Test_Results(currentMethodName);
					
					//New Iterator for the list of provided criteria the methods
					//must be tested against
					Iterator<Criteria> critIt = criterion.iterator();
					
					//Check each criteria agains the current method.
					while(critIt.hasNext()){
						
						Criteria current = critIt.next();
						results = current.testCriteria(currentMethodName, currentMethod);
						
						//Use the Method_Test_Result object to store the results 
						//of the criteria check, comparing the results and keepign the 
						//strongest.
						mtr.addAnswer(results);
					}					
					candidates.addResult(mtr);
					
				}
			}
			
			//Gets information from the answers from methods that performed best 
			//against the given criteria, then adds feedback based on this info. 
			candIt = candidates.iterator();
			while (candIt.hasNext()){
				Method_Test_Results currAn = (Method_Test_Results) candIt.next();
				feedback.addFeedbackln(currAn.getFeedback().getFeedback());
				String scr = Float.toString(currAn.getRanking());
				String s = Float.toString(currAn.getScore(maxScore));
				feedback.addFeedbackln("Score is : "+ s + " out of "+maxScore);
			}
		}
		catch(Exception e){
			feedback.addFeedbackln("Unable to find any methods.");
		}
		
	}
	

}
