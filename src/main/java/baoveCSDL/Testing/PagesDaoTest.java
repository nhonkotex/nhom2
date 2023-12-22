package baoveCSDL.Testing;

import static org.testng.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baoveCSDL.dao.PagesDao;
import baoveCSDL.model.Pages;

public class PagesDaoTest {
    private Connection con;

   
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

    // Phương thức kiểm thử cho việc đăng ký thêm liên hệ
    @Test
    public void testRegisterAddContact() throws ClassNotFoundException {
        PagesDao pagesDao = new PagesDao(con);

        // Tạo một đối tượng Pages để thêm vào cơ sở dữ liệu
        Pages pages = new Pages();
       
        pages.setTenNV("Cao Nhật Nhơn"); // Tên nhân viên
        pages.setTieude("New Page"); // Tiêu đề
        pages.setGioithieu("Introduction"); // Giới thiệu
        pages.setNoidung("Content"); // Nội dung
        pages.setSocmt("123"); // Số chứng minh thư
        pages.setDate("2023-11-25"); // Ngày
        pages.setImage("image.jpg"); // Ảnh

        int result = pagesDao.registerAddContact(pages);

        assertTrue(result > 0, "Đăng ký thêm liên hệ không thành công");
    }
    
    // xem tất cả các chi tiết
    @Test
    public void testGetAllCT() {
        PagesDao pagesDao = new PagesDao(con);

        // Gọi phương thức để lấy tất cả các chi tiết
        List<Pages> allCT = pagesDao.getAllCT();

        assertNotNull(allCT, "Danh sách tất cả chi tiết không được null");
        assertTrue(allCT.size() > 0, "Số lượng chi tiết không đúng");

        // Thêm các kiểm thử khác tùy thuộc vào logic của phương thức này
        
        Pages firstCT = allCT.get(0);
        assertEquals(firstCT.getId(), 1, "ID chi tiết không đúng");
        assertEquals(firstCT.getTenNV(), "Cao Nhật Nhơn", "Tên nhân viên không đúng");
        assertEquals(firstCT.getTieude(), "Trang chủ", "Tiêu đề không đúng");
        assertEquals(firstCT.getGioithieu(), "Chào mừng bạn đến với trang web của chúng tôi", "Giới thiệu không đúng");
        assertEquals(firstCT.getNoidung(), "Nội dung trang chủ", "Nội dung không đúng");
        assertEquals(firstCT.getSocmt(), "10", "Số chứng minh thư không đúng");
        assertEquals(firstCT.getDate(), "2023-06-15", "Ngày không đúng");
        assertEquals(firstCT.getImage(), "image1.jpg", "Ảnh không đúng");
    }

   
   
   
}
