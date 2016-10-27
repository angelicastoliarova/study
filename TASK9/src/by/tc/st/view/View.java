package by.tc.st.view;

import java.util.Scanner;

import by.tc.st.bean.AddQuiRequest;
import by.tc.st.bean.AddTestRequest;
import by.tc.st.bean.AuthenticationRequest;
import by.tc.st.bean.AuthenticationResponse;
import by.tc.st.bean.FindTestRequest;
import by.tc.st.bean.RegistrationRequest;
import by.tc.st.bean.Response;
import by.tc.st.bean.ShowTestResponse;
import by.tc.st.bean.entity.Qui;
import by.tc.st.bean.entity.User;
import by.tc.st.controller.Controller;
import by.tc.st.dao.pool.ConnectionPool;

public class View {
	private static final Controller controller = new Controller();
	private static final Scanner scanner = new Scanner(System.in);
	private static boolean exitFlag = true;
	private static String helpTutor = "1 - add new question.\n2 - Form/Create the test.";
	private static String helpStudent = "3 - Look at list of tests.\n4 - pass the exam.";

	public static void main(String[] args) throws Exception {

		System.out.println("Hello, my friend");

		while (exitFlag) {
			System.out.print("Enter 1 for authentication, 2 for registration, -1 for exit: ");
			String mainCommand = scanner.nextLine();
			switch (mainCommand) {
			// AUTHENTICATION
			case "1":
				System.out.print("Enter your login: ");
				String authLogin = scanner.nextLine();
				System.out.print("Enter your password: ");
				String authPassword = scanner.nextLine();
				AuthenticationRequest authenticationRequest = new AuthenticationRequest();
				authenticationRequest.setLogin(authLogin);
				authenticationRequest.setPassword(authPassword);
				authenticationRequest.setCommandName("AUTHENTICATION");
				AuthenticationResponse authenticationResponse = (AuthenticationResponse) controller
						.doRequest(authenticationRequest);
				if (!authenticationResponse.isErrorStatus()) {
					User currentUser = authenticationResponse.getUser();
					int sessionId = currentUser.getId();
					String role = currentUser.getRole();
					// System.out.println("Hello, " + currentUser.getLogin() +
					// "!");
					System.out.println("Hello, " + role + "!");
					while (true) {
						System.out.print("Enter 'help' or -1 for logout:");
						String localCommand = scanner.nextLine();

						if (localCommand.equals("-1")) {
							System.out.println("You have been logout!");
							break;
						}

						switch (localCommand) {
						// HELP
						case "help":
							if (role.equals("student")) {
								System.out.println(helpStudent);
								break;
							} else if (role.equals("tutor")) {
								System.out.println(helpTutor);
								break;
							}

							// ADD NEW Question
						case "1":
							System.out.print("Enter  the number of subject: ");
							int subject = new Scanner(System.in).nextInt();
							System.out.print("Enter a new question: ");
							String question = new Scanner(System.in).nextLine();
							System.out.print("Enter the correct answer: ");
							String answer = new Scanner(System.in).nextLine();
							System.out.print("Enter the incorrect answer: ");
							String incorrectanswer = new Scanner(System.in).nextLine();
							AddQuiRequest addQuiRequest = new AddQuiRequest();
							addQuiRequest.setCommandName("ADD_NEW_QUI");
							addQuiRequest.setAnswer(answer);
							addQuiRequest.setIncorrectAnswer(incorrectanswer);
							addQuiRequest.setQui(question);
							addQuiRequest.setSubject(subject);
							addQuiRequest.setUserId(sessionId);
							Response addNoteResponse = controller.doRequest(addQuiRequest);
							if (addNoteResponse.isErrorStatus() == false) {
								System.out.println(addNoteResponse.getResultMessage());
							} else {
								System.out.println(addNoteResponse.getErrorMessage());
							}
							break;
						case "2":
							System.out.print("Enter  the number of subject: ");
							int choosesubject = new Scanner(System.in).nextInt();
							System.out.print("Enter a number of test, wich you want create: ");
							int numberOfTest = new Scanner(System.in).nextInt();
							System.out.print("Enter how many tests should be include in the test ");
							int quantityOfTests = new Scanner(System.in).nextInt();

							AddTestRequest createTest = new AddTestRequest();
							createTest.setCommandName("ADD_NEW_TEST");
							createTest.setSubject(choosesubject);
							createTest.setnumberTest(numberOfTest);
							createTest.setquantityOfTests(quantityOfTests);

							Response addTestResponse = controller.doRequest(createTest);
							if (addTestResponse.isErrorStatus() == false) {
								System.out.println(addTestResponse.getResultMessage());
							} else {
								System.out.println(addTestResponse.getErrorMessage());
							}
							break;

						// ShowTestResponse showResult = (ShowTestResponse)
						// controller.doRequest(createTest);
						// if (showResult.isErrorStatus() == false) {
						// if (showResult.getNotes().size() == 0) {
						// System.out.println("Result is empty");
						// } else {
						// showResult.getNotes().stream().forEach((element) ->
						// element.printQui());
						// }
						// } else {
						// System.out.println(showResult.getErrorMessage());
						// }
						// break;

						case "3":
							System.out.print("Enter the number of test ");
							int idtest = new Scanner(System.in).nextInt();
							FindTestRequest findTestRequest = new FindTestRequest();
							findTestRequest.setCommandName("FIND_QUI_BY_TEST");
							findTestRequest.setTestId(idtest);
							findTestRequest.setUserId(sessionId);

							ShowTestResponse showTests = (ShowTestResponse) controller.doRequest(findTestRequest);
							if (showTests.isErrorStatus() == false) {
								if (showTests.getNotes().size() == 0) {
									System.out.println("Result is empty");
								} else {
									showTests.getNotes().stream().forEach((element) -> element.printQui());
								}
							} else {
								System.out.println(showTests.getErrorMessage());
							}
							break;
						case "4":
							System.out.print("Enter the number of test ");
							int idtest2 = new Scanner(System.in).nextInt();
							FindTestRequest findTestRequest2 = new FindTestRequest();
							findTestRequest2.setCommandName("FIND_QUI_BY_TEST");
							findTestRequest2.setTestId(idtest2);
							findTestRequest2.setUserId(sessionId);

							ShowTestResponse showTests2 = (ShowTestResponse) controller.doRequest(findTestRequest2);
							if (showTests2.isErrorStatus() == false) {
								if (showTests2.getNotes().size() == 0) {
									System.out.println("Result is empty");
								} else {

									for (Qui element : showTests2.getNotes()) {
										
										element.printQui();
										System.out.println("Enter the correct answer ");
										System.out.println("correct answer "+element.getcorrectanswerId());
										int userAnswer = new Scanner(System.in).nextInt();
										if (userAnswer==element.getcorrectanswerId()) {
											System.out.println("you're right");
										}
										else {System.out.println("you are not right");}
									}

									//showTests2.getNotes().stream().forEach((element) -> element.printQui());
								}
							} else {
								System.out.println(showTests2.getErrorMessage());
							}
							break;

						}
					}
				} else {
					System.out.println(authenticationResponse.getErrorMessage());
				}
				break;
			// REGISTRATION
			case "2":
				System.out.print("Enter your login: ");
				String regLogin = scanner.nextLine();
				;
				System.out.print("Enter your password: ");
				String regPassword = scanner.nextLine();
				;
				RegistrationRequest registrationRequest = new RegistrationRequest();
				registrationRequest.setCommandName("REGISTRATION");
				registrationRequest.setLogin(regLogin);
				registrationRequest.setPassword(regPassword);
				Response registrationResponse = controller.doRequest(registrationRequest);
				if (registrationResponse.isErrorStatus() == false) {
					System.out.println(registrationResponse.getResultMessage());
				} else {
					System.out.println(registrationResponse.getErrorMessage());
				}
				break;
			case "-1":
				System.out.println("Good bye, my friend!");
				ConnectionPool.getInstance().closePool();
				exitFlag = false;
				break;
			default:
				System.out.println("Command does not exits!");
				break;
			}
		}

	}
}
