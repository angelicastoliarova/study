package books;



	public class TitleAuthorComparator extends TitleComparator {
		 
		   @Override
		    public int compare(Book o1, Book o2) {
		        int compareTitleResult = super.compare(o1, o2);
		        if (compareTitleResult == 0) {
		            return o1.getAuthor().compareTo(o2.getAuthor());
		        }
		        return compareTitleResult;
		    }
		
		 }