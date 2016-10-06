package by.tc.nb.command.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import by.tc.nb.bean.FindNotesByDateRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.DateChekFormat;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;

public class FindNotesByDate implements Command {

	public Response execute(Request request) throws CommandException {
		Response response = new Response();
		FindNotesByDateRequest req = null;

		if (request instanceof FindNotesByDateRequest) {
			req = (FindNotesByDateRequest) request;
		} else {
			throw new CommandException("Wrong request");
		}

		String line;
		int lineNumber = 0;
		String fileName = req.getFileName();
		String keyWord = req.getSearchDate();
		File file = new File(fileName);
		BufferedReader br;

		if (DateChekFormat.isValid(keyWord)) {
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
					System.out.println("По заданному поиску ничего не найденно");
				response.setErrorStatus(false);
				response.setResultMessage("Поиск завершен успешно");

			} catch (FileNotFoundException e1) {
				response.setErrorStatus(true);
				response.setErrorMessage("не найден файл с таким именем: \'" + fileName + "\'. Попробуйте еще.");

			} catch (IOException e) {
				response.setErrorStatus(true);
				response.setErrorMessage("Error \'" + fileName + "\'. Попробуйте еще.");

			}
		} else {
			response.setErrorStatus(true);
			response.setErrorMessage(
					"WRONG FORMAT" + keyWord + "\nPlease write date in correct format. \'yyyy-MM-dd\' ");
			return response;
		}

		return response;
	}

}