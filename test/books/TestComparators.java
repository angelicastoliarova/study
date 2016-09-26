package books;

import static org.junit.Assert.*;




import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static junit.framework.TestCase.assertTrue;

public class TestComparators {

   @Test
   public void testComparators() {
      Random random = new Random();
      Book[] books = new Book[random.nextInt(1000)];
       for (int i = 0; i < books.length; i++) {
           books[i] = new Book(random.nextInt(1000000) + "", random.nextInt(1000000) + "", random.nextInt(10000));
      }
        Arrays.sort(books, new TitleAuthorComparator());
       assertTrue(checkSortingByTitle(books));

     Arrays.sort(books, new TitleAuthorComparator());
       assertTrue(checkSortingByTitleAndAuthor(books));
       Arrays.sort(books, new AuthorTitleComparator());
       assertTrue(checkSortingByAuthorAndTitle(books));
      Arrays.sort(books, new AuthorTitlePriceComparator());
        assertTrue(checkSortingByAuthorAndTitleAndPrice(books));
   }

  private boolean checkSortingByTitle(Book[] books) {
       for (int i = 0; i < books.length - 1; i++) {
            if (books[i].getTitle().compareTo(books[i + 1].getTitle()) > 0) {
               return false;
          }      }
      return true;
   }


   private boolean checkSortingByTitleAndAuthor(Book[] books) {
      for (int i = 0; i < books.length - 1; i++) {
           if (books[i].getTitle().compareTo(books[i + 1].getTitle()) > 0) {
                return false;
           } else {
               if (books[i].getTitle().compareTo(books[i + 1].getTitle()) == 0) {
                  if (books[i].getAuthor().compareTo(books[i + 1].getAuthor()) > 0) {
                       return false;
                   }
              }
           }
       }
       return true;
    }


  private boolean checkSortingByAuthorAndTitle(Book[] books) {
       for (int i = 0; i < books.length - 1; i++) {
           if (books[i].getAuthor().compareTo(books[i + 1].getAuthor()) > 0) {
               return false;
          } else {
              if (books[i].getAuthor().compareTo(books[i + 1].getAuthor()) == 0) {
                  if (books[i].getTitle().compareTo(books[i + 1].getTitle()) > 0) {
                      return false;
                 }
             }
         }
     }
      return true;
   }

   private boolean checkSortingByAuthorAndTitleAndPrice(Book[] books) {
       for (int i = 0; i < books.length - 1; i++) {
           if (books[i].getAuthor().compareTo(books[i + 1].getAuthor()) > 0) {
              return false;
           } else {
               if (books[i].getAuthor().compareTo(books[i + 1].getAuthor()) == 0) {
                 if (books[i].getTitle().compareTo(books[i + 1].getTitle()) > 0) {
                     return false;
                 } else {
                     if (books[i].getPrice() > books[i].getPrice()) {
                         return false;
                      }
                  }                }
          }
     }
       return true;
   }

}