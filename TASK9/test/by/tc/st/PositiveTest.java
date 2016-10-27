package by.tc.st;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PositiveTest {
	
	@Test
  @Parameters({"driver", "url", "username", "password"})
    public void connectToBD (String driver, String url, String userName, String password) throws Exception {
        Class.forName(driver).newInstance();
        
   
        Connection conn = DriverManager.getConnection(
                url, userName, password);
 
        Statement st = conn.createStatement();
        st.execute("DROP TABLE TESTS IF EXISTS");
        st.execute("CREATE TABLE TESTS(ID INT PRIMARY KEY, QUIS VARCHAR(255),  ANSWER VARCHAR(255));");
        st.execute("INSERT INTO TESTS VALUES(1, 'What collections do you know?', 'SET,MAP,LIST')");
        st.execute("INSERT INTO TESTS VALUES(2, 'Is there life on Mars?', 'OF COURSE');");
        st.execute("INSERT INTO TESTS VALUES(3, 'What is the purpose of life?', 'Love')");
        st.execute("INSERT INTO TESTS VALUES(4, 'Is JAVA the best?', 'YES!!');");
        ResultSet result = st.executeQuery("SELECT * FROM TESTS");
        String ID = "", QUIS = "", ANSWER = "";
 
        while (result.next()) {
        	QUIS = result.getString("QUIS");
            ID = result.getString("ID");
            ANSWER = result.getString("ANSWER");
            if (QUIS.equals("")) {
            	QUIS = "Вопрос отсутствует";
            }
            System.out.printf("%3s | %-10s | %-10s \n", ID, QUIS, ANSWER);
        }
    }

}
