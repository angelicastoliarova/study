package by.tc.nb.bean.entity;

import java.io.Serializable;

public class Note implements Serializable {

		FullDate date = new FullDate();

		private String note;

		public Note(String note) {

			this.note = note;

		}

		public String getNote() {
			return note;
		}

		public String getDate() {

			return date.getFullDate();
		}

	}