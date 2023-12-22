package baoveCSDL.Testing;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baoveCSDL.connection.DbCon;
import baoveCSDL.dao.AddUserDao;
import baoveCSDL.dao.addProductDao;
import baoveCSDL.model.addProduct;

public class ProductDaoTest {
  
    
    private Connection con;
    private addProductDao addProductDao;

    @BeforeClass
    public void setUp() throws ClassNotFoundException, SQLException {
        con = DbCon.getConnetion();
        addProductDao = new addProductDao(con);
    }

    @Test
    public void testRegisterProduct() throws ClassNotFoundException {
        addProduct product = new addProduct();
        product.setName("Cà Chua");
        product.setCategory("1");
        product.setPrice("50.00");
        product.setSale("1");
        product.setImage("cachua.jpg");
        product.setChitiet("cà chua ni rất chua");

        int result = addProductDao.registerProduct(product);
        assertEquals(result, 1, "Thêm sản phẩm không thành công");
    }

    @Test
    public void testSearchProduct() {
        String query = "n";
        List<addProduct> products = addProductDao.searchProduct(query);
        assertFalse(products.isEmpty(), "Không tìm thấy sản phẩm với từ khóa " + query);
    }
    //nhập số lượng sản phẩm
    @Test
    public void testGetCountProducts() {
        int count = addProductDao.getCountProducts();
        assertTrue(count >= 0, "Lỗi đếm số lượng sản phẩm");
    }
    //show tất cả các sản phẩm
    @Test
    public void testGetAllPRD() {
        List<addProduct> products = addProductDao.getAllPRD();
        assertFalse(products.isEmpty(), "Danh sách sản phẩm trống");
    }
    
    

   
}