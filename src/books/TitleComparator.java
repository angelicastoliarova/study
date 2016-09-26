package books;

import java.util.Comparator;

public class TitleComparator implements Comparator<Book> {
	    @Override
	    public int compare(Book o1, Book o2) {
	        return o1.getTitle().compareTo(o2.getTitle());
	   }
	 
	    @Override
	    public Comparator<Book> reversed() {
	        return (o1, o2) -> compare(o2, o1);
	    }
	 }

