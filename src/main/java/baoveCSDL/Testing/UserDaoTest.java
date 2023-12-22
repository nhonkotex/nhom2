package baoveCSDL.Testing;



import java.sql.Connection;
import java.sql.SQLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baoveCSDL.connection.DbCon;
import baoveCSDL.dao.UserDao;
import baoveCSDL.model.User;

import static org.testng.Assert.*;

public class UserDaoTest {

    private Connection con;
    private UserDao userDao;

    @BeforeClass
    public void setUp() throws ClassNotFoundException, SQLException {
        con = DbCon.getConnetion(); 
        userDao = new UserDao(con);
    }

    @Test
    public void testUserLogin() {
        String email = "nhon@gmail.com";
        String password = "12345";

        User user = userDao.userLogin(email, password);

        assertNotNull(user);
        assertEquals(user.getEmail(), email);
    }

    @Test
    public void testUserLoginInvalid() {
        String email = "nhon1@gmail.com";
        String password = "12344";

        User user = userDao.userLogin(email, password);

        assertNull(user);
    }

    @AfterClass
    public void tearDown() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
