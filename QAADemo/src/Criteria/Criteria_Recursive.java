package Criteria;

import java.io.InputStream;
import TestCollection.*;
import TestLibrary.*;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ListIterator;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

public class Criteria_Recursive extends Criteria {
	
	boolean fufils_criteria;
	
	AnswerList answers;
	static String classPath; 
	//String methodName;
	
	public Criteria_Recursive(float w,  Feedback f, String cPath){
		super(w);//weight = w;
		feedback = new Feedback();
		answers = new AnswerList();
		classPath = cPath;
		//methodName = mn;
	}
	
	
	//This Method returns true if a given method in a given class calls itself
		public static boolean checkIfRecursive(String mName)throws Exception{
			boolean doesCallSelf = false;
			
			
			InputStream in=MethodInfo.class.getResourceAsStream(classPath);
			 ClassReader cr = new ClassReader(in);
		        ClassNode cn = new ClassNode();
		        cr.accept(cn, ClassReader.SKIP_DEBUG);
		        
		        
		        List<MethodNode> methods = cn.methods;
		        for (int i = 0; i < methods.size(); ++i) {
		            MethodNode method = methods.get(i);
		            if(method.name.equals(mName)){
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
		
		public Answer testCriteria(String methodName, Method method) {
			Answer ans;
			try {
				if(checkIfRecursive(methodName)==true){
					
					return  ans = new Answer(1, methodName, 1, "Method calls itself, indicating it is recursive.", weight);
					//answers.addAnswer(ans);
				}
				else{
					
					return  ans = new Answer(0, methodName, 1, AdviceStrings.notRecursive(), weight);
					//answers.addAnswer(ans);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
			
			
			//return answers;
			
		}
		
	// Getter and Setter Methods
		public void setWeight(float f){
			weight = f;
		}
		
		public float getWeight(){
			return weight;
		}
		
		public boolean queryFulfiled(){
			return fufils_criteria;
		}


		

}
