package by.tc.st.command;

import by.tc.st.bean.Request;
import by.tc.st.bean.Response;
import by.tc.st.command.exception.CommandException;

public interface Command {
	Response execute(Request request) throws CommandException;
}