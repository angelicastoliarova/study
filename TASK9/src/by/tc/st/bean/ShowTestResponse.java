package by.tc.st.bean;

import java.util.List;

import by.tc.st.bean.entity.Qui;

public class ShowTestResponse extends Response {

	private List<Qui> notes = null;
	private int userId;
	private int testId;

	public List<Qui> getNotes() {
		return notes;
	}

	public void setNotes(List<Qui> notes) {
		this.notes = notes;
	}

	public int gettestId() {
		return testId;
	}

	public void settestId(int testId) {
		this.testId = testId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
