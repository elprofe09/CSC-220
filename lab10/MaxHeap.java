package lab10;

public class MaxHeap {
    /** internal representation of the heap */
    private int[] theData;
    /** store the number of current elements inside the heap */
    private int size;

    /** constructor to initialize the status of the objects of this class
        based on the input parameter (i.e., size)
        @param maxsize the size for the heap
     */
    public MaxHeap(int maxsize) {
        // TODO for Lab10
    	
    	theData = new int[maxsize];
    	size =0;
    }

    /** constructor that initializes a heap and put the values of the input
        array in it in such a way that the constructed max heap is valid.
        @param arr the input array
     */
    public MaxHeap(int[] arr){
        // TODO for Assignment10
    	this(arr.length);
//    	if(arr.length==0||arr.length==1) {
//    		return;
//    	}
    	for(int indices =0;indices<arr.length;indices++) {
    		offer(arr[indices]);
    	}
    }
    		
    

    public int size() {
        return size;
    }

    private int parent(int pos) {
    	return (pos-1)/2;
    }

    private int leftChild(int pos) {
    	return 2*pos + 1;
    }

    private int rightChild(int pos) {
    	return 2*pos + 2;
    }

    private boolean isLeaf(int pos) {
        return (pos >= size/2) && (pos < size);
    }


    /** Swap the items with index i and index j in the heap array.
        @param i index of first item in heap
        @param j index of second item in theData
     */
    private void swap(int i, int j) {
        int value = theData[i];
        theData[i] = theData[j];
        theData[j] = value;
    }


    /** Returns a string containing contents of the heap as an array
        NOTE this method should *not* be modified.
     */
    public String toString(){
        String s = "";
        for (int i = 0; i < theData.length; i++)
            s += theData[i] + ", ";
        s += "\n";
        return s;
    }

    /** Prints the tree contents, one per line, following an inorder traversal
        and using indentation to indicate node depth; prints right to left so
        that it looks correct when the output is rotated;
        NOTE this method should not be modified.
     */
    public void printSideways(){
        printSideways(0, 0);
    }

    /** Prints in reversed preorder the tree with given root, indenting each
        line to the given level
        @param root_indx the given root
        @param level indentation level
        NOTE this method should not be modified.
     */
    private void printSideways(int root_indx, int level){
        if (root_indx < theData.length){
            printSideways(rightChild(root_indx), level+1);
            for (int i = 0; i < level; i++){
                System.out.print("       ");
            }
            System.out.println(theData[root_indx]);
            printSideways(leftChild(root_indx), level+1);
        }
    }

    /**
     tests if the contents of the heap are equal to an input array
     @param arr the input array
     NOTE this method should not be modified.
    */
    public boolean IsEqual(int[] arr){
        if (arr.length != theData.length)
            return false;

        if (arr.length == 0)
            return true;

        for (int i = 0; i < arr.length; i++)
            if (arr[i] != theData[i])
                return false;

        return true;
    }


    /** Remove an item from the heap.
      pre: theData is in heap order.
      post: Removed maximum item, theData is in heap order.
      @return The item with the maximum value or -1 if empty.
     */
    public int poll() {

        int rootOfHeap = theData[0];
        if (size == 0) {
            return -1;
        }

        return pollHeapify(0, rootOfHeap);
    }
    private int pollHeapify(int position, int rootOfHeap) {

        if (theData == null) {
            return -1;
        }
        swap(position, size - 1);
        theData[size - 1] = 0;
        size--;


        while (theData[position] < theData[leftChild(position)] || 
        		theData[position] < theData[rightChild(position)]) {

            if (theData[leftChild(position)] < theData[rightChild(position)]) {
                swap(position, rightChild(position));
                position = rightChild(position);
            } else {

                swap(position, leftChild(position));
                position = leftChild(position);
            }

        }

        return rootOfHeap;
    }

    /** Insert an element into the heap.
      pre:  theData is in heap order.
      post: The element is in the heap and
            theData is in heap order.
      @param element The element to be inserted
     */
    public void offer(int element) {
        // TODO for Lab10
        int position = size;
        theData[position] = element; //maybe wrong
        while (theData[parent(position)] < theData[position]) {
            swap(position, parent(position));
            position = parent(position); //the problem was that i was comparing the values instead of the indices

        }
        size++;
    }


    /** in-place heap sort algorithm.
        @param arr the input (unsorted) array to be sorted.
        TODO finish writing siftDown() for Assignment10
        NOTE do *not* modify the signatures of sort(), heapify(), or siftDown()
     */
    public void sort(int[] arr) {
		this.theData = arr;
        this.size = arr.length;

        heapify(size-1);
		while(size > 1) {
			swap(0, size-1);
			size--;
            siftDown(0);
		}
    }


	private void heapify(int index) {

		if(index == 0) {
			return;
		}

		for (int i = parent(index); i >= 0; i--) {
			siftDown(i);
		}

	}

	private void siftDown(int index) {

        // While a child has a larger value than its parent, the largest child
        // value (either leftChild(index) or rightChild(index)) is swapped with
        // the parent (element at index). index should be updated accordingly
        // before going round the loop again.

        // TODO for Assignment10
		 //int position = index;
		if(isLeaf(leftChild(index))==true && theData[parent(index)]<theData[leftChild(index)]
				||isLeaf(rightChild(index))==true && theData[parent(index)]<theData[rightChild(index)]) {
			
			if(theData[leftChild(index)]>theData[rightChild(index)]) {
				swap(index, leftChild(index));
				
				
				
			}
			else {
				swap(index, rightChild(index));
				
			}
		
		}
		
	
	}

}
