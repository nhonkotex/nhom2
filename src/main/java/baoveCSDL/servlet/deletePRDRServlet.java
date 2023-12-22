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
import baoveCSDL.dao.addProductRDao;

/**
 * Servlet implementation class deletePRDRServlet	deletePRDR
 */
public class deletePRDRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()) {
			String id = request.getParameter("id");
			
			if(id != null) {
				
				addProductRDao productDao = new addProductRDao(DbCon.getConnetion());
				productDao.huydon(Integer.parseInt(id));
				
			}
			response.sendRedirect("QLProduct.jsp");
		}
		catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			}
		
	}

	