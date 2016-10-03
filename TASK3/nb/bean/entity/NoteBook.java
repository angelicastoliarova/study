package by.tc.nb.bean.entity;

import java.util.ArrayList;
import java.util.List;

public class NoteBook {
	
	List<Note> notes=null;
	public NoteBook() {
		notes = new ArrayList<>();
	}
	public void addNote(Note newNote) {
		System.out.println(newNote);
	this.notes.add(newNote);
	}

}
