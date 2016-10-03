package by.tc.nb.view;

import java.util.Scanner;

import by.tc.nb.bean.AddNoteRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.controller.Controller;

public class View {

	public static void main(String[] args) {
		int command = 0;
		Controller controller = new Controller();
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Input  instruction");
			command = sc.nextInt();
		} catch (Exception e) {
			System.out.println(e);
		}
		switch (command) {
		case 1:
			System.out.print("Enter message: ");
			String str = new Scanner(System.in).nextLine();
			AddNoteRequest request = new AddNoteRequest();
			request.setCommandName("ADD_NEW_NOTE");
			request.setNote(str);
			// System.out.println(request);
			Response response = controller.doRequest(request);

			if (response.isErrorStatus() == false) {

				System.out.println(response.getResultMessage());
			} else {
				System.out.println(response.getErrorMessage());
			}
		}

	}

}
