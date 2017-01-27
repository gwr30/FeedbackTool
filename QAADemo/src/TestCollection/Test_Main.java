/*This is the main method for setting up the test or tests 
that the user wishes to perform on a class or classes at a given path.
The user sets up tests by providing the package and classname 
of the class(es) they wish to test, along with the input they wish 
to test the class(es) against.
*/
package TestCollection;

import java.util.ArrayList;
import TestLibrary.*;

public class Test_Main {


	public static void main (String [] args) throws InstantiationException, IllegalAccessException{
		String packagename="SD3Labs";
		String classname ="Lab3Part1";
		int[] input1 = {0,1,5,15};
		int[][] input2= {{5,5},{10,10},{1,1}};
		float maxScore = (float) 10;
		ArrayList<String> tabs = new ArrayList<String>();
		
		Summation_Test test1 = new Summation_Test(maxScore, packagename, classname, input1);
		test1.run_test();
		tabs.add(test1.display_feedback());
		//AdvicePopUp.showAdvice(test1.display_feedback());
		
		Multiplication_Test test2 = new Multiplication_Test(maxScore, packagename, classname, input2);
		test2.run_test();
		tabs.add(test2.display_feedback());
		//AdvicePopUp.showAdvice(test2.display_feedback());
		
		Pane.go(tabs);
		
		
		
		
		
	}
	
}
