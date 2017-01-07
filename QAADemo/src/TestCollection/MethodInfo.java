package TestCollection;

import java.io.InputStream;
import java.util.ArrayList;
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
	
	

}
