package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Given a list of integers, remove duplicates, 
 * double each number, and return the first three elements in ascending order using Stream API.
 */
public class RemoveDuplicate {
	public static void main(String[] args) {
		List<Integer> li=new ArrayList<>(Arrays.asList(2,3,4,5,6,7,5,4,3,12,56,85,24,13));
		List<Integer> result=li.stream().distinct().map(n->n*2).sorted().limit(3).collect(Collectors.toList());
		System.out.println(result);
	}

}
