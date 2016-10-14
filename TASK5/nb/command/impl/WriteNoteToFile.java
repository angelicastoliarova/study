package by.tc.nb.command.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.SaveNotesRequest;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

public class WriteNoteToFile implements Command {

	public Response execute(Request request) throws CommandException {

		SaveNotesRequest req = new SaveNotesRequest();
		Response response = new Response();
		if (request instanceof SaveNotesRequest) {
			req = (SaveNotesRequest) request;
		} else {
			throw new CommandException("Wrong request");
		}

		String filePath = req.getFileName();
	
		
		
		Note newNote = new Note(req.getnote());
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		System.out.println(req.getnote());
		noteBook.addNote(newNote);
		List<Note> notes = NoteBookProvider.getInstance().getNoteBook().getNotes();

		for (Note ad : noteBook.getNotes()) {
			PrintWriter save;
			try {
				File fileName = new File(filePath);
				save = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
				save.println(ad.getNote());
				save.close();
				response.setErrorStatus(false);
				response.setResultMessage("Notes is saved to file: \'" + filePath + "\'");
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

		return response;
	}
}
