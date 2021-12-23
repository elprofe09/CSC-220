package lab04;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Testing class for generic Library.
 *
 */
public class LibraryGenericTest {

  public static void main(String[] args) {

    // test a library that uses names (String) to id patrons
    Library<String> lib1 = new Library<String>();
    lib1.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib1.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib1.add(9780446580342L, "David Baldacci", "Simple Genius");

    String patron1 = "Jane Doe";

    if (!lib1.checkout(9780330351690L, patron1, 1, 1, 2008))
      System.err.println("TEST FAILED: first checkout");
    if (!lib1.checkout(9780374292799L, patron1, 1, 1, 2008))
      System.err.println("TEST FAILED: second checkout");
    ArrayList<LibraryBook<String>> booksCheckedOut1 = lib1
        .lookup(patron1);
    if (booksCheckedOut1 == null
        || booksCheckedOut1.size() != 2
        || !booksCheckedOut1.contains(new Book(9780330351690L, "Jon Krakauer",
            "Into the Wild"))
        || !booksCheckedOut1.contains(new Book(9780374292799L,
            "Thomas L. Friedman", "The World is Flat"))
        || !booksCheckedOut1.get(0).getHolder().equals(patron1)
        || !booksCheckedOut1.get(0).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1))
        || !booksCheckedOut1.get(1).getHolder().equals(patron1)
        || !booksCheckedOut1.get(1).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1)))
      System.err.println("TEST FAILED: lookup(holder)");
    if (!lib1.checkin(patron1))
      System.err.println("TEST FAILED: checkin(holder)");

    // test a library that uses phone numbers (PhoneNumber) to id patrons
    Library<PhoneNumber> lib2 = new Library<PhoneNumber>();
    lib2.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib2.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib2.add(9780446580342L, "David Baldacci", "Simple Genius");

    PhoneNumber patron2 = new PhoneNumber("305.555.1234");

    if (!lib2.checkout(9780330351690L, patron2, 1, 1, 2008))
      System.err.println("TEST FAILED: first checkout");
    if (!lib2.checkout(9780374292799L, patron2, 1, 1, 2008))
      System.err.println("TEST FAILED: second checkout");
    ArrayList<LibraryBook<PhoneNumber>> booksCheckedOut2 = lib2
        .lookup(patron2);
    if (booksCheckedOut2 == null
        || booksCheckedOut2.size() != 2
        || !booksCheckedOut2.contains(new Book(9780330351690L, "Jon Krakauer",
            "Into the Wild"))
        || !booksCheckedOut2.contains(new Book(9780374292799L,
            "Thomas L. Friedman", "The World is Flat"))
        || !booksCheckedOut2.get(0).getHolder().equals(patron2)
        || !booksCheckedOut2.get(0).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1))
        || !booksCheckedOut2.get(1).getHolder().equals(patron2)
        || !booksCheckedOut2.get(1).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1)))
      System.err.println("TEST FAILED: lookup(holder)");
    if (!lib2.checkin(patron2))                           
      System.err.println("TEST FAILED: checkin(holder)");
    
    System.out.println("Testing done.");
    
    // FILL IN for tests
    
    // FOR LAB: write tests for getInventoryList
    ArrayList<LibraryBook<String>> lib1Inventory = lib1.getInventoryList();
    for(int i =1; i<=lib1Inventory.size()-1;++i) {
    	if(lib1Inventory.get(i).getIsbn()<lib1Inventory.get(i-1).getIsbn())
    		System.err.println("TEST FAILED: cgetInventoryList for Library<String>");
    }
    // test a medium library: you will use this for homework
    	Library<String> lib3 = new Library<String>();    
    	lib3.addAll("Mushroom_Publishing.txt");
    
    	ArrayList<LibraryBook<String>> lib3Inventory = lib3.getInventoryList();
        for(int i =1; i<=lib3Inventory.size()-1;++i) {
        	if(lib3Inventory.get(i).getIsbn()<lib3Inventory.get(i-1).getIsbn())
        		System.err.println("TEST FAILED: getInventoryList for Library<String>");
        	}
        ArrayList<LibraryBook<String>> lib3Author = lib3.getOrderedByAuthor();
        //String author1 = lib3Author.get(i).getAuthor();
        for(int i =1; i<=lib3Author.size()-1;++i) {
        	String author1 = lib3Author.get(i).getAuthor();
        	String author2 = lib3Author.get(i-1).getAuthor();
        	//if(int author1.compareTo(author2))
        		//int str1.compareTo(String str2)
        		System.err.println("TEST FAILED: cgetInventoryList for Library<String>");
}
        ArrayList<LibraryBook<String>> lib3Overdue = lib3.getOverdueList(2,2,2006);
        for(int i =1; i<=lib3Overdue.size()-1;++i) {
        	//if(lib3Overdue.get(i).getDueDate().compareTo(lib3Overdue.get(i-1).g)<lib3Overdue.get(i-1).getDueDate())
        		System.err.println("TEST FAILED: getInventoryList for Library<String>");
        	}
        
}
  
}