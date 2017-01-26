package SD3Labs;

public class Lab3Part1 {
	//Sum Of Numbers
	   
	public String wrong(String z){
		return "A String output";
	}
	
	public int summmmmm(int x){
		 return 69;
	}
	 
		 public int rttttttttt(int x){
		 return 15;
	 }
	 
	public int sum(int x){
		 if(x<=0){
			 return 0;
		 }
		 else{
			 return x + (sum(x-1));
		 }
	 }
	
	public int mult(int x, int y){
		
		if(y==0){
			return 0;
		}
		else{
			return x+mult(x,y-1);
		}
	}


	}
