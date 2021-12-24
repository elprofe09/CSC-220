package lab06;

import java.util.Arrays;

public class InsertionSort<E extends Comparable<E>> {

    /** The constant in the formula t = c * O() */
    private double c;

    /** The order O() of the implementation.
        If your implementation is in O(n^2), use Math.pow().
	    @param n index
	    @return the function of n inside the O()
	 */
    public double O(int n) {
        // EXERCISE
    	return Math.pow(n,2);
    }

    /** Calculates the constant c using a given input array of type E.
        Units of time should be converted to microseconds
    */
    public void fit(E[] array) {
        // EXERCISE
    	
    	long start = System.nanoTime(); 
    	sort(array);
    	long end =  System.nanoTime(); 
    	long diffOfStartEnd = (end-start)*1000;
    	c= diffOfStartEnd/this.O(array.length);
    	
    }

    /** Predicts the running time of an insertion sort for some index n
        @param n
        @return the estimated amount of time in unit microseconds
    */
    public double predict(int n) {
        // EXERCISE
        return c*O(n); 
    }

    /** Performs an insertion sort using a given input array
        @param array the (unsorted) array
        @return the sorted array
    */
    public E[] sort(E[] array) {
        // EXERCISE

        /* Handle case where length of array is 1 or less */
    	

        /* make a copy of the array to sort */
        E[] sorted = array.clone();
        if(sorted.length<=1) {
    		return sorted;
    	}
        
        
        /* Perform the insertion sort */
        for(int i=1; i < sorted.length; i++)
        {
        	
        	E key = sorted[i];
        	int j =i-1;
        	while(j>=0 && sorted[j].compareTo(key)>0) { // to compare the i with the key you have to use compareTo since it is a generic type
        		sorted[j+1]=sorted[j]; //changes the actual value inside && this loop shifts elements to allow space
        		j = j-1;
        	}
        	sorted[j+1]=key;//inserts the unsorted element into the correct position
        }

        return sorted; // 
    }

}
