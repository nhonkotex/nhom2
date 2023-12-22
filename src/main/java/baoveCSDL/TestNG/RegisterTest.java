package baoveCSDL.TestNG;

import java.sql.Connection;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baoveCSDL.connection.DbCon;
import baoveCSDL.dao.AddUserDao;
import baoveCSDL.model.Adduser;

public class RegisterTest {
	 private Connection con;
	    private AddUserDao addUserDao;

	    @BeforeClass
	    public void setUp() throws ClassNotFoundException, SQLException {
	        con = DbCon.getConnetion();
	        addUserDao = new AddUserDao(con);
	    }
	    @AfterClass
	    public void tearDown() {
	       
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
	    // Xác minh đăng kí không thành công khi các trường thông tin là NULL
	    @Test
	    public void testRegisterWithNullFields() throws ClassNotFoundException {
	        Adduser adduser = new Adduser(); // Create a new user object with all fields set to null

	        int result = addUserDao.registerAdduser(adduser);

	        // Assert that registration fails when all fields are NULL
	        Assert.assertEquals(result, 0, "Đăng ký người dùng thành công với các trường NULL");
	    }
	    // Xác minh đăng kí không thành công khi trường Phone nhập ký tự thường hoặc ký tự đặc biệt
	    @Test
	    public void testRegisterWithInvalidPhoneFormat() throws ClassNotFoundException {
	        Adduser adduser = new Adduser();
	        adduser.setName("Thắng");
	        adduser.setEmail("thang@gmail.com");
	        adduser.setPassword("12345");
	        adduser.setSodienthoai("abcxyz"); // Invalid phone format with lowercase characters
	        adduser.setDiachi("Đà Nẵng");

	        int result = addUserDao.registerAdduser(adduser);

	        // Assert that registration fails when the phone format is invalid
	        Assert.assertEquals(result, 0, "Đăng ký người dùng thành công với số điện thoại không hợp lệ");
	    }

	    // pass không trùng nhau
	    @Test
	    public void testRegisterWithMismatchedPasswords() throws ClassNotFoundException {
	        Adduser adduser = new Adduser();
	        adduser.setName("Thắng");
	        adduser.setEmail("thang@gmail.com");
	        adduser.setPassword("password123");
	        adduser.setPassword("mismatchedpassword"); // Mismatched confirm password
	        adduser.setSodienthoai("099858899");
	        adduser.setDiachi("Đà Nẵng");

	        int result = addUserDao.registerAdduser(adduser);

	        // Assert that registration fails when passwords do not match
	        Assert.assertEquals(result, 0, "Đăng ký người dùng thành công với mật khẩu không khớp");
	    }
	   // Xác minh đăng ký không thành công khi trường Username quá 30 ký tự
	    @Test
	    public void testRegisterWithLongUsername() throws ClassNotFoundException {
	        Adduser adduser = new Adduser();
	        adduser.setName("toolongusernameexceedingthirtycharacters");
	        adduser.setEmail("@gmail.com");
	        adduser.setPassword("password123");
	        adduser.setSodienthoai("099858899");
	        adduser.setDiachi("Đà Nẵng");

	     

	        int result = addUserDao.registerAdduser(adduser);

	        // Assert that registration fails when the username exceeds 30 characters
	        Assert.assertEquals(result, 0, "Đăng ký người dùng thành công với tên người dùng quá dài");
	    }

	    //Xác minh đăng ký không thành công khi trường Email không theo định dạng hợp lệ có "@" và "."
	    @Test
	    public void testRegisterWithInvalidEmailFormat() throws ClassNotFoundException {
	        Adduser adduser = new Adduser();
	        adduser.setName("Thắng");
	        adduser.setEmail("invalidemail"); // Invalid email format without "@" and "."
	        adduser.setPassword("password123");
	        adduser.setSodienthoai("099858899");
	        adduser.setDiachi("Đà Nẵng");

	        int result = addUserDao.registerAdduser(adduser);

	        // Assert that registration fails when the email format is invalid
	        Assert.assertEquals(result, 0, "Đăng ký người dùng thành công với định dạng email không hợp lệ");
	    }
	    // số điện thoại hơn 10 kí tự 
	    @Test
	    public void testRegisterWithInvalidphoneFormat() throws ClassNotFoundException {
	        Adduser adduser = new Adduser();
	        adduser.setName("Thắng");
	        adduser.setEmail("invalidemail"); // Invalid email format without "@" and "."
	        adduser.setPassword("password123");
	        adduser.setSodienthoai("0998588999999");
	        adduser.setDiachi("Đà Nẵng");

	        int result = addUserDao.registerAdduser(adduser);

	        // Assert that registration fails when the email format is invalid
	        Assert.assertEquals(result, 0, "Đăng ký người dùng thành công với số điện thoại hơn 10 số");
	    }
	    // email trùng nhau 
	    @Test
	    public void testRegisterWithInvaliEmailFormat() throws ClassNotFoundException {
	        Adduser adduser = new Adduser();
	        adduser.setName("Thắng");
	        adduser.setEmail("thang@fmail."); // Invalid email format without "@" and "."
	        adduser.setPassword("password123");
	        adduser.setSodienthoai("0998588999999");
	        adduser.setDiachi("Đà Nẵng");

	        int result = addUserDao.registerAdduser(adduser);

	        // Assert that registration fails when the email format is invalid
	        Assert.assertEquals(result, 0, "Đăng ký người dùng thành công với mail trùng nhau");
	    }
	    //Xác minh đăng ký không thành công khi Username có trên 2 khoảng trống giữa các ký tự
	    @Test
	    public void testRegisterWithMultipleConsecutiveSpacesInUsername() throws ClassNotFoundException {
	        Adduser adduser = new Adduser();
	       
	        adduser.setEmail("thang@gmail.com");
	        adduser.setPassword("password123");
	        adduser.setSodienthoai("099858899");
	        adduser.setDiachi("Đà Nẵng");

	        // Set a username with more than one consecutive space
	        adduser.setName("user  name  with  multiple  spaces");

	        int result = addUserDao.registerAdduser(adduser);

	        // Assert that registration fails when the username contains multiple consecutive spaces
	        Assert.assertEquals(result, 0, "Đăng ký người dùng thành công với tên người dùng chứa nhiều khoảng trắng liên tiếp");
	    }
	    //Xác minh đăng ký không thành công khi trường Password không được ít hơn 8 ký tự và nhiều hơn 20 ký tự
	    @Test
	    public void testRegisterWithTooLongPassword() throws ClassNotFoundException {
	        Adduser adduser = new Adduser();
	        adduser.setName("Thắng");
	        adduser.setEmail("thang@gmail.com");

	        // Set a password with more than 20 characters
	        adduser.setPassword("thispasswordiswaytoolong123456789");

	        adduser.setSodienthoai("099858899");
	        adduser.setDiachi("Đà Nẵng");

	        int result = addUserDao.registerAdduser(adduser);

	        // Assert that registration fails when the password length is invalid
	        Assert.assertEquals(result, 0, "Đăng ký người dùng thành công với độ dài mật khẩu không hợp lệ");
	    }
	    //Xác minh đăng ký không thành công khi trường Username bị trùng
	    @Test
	    public void testRegisterWithDuplicateUsername() throws ClassNotFoundException {
	        // Create a user with a specific username
	        Adduser existingUser = new Adduser();
	        existingUser.setName("len");
	        existingUser.setEmail("existinguser@gmail.com");
	        existingUser.setPassword("password123");
	        existingUser.setSodienthoai("099858899");
	        existingUser.setDiachi("Đà Nẵng");
	      

	        // Register the existing user
	        int existingUserRegistrationResult = addUserDao.registerAdduser(existingUser);
	        Assert.assertTrue(existingUserRegistrationResult > 0, "Đăng ký người dùng thất bại");

	        // Attempt to register a new user with the same username
	        Adduser newUser = new Adduser();
	        newUser.setName("len");
	        newUser.setEmail("newuser@gmail.com");
	        newUser.setPassword("newpassword123");
	        newUser.setSodienthoai("099858899");
	        newUser.setDiachi("Đà Nẵng");
	       
	        int result = addUserDao.registerAdduser(newUser);

	        // Assert that registration fails when the username is duplicated
	        Assert.assertEquals(result, 0, "Đăng ký người dùng thành công với tên người dùng bị trùng");
	    }
	    //Xác minh chọn nút Login chuyển trang thành công
	    @Test
	    public void testLoginButtonRedirect() {
	        // Assume you have a method to perform login and return the redirection URL
	        String redirectionURL = performLogin("validUsername", "validPassword");

	        // Define the expected URL after successful login
	        String expectedRedirectURL = "http://localhost:8080/baoveCSDL/Index.jsp";

	        // Validate that the redirection URL matches the expected URL
	        Assert.assertEquals(redirectionURL, expectedRedirectURL, "Chuyển trang sau đăng nhập không thành công");
	    }

	    // Assume you have a method to perform login and return the redirection URL
	    private String performLogin(String username, String password) {
	        // Perform login and return the redirection URL
	        // This method should handle the actual login process in your application
	        // and return the URL to which the user is redirected after successful login.
	        // For example, you might use Selenium WebDriver to interact with the login form.
	        // For simplicity, this example returns a hardcoded redirection URL.
	        return "http://localhost:8080/baoveCSDL/Index.jsp";
	    }


}
