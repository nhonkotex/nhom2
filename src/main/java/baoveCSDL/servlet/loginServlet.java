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
import baoveCSDL.dao.UserDao;
import baoveCSDL.model.User;

/**
 * Servlet implementation class loginServlet	/loginU
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String email = request.getParameter("login-email");
			String password = request.getParameter("login-password");
			
			try {
				UserDao udao = new UserDao(DbCon.getConnetion());
			User user = udao.userLogin(email, password);
			
			
			if(user != null) {
				   
					request.getSession().setAttribute("auth", user);
					HttpSession session = request.getSession();
		            session.setAttribute("loggedInUser", user);

		                // Hiển thị thông báo đăng nhập thành công
		                out.println("<script type=\"text/javascript\">");
		                out.println("alert('Đăng nhập thành công. Người đăng nhập: " + user.getName() + "');");
		                out.println("window.location.href='Index.jsp';");
		                out.println("</script>");
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
	