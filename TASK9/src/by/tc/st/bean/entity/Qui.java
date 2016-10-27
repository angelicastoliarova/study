package by.tc.st.bean.entity;

import java.io.Serializable;

public class Qui implements Serializable {

	private String data;
	private int subject;
	private int testId;
	private int correctanswerId;
	private String answer;
	private String incorrectanswer;

	public Qui(String data) {
		this.data = data;
	}

	public Qui(String data, int subject, String answer, String incorrectanswer) {
		this.data = data;
		this.subject = subject;
		this.answer = answer;
		this.incorrectanswer = incorrectanswer;
	}

	public Qui(String data, int test) {
		this.data = data;
		// this.subject = subject;
		this.testId = test;
	}

	public Qui(String data, int test, int correctanswerId) {
		this.data = data;
		this.correctanswerId = correctanswerId;
		this.testId = test;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getcorrectanswerId() {
		return correctanswerId;
	}

	public void setcorrectanswerId(int correctanswerId) {
		this.correctanswerId = correctanswerId;
	}

	public String getincorrectanswer() {
		return incorrectanswer;
	}

	public void setincorrectanswer(String incorrectanswer) {
		this.incorrectanswer = incorrectanswer;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getSubject() {
		return subject;
	}

	public int getTestId() {
		return testId;
	}

	public void setSubject(int subject) {
		this.subject = subject;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public void printQui() {
		System.out.println(this.data);
	}

}
