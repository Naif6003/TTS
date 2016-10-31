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
import Objects.User;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns="/TheLogin")
public class TheLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		
		
		request.getRequestDispatcher("/WEB-INF/TheLogin.jsp").forward(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			
			throw new ServletException(e);
			
		}
		
		
		   String username = req.getParameter("name");
	        String password = req.getParameter("password");
	        
	        Connection c = null;
	        User user = null;

	        try {

	            user = DatabaseAccessor.getUser(username, password);
	            
	            boolean foundUser = false;
	         
		        if(user.userName.equals(username) && user.userPassword.equals(password)){
		               
		        	foundUser=true;
		                //store userid and username in session for future lookup
		                req.getSession().setAttribute( "userid", user.getUserId());
		                req.getSession().setAttribute("username", user.getUserName());
		                req.getSession().setAttribute("foundUser", foundUser);
		                //request.getSession().setAttribute("message", message);
		                resp.sendRedirect("TTS");
		                
		                
		                return;
		            }
	            		        
		        if(!foundUser){
		            //User not found
		            System.out.println("user not found");
		            resp.sendRedirect("Login?message=username%20and%20password%20combination%20not%20found");
		        }
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
	            
	    

		
		System.out.println(username);

		
		
		
		
	}
	

}
