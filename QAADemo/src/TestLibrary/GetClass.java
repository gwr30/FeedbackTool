package TestLibrary;

import java.lang.reflect.Method;

public class GetClass {
	
	public static Class getClass(String className, Feedback f){
		try{
			
			Class myclass = Class.forName(className);
			return myclass;
			//Method[] methods = myclass.getDeclaredMethods();
			
		} catch (Exception e){
			f.addFeedbackln(AdviceStrings.classAdvice());
			//AdvicePopUp.showAdvice(AdviceStrings.classAdvice());
			System.out.println(AdviceStrings.classAdvice());
		}
		return null;
	}

}
