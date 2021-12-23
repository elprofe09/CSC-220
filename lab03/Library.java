package lab03;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Class representation of a library (a collection of library books).
 * 
 */
public class Library {

	
  private ArrayList<LibraryBook> library;

  public Library() {
    library = new ArrayList<LibraryBook>();
  }

  /**
   * Add the specified book to the library, assume no duplicates.
   * 
   * @param isbn --
   *          ISBN of the book to be added
   * @param author --
   *          author of the book to be added
   * @param title --
   *          title of the book to be added
   */
  public void add(long isbn, String author, String title) {
    library.add(new LibraryBook(isbn, author, title));
  }
  

  /**
   * Add the list of library books to the library, assume no duplicates.
   * 
   * @param list --
   *          list of library books to be added
   */
  public void addAll(ArrayList<LibraryBook> list) {
    library.addAll(list);
  }

  /**
   * Add books specified by the input file. One book per line with ISBN, author,
   * and title separated by tabs.
   * 
   * If file does not exist or format is violated, do nothing.
   * 
   * @param filename
   */
  public void addAll(String filename) {
    ArrayList<LibraryBook> toBeAdded = new ArrayList<LibraryBook>();

    try {
      Scanner fileIn = new Scanner(new File(filename));
      int lineNum = 1;

      while (fileIn.hasNextLine()) {
        String line = fileIn.nextLine();

        Scanner lineIn = new Scanner(line);
        lineIn.useDelimiter("\\t");

        if (!lineIn.hasNextLong())
          throw new ParseException("ISBN", lineNum);
        long isbn = lineIn.nextLong();

        if (!lineIn.hasNext())
          throw new ParseException("Author", lineNum);
        String author = lineIn.next();

        if (!lineIn.hasNext())
          throw new ParseException("Title", lineNum);
        String title = lineIn.next();

        toBeAdded.add(new LibraryBook(isbn, author, title));

        lineNum++;
      }
    } catch (FileNotFoundException e) {
      System.err.println(e.getMessage() + " Nothing added to the library.");
      return;
    } catch (ParseException e) {
      System.err.println(e.getLocalizedMessage()
          + " formatted incorrectly at line " + e.getErrorOffset()
          + ". Nothing added to the library.");
      return;
    }

    library.addAll(toBeAdded);
  }

  /**
   * Returns the holder of the library book with the specified ISBN.
   * If no book with the specified ISBN is in the library, returns null.
   * 
   * @param isbn --
   *          ISBN of the book to be looked up
   */
  public String lookup(long isbn) {
	     String holderIsbn = "";
	     // *FILL IN -- do not return null unless appropriate
	     for (int i = 0; i < library.size(); i++) {
	         if (library.get(i).getIsbn() == isbn) {
	             holderIsbn = library.get(i).getHolder(); //String holderIsbn = Long.toString(isbn); 
	             return holderIsbn; //ask T.A if when it returns holderIsbn does it terminate the whole method and not return null as well   
	         }
	     }
	     return null;

	 }
  


  /**
   * Sets the holder and due date of the library book with the specified ISBN.
   * If no book with the specified ISBN is in the library, returns false. 
   * If the book with the specified ISBN is already checked out, returns false. 
   * Otherwise, returns true.
   * 
   * @param isbn --
   *          ISBN of the library book to be checked out
   * @param holder --
   *          new holder of the library book
   * @param month --
   *          month of the new due date of the library book
   * @param day --
   *          day of the new due date of the library book
   * @param year --
   *          year of the new due date of the library book
   */
  public boolean checkout(long isbn, String holder, int month, int day, int year) {
	    // *FILL IN -- do not return false unless appropriate

	    if (lookup(isbn) != null || lookup(isbn) == null) {
	        return false;
	    } else {
	        //set the holder & due date
	        GregorianCalendar dueDate = new GregorianCalendar(year, month, day);// understand this better
	        for (int i = 0; i < library.size(); i++) {
	            long isbnOut = library.get(i).getIsbn();
	            if (isbnOut == isbn) {
	                library.get(i).checkout(holder, dueDate);
	            }
	        }
	        return true;
	    }
	}
  
  // *** you will implement the rest of the methods for your assignment
  // *** don't touch them before finishing the lab portion
 
  /**
   * Returns the list of library books checked out to the specified holder.
   * 
   * If the specified holder has no books checked out, returns an empty list.
   * 
   * @param holder --
   *          holder whose checked out books are returned
   */
  public ArrayList<LibraryBook> lookup(String holder) {// Ask exactly what this line means
    // FILL IN -- do not return null
	  ArrayList<LibraryBook> booksOfLib = new ArrayList<LibraryBook>(library);  //you have to fill the array in 
	  for(LibraryBook librarybook:library) {//adding the for loop  for(int i = 0; i<library.size();i++)
		  //LibraryBook librarybook = library(librarybook);
		  //long holderisbn = library.get(i).getIsbn();//need the ISBN of the holder
		//ArrayList<LibraryBook> checkedOutBooks = new ArrayList<LibraryBook>(library);
		  if(lookup(holder)!=null) {
			  booksOfLib.add(librarybook); //logic 
			  //returning the arrayList 
		  }
		  else //returns empty arrayList
			  return new ArrayList<LibraryBook>();
	  }
	  return booksOfLib;
  }  

  /**
   * Unsets the holder and due date of the library book.
   * If no book with the specified ISBN is in the library, returns false.
   * If the book with the specified ISBN is already checked in, returns false.
   * Otherwise, returns true.
   * 
   * @param isbn --
   *          ISBN of the library book to be checked in
   */
  public boolean checkin(long isbn) {
    // FILL IN -- do not return false unless appropriate

	  return false;
  }

  /**
   * Unsets the holder and due date for all library books checked out by the
   * specified holder.
   * If no books with the specified holder are in the library, returns false;
   * Otherwise, returns true.
   * 
   * @param holder --
   *          holder of the library books to be checked in
   */
  public boolean checkin(String holder) {
	    // *FILL IN -- do not return false unless appropriate	

	  return false;
  }
}