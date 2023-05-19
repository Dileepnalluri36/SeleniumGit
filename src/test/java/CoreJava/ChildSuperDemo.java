package CoreJava;

public class ChildSuperDemo extends ParentSuperDemo {
	
	String name="Dileep";
	public void getStringData() {
		System.out.println(name);
		System.out.println(super.name);
	}
	
	public ChildSuperDemo() {
	super();//this should always be the first line
		
		System.out.println("Child class constructor");
	}
	
	public void getData() {
	super.getData();
		System.out.println("I am in child class");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChildSuperDemo cd = new ChildSuperDemo();
		cd.getStringData();
		cd.getData();
	}

}
