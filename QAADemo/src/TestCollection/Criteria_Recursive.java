package TestCollection;

import java.io.InputStream;
import java.util.List;
import java.util.ListIterator;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

public class Criteria_Recursive {
	
	float weight;
	boolean fufils_criteria;
	
	
	//This Method returns true if a given method in a given class calls itself
		public static boolean testCriteria(String className, String methodName)throws Exception{
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
