package AllEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Product {//product_id	product_name	description	category	price
	private int pid;
	private String 	pname;
	private String 	pdescrptn;
	private String catgry;
	private String price;
	
	public Product() {
	    // Default constructor
      }
	public Product(int pid, String pname,String pdescrptn, String catgry,String price) {
		super();
		this.pid=pid;
		this.pname=pname;
		this.pdescrptn=pdescrptn;
		this.catgry=catgry;
		this. price=price;
		}
      
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdescrptn() {
		return pdescrptn;
	}
	public void setPdescrptn(String pdescrptn) {
		this.pdescrptn = pdescrptn;
	}
	public String getCatgry() {
		return catgry;
	}
	public void setCatgry(String catgry) {
		this.catgry = catgry;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void makeconnection() {
	}
		public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/payment_billing_product";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO products(product_name,	description,	category,	price) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       //preparedStatement.setString(1, this.actid);
	     
	       preparedStatement.setString(1, this.pname);
	       preparedStatement.setString(2, this.pdescrptn);
	       preparedStatement.setString(3, this.catgry);
	       preparedStatement.setString(4, this.price);
	     
	       // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data insert successfully!");
	            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}
	 
		public static ResultSet viewData() {
	        String host = "jdbc:mysql://localhost/payment_billing_product";
	        String user = "root";
	        String password = "";

	        String sql = "SELECT * FROM products";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	public void update(int inputpid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/payment_billing_product";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE products SET product_name=?,	description=?,	category=?,	price=? WHERE product_id	=?";

	    try (   
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getPname());
	          stm.setString(2, this.getPdescrptn());
	        // Assuming there is a column named 'id' for the WHERE clause
	          stm.setString(3, this.getCatgry());
	          stm.setString(4, this.getPrice());
	         
	          stm.setInt(5, inputpid);
	          
	          // Execute the update
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int inputpid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/payment_billing_product";
	    
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM products WHERE product_id =?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputpid); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	}
}





