
public class thisDemo {

	int a = 2;

	public void getData() {
//This keyword refers to current object,object scope lies in class level
		int a = 3;
		System.out.printf("%d %d",a, this.a);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
thisDemo td = new thisDemo();
td.getData();
	}

}
