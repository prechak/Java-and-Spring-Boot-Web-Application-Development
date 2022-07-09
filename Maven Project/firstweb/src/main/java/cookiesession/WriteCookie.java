package cookiesession;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WriteCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cookie count = new Cookie("count", "0");	// "name", "value"
		response.addCookie(count);
		
		Cookie man = new Cookie("Prasert", "79");
		response.addCookie(man);
	}

}
