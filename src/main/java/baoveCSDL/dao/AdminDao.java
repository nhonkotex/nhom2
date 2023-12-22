package baoveCSDL.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import baoveCSDL.model.Admin;

public class AdminDao {
    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public AdminDao(Connection con) {
        this.con = con;
    }

    public Admin adminLogin(String email, String password) {
        Admin user = null;
        try {
            query = "SELECT * FROM Nhanvien WHERE emailNV=? AND passwordNV=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);

            rs = pst.executeQuery();
            if (rs.next()) {
                user = new Admin();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("tenNV"));
                user.setEmail(rs.getString("emailNV"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return user;
    }

    public String getLoggedInUserName(String email, String password) {
        String loggedInUserName = null;
        try {
            query = "SELECT tenNV FROM Nhanvien WHERE emailNV=? AND passwordNV=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);

            rs = pst.executeQuery();
            if (rs.next()) {
                loggedInUserName = rs.getString("tenNV");
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return loggedInUserName;
    }
}
