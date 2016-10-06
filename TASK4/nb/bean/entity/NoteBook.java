package by.tc.nb.bean.entity;

import java.util.ArrayList;
import java.util.List;

public class NoteBook {

	List<Note> notes = null;

	public NoteBook() {
		notes = new ArrayList<>();
	}

	public void addNote(Note newNote) {
		System.out.println(newNote.note);
		this.notes.add(newNote);
	}

	public void writeNoteBook(Note newNote) {
		System.out.println(newNote.note);
		this.notes.add(newNote);
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

	public List<Note> getNotes() {
		return notes;
	}

	public void clearNote() {
		this.notes.clear();

	}

}
