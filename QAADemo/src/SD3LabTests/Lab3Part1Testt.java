package SD3LabTests;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
//import org.objectweb.asm.commons.*;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;

//import org.reflections.*;









import SD3Labs.Lab3Part1;

import org.junit.Test;

import TestCollection.AdvicePopUp;
import TestCollection.AdviceStrings;
import TestCollection.Answer;
import TestCollection.AnswerList;
import TestCollection.MethodInfo;

public class Lab3Part1Testt {
	
	static float score = 0;
	boolean isRecursive = false;
	boolean correctAnswer = false;
	static AnswerList answerList=new AnswerList();
	static String className= "Lab3Part1";
	static String packageName = "SD3Labs";
	static int answer1,answer2,answer3;
	
	public static void main(String []args) throws ClassNotFoundException{
		labTest1();
		//labTest2();
		//labTest3();
		
		
		
	}

	
	public static void labTest1() throws ClassNotFoundException {
		int x =6;
		
		try{
		
			Class myclass = Class.forName("SD3Labs."+className);
			Method[] methods = myclass.getDeclaredMethods();
			//System.out.println(methods.toString());
			
			Object t = myclass.newInstance();
			
			try {
				ArrayList<String> methodsList = MethodInfo.showMethods("/"+packageName+"/"+className+".class");
				//System.out.println(methodsList.toString());
				Iterator<String> it = methodsList.iterator();
				System.out.println("Lab 3 Part 1.1");
				while(it.hasNext()){
					
					String currentMethodName = it.next();
					if(!currentMethodName.equals("<init>")){
						Method currentMethod = findMethod(methods, currentMethodName);
						System.out.println("++++++++++++++++++++++"+currentMethod.toString());
						currentMethod.setAccessible(true);
						int[] inputs = {15};
						System.out.println("Examining method "+currentMethodName+"...");
						//////////////////////////////////////////testcode
						int foo = (int) currentMethod.invoke(t, inputs[0]);
						System.out.println("lickety split");
						System.out.println(foo);
						
						///////////////////////////////////////////testcode
						
						try{
							System.out.println("here");
							//System.out.println("///////////////////////////"+currentMethod.invoke(5));
							int[] input = {5,1,0};
							boolean test1= ((int)currentMethod.invoke(t,input[0]) == 15);
							
							answer1 = (int)currentMethod.invoke(t,input[0]);
							System.out.println("----------------------"+answer1);
							boolean test2=((int)currentMethod.invoke(t,input[1]) == 1);
							answer2 = (int)currentMethod.invoke(t,input[1]);
							boolean test3=((int)currentMethod.invoke(t,input[2]) == 0);
							answer3 = (int)currentMethod.invoke(t,input[2]);
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
				AdvicePopUp.showAdvice(AdviceStrings.methodAdvice());
				System.out.println(AdviceStrings.methodAdvice());
			}
		} catch (Exception e){
			AdvicePopUp.showAdvice(AdviceStrings.classAdvice());
			System.out.println(AdviceStrings.classAdvice());
		}
		
		int lvl = answerList.getHighestLevel();
		if(lvl==0){
			
			AdvicePopUp.showAdvice("No method was found.\n"+AdviceStrings.methodAdvice());
			System.out.println("No method was found that recursively calculated the sum of numbers.");
			System.out.println(AdviceStrings.methodAdvice());
		}
		else if(lvl==1){
			AdvicePopUp.showAdvice("The following methods return some expected answers, but not all: "
					+ answerList.returnList()
					+ "\n\nInput was:  5\n"
					+ "Expected outcome was:  15\n"
					+ "Actual outcome was: "+answer1+"\n"
					+ "Input was:  1\n"
					+ "Expected outcome was:  1\n"
					+ "Actual outcome was: "+answer2+"\n"
					+ "Input was:  0\n"
					+ "Expected outcome was:  0\n"
					+ "Actual outcome was: "+answer2+"\n"
					+ "\nThe method does not call itself so does not appear to be recursive.\n "
					+ "Try starting with a base case. Ask yourself what the final state is that will make\n"
					+ "the recursive method stop calling itself. Without a base case the method will call itself forever.\n"
					+ "Also be cautious of using while or for loops. Using recursion should prevent the need for these \n"
					+ "and having them may be an indication that your solution is not recursive.\n"
					+ "Check edge cases such as an input of 0 are accounted for.\n"+answerList.returnList());
			
			System.out.println("The following methods return some expected answers, but not all. "
					+ "The method does not call itself so does not appear to be recursive. "
					+ "Check edge cases such as an input of 0 are accounted for.");
			answerList.printList();
		}
		else if(lvl==2){
			
			AdvicePopUp.showAdvice("The following methods return the results expected for\n"
					+"all the given input, however the method does\n"
					+ "not call itself so does not appear to be recursive.\n "
					+answerList.returnList()
					+ "\n\nTry starting with a base case. Ask yourself what the final state is that will make\n"
					+ "the recursive method stop calling itself. Without a base case the method will call itself forever.\n"
					+ "Also be cautious of using while or for loops. Using recursion should prevent the need for these \n"
					+ "and having them may be an indication that your solution is not recursive.\n"
					);
			
			System.out.println("The following methods return the results expected for\n"
					+"all the given input, however the method does\n"
					+ "not call itself so does not appear to be recursive.\n "+answerList.returnList());
			answerList.printList();
		}
		else if(lvl==3){
			AdvicePopUp.showAdvice("The following methods return some expected answers, but not all. "
					+ "The methods do call themselves suggesting it is recursive. "
					+ "Check edge cases such as an input of 0 are accounted for.\n"+answerList.returnList());
			
			System.out.println("The following methods return some expected answers, but not all. "
					+ "The methods do call themselves suggesting it is recursive. "
					+ "Check edge cases such as an input of 0 are accounted for.");
			answerList.printList();
			score = score+1;
		}
		else if(lvl==4){
			
			AdvicePopUp.showAdvice("Success. The following methods return the results expected of the given\ninput and call themselves,"
					+ " suggesting they are recursive:\n" +answerList.returnList());
			System.out.println("Success. The following methods return the results expected of the given\ninput and call themselves,"
					+ " suggesting they are recursive:");
			answerList.printList();
			score = score+2;
		}
	}
	
	
	
	
	
	static Method findMethod(Method[] methods, String name) {
		for(Method element : methods){
			if((element.getName()).equals(name)){
				return element;
			}
		}
		return null;
	}

}


