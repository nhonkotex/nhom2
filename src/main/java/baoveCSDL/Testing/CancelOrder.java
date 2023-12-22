package baoveCSDL.Testing;

import static org.testng.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baoveCSDL.dao.OrderDao;
import baoveCSDL.model.Order;

public class CancelOrder {
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
    public void testCancelOrder() {
        // Đặt ID đơn hàng cần hủy
        int orderIdToCancel = 13;

       
        OrderDao orderDao = new OrderDao(con);

      
        orderDao.cancelOrder(orderIdToCancel);

    }
   
}
