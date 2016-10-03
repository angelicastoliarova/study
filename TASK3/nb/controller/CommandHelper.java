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
		commands.put("ADD_NEW_NOTE", new AddNewNote()); //������� ����� �������
		commands.put("", new AddNewNote());//�������� ������ � �������
		commands.put("", new FindNotes()); //����� ������ � �������� �� �����������
		commands.put("", new FindNotesByDate());// ����� ������ � �������� �� ���� ��������
		commands.put("", new ShowNotes());// �������� ������ � ��������
		commands.put("", new WriteNoteToFile());// �������� ������� � ����
		commands.put("", new WriteNoteFromFile());// ��������� ������� �� �����
		//getClass().commands.put("CREATE_NEW_NOTE_BOOK", new CreateNewNoteBook()); //������� ����� �������

	}

	public Command getCommand(String commandName) {
		Command command;

		command = commands.get(commandName);

		return command;

	}

}