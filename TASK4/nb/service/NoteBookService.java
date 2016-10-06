package by.tc.nb.service;

import java.util.List;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.service.exception.ServiceException;

public interface NoteBookService {

	void addNote(String note) throws ServiceException;

	void createNewNoteBook();

	List<Note> findNotesByContent(String keyWords) throws ServiceException;

	List<Note> findNotesByDate(String dateKey) throws ServiceException;

	void loadNoteBookFromFile(String loadFileName) throws ServiceException;

	void saveNoteBookToFile(String saveFileName) throws ServiceException;

}