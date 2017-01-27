package TestLibrary;

public class AdviceStrings {
	
	public static String classAdvice(){
		return "Classes are declared with the following format: \n"
				+ "[Modifiers] class [Class Name]{}\n"
				+ "Modifiers are optional and include keywords such as public/private or abstract.\n"
				+ "Make sure the Class name in the declaration is exactly the same as the class filename.\n"
				+ "e.g if you have a class file called Person then your decleration would be something like\n"
				+ "public class Person{}\n"
				+ "Class names begin with an upper-case letter by convention.\n"
				+ "Inside the curly brackets put the class variables and the methods.";
	}
	
	public static String methodAdvice(){
		
		return "Methods are created inside classes in the following format: <br><br>"
				+ "[Modifiers] [Return Type] [Method Name] ([Arguments]){}<br><br>"
				+ "For example:<br><br>"
				+ "public void helloWorld(){"
				+ "\n   System.out.println(\"Hello Wordl\");<br>}<br><br>"
				+ "Modifiers are optional and include keywords such as public/private or abstract.<br>"
				+ "The Return Type is not optional; if the method returns nothing put void.<br>"
				+ "The Method Name must be unique and conventionally begins with a lower case letter.<br>"
				+ "Arguments are the variables the method takes such as String mystring or int myInt.<br>"
				+ "They should be surrounded by brackets and sepertated with commas.<br>"
				+ "If there are no arguments put empty brackets e.g () .<br>"
				+ "The body of the method goes inside the curly brackets.";
	}
	
	public static String partAnsNonRec(){
		return "The following methods return some expected answers, but not all. "
				+ "The method does not call itself so does not appear to be recursive. "
				+ "Check edge cases such as an input of 0 are accounted for.";
	}
	
	public static String notRecursive(){
		return  "The method does not call itself so does not appear to be recursive.<br> "
				+ "Recursive methods call themselves.<br>"+
				"Start by working out what your base case is. This is the "+
				"case in which the method will stop calling itself. Without a base "+
				"case a recursive method will call itself indefinitely.";
	}

}
