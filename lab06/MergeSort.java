package lab06;

public class MergeSort<E extends Comparable<E>> {

    /** The constant in the formula t = c * O() */
    private double c;

    /** The order O() of the implementation.
        If your implementation is in O(n^2), use Math.pow().
	    @param n index
	    @return the function of n inside the O()
	 */
    public double O(int n) {
        // EXERCISE
        return n*(Math.log10(n)/Math.log10(2));
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

    /** Predicts the running time of a merge sort for some index n
        @param n
        @return the estimated amount of time in unit microseconds
    */
    public double predict(int n) {
        // EXERCISE
        return c*O(n);  // NOT RIGHT
    }

    /** Performs a merge sort using a given input array
        @param array the (unsorted) array
        @return the sorted array
    */
    public E[] sort(E[] array) {
        if (array.length <= 1)
            return array;
        E[] sorted = array.clone();
        E[] array2 = sorted.clone();
        sort(sorted, array2, 0, array.length - 1);
        return sorted;
    }

    private void sort(E[] array1, E[] array2, int first, int last) {
        if (first >= last)
            return;

        int middle = (first + last) / 2;
        sort(array1, array2, first, middle);
        sort(array1, array2, middle+1, last);

        int i = first;
        int a = first;
        int b = middle+1;
        while (a <= middle && b <= last) {
            // EXERCISE
        	//while(i<array1.length-1) {
        		if(array1[a].compareTo(array1[b])<0) {
        			array2[i]=array1[a];
        			a++;
        			i++;
        		}
        		if(array1[a].compareTo(array1[b])>0) {
        			array2[i]=array1[b];
        			b++;
        			i++;
        		}
        		/*else {
        			array2[i]=array1[a];
        			//i++;
        		}*/
        		//i++;
        	//}
            // Copy the smaller of array[a] or array[b] to array2[i]
            // (in the case of a tie, copy array[a])
            // and increment i and a or b (the one you copied).
        	
         

        }

        // EXERCISE
        // Copy the rest of a or b, whichever is not at the end.
        while(a<=middle) {
    		array2[i]=array1[a];
    		i++;
    		a++;
    	}
    	while(b<=last) {
    		array2[i]=array1[b];
    		i++;
    		b++;
    	}

        System.arraycopy(array2, first, array1, first, last - first + 1);
    }

}
