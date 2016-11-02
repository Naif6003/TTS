package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.DatabaseAccessor;
import Objects.Items;



/**
 * Servlet implementation class OfferTrade
 */
@WebServlet("/OfferTrade")
public class OfferTrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		int itemID = Integer.parseInt(id);
		
		Connection c = null;
		Items item = null;
		List<Items> items = null;
	
		int currentUserId = (int) request.getSession().getAttribute("userid");
		
		try {
	
			item = DatabaseAccessor.getItem(itemID);
			items = DatabaseAccessor.getItemsOfUser(currentUserId);
			
			}
	
		 catch (SQLException e) {
			// Escalate to Server error
			throw new ServletException(e);
		}
		// Always close connections, no matter what happened
		finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}
		
		request.setAttribute("item", item);
		request.setAttribute("owner", item.user);
		request.setAttribute("items", items);
		
		request.getRequestDispatcher("/WEB-INF/OfferTrade.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
