package by.tc.nb.bean.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NoteBook implements Serializable {

	Note newNote;
	List<Note> notes;

	public NoteBook() {
		notes = new LinkedList<Note>();
	}

	public void add(Note newNote) {
		this.notes.add(newNote);
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void clearNoteBook() {
		this.notes.clear();

	}

	public List<Note> FindNotesByContent(String keyWords) {
		List<Note> wishContent = new ArrayList<>();
		for (Note find : notes) {
			if (find.getNote().contains(keyWords))
				wishContent.add(find);
		}

		return wishContent;
	}

	public List<Note> FindNotesByDate(String dateToFind) {

		List<Note> searchDate = new ArrayList<Note>();

		for (Note wishDate : this.getNotes()) {
			if (wishDate.getNote().contains(dateToFind)) {
				searchDate.add(wishDate);
			}
		}
		return searchDate;
	}

	public void showNotes() {
		System.out.println("Here is all your notes");

	}

	public void addNote(Note currentNote) {
	
	}
}