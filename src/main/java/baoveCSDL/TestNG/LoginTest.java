package baoveCSDL.TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baoveCSDL.dao.AdminDao;
import baoveCSDL.model.Admin;

public class LoginTest {
	
	
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
    public void testEmptyLoginFields() {
        AdminDao adminDao = new AdminDao(con);

        // Đối với trường hợp này, bạn cần đảm bảo rằng việc đăng nhập sẽ thất bại khi không có thông tin đăng nhập
        Admin loggedInAdmin = adminDao.adminLogin("", "");

        // Kiểm tra xem người dùng đăng nhập có không
        assertNull(loggedInAdmin, "Đăng nhập không thành công với các trường trống");

      
    }
    //Xác minh đăng nhập không thành công khi bỏ trống trường Password
    @Test
    public void testLoginWithEmptyPassword() {
        AdminDao adminDao = new AdminDao(con);

        // Đăng nhập với trường Email hợp lệ nhưng trường Password bị trống
        Admin loggedInAdmin = adminDao.adminLogin("nhon@gmail.com", "");

        // Kiểm tra xem người dùng đăng nhập có thành công không
        assertNull(loggedInAdmin, "Đăng nhập thành công khi bỏ trống trường Password");

       
    }
    //Xác minh đăng nhập không thành công khi không nhập đúng định dạng có  "@" và "."
    @Test
    public void testLoginWithInvalidEmailFormat() {
        AdminDao adminDao = new AdminDao(con);

        // Đăng nhập với định dạng Email không hợp lệ
        Admin loggedInAdmin = adminDao.adminLogin("nhon_gmail_com", "123456");

        // Kiểm tra xem người dùng đăng nhập có thành công không
        assertNull(loggedInAdmin, "Đăng nhập thành công với định dạng Email không hợp lệ");

       
    }
    //Xác minh đăng nhập không thành công khi nhập sai Password
    @Test
    public void testLoginSaiPassword() {
        AdminDao adminDao = new AdminDao(con);

        // Đăng nhập với định dạng Email không hợp lệ
        Admin loggedInAdmin = adminDao.adminLogin("nhon@gmail.com", "123456aa");

        // Kiểm tra xem người dùng đăng nhập có thành công không
        assertNull(loggedInAdmin, "Đăng nhập thành công với mật Khẩu sai");

       
    }
    //Xác minh đăng nhập không thành công khi nhập quá 20 ký tự ở trường Password
    @Test
    public void testLoginWithLongPassword() {
        AdminDao adminDao = new AdminDao(con);

        // Tạo một mật khẩu có độ dài lớn hơn 20 ký tự
        String longPassword = "123456789012345678901";

        // Đăng nhập với mật khẩu có độ dài lớn hơn 20 ký tự
        Admin loggedInAdmin = adminDao.adminLogin("nhon@gmail.com", longPassword);

        // Kiểm tra xem người dùng đăng nhập có thành công không
        assertNull(loggedInAdmin, "Đăng nhập thành công với mật khẩu có độ dài lớn hơn 20 ký tự");

    }
    //Xác minh đăng nhập không thành công khi nhập ít hơn 8 ký tự ở trường Password
    @Test
    public void testLoginWithShortPassword() {
        AdminDao adminDao = new AdminDao(con);

        // Tạo một mật khẩu có độ dài ít hơn 8 ký tự
        String shortPassword = "123456";

        // Đăng nhập với mật khẩu có độ dài ít hơn 8 ký tự
        Admin loggedInAdmin = adminDao.adminLogin("nhon@gmail.com", shortPassword);

        // Kiểm tra xem người dùng đăng nhập có thành công không
        assertNull(loggedInAdmin, "Đăng nhập thành công với mật khẩu có độ dài ít hơn 8 ký tự");
    }


   
    @Test
    public void testGetLoggedInUserName() {
        AdminDao adminDao = new AdminDao(con);

        
        String loggedInUserName = adminDao.getLoggedInUserName("nhon@gmail.com", "123456");

       
        assertNotNull(loggedInUserName, "Tên người dùng không được null");

        
        assertEquals(loggedInUserName, "Cao Nhật Nhơn", "Tên người dùng không đúng");
    }
    
}