package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Given a list of strings, convert each string to uppercase, 
 * remove duplicates, and return the first three elements in alphabetical order using Stream API.
 */
public class ConvertTouppercase {
	public static void main(String[] args) {
		List<String> list=new ArrayList<>(Arrays.asList("mogra","nose","parrot","cat","frog","elephant"));
		List<String> result=list.stream().map(String::toUpperCase).distinct().sorted().limit(3).collect(Collectors.toList());
		System.out.println(result);
	}

}
