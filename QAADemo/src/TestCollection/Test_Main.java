package TestCollection;

public class Test_Main {

	public static void main (String [] args) throws InstantiationException, IllegalAccessException{
		//Format = "SD3Labs.Lab3Part1"
		String packagename="SD3Labs";
		String classname ="Lab3Part1";
		int[] input = {0,1,5,15};
		float maxScore = (float) 10;
		
		Summation_Test test1 = new Summation_Test(maxScore, packagename, classname, input);
		test1.run_test();
		test1.display_feedback();
	}
	
}
