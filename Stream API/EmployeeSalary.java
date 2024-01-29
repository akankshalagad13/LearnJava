package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 *  Wap take a list of employee salaries and find out the  3rd max salary from that list, take a list 10 salary the highest salary must be repeated there.
    Do it by using stream API. you don't have to use inbuilt max and min methods.
 */
public class EmployeeSalary {
	public static void main(String[] args) {
		List<Integer> salary=new ArrayList<>(Arrays.asList(200,356,455,896,896,666,745,666,250,150,1000));
		List<Integer> result=salary.stream().distinct().sorted(Comparator.reverseOrder()).skip(2).limit(4).collect(Collectors.toList());
		System.out.println(result);
		
	}

}
