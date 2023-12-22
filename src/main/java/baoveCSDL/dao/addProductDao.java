package baoveCSDL.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import baoveCSDL.model.addProduct;

public class addProductDao {
    // thêm hàng
	public int registerProduct(addProduct adduser) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO sanpham1" +
            "  (id, name1, category, price, sale, image, chitiet) VALUES " +
            " (?, ?, ?, ?, ?, ?, ? );";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
        		.getConnection("jdbc:mysql://localhost:3306/nhom9","root","07191908");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, adduser.getId() );
            preparedStatement.setString(2, adduser.getName());
            preparedStatement.setString(3, adduser.getCategory());
            preparedStatement.setString(4, adduser.getPrice());
            preparedStatement.setString(5, adduser.getSale());
            preparedStatement.setString(6, adduser.getImage());
            preparedStatement.setString(7, adduser.getChitiet());
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    // tìm sản phẩm
    public List<addProduct> searchProduct(String query) {
        List<addProduct> results = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhom9", "root",
                "07191908");
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM sanpham1 WHERE name1 LIKE ?")) {

            // Set the search term as a parameter in the SQL query
            String searchTerm = "%" + query + "%";
            statement.setString(1, searchTerm);

            // Execute the query and loop through the results
ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                addProduct user = new addProduct();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name1"));
                user.setCategory(resultSet.getString("category"));
                user.setPrice(resultSet.getString("price"));
                user.setImage(resultSet.getString("image"));
                user.setChitiet(resultSet.getString("chitiet"));
                results.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    public int getCountProducts() {
        int count = 0;

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhom9", "root",
                "07191908");
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS total FROM sanpham1");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                count = resultSet.getInt("total");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public addProductDao(Connection con) {
        this.con = con;
    }

    public List<addProduct> getAllPRD() {
        List<addProduct> products = new ArrayList<>();
        try {
            query = "select * from sanpham1";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                addProduct row = new addProduct();
                row.setId(rs.getInt("id"));
                row.setName(rs.getString("name1"));
                row.setCategory(rs.getString("category"));
                row.setPrice(rs.getString("price"));
                row.setSale(rs.getString("sale"));
                row.setImage(rs.getString("image"));
                row.setChitiet(rs.getString("chitiet"));
                row.setDiscountedPriceR(rs.getString("discountedPriceR"));
                products.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return products;
    }
    
    
 // Chức năng hiển thị sản phẩm thể loại 1
    public List<addProduct> getAllPRDByCategory(String category) {
        List<addProduct> products = new ArrayList<>();
        try {
            String query = "SELECT * FROM sanpham1 WHERE category = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, category);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                addProduct row = new addProduct();
                row.setId(rs.getInt("id"));
row.setName(rs.getString("name1"));
                row.setCategory(rs.getString("category"));
                row.setPrice(rs.getString("price"));
                row.setSale(rs.getString("sale"));
                row.setImage(rs.getString("image"));
                row.setChitiet(rs.getString("chitiet"));

                products.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return products;
    }


}