package CoreJava;

public class MethodOverloading {
	// Method overloading
	// Either argument count should be different or argument data type should be
	// different

	public void getData(int a) {
		System.out.println(a);
	}
	
	public void getData(String  a) {
		System.out.println(a);
	}

	public void getData(int a, int b) {
		System.out.printf("%d %d", a, b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodOverloading c = new MethodOverloading();
		c.getData(2);
		c.getData(3, 5);
		c.getData("Dileep");
	}

}
