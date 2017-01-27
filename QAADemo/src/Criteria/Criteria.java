/*Tests are comprised of one or more criteria, that a classes methods are tested against,
 * as provided by this class
 *All criteria have a weight that indicates how much they contribute to the
 *overall score of the test. 
 */
package Criteria;

import java.lang.reflect.Method;
import TestCollection.*;
import TestLibrary.*;

public abstract class Criteria {
	
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
		
		public abstract Answer testCriteria(String methodName, Method currentMethod);


}
