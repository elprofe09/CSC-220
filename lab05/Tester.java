package lab05;

public class Tester {
	public static void main(String[] args) {
		SortedBinarySet testSet = new SortedBinarySet();
		testSet.insert(1);
		testSet.insert(5);
		testSet.insert(3);
		testSet.insert(4);
		System.out.println(testSet);
		System.out.println();
		System.out.println();
		testSet.size();
		
		
		testSet.clear();
		System.out.println(testSet);
		testSet.grow();
		testSet.insert(1);
		testSet.insert(5);
		testSet.insert(3);
		testSet.insert(4);
		testSet.insert(7);
		testSet.insert(8);
		testSet.insert(9);
		testSet.insert(11);
		testSet.insert(12);
		testSet.insert(13);
		testSet.insert(14);
		testSet.insert(15);
		testSet.insert(24);
		
		testSet.remove(24);		
		System.out.println(testSet);
		
		System.out.println();
		testSet.findIndex(12);
		System.out.println();
		System.out.println(testSet);
		
	}

}
