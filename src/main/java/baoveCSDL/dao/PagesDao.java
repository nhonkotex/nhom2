package baoveCSDL.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import baoveCSDL.model.Pages;

public class PagesDao {
	 // thêm tt 
	 public int registerAddContact(Pages addproduct) throws ClassNotFoundException {
	        String INSERT_USERS_SQL = "INSERT INTO pages" +
	            "  (id, tenNV ,tieude, gioithieu, noidung, socmt, date1, image) VALUES " +
	            " (?, ?, ?, ?, ?, ?, ?, ?);";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	        		.getConnection("jdbc:mysql://localhost:3306/nhom9","root","07191908");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setInt(1, addproduct.getId());
	            preparedStatement.setString(2, addproduct.getTenNV());
	            preparedStatement.setString(3, addproduct.getTieude());
	            preparedStatement.setString(4, addproduct.getGioithieu());
	            preparedStatement.setString(5, addproduct.getNoidung());
	            preparedStatement.setString(6, addproduct.getSocmt());
	            preparedStatement.setString(7, addproduct.getDate());
	            preparedStatement.setString(8, addproduct.getImage());
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
	        for (Throwable e: ex) {
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
	 public List<Pages> searchContact(String query) {
	   	    List<Pages> results = new ArrayList<>();

	   	    try {
	   	        // Prepare the SQL query with placeholders for the search term
	   	        String sql = "SELECT * FROM pages WHERE name LIKE ?";
	   	        PreparedStatement statement = con.prepareStatement(sql);

	   	        // Set the search term as a parameter in the SQL query
	   	        String searchTerm = "%" + query + "%";
	   	        statement.setString(1, searchTerm);

	   	        // Execute the query and loop through the results
	   	        ResultSet resultSet = statement.executeQuery();
	   	        while (resultSet.next()) {
	   	        	Pages user = new Pages();
	   	            user.setId(resultSet.getInt("idC"));
	   	            user.setTieude(resultSet.getString("tieude"));
	   	           
	   	            results.add(user);
	   	        }

	   	    } catch (SQLException e) {
	   	        e.printStackTrace();
	   	    }

	   	    return results;
	   	}
	   
	   
	 
	 private Connection con;
	   	private String query;
	   	private PreparedStatement pst;
	   	private ResultSet rs;
	   	public PagesDao(Connection con) {
	   		this.con = con;
	   	}
	   	
		public List<Pages> getAllCT() {
	        List<Pages> products= new ArrayList<>();
	        try {

	            query = "select * from pages";
	            pst = this.con.prepareStatement(query);
	            rs = pst.executeQuery();

	            while (rs.next()) {
	            	Pages row = new Pages();
	                row.setId(rs.getInt("id"));
	                row.setTenNV(rs.getString("tenNV"));
	                row.setTieude(rs.getString("tieude"));
	                row.setGioithieu(rs.getString("gioithieu"));
	                row.setNoidung(rs.getString("noidung"));
	                row.setSocmt(rs.getString("socmt"));
	                row.setDate(rs.getString("date1"));
	                row.setImage(rs.getString("image"));
	                products.add(row);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	        return products;
		
	}
		


}
