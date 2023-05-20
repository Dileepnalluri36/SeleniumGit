package CoreJava;

public class StaticVar {

	String name, address;///Instance variables will be changing across all objects
	static String city ="Vsp";//Static/Class variables will apply to class and common across all objects
	static int i=0;
	
	static {//We use static block to optimize static variables
		city ="vsp";
		i =0;
	}

	StaticVar(String name, String address) {
		this.name = name;
		this.address = address;
		i++;
		System.out.println(i);
	}

	public void getData() {
		System.out.println(address +city);
	}
	
	public static void getName() {
		System.out.println(city);//We cant use instance variables in static methods.
		//Here city is Static variable
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticVar obj = new StaticVar("Dil", "ari");
		StaticVar obj1 = new StaticVar("Dil", "seet");
		obj.getData();
		obj1.getData();
		StaticVar.getName();//For static methods,we need to use class
		System.out.println("Hi");
		System.out.println("Hi2");
		System.out.println("Hi3");
		
		//New changes
	System.out.println("Branch changes");
	System.out.println("Branch changes");
	System.out.println("Branch changes");
	System.out.println("Branch changes");
	System.out.println("Branch changes");
	}

}
