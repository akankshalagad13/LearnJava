package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * .Given a list of integers, find the sum of the squares of all odd numbers using Stream API.
 */
public class SquareOfOddNumbers {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>(Arrays.asList(12,45,67,89,90,13));
		int sum=list.stream().filter(n->n%2!=0).mapToInt(n->n*n).sum();
		System.out.println(sum);
		
	}

}
