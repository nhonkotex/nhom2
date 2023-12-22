package baoveCSDL.Testing;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import baoveCSDL.connection.DbCon;
import baoveCSDL.dao.AddUserDao;
import baoveCSDL.dao.ProductDao;
import baoveCSDL.model.*;
import baoveCSDL.model.Cart;

public class MuahangDaoTest {
    private Connection con;

    @BeforeMethod
    public void setUp() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhom9", "root", "07191908");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Phương thức để đóng kết nối sau khi chạy các phương thức kiểm thử
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
    public void testGetAllProducts() {
        ProductDao productDao = new ProductDao(con);
        List<Product> products = productDao.getAllProducts();
        assertNotNull(products, "Danh sách sản phẩm không được null");
       
    }
    
    // kiểm tra sản phẩm 
    @Test
    public void testGetSingleProduct() {
    	
        ProductDao productDao = new ProductDao(con);
        int productId = 3; 
        Product product = productDao.getSingleProduct(productId);

        // Kiểm tra xem sản phẩm có tồn tại hay không
        assertNotNull(product, "Sản phẩm không tồn tại");

        assertEquals(product.getId(), productId, "ID của sản phẩm không đúng");

        assertNotNull(product.getName(), "Tên sản phẩm không được null");
        assertNotNull(product.getCategory(), "Danh mục sản phẩm không được null");
        assertNotNull(product.getPrice(), "Giá sản phẩm không được null");
        assertNotNull(product.getImage(), "Ảnh sản phẩm không được null");
        assertNotNull(product.getChitiet(), "Chi tiết sản phẩm không được null");
    }
    // thêm hàng vào 
    @Test
    public void testGetCartProducts() {
       
        ProductDao productDao = new ProductDao(con);

        // Tạo danh sách giỏ hàng với một số sản phẩm
        ArrayList<Cart> cartList = new ArrayList<>();
        
       
        Cart cartItem1 = new Cart();
        cartItem1.setId(1);
        cartItem1.setQuantity(2);
        cartItem1.setName("Nho đen");
        cartItem1.setCategory("1");
        cartItem1.setPrice(72.9); 
        cartItem1.setImage("pr1.jpg");
        cartItem1.setChitiet("trái ni ngon lắm");
        cartList.add(cartItem1);
        
       

        
        List<Cart> cartProducts = productDao.getCartProducts(cartList);

        
        assertNotNull(cartProducts, "Danh sách sản phẩm trong giỏ hàng không được null");

        
        assertEquals(cartProducts.size(), cartList.size(), "Số lượng sản phẩm không đúng");

        
        for (int i = 0; i < cartList.size(); i++) {
            Cart expectedCartItem = cartList.get(i);
            Cart actualCartItem = cartProducts.get(i);

            assertEquals(actualCartItem.getId(), expectedCartItem.getId(), "ID sản phẩm không đúng");
            assertEquals(actualCartItem.getQuantity(), expectedCartItem.getQuantity(), "Số lượng sản phẩm không đúng");

          
            assertEquals(actualCartItem.getName(), expectedCartItem.getName(), "Tên sản phẩm không đúng");
            assertEquals(actualCartItem.getCategory(), expectedCartItem.getCategory(), "Danh mục sản phẩm không đúng");
            assertEquals(actualCartItem.getPrice(), expectedCartItem.getPrice(), "Giá sản phẩm không đúng");
            assertEquals(actualCartItem.getImage(), expectedCartItem.getImage(), "Ảnh sản phẩm không đúng");
            assertEquals(actualCartItem.getChitiet(), expectedCartItem.getChitiet(), "Chi tiết sản phẩm không đúng");
        }
    }
    // tính tiền sản phẩm.
    @Test
    public void testGetTotalCartPrice() {
        
        ProductDao productDao = new ProductDao(con);

       //tạo cn mua hàng
        ArrayList<Cart> cartList = new ArrayList<>();

        
        Cart cartItem1 = new Cart();
        cartItem1.setId(1);
        cartItem1.setQuantity(2);
        cartItem1.setPrice(72.9);
        cartList.add(cartItem1);

      
        Cart cartItem2 = new Cart();
        cartItem2.setId(3);
        cartItem2.setQuantity(1);
        cartItem2.setPrice(13.5);
        cartList.add(cartItem2);

        //  tổng giá giỏ hàng
        double totalCartPrice = productDao.getTotalCartPrice(cartList);

        // Thực hiện các kiểm thử để xác nhận sự chính xác của tổng giá giỏ hàng
        assertEquals(totalCartPrice, 86.4, "Tổng giá giỏ hàng không chính xác");
    }

   
   
}
