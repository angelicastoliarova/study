package by.tc.st.service.impl;

import java.util.List;

import by.tc.st.bean.entity.Qui;
import by.tc.st.dao.DAOFactory;
import by.tc.st.dao.exception.DAOException;
import by.tc.st.service.TestService;
import by.tc.st.service.exception.ServiceException;

public class TestServiceImpl implements TestService {

	@Override
	public List<Qui> findQuiByTest(int testId) throws ServiceException {

		if (testId <= 0) {
			throw new ServiceException("Test ID =0. It is wrong parameter");
		}

		try {
			return DAOFactory.getInstance().getTestDAO().findQuiByTest(testId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public void addQui(String note, int subject, String answer, String incorrectanswer) throws ServiceException {

		if (note == null || note.equals("") || answer == null || answer.equals("") || incorrectanswer == null
				|| incorrectanswer.equals("")) {
			throw new ServiceException("Illegal parameters");
		}

		try {
			DAOFactory.getInstance().getTestDAO().addQui(new Qui(note, subject, answer, incorrectanswer));
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<Qui> addTest(int subject, int numberOfTest, int quantityOfTests) throws ServiceException {
		if (subject <= 0 || numberOfTest <= 0 || quantityOfTests <= 0) {
			throw new ServiceException(" ID =0. It is wrong parameters");
		}

		try {
			return DAOFactory.getInstance().getTestDAO().findForAddingTest(subject, numberOfTest, quantityOfTests);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
}
