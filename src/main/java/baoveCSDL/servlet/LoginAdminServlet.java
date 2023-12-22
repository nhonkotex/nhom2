package baoveCSDL.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import baoveCSDL.connection.DbCon;
import baoveCSDL.dao.AdminDao;
import baoveCSDL.model.Admin;

public class LoginAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("loginAdmin.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("admin-email");
            String password = request.getParameter("admin-password");

            try {
                AdminDao adminDao = new AdminDao(DbCon.getConnetion());
                Admin user = adminDao.adminLogin(email, password);

                if (user != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("loggedInUser", user);

                    response.sendRedirect("admin.jsp");
                } else {
                    response.setContentType("text/html");
                    PrintWriter out1 = response.getWriter();
                    out1.println("<script type=\"text/javascript\">");
                    out1.println("alert('Email hoặc mật khẩu không đúng.');");
                    out1.println("window.location.href='login.jsp';");
                    out1.println("</script>");
                }

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
