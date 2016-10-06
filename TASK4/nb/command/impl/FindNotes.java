package by.tc.nb.command.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import by.tc.nb.bean.FindNotesRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;

public class FindNotes implements Command {

	@Override
	public Response execute(Request request) throws CommandException {
		Response response = new Response();
		FindNotesRequest req = new FindNotesRequest();
		if (request instanceof FindNotesRequest) {
			req = (FindNotesRequest) request;
		} else {
			throw new CommandException("Wrong request");
		}

		String line;
		int lineNumber = 0;
		String fileName = req.getFileName();
		String keyWord = req.getKeyWords();
		File file = new File(fileName);
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			while ((line = br.readLine()) != null) {
				lineNumber++;
				if (line.contains(keyWord)) {
					System.out.println("Was found on the " + lineNumber + " line: " + line);
				}
			}
			br.close();
			if (lineNumber == 0)
				System.out.println("По заданному поиску ничего не найденно ");
			response.setErrorStatus(false);
			response.setResultMessage("Поиск завершен успешно");

		} catch (FileNotFoundException e1) {
			response.setErrorStatus(true);
			response.setErrorMessage("файл с таким именем не существует: " + fileName );

		} catch (IOException e) {
			response.setErrorStatus(true);
			response.setErrorMessage("Error" + fileName + ". Попробуйте еще.");

		}

		return response;
	}
}
