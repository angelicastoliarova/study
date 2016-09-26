package books;

public class Book implements Cloneable, Comparable<Book> {
	private String title;
	private String author;
	private int price;
	private int edition;
	private int isbn;

	public Book(int isbn, String title, String author, int price) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}


	public int getisbn() {
		return isbn;
	}

	@Override
	public int hashCode() {
		final int value = 31;
		int result = 1;
		result = value * result + ((author == null) ? 0 : author.hashCode());
		result = value * result + edition;
		result = value * result + price;
		result = value * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Book book = (Book) obj;

		if (edition != book.edition) {
			return false;
		}
		if (price != book.price) {
			return false;
		}
		if (author == null) {
			if (book.author != null) {
				return false;
			}
		} else if (!author.equals(book.author)) {
			return false;
		}
		if (title == null) {
			if (book.title != null) {
				return false;
			}
		} else if (!title.equals(book.title)) {
			return false;
		}
		return true;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Book clone = new Book(isbn, title, author, price);
		return clone;
	}

	@Override
	public String toString() {
		return getClass().getName() + "@ " + "isbn " + isbn + " title " + title + " author " + author + " price "
				+ price + " edition " + edition;
	}

	@Override
	public int compareTo(Book anotherBook) {
		int anotherIsbn = anotherBook.getisbn();
		return this.isbn - anotherIsbn;
	}

	public String getTitle() {
	
		return title;
	}

	public String getAuthor() {
	
		return author;
	}

	public int getPrice() {
		
		return price;
	}

}
