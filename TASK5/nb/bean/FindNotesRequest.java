package by.tc.nb.bean;

public class FindNotesRequest extends Request {
	private int userId;
	private String keyWords;


	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	

	public int getUserId() {

		return userId;
	}
}
