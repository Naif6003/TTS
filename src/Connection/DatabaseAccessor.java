package Connection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Objects.Items;
import Objects.User;

public class DatabaseAccessor {
	
	
	public static final String LIST_ITEMS_QUERY = "select t.id, t.item_name, t.description, t.user_id, u.username, u.user_email, u.user_address, u.user_password from trading_items t join users u on u.id=t.user_id";
    public static final String LIST_A_USER_QUERY = "select * from users where username = ? and user_password = ?";
    public static final String LIST_AN_ITEM_QUERY = "select t.id, t.item_name, t.description, t.user_id, u.username, u.user_email, u.user_address, u.user_password from trading_items t join users u on u.id=t.user_id where t.id = ?";
    public static final String LIST_ITEMS_OF_A_USER_QUERY = "select * from trading_items where user_id = ?";
    public static final String GET_OFFERED_ITEMS = "select t.id, t.item_name, t.description, t.user_id, u.username, u.user_email, u.user_address, u.user_password from trading_items t  join users u on t.user_id = u.id join offered_items oi on oi.trading_items_id=t.id where oi.user_who_owns_item_id = ?";
    
    
    public static List<Items> getItems() throws SQLException {
        Connection c = null;
        
        List<Items> items = new ArrayList<Items>();
      
        try {
        
        	c = ConnectionUtils.getMySQLConnection(DatabaseConfig.MYSQL_USERNAME, DatabaseConfig.MYSQL_PASSWORD,
                    DatabaseConfig.MYSQL_HOST, DatabaseConfig.MYSQL_PORT, DatabaseConfig.MYSQL_DATABASE_TO_USE);
            PreparedStatement stmt = c.prepareStatement(LIST_ITEMS_QUERY);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
           
                int itemsId = rs.getInt("id");
                String itemName = rs.getString("item_name");
                String description = rs.getString("description");
                int userId = rs.getInt("user_id");
                String username = rs.getString("username");
                String email = rs.getString("user_email");
                String address = rs.getString("user_address");
                String password = rs.getString("user_password");
                
                
                items.add(new Items(itemsId, itemName, description, new User(userId, username, email, address, password)));
            }
        
        } catch (SQLException e) {
            // Escalate to Server error
            throw e;
        }
        // Always close connections, no matter what happened
        finally {
            try {
                if (c != null)
                    c.close();
            } catch (SQLException e) {
                throw e;
            }
        }
        return items;
    }
    
    
    public static User getUser(String username, String password) throws SQLException {
        Connection c = null;
        
        User user = null;
      
        try {
        
        	c = ConnectionUtils.getMySQLConnection(DatabaseConfig.MYSQL_USERNAME, DatabaseConfig.MYSQL_PASSWORD,
                    DatabaseConfig.MYSQL_HOST, DatabaseConfig.MYSQL_PORT, DatabaseConfig.MYSQL_DATABASE_TO_USE);
            PreparedStatement stmt = c.prepareStatement(LIST_A_USER_QUERY);
            stmt.setString( 1, username);
            stmt.setString( 2, password);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
           
                int userId = rs.getInt("id");
                String userName = rs.getString("username");
                String userEmail = rs.getString("user_email");
                String userAddress = rs.getString("user_address");
                String userPassword = rs.getString("user_password");
                
                
                user = new User(userId, userName, userEmail,userAddress,userPassword);
            }
        
        } catch (SQLException e) {
            // Escalate to Server error
            throw e;
        }
        // Always close connections, no matter what happened
        finally {
            try {
                if (c != null)
                    c.close();
            } catch (SQLException e) {
                throw e;
            }
        }
        return user;
    }
    
    
    public static Items getItem(int id) throws SQLException {
        Connection c = null;
        
        Items item = null;
      
        try {
        
        	c = ConnectionUtils.getMySQLConnection(DatabaseConfig.MYSQL_USERNAME, DatabaseConfig.MYSQL_PASSWORD,
                    DatabaseConfig.MYSQL_HOST, DatabaseConfig.MYSQL_PORT, DatabaseConfig.MYSQL_DATABASE_TO_USE);
            PreparedStatement stmt = c.prepareStatement(LIST_AN_ITEM_QUERY);
            stmt.setInt( 1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
           
            	int itemsId = rs.getInt("id");
                String itemName = rs.getString("item_name");
                String description = rs.getString("description");
                int userId = rs.getInt("user_id");
                String username = rs.getString("username");
                String email = rs.getString("user_email");
                String address = rs.getString("user_address");
                String password = rs.getString("user_password");
                
                
                item = new Items(itemsId, itemName, description, new User(userId, username, email, address, password));
            }
        
        } catch (SQLException e) {
            // Escalate to Server error
            throw e;
        }
        // Always close connections, no matter what happened
        finally {
            try {
                if (c != null)
                    c.close();
            } catch (SQLException e) {
                throw e;
            }
        }
        return item;
    }

    public static List<Items> getItemsOfUser(int id) throws SQLException {
        Connection c = null;
        
        List<Items> items = new ArrayList<Items>();
      
        try {
        
        	c = ConnectionUtils.getMySQLConnection(DatabaseConfig.MYSQL_USERNAME, DatabaseConfig.MYSQL_PASSWORD,
                    DatabaseConfig.MYSQL_HOST, DatabaseConfig.MYSQL_PORT, DatabaseConfig.MYSQL_DATABASE_TO_USE);
            PreparedStatement stmt = c.prepareStatement(LIST_ITEMS_OF_A_USER_QUERY);
            stmt.setInt( 1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
           
                int itemsId = rs.getInt("id");
                String itemName = rs.getString("item_name");
                String description = rs.getString("description");
                int userId = rs.getInt("user_id");
              
                items.add(new Items(itemsId, itemName, description, userId));
            }
        
        } catch (SQLException e) {
            // Escalate to Server error
            throw e;
        }
        // Always close connections, no matter what happened
        finally {
            try {
                if (c != null)
                    c.close();
            } catch (SQLException e) {
                throw e;
            }
        }
        return items;
    }

    public static List<Items> getOfferedItems(int id) throws SQLException {
        Connection c = null;
        
        List<Items> items = new ArrayList<Items>();
      
        try {
        
        	c = ConnectionUtils.getMySQLConnection(DatabaseConfig.MYSQL_USERNAME, DatabaseConfig.MYSQL_PASSWORD,
                    DatabaseConfig.MYSQL_HOST, DatabaseConfig.MYSQL_PORT, DatabaseConfig.MYSQL_DATABASE_TO_USE);
            PreparedStatement stmt = c.prepareStatement(GET_OFFERED_ITEMS);
            stmt.setInt( 1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
           
                int itemsId = rs.getInt("id");
                String itemName = rs.getString("item_name");
                String description = rs.getString("description");
                int userId = rs.getInt("user_id");
                
                items.add(new Items(itemsId, itemName, description, userId));
            }
        
        } catch (SQLException e) {
            // Escalate to Server error
            throw e;
        }
        // Always close connections, no matter what happened
        finally {
            try {
                if (c != null)
                    c.close();
            } catch (SQLException e) {
                throw e;
            }
        }
        return items;
    }
    
}
