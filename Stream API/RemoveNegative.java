package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * .Given a list of doubles, remove negative numbers, 
 * square each positive number, and return the first four elements in ascending order using Stream API.
 */
public class RemoveNegative {
	public static void main(String[] args) {
		List<Double> list=new ArrayList<>(Arrays.asList(12.2d,13.5d,15.5,16.5d,23.2d,18.5d));
		List<Double> li=list.stream().filter(d ->d>=0).map(d->Math.pow(d, 2)).sorted().limit(4).collect(Collectors.toList());
		System.out.println(li);
		
	}

}
