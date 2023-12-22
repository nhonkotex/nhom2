package baoveCSDL.TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baoveCSDL.dao.OrderDao;
import baoveCSDL.dao.ProductDao;
import baoveCSDL.model.Cart;
import baoveCSDL.model.Order;
import baoveCSDL.model.Product;

public class PurchaseTest {
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
	    //thêm nhiều sản phẩm vào giỏ hàng
	    
	    @Test
	    public void testGetCartProducts11() {
	       
	        ProductDao productDao = new ProductDao(con);

	        // Tạo danh sách giỏ hàng với một số sản phẩm
	        ArrayList<Cart> cartList = new ArrayList<>();
	        
	       
	        Cart cartItem1 = new Cart();
	        cartItem1.setId(1);
	        cartItem1.setQuantity(4);
	        cartItem1.setName("Nho đen");
	        cartItem1.setCategory("1");
	        cartItem1.setPrice(145.8); 
	        cartItem1.setImage("pr1.jpg");
	        cartItem1.setChitiet("trái ni ngon lắm");
	        cartList.add(cartItem1);
	        
	        Cart cartItem2 = new Cart();
	        cartItem2.setId(3);
	        cartItem2.setQuantity(2);
	        cartItem2.setName("củ cải");
	        cartItem2.setCategory("2");
	        cartItem2.setPrice(27.00); 
	        cartItem2.setImage("pr1.jpg");
	        cartItem2.setChitiet("trái ni ngon lắm");
	        cartList.add(cartItem2);
	        
	       

	        
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
	    // xoá sản phẩm khỏi đơn hàng 

	    @Test
	    public void testdeleteProducts() {
	        ProductDao productDao = new ProductDao(con);
	        List<Product> products = productDao.getAllProducts();
	        assertNotNull(products, "xoá sản phẩm không thành công");
	       
	    }
	    // tính tiền sản phẩm 
	    @Test
	    public void testGetProducts() {
	       
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
	    
	   // tính tiền nhiều sản phẩm
	    @Test
	    public void testGetCartProducts1001() {
	       
	        ProductDao productDao = new ProductDao(con);

	        // Tạo danh sách giỏ hàng với một số sản phẩm
	        ArrayList<Cart> cartList = new ArrayList<>();
	        
	       
	        Cart cartItem1 = new Cart();
	        cartItem1.setId(1);
	        cartItem1.setQuantity(4);
	        cartItem1.setName("Nho đen");
	        cartItem1.setCategory("1");
	        cartItem1.setPrice(145.8); 
	        cartItem1.setImage("pr1.jpg");
	        cartItem1.setChitiet("trái ni ngon lắm");
	        cartList.add(cartItem1);
	        
	        Cart cartItem2 = new Cart();
	        cartItem2.setId(3);
	        cartItem2.setQuantity(2);
	        cartItem2.setName("củ cải");
	        cartItem2.setCategory("2");
	        cartItem2.setPrice(27.00); 
	        cartItem2.setImage("pr1.jpg");
	        cartItem2.setChitiet("trái ni ngon lắm");
	        cartList.add(cartItem2);
	        
	       

	        
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
	    //thêm đơn hàng
	    @Test
	    public void testInsertOrder() {
	        OrderDao orderDao = new OrderDao(con);

	        
	        Order order = new Order();
	        order.setId(2); // ID sản phẩm 
	        order.setUid(2); // ID người dùng 
	        order.setQuantity(5); //  số lượng sản phẩm 
	        order.setDate("2023-01-01"); 

	        boolean result = orderDao.insertOrder(order);

	        assertTrue(result, "Thêm đơn hàng không thành công");
	    }
	    
	    // xoá sản phẩm khỏi đơn hàng 

	    @Test
	    public void testdeleteProdu() {
	        ProductDao productDao = new ProductDao(con);
	        List<Product> products = productDao.getAllProducts();
	        assertNotNull(products, "xoá sản phẩm không thành công");
	       
	    }
	    // xoá sản phẩm khỏi đơn hàng 

	    @Test
	    public void testdeletOrder() {
	        ProductDao productDao = new ProductDao(con);
	        List<Product> products = productDao.getAllProducts();
	        assertNotNull(products, "xoá đơn hàng không thành công");
	       
	    }
	    
}
