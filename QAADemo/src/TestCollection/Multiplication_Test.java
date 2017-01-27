package TestCollection;

import java.util.ArrayList;
import Criteria.*;
import TestLibrary.*;
import java.util.Iterator;

public class Multiplication_Test  extends Test {
	
	
	Criteria first_criteria; 
	Criteria second_criteria;
	Iterator<String> method_it;
	
	String highest_scoring_method;
	float tempScore = (float)0.0;


	
	public Multiplication_Test(Float maxScore, String packagename, String className, int[][] input) throws InstantiationException, IllegalAccessException{
		
		super (maxScore,packagename,className);
		float weight1 = (float) 0.5;
	
		
		first_criteria = new Criteria_Multiplication(weight1, input, myClassInstance, feedback);
		second_criteria = new Criteria_Recursive(weight1, feedback, classpath);
		
		criterion= new ArrayList<Criteria>();
		criterion.add(first_criteria);
		criterion.add(second_criteria);
		
	}
	

	
	

}
