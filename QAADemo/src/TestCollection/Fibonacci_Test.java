package TestCollection;

import java.util.ArrayList;
import java.util.Iterator;

import Criteria.*;

import TestLibrary.*;

public class Fibonacci_Test extends Test{
	Criteria first_criteria; 
	Criteria second_criteria;
	Iterator<String> method_it;
	
	String highest_scoring_method;
	float tempScore = (float)0.0;


	
	public Fibonacci_Test(Float maxScore, String packagename, String className, int[] input) throws InstantiationException, IllegalAccessException{
		
		super (maxScore,packagename,className);
		float weight1 = (float) 0.5;
	
		
		first_criteria = new Criteria_Fibonacci(weight1, input, myClassInstance, feedback);
		second_criteria = new Criteria_Recursive(weight1, feedback, classpath);
		
		criterion= new ArrayList<Criteria>();
		criterion.add(first_criteria);
		criterion.add(second_criteria);
		
	}

}
