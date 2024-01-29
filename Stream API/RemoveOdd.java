package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Given a list of integers, skip the first two elements,
 *  remove odd numbers, and return the next four elements in descending order using Stream API.
 */
public class RemoveOdd {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>(Arrays.asList(3,4,5,6,9,8,24,56,42,12));
		List<Integer> result =list.stream().skip(2).filter(n->n%2==0).sorted(Comparator.reverseOrder()).limit(4).collect(Collectors.toList());
		System.out.println(result);
		
	}

}
