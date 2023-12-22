package baoveCSDL.Testing;



import baoveCSDL.connection.DbCon;
import baoveCSDL.dao.AddUserDao;
import baoveCSDL.model.Adduser;
import baoveCSDL.model.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.testng.Assert.*;

public class AddUserDaoTest {

    private Connection con;
    private AddUserDao addUserDao;

    @BeforeClass
    public void setUp() throws ClassNotFoundException, SQLException {
        con = DbCon.getConnetion();
        addUserDao = new AddUserDao(con);
    }

    @Test
    public void testRegisterAddUser() throws ClassNotFoundException {
        Adduser adduser = new Adduser();
        adduser.setName("Thắng");
        adduser.setEmail("thang@gmail.com");
        adduser.setPassword("12345");
        adduser.setSodienthoai("099858899");
        adduser.setDiachi("Đà Nẵng");

        int result = addUserDao.registerAdduser(adduser);
        assert result > 0 : "Đăng ký người dùng thất bại";
    }

    @Test
    public void testSearchUsers() {
        String query = "nhon";
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

