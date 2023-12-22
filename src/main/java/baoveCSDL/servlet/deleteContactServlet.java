package baoveCSDL.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import baoveCSDL.connection.DbCon;
import baoveCSDL.dao.ContactDao;

/**
 * Servlet implementation class deleteContactServlet	/deleteContact
 */
public class deleteContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()) {
			String id = request.getParameter("id");
			
			if(id != null) {
				
				ContactDao productDao = new ContactDao(DbCon.getConnetion());
				productDao.huydon(Integer.parseInt(id));
				
			}
			response.sendRedirect("QLtinnhan.jsp");
		}
		catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			}
		
	}