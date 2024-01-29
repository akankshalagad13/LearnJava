package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * Given a list of integers, find the maximum even number By using Stream API.
 */
public class MaximumEven {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>(Arrays.asList(3,5,6,8,2,4,9,7,89,77,45,25,1,41,56));
		Optional<Integer> li=list.stream().filter(n->n%2==0).max(Integer::compareTo);
		
		if(li.isPresent()) {
			System.out.println("maximum  even number is:"+li.get());
		}
		else {
			System.out.println("No maximum even number is found");
		}
		
	}

}
