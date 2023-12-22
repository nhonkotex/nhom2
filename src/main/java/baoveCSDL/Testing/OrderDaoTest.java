package baoveCSDL.Testing;

import static org.testng.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baoveCSDL.connection.DbCon;
import baoveCSDL.dao.OrderDao;
import baoveCSDL.model.Order;

public class OrderDaoTest {
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
   
    // người dùng đã đặt bao nhiêu đơn hàng/ kiểm tra số đơn đó
    @Test
    public void testUserOrders() {
        OrderDao orderDao = new OrderDao(con);

        // Gọi phương thức để lấy danh sách đơn hàng của một người dùng
        List<Order> userOrders = orderDao.userOrders(1);

        assertNotNull(userOrders, "Danh sách đơn hàng không được null");
        assertEquals(userOrders.size(), 8, "Số lượng đơn hàng không đúng");

        // Kiểm tra thông tin của đơn hàng đầu tiên trong danh sách
        Order firstOrder = userOrders.get(0);
        assertEquals(firstOrder.getOrderId(), 11, "ID đơn hàng không đúng");
        assertEquals(firstOrder.getId(), 2, "ID sản phẩm không đúng");
        assertEquals(firstOrder.getUid(), 0, "ID người dùng không đúng");
        assertEquals(firstOrder.getQuantity(), 5, "Số lượng sản phẩm không đúng");
        assertEquals(firstOrder.getDate(), "2023-01-01", "Ngày đặt hàng không đúng");
    }
    
   

   
}
