package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Given a list of strings, remove elements with a length less than 3, convert 
 * the remaining strings to uppercase, and return the last two elements in descending order using Stream API.
 */
public class DescendingOrder {
	public static void main(String[] args) {
		List<String> list=new ArrayList<>(Arrays.asList("Apple","mango","Banana","guava","carrot","Icecream","JackFruit"));
		List<String> li=list.stream().filter(s->s.length()>3).map(String::toUpperCase).sorted(Comparator.reverseOrder())
				.skip(list.size()-2).limit(2).collect(Collectors.toList());
		System.out.println(li);
	}

}
