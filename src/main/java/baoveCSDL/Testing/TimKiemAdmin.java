package baoveCSDL.Testing;

import static org.testng.Assert.assertFalse;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baoveCSDL.connection.DbCon;
import baoveCSDL.dao.AddUserDao;
import baoveCSDL.dao.addProductDao;
import baoveCSDL.model.Adduser;
import baoveCSDL.model.addProduct;

public class TimKiemAdmin {

    private Connection con;
    private AddUserDao addUserDao;

    @BeforeClass
    public void setUp() throws ClassNotFoundException, SQLException {
        con = DbCon.getConnetion();
        addUserDao = new AddUserDao(con);
    }

   
    @Test
    public void testSearchUsers() {
        String query = "thang";
        List<Adduser> users = addUserDao.searchUsers(query);

        assertFalse(users.isEmpty(), "Không tìm thấy người dùng với từ khóa " + query);

        for (Adduser user : users) {
            if (user.getName().toLowerCase().contains(query.toLowerCase())) {
                System.out.println("Tên người dùng: " + user.getName());
            }
        }
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

