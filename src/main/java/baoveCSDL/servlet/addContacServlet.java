package baoveCSDL.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import baoveCSDL.dao.ContactDao;

import baoveCSDL.model.Contact;

/**
 * Servlet implementation class addContacServlet	addContac
 */
public class addContacServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;
    private ContactDao addhangDao;
    public void init() {
 	   addhangDao = new ContactDao(null);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String message = request.getParameter("message");
		
		
		Contact addsp = new Contact();
		addsp.setName(name);
		addsp.setEmail(email);
		addsp.setPhone(phone);
		addsp.setMessage(message);
		try {
		addhangDao.registerAddContact(addsp);
		}catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
	}
		response.sendRedirect("contact.jsp");
	}

}
