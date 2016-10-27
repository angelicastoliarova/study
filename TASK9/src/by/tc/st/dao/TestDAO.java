package by.tc.st.dao;

import java.util.List;

import by.tc.st.bean.entity.Qui;
import by.tc.st.dao.exception.DAOException;

public interface TestDAO {
	  void addQui(Qui qui) throws DAOException;
	 
	   List<Qui> findQuiByTest(int id) throws DAOException;
	   List<Qui> findForAddingTest(int subject,int numberOfTest,int quantityOfTests) throws DAOException;
	
}
