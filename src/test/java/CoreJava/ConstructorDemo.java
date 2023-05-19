package CoreJava;

public class ConstructorDemo {

	//Constructtor will not return value and 
	//name of constructor should be the class name
	
	public ConstructorDemo() {
		System.out.println("I am in the constructor");
	}
	
	//Parameterized Constructor
	public ConstructorDemo(int a,int b) {
		System.out.println("I am in the parameterized constructor "+a+" "+b);
	}
	
	
	public void getData() {
		System.out.println("Hi,I am Dileep");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructorDemo cd = new ConstructorDemo();
		ConstructorDemo cd1 = new ConstructorDemo(1,2);
		//Whenever we create an object constructor is called
		//block of code is executed
		//Object matches the constructor types and executes that constructor
		
	}

}
