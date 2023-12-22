package baoveCSDL.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import baoveCSDL.model.Contact;

public class ContactDao {
	 // thêm hàng 
	 public int registerAddContact(Contact addproduct) throws ClassNotFoundException {
	        String INSERT_USERS_SQL = "INSERT INTO contact" +
	            "  (idC, ten, emailC, phoneC, messageC) VALUES " +
	            " (?, ?, ?, ?, ?);";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	        		.getConnection("jdbc:mysql://localhost:3306/nhom9","root","07191908");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setInt(1, addproduct.getId());
	            preparedStatement.setString(2, addproduct.getName());
	            preparedStatement.setString(3, addproduct.getEmail());
	            preparedStatement.setString(4, addproduct.getPhone());
	            preparedStatement.setString(5, addproduct.getMessage());
	           
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
	 public List<Contact> searchContact(String query) {
	   	    List<Contact> results = new ArrayList<>();

	   	    try {
	   	        // Prepare the SQL query with placeholders for the search term
	   	        String sql = "SELECT * FROM contact WHERE name LIKE ?";
	   	        PreparedStatement statement = con.prepareStatement(sql);

	   	        // Set the search term as a parameter in the SQL query
	   	        String searchTerm = "%" + query + "%";
	   	        statement.setString(1, searchTerm);

	   	        // Execute the query and loop through the results
	   	        ResultSet resultSet = statement.executeQuery();
	   	        while (resultSet.next()) {
	   	        	Contact user = new Contact();
	   	            user.setId(resultSet.getInt("idC"));
	   	            user.setName(resultSet.getString("ten"));
	   	           
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
	   	public ContactDao(Connection con) {
	   		this.con = con;
	   	}
	   	
		public List<Contact> getAllCT() {
	        List<Contact> products= new ArrayList<>();
	        try {

	            query = "select * from contact";
	            pst = this.con.prepareStatement(query);
	            rs = pst.executeQuery();

	            while (rs.next()) {
	            	Contact row = new Contact();
	                row.setId(rs.getInt("idC"));
	                row.setName(rs.getString("ten"));
	                row.setEmail(rs.getString("emailC"));
	                row.setPhone(rs.getString("phoneC"));
	                row.setMessage(rs.getString("messageC"));

	                products.add(row);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	        return products;
		
	}
		
		public void huydon(int id) {
	        //boolean result = false;
	        try {
	            query = "delete from contact where idC=?";
	            pst = this.con.prepareStatement(query);
	            pst.setInt(1, id);
	            pst.execute();
	            //result = true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.print(e.getMessage());
	        }
	        //return result;
	    }

}
