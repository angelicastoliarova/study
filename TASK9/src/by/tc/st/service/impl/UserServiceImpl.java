package by.tc.st.service.impl;

import by.tc.st.bean.entity.User;
import by.tc.st.dao.DAOFactory;
import by.tc.st.dao.exception.DAOException;
import by.tc.st.service.UserService;
import by.tc.st.service.exception.ServiceException;

public class UserServiceImpl implements UserService {
    @Override
    public User logination(String login, String password) throws ServiceException {
        if(login == null || login.equals("") || password == null || password.equals("")) {
            throw new ServiceException("Illegal parameters");
        }

        try {
            return DAOFactory.getInstance().getUserDAO().logination(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean registration(String login, String password) throws ServiceException {
        if(login == null || login.equals("") || password == null || password.equals("")) {
            throw new ServiceException("Illegal parameters");
        }

        try {
            return DAOFactory.getInstance().getUserDAO().registration(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}