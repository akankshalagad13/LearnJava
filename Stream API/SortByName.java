package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * .Given a list of names, filter out names with less than four characters,
 *  sort the remaining names by length, and return the first two names using Stream API.
 */
public class SortByName {
	public static void main(String[] args) {
		List<String> list=new ArrayList<>(Arrays.asList("anjali","anju","Ram","sham","krish","sai","anu","shraddha"));
		List<String> li=list.stream().filter(s -> !(s.length()>=4)).sorted((s1,s2)->Integer.compare(s1.length(), s2.length())).limit(2)
				.collect(Collectors.toList());
		System.out.println(li);
		
		
	}

}
