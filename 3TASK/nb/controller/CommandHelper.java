package by.tc.nb.controller;

import java.util.HashMap;
import java.util.Map;

import by.tc.nb.command.Command;
import by.tc.nb.command.impl.AddNewNote;
import by.tc.nb.command.impl.CreateNewNoteBook;
import by.tc.nb.command.impl.FindNotes;
import by.tc.nb.command.impl.FindNotesByDate;
import by.tc.nb.command.impl.ShowNotes;
import by.tc.nb.command.impl.WriteNoteFromFile;
import by.tc.nb.command.impl.WriteNoteToFile;

public class CommandHelper {

	private Map<String, Command> commands = new HashMap<String, Command>();

	public CommandHelper() {
		commands.put("ADD_NEW_NOTE", new AddNewNote()); // создать новый блокнот
		commands.put("", new AddNewNote());// добавить запись в Блокнот
		commands.put("FIND_NOTES_BY_CONTEXT", new FindNotes()); // найти записи
																// в блокноте по
																// содержимому
		commands.put("FIND_NOTES_BY_DATE", new FindNotesByDate());// найти
																	// записи в
																	// блокноте
																	// по дате
																	// создания
		commands.put("SHOW_NOTES", new ShowNotes());// показать записи в
													// блокноте
		commands.put("WRITE_NOTE_TO_FILE", new WriteNoteToFile());// записать
																	// блокнот в
																	// файл
		commands.put("WRITE_NOTE_FROM_FILE", new WriteNoteFromFile());// Загрузить
																		// блокнот
																		// из
																		// файла
		// getClass().commands.put("CREATE_NEW_NOTE_BOOK", new
		// CreateNewNoteBook()); //создать новый блокнот

	}

	public Command getCommand(String commandName) {
		Command command;

		command = commands.get(commandName);

		return command;

	}

}
