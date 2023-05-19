import java.util.ArrayList;

public class CoreJavaBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Enhanced For Loop

		int arr[] = { 1, 2, 32, 4, 43, 4, 434 };

		for (int i : arr) {
			System.out.println(i);
		}

		// Array List
		ArrayList<String> a = new ArrayList<String>();
		a.add("Dileep");
		a.remove("Dileep");

//		Types of methods to create a string

		// String is an object which contains sequence of characters
		String s = "Dileep is learning selenium";
		String s1 = new String("Dileep is learning selenium  ");// IT creates new memory space for the string
		// If both strings have same content ,java will point to the previously created
		// one if we use first
//		method to create String
//String methods
		System.out.println(s1.trim());
		String[] splitString = s.split(" ");
		System.out.println(splitString[1]);

		/// charAt
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}
		for (int i = s.length() - 1; i > 0; i--) {
			if (s.charAt(i) == ' ') {
				continue;
			} else {
				System.out.println(s.charAt(i));

			}
		}

		getData();
	}

	// Static keyword provides class level access
	public static void getData() {
		System.out.println("Hello World");
	}
}
