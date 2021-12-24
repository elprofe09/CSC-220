package lab05;

public class SortedBinarySet {
	/** represent the simple array that holds the list values */
	public double[] theData;
	/** holds the length of the storage array */
	private int capacity;
	/** holds the number of elements in the list */
	private int size;

	/** constant for initial storage array capacity */
	private static final int INITIAL_STORAGE_CAPACITY = 11;

	/** keep this FALSE for lab; we will play with this in the assignment **/
	public boolean usesBinarySearch = false;

	double [] theIncreasedData = new double[capacity];//ask T.A. if this is correct?
	/** default constructor */
	public SortedBinarySet(){
		// TODO
		theData = new double [INITIAL_STORAGE_CAPACITY];
		size = 0;
		capacity = INITIAL_STORAGE_CAPACITY;
		
	}

	public SortedBinarySet(double[] input){
		// TODO (for assignment, not lab)
	}

	public boolean empty(){
		if(theData.length==0)
		return false; //placeholder
		
		else
			return true;
	}

	public int size(){
		return size; //placeholder
	}

	public void grow(){
		// TODO
		capacity = capacity*2;
		double [] theIncreasedData = new double[capacity];
		for(int i = 0; i<=size;i++) {
			theIncreasedData[i]=theData[i];
		}
		 theData=theIncreasedData;
	}

	public String toString(){
		// TODO
		String printElements ="";
		for(int i = 0; i<size;i++) {
		printElements +=i;
		printElements += " ";
		}
		System.out.print("\n");
		System.out.print(size);
		System.out.print("\n");
		System.out.print(capacity);
		
		return printElements; // placeholder
	}

	public void clear() {
		// TODO
		for(int i = 0;i<size;i++) {
			theData[i]=0;
		}
		size = 0;
	}

	public boolean insert(double newVal){
		// TODO
		
		//double [] addNewElement = new double[capacity];
		int	indexPos = findIndex(newVal);
		
		if(indexPos>=0) {
			return false;
		}
		else {
			indexPos = (-indexPos)-1;
			if (size==capacity) {
				grow();
			}
			for(int i =size-1;i>=indexPos;i--) {
				theData[i+1]= theData[i];
			}
			theData[indexPos]= newVal;
			size++;
			return true;
		}
		
		
		/*if(indexPos<0) {
			indexPos = -indexPos-1;
			for (int i = 0; i < indexPos; i++) 
				addNewElement[i] = theData[i]; 
	  
			addNewElement[indexPos] = newVal; 
			
			for (int i = indexPos; i < size; i++) 
				addNewElement[i+1] = theData[i];
			
			size = size+1;
	  
	        return true; 
		}*/
	}

	public boolean remove(double element){
		// TODO
		return false; // placeholder
	}


	private int sequentialFind(double target) {//double check i'm not sure its iterating thru
		//int index = -1;
		for(int i = 0; i<size;i++) {
			if(theData[i]==target)
				return i;
			else if(target<theData[i])
				return -i-1;
		}
		 //placeholder
		return -size-1;// Ask t.a
	}

	private int binaryFind(double target) {
		// TODO
		return 0; // placeholder
	}

	public int findIndex(double target) {//ask T.A to explain this in detail
		if (usesBinarySearch) {
			return binaryFind(target);
		} else {
			return sequentialFind(target);

		}
	}

	public boolean containsAll(double[] elements){
		// TODO
		return false; // placeholder
	}

	public boolean contains(double element){
		// TODO
		return false; // placeholder
	}

}
