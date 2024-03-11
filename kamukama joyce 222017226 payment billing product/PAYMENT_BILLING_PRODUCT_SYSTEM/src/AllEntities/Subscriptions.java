package AllEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Subscriptions {//subscription_id	product_id	start_date	end_date	status
	private int subsid;
	private String 	pid;
	private String 	strtdate;
	private String enddate;
	private String status;
	
	public Subscriptions() {
	    // Default constructor
      }
	public Subscriptions(int subsid, String pid,String strtdate, String enddate,String status) {
		super();
		this.subsid=subsid;
		this.pid=pid;
		this.strtdate=strtdate;
		this.enddate=enddate;
		this.status=status;
	}
	
	public int getSubsid() {
		return subsid;
	}
	public void setSubsid(int subsid) {
		this.subsid = subsid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getStrtdate() {
		return strtdate;
	}
	public void setStrtdate(String strtdate) {
		this.strtdate = strtdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void makeconnection() {
	}
		public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/payment_billing_product";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO subscriptions(product_id,	start_date,	end_date,	status) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       //preparedStatement.setString(1, this.actid);
	     
	       preparedStatement.setString(1, this.pid);
	       preparedStatement.setString(2, this.strtdate);
	       preparedStatement.setString(3, this.enddate);
	       preparedStatement.setString(4, this.status);
	      
	      
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

	        String sql = "SELECT * FROM subscriptions";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	public void update(int inputsubsid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/payment_billing_product";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE subscriptions SET product_id=?,	start_date=?,	end_date=?,	status=? WHERE subscription_id=?";

	    try (   
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getPid());
	          stm.setString(2, this.getStrtdate());
	        // Assuming there is a column named 'id' for the WHERE clause
	          stm.setString(3, this.getEnddate());
	          stm.setString(4, this.getStatus());
	         
	          stm.setInt(5, inputsubsid);
	          
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
	public void delete(int inputsubsid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/payment_billing_product";
	    
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM subscriptions WHERE subscription_id=?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputsubsid); // Assuming there is a column named 'id' for the WHERE clause

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



