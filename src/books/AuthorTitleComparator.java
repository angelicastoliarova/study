package books;


public class AuthorTitleComparator extends TitleComparator {

   @Override
   public int compare(Book o1, Book o2) {
       int compareAuthorResult = o1.getAuthor().compareTo(o2.getAuthor());
       if (compareAuthorResult == 0) {
          return super.compare(o1, o2);
       }
       return compareAuthorResult;
   }
}