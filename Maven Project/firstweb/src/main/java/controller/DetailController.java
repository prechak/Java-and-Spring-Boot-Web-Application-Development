package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import firstweb.Product;

public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Product p = new Product(69, "Coffee", "Arabica", 77);	// from database
		request.setAttribute("result", p);
		request.getRequestDispatcher("test.jsp").forward(request, response); // send to jsp page
		
	}

}
