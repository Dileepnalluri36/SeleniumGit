package CoreJava;

public class NestedLoops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;String output="";
		for(int i= 1;i<=4;i++) {
			output="";
			
			for(int j=0;j<i;j++) {
				sum+=3;
				output+=String.valueOf(sum)+ "\t";
	
			}
			System.out.println(output);
		}

	}

}
