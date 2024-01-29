package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Given a list of names, filter out names starting with 'A', 
 * sort the remaining names in reverse alphabetical order, and return the first three names using Stream API.
 */
public class ReverseAlphabetical {
	public static void main(String[] args) {
		List<String> list=new ArrayList<>(Arrays.asList("Virat","Dhoni","Hardik","Abhiraj","Aditya","Amrita","Ashok"));
		List<String> li=list.stream().filter(s-> !s.startsWith("A")).sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
		System.out.println(li);
		
	}

}
