package TestLibrary;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;





import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

public class MethodInfo {
	
	
	//This Method returns a list of names of the methods that a class contains
	public static ArrayList<String> showMethods(String className)throws Exception{
		
		ArrayList<String> methodList = new ArrayList<String>();
		
		InputStream in=MethodInfo.class.getResourceAsStream(className);
		 ClassReader cr = new ClassReader(in);
	        ClassNode cn = new ClassNode();
	        cr.accept(cn, ClassReader.SKIP_DEBUG);
	        List<MethodNode> methods = cn.methods;
	        for (int i = 0; i < methods.size(); ++i) {
	            MethodNode method = methods.get(i);
	            if(method.name != null)
	            	methodList.add(method.name);
	            
	            
	        }
		
		return methodList;
	}
	
	
	//This Method returns a list of names of methods that call themselves in a given class
	public List<String> showSelfCallingMethods(String className) throws Exception{
		List<String> methodList = null;
		
		InputStream in=MethodInfo.class.getResourceAsStream(className);
		 ClassReader cr = new ClassReader(in);
	        ClassNode cn = new ClassNode();
	        cr.accept(cn, ClassReader.SKIP_DEBUG);
	        
	        
	        List<MethodNode> methods = cn.methods;
	        for (int i = 0; i < methods.size(); ++i) {
	            MethodNode method = methods.get(i);
	            
	            if (method.instructions.size() > 0) {
	            	
	            	   
	            	InsnList instructions = method.instructions;
	            	ListIterator insIterator = instructions.iterator();
	            	while(insIterator.hasNext()){
	            		AbstractInsnNode instruction = (AbstractInsnNode) insIterator.next();
	            		if (instruction.toString().contains("MethodInsnNode")){
	            			MethodInsnNode methInsn = (MethodInsnNode) instruction;
	            			//System.out.println(methInsn.name);
	            			if (methInsn.name.equals(method.name)){
	            				methodList.add(method.name);
	            			}
	            		}
	            		
	            		
	            	}
	            	
	            }
	        }
		
		return methodList;
	}
	
	//This Method returns true if a given method in a given class calls itself
	public static boolean callsSelf(String className, String methodName)throws Exception{
		boolean doesCallSelf = false;
		
		
		InputStream in=MethodInfo.class.getResourceAsStream(className);
		 ClassReader cr = new ClassReader(in);
	        ClassNode cn = new ClassNode();
	        cr.accept(cn, ClassReader.SKIP_DEBUG);
	        
	        
	        List<MethodNode> methods = cn.methods;
	        for (int i = 0; i < methods.size(); ++i) {
	            MethodNode method = methods.get(i);
	            if(method.name.equals(methodName)){
		            if (method.instructions.size() > 0) {
		            	
		            	  
		            	InsnList instructions = method.instructions;
		            	ListIterator insIterator = instructions.iterator();
		            	while(insIterator.hasNext()){
		            		AbstractInsnNode instruction = (AbstractInsnNode) insIterator.next();
		            		if (instruction.toString().contains("MethodInsnNode")){
		            			MethodInsnNode methInsn = (MethodInsnNode) instruction;
		            			//System.out.println(methInsn.name);
		            			if (methInsn.name.equals(method.name)){
		            				doesCallSelf = true;
		            			}
		            		}
		            		
		            		
		            	}
		            	
		            }
	            }
	        }
		
		return doesCallSelf;
	}
	//This method searches an array of methods for a method thats name matches the given String
	public static Method findMethod(Method[] methods, String name) {
		for(Method element : methods){
			if((element.getName()).equals(name)){
				return element;
			}
		}
		return null;
	}
	
	//This methods returns an array of the declared methods in a given class
	public static Method[] declaredMethods(Class myclass){
		Method[] methods = myclass.getDeclaredMethods();
		return methods;
	}
	
	//This method returns an iterator across a list of methods
	public static Iterator methodListIterator(Class myclass, String packagename, String classname, Feedback f){
		
		try {
			
			//Method[] methods = myclass.getDeclaredMethods();
			//format is "SD3Labs/Lab3Part1.class"
			ArrayList<String> methodsList = showMethods("/"+packagename+"/"+classname+".class");//"/"+packageName+"/"+className+".class"
			
			Iterator<String> it = methodsList.iterator();
		
			
			return it;
			//System.out.println("Lab 3 Part 1.1");
			/*while(it.hasNext()){
				
				String currentMethodName = it.next();
				if(!currentMethodName.equals("<init>")){
					Method currentMethod = MethodInfo.findMethod(methods, currentMethodName);
					currentMethod.setAccessible(true);
					int[] inputs = {15};
					System.out.println("Examining method "+currentMethodName+"...");
				
				}
			}*/
		} catch (Exception e) {
			//AdvicePopUp.showAdvice(AdviceStrings.methodAdvice());
			f.addFeedbackln(AdviceStrings.methodAdvice());
			System.out.println(AdviceStrings.methodAdvice());
		}
		return null;
	}
	

}
