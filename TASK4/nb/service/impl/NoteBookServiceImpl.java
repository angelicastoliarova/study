package by.tc.nb.service.impl;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.exception.ServiceException;
import by.tc.nb.source.NoteBookProvider;

public class NoteBookServiceImpl implements NoteBookService {

	public void addNote(String note) throws ServiceException {

		if (note == null || "".equals(note)) {
			throw new ServiceException("Wrong parameter!");
		}

		Note newNote = new Note(note);

		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		noteBook.addNote(newNote);
	}

	@Override
	public void createNewNoteBook() {

		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();

		noteBook.clearNote();

	}

	public List<Note> findNotesByContent(String keyWords) throws ServiceException {

		if (keyWords == null || "".equals(keyWords)) {

			throw new ServiceException("Wrong parameter!");

		}

		List<Note> foundNotes = new ArrayList<Note>();

		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();

		foundNotes = noteBook.FindNotesByContent(keyWords);
		if (foundNotes.isEmpty())
			System.out.println("There is nothing found by yor request");
		else
			System.out.println("\nHere is found notes:\n");
		return foundNotes;

	}

	@Override

	public List<Note> findNotesByDate(String dateKey) throws ServiceException {

		List<Note> foundNotes;

		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();

		foundNotes = noteBook.FindNotesByDate(dateKey);
		if (!foundNotes.isEmpty()) {
			System.out.println("\nTake a result of search:\n");
		} else {
			System.out.println("\nSorry, but we found nothing by your date key\n");
		}
		return foundNotes;

	}

	@Override

	public void loadNoteBookFromFile(String loadFileName) throws ServiceException {

		try {

			FileInputStream loadFile = new FileInputStream(loadFileName);

			ObjectInputStream uncoding = new ObjectInputStream(loadFile);

			NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();

			while (loadFile.available() > 0) {

				Note currentNote = (Note) uncoding.readObject();
				noteBook.addNote(currentNote);

			}

			uncoding.close();

			loadFile.close();

		} catch (EOFException e) {

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}

	@Override

	public void saveNoteBookToFile(String fileLocation) throws ServiceException {

		try {

			FileOutputStream saveFile = new FileOutputStream(fileLocation);

			ObjectOutputStream codingSaveFile = new ObjectOutputStream(saveFile);

			NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();

			for (Note note : noteBook.getNotes()) {

				codingSaveFile.writeObject(note);

				codingSaveFile.reset();

			}

			codingSaveFile.close();

			saveFile.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}