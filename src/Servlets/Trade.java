package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.ConnectionUtils;
import Connection.DatabaseAccessor;
import Connection.DatabaseConfig;
import Objects.Items;


@WebServlet("/Trade")
public class Trade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		
		Connection c = null;
		List<Items> items = null;
	
		int currentUserId = (int) request.getSession().getAttribute("userid");
		System.out.println(currentUserId);
		
		try {
	
			items = DatabaseAccessor.getItems();
			
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
		
		
		//request.setAttribute("item", item);
		//request.setAttribute("owner", item.user.userId);
		request.setAttribute("items", items);
		
		request.getRequestDispatcher("/WEB-INF/Trade.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        Connection c = null;
        String[] offeredItemsID = request.getParameterValues("offeredItems");
        String owner = request.getParameter("owner");
        int ownerID = Integer.parseInt(owner);
        
        try {
            
        	String sql = "insert into offered_items (trading_items_id, user_who_owns_item_id, user_who_offers_id) values (?, ?, ?)";

    		c = ConnectionUtils.getMySQLConnection(DatabaseConfig.MYSQL_USERNAME, DatabaseConfig.MYSQL_PASSWORD,
					DatabaseConfig.MYSQL_HOST, DatabaseConfig.MYSQL_PORT, DatabaseConfig.MYSQL_DATABASE_TO_USE);            
    		PreparedStatement pstmt = c.prepareStatement( sql );
    		
    		int currentUserId = (int) request.getSession().getAttribute("userid");
    		for(int x = 0; x < offeredItemsID.length;x++){
	    		pstmt.setInt( 1, Integer.parseInt(offeredItemsID[x]));
	    		pstmt.setInt( 2, ownerID);
	            pstmt.setInt( 3, currentUserId);
	            pstmt.executeUpdate();
    		}
            
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
        finally
        {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
        }
        
        response.sendRedirect("TTS");
	}

}
