package TestCollection;

import java.lang.reflect.Method;

public class GetClass {
	
	public Class getClass(String className){
		try{
			
			Class myclass = Class.forName("SD3Labs."+className);
			return myclass;
			//Method[] methods = myclass.getDeclaredMethods();
			
		} catch (Exception e){
			AdvicePopUp.showAdvice(AdviceStrings.classAdvice());
			System.out.println(AdviceStrings.classAdvice());
		}
		return null;
	}

}
