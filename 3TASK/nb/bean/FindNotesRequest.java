package by.tc.nb.bean;

public class FindNotesRequest extends Request {

	private String keyWords;
	private String fileName = "d:\\123.txt";

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getFileName() {
		return fileName;
	}

}
