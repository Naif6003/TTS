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
	
	
	public static final String LIST_ITEMS_QUERY = "select * from trading_items";
    public static final String LIST_DISHESINMENU_QUERY = "select d.id as 'dish_id', d.name, i.id as 'ingredient_id', i.ingredient_name, i.price, di.quantity from dishes d join dish_ingredients di on d.id=di.dishes_id join ingredients i on di.ingredient_id=i.id where d.menu_id = ?";
    public static final String LIST_User_QUERY = "select * from users";
    public static final String LIST_A_DISH = "select id from dishes where name = ?";
    
    
    public static List<Items> getMenus() throws SQLException {
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
                
                
                items.add(new Items(itemsId, itemName, description));
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
    
    
    public static List<User> getUser() throws SQLException {
        Connection c = null;
        
        List<User> user = new ArrayList<User>();
      
        try {
        
        	c = ConnectionUtils.getMySQLConnection(DatabaseConfig.MYSQL_USERNAME, DatabaseConfig.MYSQL_PASSWORD,
                    DatabaseConfig.MYSQL_HOST, DatabaseConfig.MYSQL_PORT, DatabaseConfig.MYSQL_DATABASE_TO_USE);
            PreparedStatement stmt = c.prepareStatement(LIST_User_QUERY);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
           
                int userId = rs.getInt("id");
                String userName = rs.getString("user_name");
                String userEmail = rs.getString("user_email");
                String userAddress = rs.getString("user_address");
                String userPassword = rs.getString("user_password");
                
                
                user.add(new User(userId, userName, userEmail,userAddress,userPassword));
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
//    public static List<Ingredients> getIngredients() throws SQLException {
//        Connection c = null;
//        List<Ingredients> ingredients = new ArrayList<Ingredients>();
//        try {
//            c = ConnectionUtils.getMySQLConnection(DatabaseConfig.MYSQL_USERNAME, DatabaseConfig.MYSQL_PASSWORD,
//                    DatabaseConfig.MYSQL_HOST, DatabaseConfig.MYSQL_PORT, DatabaseConfig.MYSQL_DATABASE_TO_USE);
//            PreparedStatement stmt = c.prepareStatement(LIST_INGREDIENTS_QUERY);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                int ingredientID = rs.getInt("id");
//                String menuName = rs.getString("ingredient_name");
//                double price = rs.getDouble("price");
//                ingredients.add(new Ingredients(ingredientID, menuName, price));
//            }
//        } catch (SQLException e) {
//            // Escalate to Server error
//            throw e;
//        }
//        // Always close connections, no matter what happened
//        finally {
//            try {
//                if (c != null)
//                    c.close();
//            } catch (SQLException e) {
//                throw e;
//            }
//        }
//        return ingredients;
//    }
//    
//    public static List<Dish> getMenuWithDishes(int id) throws SQLException {
//        Connection c = null;
//        List<Dish> dishes = new ArrayList<Dish>();
//        try {
//            c = ConnectionUtils.getMySQLConnection(DatabaseConfig.MYSQL_USERNAME, DatabaseConfig.MYSQL_PASSWORD,
//                    DatabaseConfig.MYSQL_HOST, DatabaseConfig.MYSQL_PORT, DatabaseConfig.MYSQL_DATABASE_TO_USE);
//            PreparedStatement stmt = c.prepareStatement(LIST_DISHESINMENU_QUERY);
//            stmt.setInt( 1, id);
//            ResultSet rs = stmt.executeQuery();
//            HashMap<Ingredients, Integer> hmap = new HashMap<Ingredients, Integer>();
//            while (rs.next()) {
//                int dishID = rs.getInt("dish_id");
//                String dishName = rs.getString("name");
//                int ingredientID = rs.getInt("ingredient_id");
//                String ingredientName = rs.getString("ingredient_name");
//                double ingPrice = rs.getDouble("price");
//                int quantity = rs.getInt("quantity");
//                Ingredients ingredient = new Ingredients(ingredientID, ingredientName, ingPrice);
//                
//                boolean InDishes = true;
//                if(dishes.size() == 0){
//                    hmap.put(ingredient, quantity);
//                    Dish dish = new Dish(dishID, dishName, hmap);
//                    dishes.add(dish);
//                    InDishes = true;
//                }
//                    
//                for(int x = 0; x < dishes.size(); x++){
//                        Dish d = dishes.get(x);
//                        if(d.id == dishID){
//                            InDishes = true;
//                            d.quantityOfIngredients.put(ingredient, quantity);
//                            d.sizeOfMap += 1;
//                            break;
//                        }
//                        InDishes = false;
//                }
//                    
//                if(!InDishes){
//                    HashMap<Ingredients, Integer> hmap2 = new HashMap<Ingredients, Integer>();
//                    hmap2.put(ingredient, quantity);
//                    Dish dish = new Dish(dishID, dishName, hmap2);
//                    dishes.add(dish);
//                }
//                
//            }
//        } catch (SQLException e) {
//            // Escalate to Server error
//            throw e;
//        }
//        // Always close connections, no matter what happened
//        finally {
//            try {
//                if (c != null)
//                    c.close();
//            } catch (SQLException e) {
//                throw e;
//            }
//        }
//        return dishes;
//    }
//    
//    public static int getADishID(String name) throws SQLException {
//        Connection c = null;
//        int dishID = 0;
//        try {
//            c = ConnectionUtils.getMySQLConnection(DatabaseConfig.MYSQL_USERNAME, DatabaseConfig.MYSQL_PASSWORD,
//                    DatabaseConfig.MYSQL_HOST, DatabaseConfig.MYSQL_PORT, DatabaseConfig.MYSQL_DATABASE_TO_USE);
//            PreparedStatement stmt = c.prepareStatement(LIST_A_DISH);
//            stmt.setString( 1, name);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                dishID = rs.getInt("id");
//                
//            }
//        } catch (SQLException e) {
//            // Escalate to Server error
//            throw e;
//        }
//        // Always close connections, no matter what happened
//        finally {
//            try {
//                if (c != null)
//                    c.close();
//            } catch (SQLException e) {
//                throw e;
//            }
//        }
//        return dishID;
//    }
//}

}
