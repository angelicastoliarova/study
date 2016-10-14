package by.tc.nb.dao.factoty;

import by.tc.nb.dao.NoteBookDAO;
import by.tc.nb.dao.UserDAO;
import by.tc.nb.dao.impl.mysql.MySQLNoteBookDAO;
import by.tc.nb.dao.impl.mysql.MySQLUserDAO;

public class DAOFactory {

		private static final DAOFactory INSTANCE = new DAOFactory();

		private final NoteBookDAO noteBookDAO = new MySQLNoteBookDAO();
		private final UserDAO userDAO = new MySQLUserDAO();

		private DAOFactory() {

		}

		public static DAOFactory getInstance() {
			return INSTANCE;
		}

		public NoteBookDAO getNoteBookDAO() {
			return noteBookDAO;
		}

		public UserDAO getUserDAO() {
			return userDAO;
		}

	}