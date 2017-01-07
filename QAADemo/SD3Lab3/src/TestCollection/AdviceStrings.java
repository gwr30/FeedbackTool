package TestCollection;

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
		
		return "Methods are created inside classes in the following format: \n"
				+ "[Modifiers] [Return Type] [Method Name] ([Arguments]){}\n"
				+ "Modifiers are optional and include keywords such as public/private or abstract.\n"
				+ "The Return Type is not optional; if the method returns nothing put void.\n"
				+ "The Method Name must be unique and conventionally begins with a lower case letter.\n"
				+ "Arguments are the variables the method takes such as String mystring or int myInt.\n"
				+ "They should be surrounded by brackets and sepertated with commas.\n"
				+ "If there are no arguments put empty brackets e.g () .\n"
				+ "The body of the method goes inside the curly brackets.";
	}

}
