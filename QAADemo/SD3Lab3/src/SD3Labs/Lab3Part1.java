package SD3Labs;

public class Lab3Part1 {
//Sum Of Numbers
	//recursive
	public static int sum(int n){
		if (n==0)
			return 0;
		else
			return n + sum(n-1);
	}

	
	
// Multiplication using addition
	//recursive
	public static int multiply(int m, int n){
		if(n==0)
			return 0;
		else
			return m + multiply(m,n-1);
	}
	
//Fibonacci Number
	//recursive
	public static int Fibonacci(int n){
		if(n==0 || n==1)
			return n;
		else
			return Fibonacci(n-1)+Fibonacci(n-2);
		
	}


}
