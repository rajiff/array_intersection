// package datastructures.tutorials;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ArrayIntersectionFinder {

	static int[] commaDelimStrToIntArray(String commaDelimStr) {
		return Arrays.stream(commaDelimStr.split(", ")).mapToInt(Integer::parseInt​).toArray();
	}
	
	static String intArrayToCommaDelimStr(int[] intArray) {
		String interesectionStr = (intArray.length > 0) ? Arrays.stream(intArray).mapToObj(Integer::toString).collect(Collectors.joining(", ")) : null;
		return interesectionStr;
	}

	static String findIntersection(String[] strArray) {
    // map to a parsed integer arrays from the given comma delim string inputs
		int[] set1 = commaDelimStrToIntArray(strArray[0]);
		int[] set2 = commaDelimStrToIntArray(strArray[1]);
		
		int[] intersection = Arrays.stream(set1).filter((val) -> Arrays.binarySearch​(set2, val) >= 0).toArray();
		
		String interesectionStr = (intersection.length > 0) ? intArrayToCommaDelimStr(intersection) : "false";

		return interesectionStr;
	}

	public static void main(String[] args) {
		System.out.println("** Program to find Array Intersection **");
		
		String strScenario1[] = {new String("1, 2, 3, 16"), new String("1, 4, 5, 16, 18")};
		System.out.println(findIntersection(strScenario1));
		
		String strScenario2[] = {new String("0, 1, 9, 12"), new String("1, 9, 10, 11, 12")};
		System.out.println(findIntersection(strScenario2));
		
		String strScenario3[] = {new String("45, 46, 47, 48"), new String("49, 50, 51, 52")};
		System.out.println(findIntersection(strScenario3));
		
		String strScenario4[] = {new String("7"), new String("7")};
		System.out.println(findIntersection(strScenario4));
	}
}