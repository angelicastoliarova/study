package by.tc.st.service;

import java.util.List;

import by.tc.st.bean.entity.Qui;
import by.tc.st.service.exception.ServiceException;

public interface TestService {
    void addQui(String note,int subject, String answer, String incorrectanswer) throws ServiceException;
   // void addTest(int subject, int numberOfTest, int quantityOfTests) throws ServiceException;
    List<Qui> findQuiByTest(int testId) throws ServiceException;
    List<Qui> addTest(int subject, int numberOfTest, int quantityOfTests) throws ServiceException;
}
