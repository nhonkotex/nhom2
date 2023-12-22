package baoveCSDL.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import baoveCSDL.model.Nhanvien;

public class NhanvienDao {
	  private Connection con;
		private String query;
		private PreparedStatement pst;
		private ResultSet rs;
		public NhanvienDao(Connection con) {
			this.con = con;
		}
		public List<Nhanvien> getAllNhanvien() {
		    List<Nhanvien> nhanvien = new ArrayList<>();
		    try {
		
		        query = "select * from Nhanvien";
		        pst = this.con.prepareStatement(query);
		        rs = pst.executeQuery();
		
		        while (rs.next()) {
		        	Nhanvien row = new Nhanvien();
		            row.setId(rs.getInt("id"));
		            row.setNameNV(rs.getString("tenNV"));
		            row.setEmailNV(rs.getString("emailNV"));
		            row.setPasswordNV(rs.getString("passwordNV"));
		            row.setSdt(rs.getString("sodienthoaiNV"));
		            row.setLuong(rs.getString("luong"));
		            row.setChucvu(rs.getString("chuc_vu"));
		           
		            
		            row.setDiachi(rs.getString("diachiNV"));
		            
		         
		            row.setImage(rs.getString("imageNV"));
		           
		            nhanvien.add(row);
		        }
		
		    } catch (SQLException e) {
		        e.printStackTrace();
		        System.out.println(e.getMessage());
		    }
		    return nhanvien;	   
		
		}
		
		 public int registerAddNhanvien(Nhanvien nhanvien) throws ClassNotFoundException {
		        String INSERT_USERS_SQL = "INSERT INTO Nhanvien" +
		            "  (id, tenVN, emailNV, passwordNV, sodienthoaiNV, luong, chuc_vu, diachiNV, imageNV) VALUES " +
		            " (?, ?, ?, ?, ?, ?, ?, ?, ? );";

		        int result = 0;

		        Class.forName("com.mysql.jdbc.Driver");

		        try (Connection connection = DriverManager
		        		.getConnection("jdbc:mysql://localhost:3306/shoppet","root","07191908");

		            // Step 2:Create a statement using connection object
		            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
		            preparedStatement.setInt(1, nhanvien.getId());
		            preparedStatement.setString(2, nhanvien.getNameNV());
		            preparedStatement.setString(3, nhanvien.getEmailNV());
		            preparedStatement.setString(4, nhanvien.getPasswordNV());
		            preparedStatement.setString(5, nhanvien.getSdt());
		            preparedStatement.setString(6, nhanvien.getLuong());
		            preparedStatement.setString(7, nhanvien.getChucvu());
		            preparedStatement.setString(8, nhanvien.getDiachi());
		            preparedStatement.setString(9, nhanvien.getImage());
		          
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
		 
		 public void xoanhanvien(int id) {
		        //boolean result = false;
		        try {
		            query = "delete from Nhanvien where id=?";
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
