package TestCollection;

public class Test_Main {

	public static void main (String [] args) throws InstantiationException, IllegalAccessException{
		String packagename="SD3Labs";
		String classname ="Lab3Part1";
		int[] input1 = {0,1,5,15};
		int[][] input2= {{5,5},{10,10},{1,1}};
		float maxScore = (float) 10;
		
		Summation_Test test1 = new Summation_Test(maxScore, packagename, classname, input1);
		test1.run_test();
		test1.display_feedback();
		
		Multiplication_Test test2 = new Multiplication_Test(maxScore, packagename, classname, input2);
		test2.run_test();
		test2.display_feedback();
		
		
		
		
		
		
	}
	
}
