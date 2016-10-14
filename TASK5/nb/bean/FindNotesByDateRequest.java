package by.tc.nb.bean;

public class FindNotesByDateRequest  extends Request {

	private String searchDate;
private int userId;


	public String getSearchDate() {
		return searchDate;
	}

	public int getUserId() {

		return userId;
	}
	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}

}
