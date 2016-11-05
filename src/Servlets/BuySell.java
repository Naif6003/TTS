package Servlets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Objects.Items;


@WebServlet(urlPatterns = "/BuySell", loadOnStartup = 1)
public class BuySell extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		ServletContext appContext = getServletContext();
		Items item1 = new Items(0, "Ipod Touch 1", "Apple Ipod Touch 5th generation in mint condition","https://c7.staticflickr.com/3/2154/2264556662_cbc3f09362_b.jpg");
		Items item2 = new Items(1, "Ipod Touch 2", "Apple Ipod Touch 5th generation in mint condition","https://c7.staticflickr.com/3/2154/2264556662_cbc3f09362_b.jpg");
		Items item3 = new Items(2, "Ipod Touch 3", "Apple Ipod Touch 5th generation in mint condition","https://c7.staticflickr.com/3/2154/2264556662_cbc3f09362_b.jpg" );
		Items item4 = new Items(3, "Ipod Touch 4", "Apple Ipod Touch 5th generation in mint condition","https://c7.staticflickr.com/3/2154/2264556662_cbc3f09362_b.jpg" );
		Items item5 = new Items(2, "Ipod Touch 5", "Apple Ipod Touch 5th generation in mint condition","https://c7.staticflickr.com/3/2154/2264556662_cbc3f09362_b.jpg");
		Items item6 = new Items(3, "Ipod Touch 6", "Apple Ipod Touch 5th generation in mint condition","https://c7.staticflickr.com/3/2154/2264556662_cbc3f09362_b.jpg");
		
		List<Items> items = new ArrayList<>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		items.add(item5);
		items.add(item6);
		
		appContext.setAttribute("items", items);
		request.getRequestDispatcher("/WEB-INF/BuySell.jsp").forward(request, response);
		
	}
}



 