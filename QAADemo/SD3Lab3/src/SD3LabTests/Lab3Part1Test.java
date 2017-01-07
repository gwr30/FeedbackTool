package SD3LabTests;



import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;

//import org.reflections.*;







import SD3Labs.Lab3Part1;

import org.junit.Before;
import org.junit.Test;

import TestCollection.AdviceStrings;
import TestCollection.Answer;
import TestCollection.AnswerList;
import TestCollection.MethodInfo;

public class Lab3Part1Test {
	
	double score = 0.0;
	boolean isRecursive = false;
	boolean correctAnswer = false;
	AnswerList answerList=new AnswerList();
	String className= "Lab3Part1";
	String packageName = "SD3Labs";
	

	@Test
	public void test1() throws ClassNotFoundException {
		int x =6;
		//System.out.println("got here");
		try{
		
			Class myclass = Class.forName("SD3Labs."+className);
			Method[] methods = myclass.getDeclaredMethods();
			
			try {
				ArrayList<String> methodsList = MethodInfo.showMethods("/"+packageName+"/"+className+".class");
				Iterator<String> it = methodsList.iterator();
				System.out.println("Lab 3 Part 1.1");
				while(it.hasNext()){
					String currentMethodName = it.next();
					if(!currentMethodName.equals("<init>")){
						Method currentMethod = findMethod(methods, currentMethodName);
						System.out.println("Examining method "+currentMethodName+"...");
						try{
							
							boolean test1= ((int)currentMethod.invoke(null,5) == 15);
							boolean test2=((int)currentMethod.invoke(null,1) == 1);
							boolean test3=((int)currentMethod.invoke(null,0) == 0);
							boolean allTest=(test1&&test2&&test3);
							boolean partial = ((test1||test2||test3)&&(!allTest));
							
							/*
							 * Answer level 0: No correct answers.
							 * Answer level 1: Some correct answers. Not recursive.
							 * Answer level 2: All correct answers. Not recursive.
							 * Answer level 3: Partial correct Answers. Recursive.
							 * Answer level 4: All correct answers. Recursive.
							 */
							
							if(allTest&&MethodInfo.callsSelf("/"+packageName+"/"+className+".class",currentMethodName)){
								answerList.addAnswer(new Answer(4,currentMethodName));
							}
							else if(partial&&MethodInfo.callsSelf("/"+packageName+"/"+className+".class",currentMethodName)){
								answerList.addAnswer(new Answer(3,currentMethodName));
							}
							else if(allTest){
								answerList.addAnswer(new Answer(2,currentMethodName));
							}
							else if(partial){
								answerList.addAnswer(new Answer(1,currentMethodName));
							}				
						}
						catch(Exception e){
							
						}
						
					}
				}
			} catch (Exception e) {
			
				System.out.println(AdviceStrings.methodAdvice());
			}
		} catch (Exception e){
			System.out.println(AdviceStrings.classAdvice());
		}
		
		int lvl = answerList.getHighestLevel();
		if(lvl==0){
			System.out.println("No method was found that recursively calculated the sum of numbers.");
			System.out.println(AdviceStrings.methodAdvice());
		}
		else if(lvl==1){
			System.out.println("The following methods return some expected answers, but not all. \n"
					+ "The method does not call itself so does not appear to be recursive. \n"
					+ "Check edge cases such as an input of 0 are accounted for.");
			answerList.printList();
		}
		else if(lvl==2){
			System.out.println("The following methods return the results expected for all\n"
					+"all the given input, however the method does\n"
					+ "not call itself so does not appear to be recursive. ");
			answerList.printList();
		}
		else if(lvl==3){
			System.out.println("The following methods return some expected answers, but not all. \n"
					+ "The methods do call themselves suggesting it is recursive. \n"
					+ "Check edge cases such as an input of 0 are accounted for.");
			answerList.printList();
			//score = score + 1.0;
		}
		else if(lvl==4){
			System.out.println("Success. The following methods return the results expected of the given\ninput and call themselves,\n"
					+ " suggesting they are recursive:");
			answerList.printList();
			//addScore(2.0);
		}
	}
	
