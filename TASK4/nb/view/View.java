package by.tc.nb.view;

import java.util.Scanner;

import by.tc.nb.bean.AddNoteRequest;
import by.tc.nb.bean.FindNotesByDateRequest;
import by.tc.nb.bean.FindNotesRequest;
import by.tc.nb.bean.LoadFileRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.SaveNotesRequest;
import by.tc.nb.bean.ShowNoteRequest;
import by.tc.nb.controller.Controller;

public class View {

	public static void main(String[] args) {
		int command = 0;
		// Controller controller = new Controller();
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Input  instruction from 1 to 6");
			command = sc.nextInt();
		} catch (Exception e) {
			System.out.println(e);
		}
		switch (command) {
		case 1:
			int request1 = 1;
			System.out.print("Enter message: ");
			String str = new Scanner(System.in).nextLine();
			AddNoteRequest request = new AddNoteRequest();
			String CommandName = "ADD_NEW_NOTE";
			request.setNote(str);
			doRequest(str, CommandName, request1);
			break;

		case 2:
			int request2 = 2;
			System.out.println("Enter the contex to find the notebook: ");
			String str1 = new Scanner(System.in).nextLine();
			String str2 = "FIND_NOTES_BY_CONTEXT";
			doRequest(str1, str2, request2);
			break;
		case 3:
			int request3 = 3;
			System.out.println("Enter the date to find the notebook: ");
			String str3 = new Scanner(System.in).nextLine();
			String str4 = "FIND_NOTES_BY_DATE";
			doRequest(str3, str4, request3);
			break;
		case 4:
			int request4 = 4;
			// System.out.println("Enter the path to find the notebook: ");
			// String str5 = new Scanner(System.in).nextLine();
			String str6 = "SHOW_NOTES";
			doRequest("", str6, request4);
			break;
		case 5:
			int request5 = 5;
			System.out.println("Enter the notes to write to the notebook: ");
			String str7 = new Scanner(System.in).nextLine();
			String str8 = "WRITE_NOTE_TO_FILE";
			doRequest(str7, str8, request5);
			break;
		case 6:
			int request6 = 6;
			System.out.println("Enter the path to notebook to read the note:");
			String str9 = new Scanner(System.in).nextLine();
			String str10 = "WRITE_NOTE_FROM_FILE";
			doRequest(str9, str10, request6);
			break;

		}
	}

	private static void doRequest(String str1, String str2, int request) {

		Controller controller = new Controller();
		if (request == 1) {
			AddNoteRequest request1 = new AddNoteRequest();
			request1.setCommandName(str2);
			request1.setNote(str1);
			Response response = controller.doRequest(request1);
			if (response.isErrorStatus() == false) {

				System.out.println(response.getResultMessage());
			} else {
				System.out.println(response.getErrorMessage());

			}

		} else if (request == 2) {
			FindNotesRequest request1 = new FindNotesRequest();
			request1.setCommandName(str2);
			request1.setKeyWords(str1);
			Response response = controller.doRequest(request1);
			if (response.isErrorStatus() == false) {

				System.out.println(response.getResultMessage());
			} else {
				System.out.println(response.getErrorMessage());

			}
		} else if (request == 3) {
			FindNotesByDateRequest request1 = new FindNotesByDateRequest();
			request1.setCommandName(str2);
			request1.setSearchDate(str1);
			Response response = controller.doRequest(request1);
			if (response.isErrorStatus() == false) {

				System.out.println(response.getResultMessage());
			} else {
				System.out.println(response.getErrorMessage());

			}
		} else if (request == 4) {
			ShowNoteRequest request1 = new ShowNoteRequest();
			request1.setCommandName(str2);
			// request1.setSearchDate(str1);
			Response response = controller.doRequest(request1);
			if (response.isErrorStatus() == false) {

				System.out.println(response.getResultMessage());
			} else {
				System.out.println(response.getErrorMessage());

			}
		} else if (request == 5) {
			SaveNotesRequest request1 = new SaveNotesRequest();
			request1.setCommandName(str2);
			request1.setNote(str1);
			Response response = controller.doRequest(request1);
			if (response.isErrorStatus() == false) {

				System.out.println(response.getResultMessage());
			} else {
				System.out.println(response.getErrorMessage());

			}
		} else if (request == 6) {
			LoadFileRequest request1 = new LoadFileRequest();
			request1.setCommandName(str2);
			request1.setLoadFileName(str1);
			Response response = controller.doRequest(request1);
			if (response.isErrorStatus() == false) {

				System.out.println(response.getResultMessage());
			} else {
				System.out.println(response.getErrorMessage());

			}
		}

	}

}
