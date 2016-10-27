package by.tc.st.controller;

import java.util.HashMap;
import java.util.Map;

import by.tc.st.command.Command;
import by.tc.st.command.impl.AddNewQui;

import by.tc.st.command.impl.Authentication;
import by.tc.st.command.impl.FindQuiByTest;
import by.tc.st.command.impl.FormNewTest;
import by.tc.st.command.impl.Registration;

public class CommandHelper {

	private Map<String, Command> commands = new HashMap<String, Command>();

	public CommandHelper() {
		commands.put("ADD_NEW_QUI", new AddNewQui());
		commands.put("ADD_NEW_TEST", new FormNewTest());
		commands.put("FIND_QUI_BY_TEST", new FindQuiByTest());

		// commands.put("SHOW_ALL_QUI", new ShowAllQui());

		commands.put("AUTHENTICATION", new Authentication());
		commands.put("REGISTRATION", new Registration());
	}

	public Command getCommand(String commandName) {
		Command command;

		command = commands.get(commandName);

		return command;

	}

}