package baoveCSDL.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import baoveCSDL.dao.AddUserDao;
import baoveCSDL.model.Adduser;
import baoveCSDL.model.User;

/**
 * Servlet implementation class AddUserServlet	/AddUser
 */
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	
	private AddUserDao adduserDao;

    public void init() {
    	adduserDao = new AddUserDao(null);
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String sodienthoai = request.getParameter("sodienthoai");
        String diachi = request.getParameter("diachi");
        
       
      
		User u = adduserDao.CheckUsername(name);
		
		if(u != null)
		{
			request.setAttribute("err", "1");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {
			 Adduser adduser = new Adduser();
		        adduser.setName(name);
		        adduser.setEmail(email);
		        adduser.setPassword(password);
		        adduser.setSodienthoai(sodienthoai);
		        adduser.setDiachi(diachi);
		        try {
		        	adduserDao.registerAdduser(adduser);
		            
		            
		                  } catch (Exception e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }		}

        response.sendRedirect("ThemUserTC.jsp");
    }
}