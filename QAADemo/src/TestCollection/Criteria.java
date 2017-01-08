package TestCollection;

abstract class Criteria {
	
	float weight;
	boolean fulfils_criteria;
	Feedback feedback;
	
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


}
