package TestCollection;

import java.lang.reflect.Method;

abstract class Criteria {
	
	float weight;
	boolean fulfils_criteria;
	Feedback feedback;
	AnswerList answers;
	
	Criteria(){
		
	}
	
	Criteria(float w){
		weight = w;
		fulfils_criteria= false;
		
	}
	
		//abstract boolean testCriteria();
	
	// Getter and Setter Methods
		public void setWeight(float f){
			weight = f;
		}
		
		public float getWeight(){
			return weight;
		}
		
		public boolean queryFulfiled(){
			return fulfils_criteria;
		}
		
		abstract Answer testCriteria(String methodName, Method currentMethod);


}
