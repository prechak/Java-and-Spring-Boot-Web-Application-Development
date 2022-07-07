package firstweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ExportProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType( "application/json; charset=utf-8" );
		//response.setHeader("Content-Disposition","attachment;filename=product.csv");
		
		PrintWriter out = response.getWriter();
		
		ObjectMapper mapper = new ObjectMapper();
		
		ProductDAO dao;
		try {
			dao = new ProductDAO();
			ArrayList<Product> list = dao.getAllProduct();
			String json = mapper.writeValueAsString(list);

			//out.println("{\"pname\":\"สบู่\"}");
			out.println(json);
			
			
			//out.print("<table border=1>");
/*			for(Product p : list) {
			out.println(p.getProductName() + "," + p.getProductDetail() + "," + p.getPrice());
			} */
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
