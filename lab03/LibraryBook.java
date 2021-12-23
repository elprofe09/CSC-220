package lab03;

// What imports do you need to include? Put them here.
import java.util.GregorianCalendar;

public class LibraryBook extends Book/* ADD SOMETHING HERE */ { //Construct a class LibraryBook derived from Book and containing the library 

	// A LibraryBook contains a holder (a String) and due date represented by
	// a GregorianCalendar
	String holder;
	GregorianCalendar dueDate; //Gregorian calendar is a type
	public LibraryBook(long isbn, String author, String title) {//use super here
		// FILL IN
		super(isbn,author,title);
		
	}

	public String getHolder() {
		// FILL IN
		
		return holder; // placeholder
	}
	
	public GregorianCalendar getDueDate() {
		// FILL IN
		
		return dueDate; // placeholder
	}
	
	public void checkin() {
		// use keyword this
		this.holder = null;
		this.dueDate =null;
	}
	
	public void checkout(String holder, GregorianCalendar dueDate){
		// FILL IN
		this.holder = holder;
		this.dueDate = dueDate;
		
	}	
	

	// Do not override the equals method in Book

}