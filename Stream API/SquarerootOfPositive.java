package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Given a list of doubles, find the square root of each positive number, remove negative numbers,
 *  and return the first five elements in descending order using Stream API.
 */
public class SquarerootOfPositive {
	public static void main(String[] args) {
		List<Double> list=new ArrayList<>(Arrays.asList(11.2d,13.4d,56.5d,44.4d,18.8d,46.5d));
		List<Double> li=list.stream().filter(d->d>=0).map(Math::sqrt).sorted(Comparator.reverseOrder()).limit(5).collect(Collectors.toList())
;
		System.out.println(li);}

}
