package CoreJava;

public class ChildAbstractClass extends ParentAbstractClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChildAbstractClass c = new ChildAbstractClass();
		c.guidelines();
		c.rules();
		c.color();
		//abstract classes cannot be used for creating objects
	}

	@Override
	public void color() {
		// TODO Auto-generated method stub
		System.out.println("Red");
	}

}
