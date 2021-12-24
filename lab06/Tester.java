package lab06;

import java.util.Arrays;

public class Tester {
	public static void main(String[] args) {
		//String TestString = "zebra";
		//String TestString2 = "pizza";
		String firstName = "alfred";
		//String lastName = "labrada";
		String emptyString = "";
		
		SortedString sortedT1 = new SortedString(firstName);
		SortedString sortedT2 = new SortedString(emptyString);

		String print1 = sortedT1.getUnsorted();
		String print2 = sortedT2.getUnsorted();
		System.out.println(print1);
		System.out.println(print2);
		
		if(sortedT1.compareTo(sortedT2)<0) {
			System.out.println("SortedT1 is less than SortedT2");
		}
		else if(sortedT1.compareTo(sortedT2)>0) {
			System.out.println("SortedT1 is greater than SortedT2");
		}
		else
			System.out.println("SortedT1 is the same as SortedT2");
		
		//test for Anagrams
		Boolean checkAnagrams = AnagramUtil.areAnagrams(sortedT1, sortedT2);
		System.out.println(checkAnagrams);
		
		
		//insertionSort test
		String[] myarray = {"cat","ski","joy","bot"}; //String[] cars
		
		
		SortedString[] result = SortedString.toSortedString(myarray);
		
		System.out.print(Arrays.toString(result));
		
		InsertionSort <SortedString> m = new InsertionSort<SortedString>();
		SortedString[] resultOfM = m.sort(result);
		System.out.println("hey");
		System.out.println(Arrays.toString(resultOfM)); //print statement is incorrect
		//InsertionSort<SortedString>sort.myarray;

		//Testing for GetLargestAnagram
		String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		System.out.println(Arrays.toString(s3));
		
		
		/*String[] s4 = new String[] {"d", "d", "c", "a", "c", "d", "d", "d", "a", "b"};
		s4 = AnagramUtil.getLargestAnagramGroup(SortedString.toSortedString(s4));
		System.out.println(Arrays.toString(s4));*/
		
		//tester for mergeSort
		MergeSort<Integer> mergeSortTester = new MergeSort<Integer>();
		Integer[] test1 = {1};
		Integer[] test2 = {4,2};
		Integer[] test3 = {1,2,3,4,5,6};
		Integer[] test4 = {5,2,7,9,3,6};
		
		//MergeSort<Integer> mergeSortTester = new MergeSort<Integer>();
		
		Integer[] testsResults1 = mergeSortTester.sort(test1);
		Integer[] testsResults2 = mergeSortTester.sort(test2);
		Integer[] testsResults3 = mergeSortTester.sort(test3);
		Integer[] testsResults4 = mergeSortTester.sort(test4);
		
		System.out.println(Arrays.toString(testsResults1));
		System.out.println(Arrays.toString(testsResults2));
		System.out.println(Arrays.toString(testsResults3));
		System.out.println(Arrays.toString(testsResults4));
		
		//testing for fit and predict
		//int[] fitTest = {1,2,3,6,7,8,21,9,51,11};
		//MergeSort.fit(fitTest);

}
}
