package baoveCSDL.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import baoveCSDL.dao.PagesDao;
import baoveCSDL.model.Pages;
/**
 * Servlet implementation class themPagesServlet /themPages
 */
public class themPagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PagesDao addhangDao;
    public void init() {
 	   addhangDao = new PagesDao(null);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tenNV = request.getParameter("tenNV");
		String tieude = request.getParameter("tieude");
		String gioithieu = request.getParameter("gioithieu");
		String noidung = request.getParameter("noidung");
		String socmt = request.getParameter("socmt");
		String date = request.getParameter("date");
		String image = request.getParameter("image");
		Pages addsp = new Pages();
		addsp.setTenNV(tenNV);
		addsp.setTieude(tieude);
		addsp.setGioithieu(gioithieu);
		addsp.setNoidung(noidung);
		addsp.setSocmt(socmt);
		addsp.setDate(date);
		addsp.setImage(image);
		try {
		addhangDao.registerAddContact(addsp);
		}catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
	}
		response.sendRedirect("QLthongbao.jsp");
	}

}

