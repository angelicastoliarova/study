package by.tc.st.view;

import java.util.ArrayList;

public class CommandNameValidator {
	private static ArrayList<String> commandNames = new ArrayList<String>() {
		{
			this.add("ADD_NEW_QUI");
			this.add("FIND_QUI_BY_TEST");
			this.add("ADD_NEW_TEST");
			this.add("SHOW_ALL_QUI");

			this.add("AUTHENTICATION");
			this.add("REGISTRATION");
		}
	};

	public static boolean isValid(String commandName) {
		if (commandName == null) {
			return false;
		} else if (commandName.equals("")) {
			return false;
		} else if (!commandNames.contains(commandName)) {
			return false;
		}
		return true;
	}

}
