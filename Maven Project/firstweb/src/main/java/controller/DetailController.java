package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import firstweb.Product;
import firstweb.ProductDAO;

public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Product p; //= new Product(69, "Coffee", "Arabica", 77);	// from database
		String id = request.getParameter("id");
		try {
			ProductDAO dao = new ProductDAO();
			p = dao.getProduct(Integer.parseInt(id));				// connect straight to DB
			request.setAttribute("result", p);
			request.getRequestDispatcher("test.jsp").forward(request, response); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		request.setAttribute("result", p);
//		request.getRequestDispatcher("test.jsp").forward(request, response); // send to jsp page
		
	}

}
