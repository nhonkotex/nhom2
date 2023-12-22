package baoveCSDL.Testing;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baoveCSDL.dao.OrderDao;
import baoveCSDL.model.Order;

public class AddOrderTest  {
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
    
  
   
}
