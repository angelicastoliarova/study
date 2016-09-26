package books;

public class ProgrammerBook extends Book {

	public ProgrammerBook(int isbn, String title, String author, int price) {
		super(isbn, title, author, price);

	}

	private String language;
	private int level;

	@Override
	public int hashCode() {
		final int value = 31;
		int result = super.hashCode();
		result = value * result + ((language == null) ? 0 : language.hashCode());
		result = value * result + level;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ProgrammerBook pbook = (ProgrammerBook) obj;
		if (language == null) {
			if (pbook.language != null) {
				return false;
			}
		} else if (!language.equals(pbook.language)) {
			return false;
		}
		if (level != pbook.level) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return getClass().getName() + "@" + "language" + language + "level" + level + super.toString();
	}

}
