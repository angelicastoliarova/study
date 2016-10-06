package by.tc.nb.bean;

public class SaveNotesRequest extends Request {
	private String note;
	private String fileName = "d:\\123.txt";

	public String getnote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	


	public String getFileName() {
		return fileName;
	}

}
