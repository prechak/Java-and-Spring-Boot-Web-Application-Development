package firstweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullname = request.getParameter("fullname");
		String weight = request.getParameter("weight");
		String height = request.getParameter("height");
		double bmi = Double.parseDouble(weight) / (Double.parseDouble(height) * Double.parseDouble(height)) ;
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body><h1>Welcome to Servlet " + fullname + " " + weight + "</h1>");
		out.println("BMI : " + bmi);
		out.println("<img src='img/Dog.jpg'></body></html>");
		System.out.println("t\t >>>> " + height);
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body><h1> This is doPost </h1></body></html>");
	
	}

}
