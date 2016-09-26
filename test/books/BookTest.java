package books;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static junit.framework.TestCase.assertTrue;

public class BookTest {

	@Test
	public void test() {
		Random random = new Random();
		Book[] books = new Book[random.nextInt(500)];
		for (int i = 0; i < books.length; i++) {
			books[i] = new Book(random.nextInt(500000), "voina", "tolstoy", 10);

		}
		Arrays.sort(books);
		assertTrue(isSortedBooks(books));
	}

	private static boolean isSortedBooks(Book[] books) {
		for (int i = 0; i < books.length - 1; i++) {
		
			if (books[i].getisbn() > books[i + 1].getisbn()) {

				return false;
			}
		}
		return true;
	}
}