package Servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/TTS")
public class TTS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			
			throw new ServletException(e);
			
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		request.getRequestDispatcher("/WEB-INF/MainPage.jsp").forward(request, response);
	}
}
