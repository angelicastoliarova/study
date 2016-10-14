package by.tc.nb.dao;

import java.util.List;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.dao.exception.DAOException;

public interface NoteBookDAO {
	
	

	void findNoteByContent(String keyWord, int userID);

	void createNewNoteBook(int userID);

	void showAllNotes(int userID);

	void findNotesByDate(String dateKey, int userID);

	void addNote(Note note, int userID);



	
	
	

}