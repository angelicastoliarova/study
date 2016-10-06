package by.tc.nb.command.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import by.tc.nb.bean.LoadFileRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;

public class WriteNoteFromFile implements Command {
	public Response execute(Request request) throws CommandException {
	LoadFileRequest req = new LoadFileRequest();
	Response response = new Response();

	if (request instanceof LoadFileRequest) {
		req = (LoadFileRequest) request;
	} else {
		throw new CommandException("Wrong request");
	}
	String fileName = req.getLoadFileName();

	// PATH FOR SEARH FILE
	File loadFile = new File("./");
	String[] find = loadFile.list();
	int count = 0;
	for (String searchName : find) {
		if (searchName.equals(fileName)) {
			File f = new File(searchName);
			BufferedReader bf;
			try {
				bf = new BufferedReader(new FileReader(f));
				String line;
				while ((line = bf.readLine()) != null)
					System.out.println(line);
				bf.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			response.setErrorStatus(false);
			response.setResultMessage(fileName + " is load success!");
			count++;
			break;

		}
	}

	if (count == 0) {
		response.setErrorStatus(true);
		response.setErrorMessage(fileName + " does not found!!!");
		return response;

	}

	return response;
}
}