	//Multiplication through addition test
	@Test
	public void test2() throws ClassNotFoundException {
		int x =6;
		try{
			Class myclass = Class.forName(packageName+"."+className);
			Method[] methods = myclass.getDeclaredMethods();
			
			try {
				ArrayList<String> methodsList = MethodInfo.showMethods("/"+packageName+"/"+className+".class");
				Iterator<String> it = methodsList.iterator();
				System.out.println("Lab 3 Part 1.2");
				while(it.hasNext()){
					String currentMethodName = it.next();
					if(!currentMethodName.equals("<init>")){
						Method currentMethod = findMethod(methods, currentMethodName);
						System.out.println("Examining method "+currentMethodName+"...");
						try{
							
							boolean test1= ((int)currentMethod.invoke(null,16,19) == 304);
							boolean test2=((int)currentMethod.invoke(null,1,1) == 1);
							boolean test3=((int)currentMethod.invoke(null,5,5) == 25);
							boolean allTest=(test1&&test2&&test3);
							boolean partial = ((test1||test2||test3)&&(!allTest));
							
							/*
							 * Answer level 0: No correct answers.
							 * Answer level 1: Some correct answers. Not recursive.
							 * Answer level 2: All correct answers. Not recursive.
							 * Answer level 3: Partial correct Answers. Recursive.
							 * Answer level 4: All correct answers. Recursive.
							 */
							
							if(allTest&&MethodInfo.callsSelf("/"+packageName+"/"+className+".class",currentMethodName)){
								answerList.addAnswer(new Answer(4,currentMethodName));
							}
							else if(partial&&MethodInfo.callsSelf("/"+packageName+"/"+className+".class",currentMethodName)){
								answerList.addAnswer(new Answer(3,currentMethodName));
							}
							else if(allTest){
								answerList.addAnswer(new Answer(2,currentMethodName));
								score = score + 2.0;
							}
							else if(partial){
								answerList.addAnswer(new Answer(1,currentMethodName));
							}				
						}
						catch(Exception e){
							
						}
						
					}
				}
			} catch (Exception e) {
				//fail("Unable to get list of methods");
				System.out.println(AdviceStrings.methodAdvice());
			}
		} catch (Exception e){
			System.out.println(AdviceStrings.classAdvice());
		}
		//assertEquals(SumOfNumbers.sum(x),21);
		int lvl = answerList.getHighestLevel();
		if(lvl==0){
			System.out.println("No method was found that recursively calculated the sum of numbers.");
			System.out.println(AdviceStrings.methodAdvice());
		}
		else if(lvl==1){
			System.out.println("The following methods return some expected answers, but not all. \n"
					+ "The method does not call itself so does not appear to be recursive. \n"
					+ "Check edge cases such as an input of 0 are accounted for.");
			answerList.printList();
		}
		else if(lvl==2){
			System.out.println("The following methods return the results expected for all\n"
					+"all the given input, however the method does\n"
					+ "not call itself so does not appear to be recursive. ");
			answerList.printList();
		}
		else if(lvl==3){
			System.out.println("The following methods return some expected answers, but not all. \n"
					+ "The methods do call themselves suggesting it is recursive. \n"
					+ "Check edge cases such as an input of 0 are accounted for.");
			answerList.printList();
			//score = score+1;
		}
		else if(lvl==4){
			System.out.println("Success. The following methods return the results expected of the given\ninput and call themselves,"
					+ " suggesting they are recursive:");
			answerList.printList();
			//addScore(2.0);
			
		}
	}
	
	//Fibonacci number test
	@Test
	public void test3() throws ClassNotFoundException {
		int x =6;
		try{
			Class myclass = Class.forName(packageName+"."+className);
			Method[] methods = myclass.getDeclaredMethods();
			
			try {
				ArrayList<String> methodsList = MethodInfo.showMethods("/"+packageName+"/"+className+".class");
				Iterator<String> it = methodsList.iterator();
				System.out.println("Lab 3 Part 1.3");
				while(it.hasNext()){
					String currentMethodName = it.next();
					if(!currentMethodName.equals("<init>")){
						Method currentMethod = findMethod(methods, currentMethodName);
						System.out.println("Examining method "+currentMethodName+"...");
						try{
							
							boolean test1= ((int)currentMethod.invoke(null,0) == 0);
							boolean test2=((int)currentMethod.invoke(null,1) == 1);
							boolean test3=((int)currentMethod.invoke(null,3) == 2);
							boolean test4=((int)currentMethod.invoke(null,10) == 55);
							boolean allTest=(test1&&test2&&test3&&test4);
							boolean partial = ((test1||test2||test3||test4)&&(!allTest));
							
							/*
							 * Answer level 0: No correct answers.
							 * Answer level 1: Some correct answers. Not recursive.
							 * Answer level 2: All correct answers. Not recursive.
							 * Answer level 3: Partial correct Answers. Recursive.
							 * Answer level 4: All correct answers. Recursive.
							 */
							
							if(allTest&&MethodInfo.callsSelf("/"+packageName+"/"+className+".class",currentMethodName)){
								answerList.addAnswer(new Answer(4,currentMethodName));
							}
							else if(partial&&MethodInfo.callsSelf("/"+packageName+"/"+className+".class",currentMethodName)){
								answerList.addAnswer(new Answer(3,currentMethodName));
							}
							else if(allTest){
								answerList.addAnswer(new Answer(2,currentMethodName));
							}
							else if(partial){
								answerList.addAnswer(new Answer(1,currentMethodName));
							}				
						}
						catch(Exception e){
							
						}
						
					}
				}
			} catch (Exception e) {
				//fail("Unable to get list of methods");
				System.out.println(AdviceStrings.methodAdvice());
			}
		} catch (Exception e){
			System.out.println(AdviceStrings.classAdvice());
		}
		//assertEquals(SumOfNumbers.sum(x),21);
		int lvl = answerList.getHighestLevel();
		if(lvl==0){
			System.out.println("No method was found that recursively calculated the correct number found at the given position in the Fibonacci sequence.");
			System.out.println(AdviceStrings.methodAdvice());
		}
		else if(lvl==1){
			System.out.println("The following methods return some expected answers, but not all. "
					+ "The method does not call itself so does not appear to be recursive. "
					+ "Check edge cases such as an input of 0 are accounted for.");
			answerList.printList();
		}
		else if(lvl==2){
			System.out.println("The following methods return the results expected for all\n"
					+"all the given input, however the method does\n"
					+ "not call itself so does not appear to be recursive. ");
			answerList.printList();
		}
		else if(lvl==3){
			System.out.println("The following methods return some expected answers, but not all. \n"
					+ "The methods do call themselves suggesting it is recursive. \n"
					+ "Check edge cases such as an input of 0 are accounted for.");
			answerList.printList();
			//score = score + 0.5;
		}
		else if(lvl==4){
			System.out.println("Success. The following methods return the results expected of the given\ninput and call themselves,"
					+ " suggesting they are recursive:");
			answerList.printList();	
			//addScore(1.0);
			
		}
		//System.out.println("Current Score = " +score+"/5.0");
	}
	
	
	
	Method findMethod(Method[] methods, String name) {
		for(Method element : methods){
			if((element.getName()).equals(name)){
				return element;
			}
		}
		return null;
	}
	
	private void addScore(Double d){
		double s = score;
		score = s+d;
	}

}

