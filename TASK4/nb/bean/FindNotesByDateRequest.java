package by.tc.nb.bean;

public class FindNotesByDateRequest  extends Request {

	private String searchDate;
	private String fileName = "d:\\123.txt";
	
	public String getFileName() {
		return fileName;
	}

	public String getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}

}
