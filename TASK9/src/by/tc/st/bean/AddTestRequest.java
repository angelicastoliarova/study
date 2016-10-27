package by.tc.st.bean;

public class AddTestRequest extends Request {
	private String qui;
	private int subject;
	private int numberTest;
	private int quantityOfTests;

	public void setSubject(int subject) {
		this.subject = subject;
	}

	public int getSubject() {
		return subject;
	}

	public void setnumberTest(int numberTest) {
		this.numberTest = numberTest;
	}
	public int getnumberTest() {
		return numberTest;
	}
	public void setquantityOfTests(int quantityOfTests) {
		this.quantityOfTests = quantityOfTests;
	}
	public int getquantityOfTests() {
		return quantityOfTests;
	}



	public String getQui() {
		return qui;
	}

	public void setQui(String qui) {
		this.qui = qui;
	}

}
