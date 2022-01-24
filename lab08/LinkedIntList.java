package lab08;


// modified version of Chapter 16 LinkedIntList class (page 990)
public class LinkedIntList {
	public ListNode front; // first value in the list

	// post: constructs an empty list
	public LinkedIntList(){
		front = null;
	}

	public LinkedIntList(int[] arr){
		this();

		for (int i = 0; i < arr.length; i++)
			add(arr[i]);
	}

	// post: returns the current number of elements in the lists
	public int size(){
		int count = 0;
		ListNode current = front;
		while (current != null){
			current = current.next;
			count++;
		}
		return count;
	}

	// post: return comma-separated, bracketed version of the list
	public String toString(){
		if (front == null){
			return "[]";
		}else{
			String result = "[" + front.data;
			ListNode current = front.next;
			while (current != null){
				result += ", " + current.data;
				current = current.next;
			}
			result += "]";
			return result;
		}
	}

	// post: appends the given value to the end of the list
	public void add(int value){
		if (front == null){
			front = new ListNode(value);
		}else{
			ListNode current = front;
			while(current.next != null){
				current = current.next;
			}
			current.next = new ListNode(value);
		}
	}


	// pre: 0 <= index < size()
	// post: returns a reference to the node at the given index
	private ListNode nodeAt(int index){
		ListNode current = front;
		for (int i = 0; i < index; i++){
			current = current.next;
		}
		return current;
	}

	// pre: 0 <= index <= size()
	// post: inserts the given value at the given index
	public void add(int index, int value){
		if (index == 0){
			front = new ListNode(value, front);
		}else if (index == size()){
			add(value);
		}else if (index > size()){
			return;
		}else{
			ListNode current = nodeAt(index-1);
			current.next = new ListNode(value, current.next);
		}
	}

	//*************************************************

	// This method accepts an integer value as a parameter and returns the index in the list of
	// the last occurrence of that value, or -1 if the value is not found in the list.
	public int lastIndexOf(int value) {
	    //* FILL IN - DO NOT RETURN -1
	    ListNode current = front;
	    int count = -1;
	    int index = -1;

	    if (current == null) {
	        return -1; // should   include a check to see if its an empty list
	    }
	    while (current != null) { //is current even being use here with the updates
	        count++;
	        if (current.data == value) {
	            index = count;
	        }
	        current = current.next; //problem is if it is never found never 
	        if (current == null) {
	            return index;
	        }
	    }

	    return index;
	}

	// This method should remove all occurrence of a particular value.
	public void removeAll(int value) {
	    ListNode current = front;
	    //ListNode temp = front;
	    ListNode previous = null;

	    if (current.data == value) {
	        current = current.next;
	        front = front.next;
	        //temp.next= null;	
	    }
	    while (current.next != null && current.data != value) {
	        previous = current;
	        current = current.next;
	    }

	    /*if(current==null) {
	    	return;
	    }*/

	    if (current.next.data != value) {
	        previous.next = current.next;
	    } else {
	        previous.next = current.next.next;
	    }
	    //insert check for if current.next == value
	    if (current.next == null && current.data == value) {
	        previous.next = null;
	    }
	}

	// This method will rearrange the elements of a list of integers by moving to the end of the list all
	// values that are in odd-numbered positions and otherwise preserving list order. Remember, it does not
	// matter whether the value itself is odd or even; what matters is whether the value appears in an odd
	// index. Also, the original order of the elements of the list should otherwise be preserved.
	// You may not construct any new nodes nor use any auxiliary data structures to solve this problem.
	// You also may not change any data fields of the nodes; you must solve this problem by rearranging the
	// links of the list.
	public void shift() {
	    if (front != null && front.next != null) {
	        
	        ListNode current = front;
	        ListNode pervious = front.next;
	        ListNode currentFront = current;
	        ListNode perviousFront = pervious;
	        
	        while (current.next != null && pervious.next != null) {
	            current.next = current.next.next;
	            current = current.next;
	            pervious.next = pervious.next.next;
	            pervious = pervious.next;
	        }
	        current.next = perviousFront;
	        front = currentFront;
	    }

	    /*if (front == null)
	        return;
		ListNode current = front;
		ListNode tail = front;
		ListNode shiftCurrent = front;
		//ListNode tempShift = front;
		ListNode pervious;
		//ListNode skip = shiftCurrent.next.next;
		//ListNode skipForPervious = pervious.next.next;
		//ListNode linkerForLast = pervious;
		while(current!=null) {
		current = current.next;
		}
		tail = current;
		
		
	while(shiftCurrent.next!=tail) {//increment shiftCurrent
			
			/*if(shiftCurrent.next == null){//if statement maybe to guard against null checker
				tail = front.next;
			}*/
	    /*pervious = shiftCurrent.next;
	    shiftCurrent.next = shiftCurrent.next.next;
	    pervious.next = null;
	     tail = tail.next = pervious;
	     shiftCurrent = shiftCurrent.next;
	    /*if(shiftCurrent.next == null){//if statement maybe to guard against null checker
	    	return;
	    }*/

	    //pervious = pervious.next.next;

	    //}

	}






	// This method will double the size of the list by replacing every integer
	// in the list with two of that integer.
	// if the list is empty simply return
	public void stutter() {
	    //* FILL IN
	    ListNode current = front;
	    ListNode previous = null;
	    if (current == null) {
	        return;
	    }
	    while (current != null) {
	        ListNode tempNode = new ListNode(current.data);
	        previous = current;
	        current = current.next;
	        tempNode.next = previous.next;
	        previous.next = tempNode;
	    }
	}


	}

	//old code from the removal method 
	/*if(infront.data==value) {//figure what happens if it doesn't enter the if statements after
		if(infront.next!=null) {
			if(infront.next.data!=value) {
				current= infront.next;//how to include a check that the one were jumping to isn'0t a value
			}		
		}
		infront.next=null;//maybe here is where u handle the case of the last node being the value
	}
	else {
		current = current.next;//be mindful of the order of updates 
	}*/