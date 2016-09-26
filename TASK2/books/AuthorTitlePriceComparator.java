package books;

public class AuthorTitlePriceComparator extends AuthorTitleComparator {
	 
	    @Override
	    public int compare(Book o1, Book o2) {
	       int authorTitleCompare = super.compare(o1, o2);
	       if (authorTitleCompare == 0) {
	            return o1.getPrice() - o2.getPrice();
	        }
	        return authorTitleCompare;
	    }
	 }