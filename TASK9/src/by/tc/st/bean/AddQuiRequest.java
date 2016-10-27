package by.tc.st.bean;

public class AddQuiRequest extends Request { 
	
		private String qui;
		private String answer;
		private String incorrectanswer;
		private int  subject;
		private int userId;

	    public int getSubject() {
	        return subject;
	    }

	    public void setSubject(int subject) {
	        this.subject = subject;
	    }
		public String getQui() {
			return qui;
		}

		public void setAnswer(String answer) {
			this.answer = answer;
		}
		public String getAnswer() {
			return answer;
		}
		public void setIncorrectAnswer(String incorrectanswer) {
			this.incorrectanswer = incorrectanswer;
		}
		public String getIncorrectAnswer() {
			return incorrectanswer;
		}

		public void setQui(String qui) {
			this.qui = qui;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}
	}


