package baoveCSDL.Testing;

import static org.testng.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baoveCSDL.dao.AdminDao;
import baoveCSDL.model.Admin;

public class LoginAdmin {
    private Connection con;

    // Phương thức để thiết lập kết nối trước khi chạy các phương thức kiểm thử
    @BeforeMethod
    public void setUp() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhom9", "root", "07191908");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 
    @Test
    public void testAdminLogin() {
        AdminDao adminDao = new AdminDao(con);

       
        Admin loggedInAdmin = adminDao.adminLogin("nhon@gmail.com", "123456");

        // Kiểm tra xem người dùng đăng nhập có không
        assertNotNull(loggedInAdmin, "Đăng nhập không thành công");

        
        assertEquals(loggedInAdmin.getName(), "Cao Nhật Nhơn", "Tên người dùng không đúng");
        assertEquals(loggedInAdmin.getEmail(), "nhon@gmail.com", "Email người dùng không đúng");
    }
    
    // để trống các trường 
    @Test
    public void testLoginWithEmptyFields() {
        AdminDao adminDao = new AdminDao(con);

        // Đăng nhập với tất cả các trường thông tin bị trống
        Admin loggedInAdmin = adminDao.adminLogin("", "");

        // Kiểm tra xem người dùng đăng nhập có thành công không (ví dụ: quy định hệ thống)
        assertNotNull(loggedInAdmin, "Đăng nhập không thành công với các trường trống");

       
    }


   
    @Test
    public void testGetLoggedInUserName() {
        AdminDao adminDao = new AdminDao(con);

        
        String loggedInUserName = adminDao.getLoggedInUserName("nhon@gmail.com", "123456");

       
        assertNotNull(loggedInUserName, "Tên người dùng không được null");

        
        assertEquals(loggedInUserName, "Cao Nhật Nhơn", "Tên người dùng không đúng");
    }
}