package by.tc.st.service;

import by.tc.st.bean.entity.User;
import by.tc.st.service.exception.ServiceException;

public interface UserService {

	    User logination(String login, String password) throws ServiceException;
	    boolean registration(String login, String password) throws ServiceException;

	}

