package CoreJava;

public class MultiDimensionalArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[][] = new int[2][2];
		a[0][0]=1;
		a[0][1]=2;
		a[1][0]=3;
		a[1][1]=4;
		
		for(int i=0;i<2;i++) //row
		{

		for(int j=0;j<2;j++) //coloumn
		{

		System.out.println(a[i][j]);
		}
		}
		
	}

}
