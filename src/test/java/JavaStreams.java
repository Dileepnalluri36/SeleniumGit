import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreams {

	// TODO Auto-generated method stub
	// Count the number of names starting with alphabets A in list
	// @Test
	public void regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Dileep");
		names.add("Abhi");
		names.add("Sathish");
		names.add("Swarna");
		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).startsWith("A")) {
				count++;
			}

		}
		System.out.println(count);

	}

//	@Test
	public void StreamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Dileep");
		names.add("Abhi");
		names.add("Sathish");
		names.add("Swarna");
		names.add("Anand");
		names.add("Ashish");

		// There is no life for intermediate op if there is no terminal op
		// Terminal operation will execute only if inter op(filter) returns true
		// We can create stream
		// How to use filter in stream API
		long count = names.stream().filter(i -> i.startsWith("A")).count();
		long anotherCount = Stream.of("Dileep", "Abhi", "Sathish", "Swarna", "Anand", "Ashish")
				.filter(i -> i.startsWith("A")).count();
		System.out.printf("%d %d", count, anotherCount);
		// Print all the names of ArrayList
		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
	}

//	@Test
	public void Math() {
		// Print names of last letter of 'a' with Uppercase
		Stream.of("Dileep", "Abhi", "Sathish", "Swarna", "Anand", "Ashish").filter(s -> s.endsWith("a"))
				.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		// Print names which have first letter as a with uppercase and sorted
		Stream.of("Dileep", "Abhi", "Sathish", "Swarna", "Hari", "Priya").filter(s -> s.startsWith("A")).sorted()
				.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		List<String> names = Arrays.asList("Dileep", "Abhi", "Sathish", "Swarna", "Anand", "Ashish");
		List<String> names1 = Arrays.asList("Dileep", "Abhi", "Sathish", "Swarna", "Anand", "Ashish");
		// Merging two lists
		Stream<String> concatStreams = Stream.concat(names.stream(), names1.stream());
		// concatStreams.sorted().forEach(s -> System.out.println(s));
		boolean flag = concatStreams.anyMatch(s -> s.equalsIgnoreCase("dileep"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}

	@Test
	public void streamCollect() {
	List<String> ls=	Stream.of("Dileep", "Abhi", "Sathish", "Swarna", "Anand", "Ashish").filter(s -> s.endsWith("a"))
		.map(s -> s.toUpperCase()).collect(Collectors.toList());
	System.out.println(ls.get(0));
	
	//Find unique number from array,sort and print 3rd index
	List<Integer>values= Arrays.asList(1,24,5,34,1,52,65,26);

	values.stream().distinct().forEach(s->System.out.println(s));
	List<Integer> li =values.stream().sorted().distinct().collect(Collectors.toList());
	System.out.println(li.get(2));///3rd value
	System.out.println(li.get(li.size()-1));///Max value
	}
}
