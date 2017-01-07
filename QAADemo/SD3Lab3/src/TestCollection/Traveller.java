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

public class Traveller {
	
	public static void main(String[] args)throws Exception
	{
		InputStream in=Traveller.class.getResourceAsStream("/lab3/recursiveSumOfNumbers.class");
		 ClassReader cr = new ClassReader(in);
	        ClassNode cn = new ClassNode();
	        cr.accept(cn, ClassReader.SKIP_DEBUG);
	        
	        
	        List<MethodNode> methods = cn.methods;
	        for (int i = 0; i < methods.size(); ++i) {
	            MethodNode method = methods.get(i);
	            
	            //System.out.println(method.desc);
	            
	            if (method.instructions.size() > 0) {
	            	//System.out.println(method.instructions.size());
	            	System.out.println("Method: "+method.name);
	            	//System.out.println(method.toString());
	            	InsnList instructions = method.instructions;
	            	ListIterator insIterator = instructions.iterator();
	            	while(insIterator.hasNext()){
	            		AbstractInsnNode instruction = (AbstractInsnNode) insIterator.next();
	            		//System.out.println(instruction.getType());
	            		//System.out.println(instruction.toString());
	            		if (instruction.toString().contains("MethodInsnNode")){
	            			MethodInsnNode methInsn = (MethodInsnNode) instruction;
	            			System.out.println(methInsn.name);
	            			//System.out.println(methInsn.owner);
	            			if (methInsn.name.equals(method.name)){
	            				System.out.println("The method "+method.name+" calls the method "+methInsn.name+" and is therefore recursive");
	            			}
	            		}
	            		
	            		
	            	}
	            	
	            }
	        }
		
	}

}
