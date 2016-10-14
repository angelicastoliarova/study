package by.tc.nb.service;

import java.util.List;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.service.exception.ServiceException;

public interface NoteBookService {

	void addNote(String note, int userId) throws ServiceException;

	List<Note> findNotesByContent(String keyWords) throws ServiceException;

	boolean findNotesByDate(String dateKey, int userID) throws ServiceException;

	void loadNoteBookFromFile(String loadFileName) throws ServiceException;

	void saveNoteBookToFile(String saveFileName) throws ServiceException;

	void createNewNoteBook(int userID);

}