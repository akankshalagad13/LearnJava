package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a list of strings, find the length of the longest string
 *  that contains the letter 'a' using Stream API.
 */
public class LongestStringWithA {
	public static void main(String[] args) {
	     List<String> list=new ArrayList<>(Arrays.asList("Banana","Apple","Carrot","Dog","Frog"));
	    int maxnum=list.stream().filter(s->s.contains("a")).mapToInt(String::length).max().orElse(0);
	    System.out.println("length of the longest string with letter a:"+maxnum);
	}

}
