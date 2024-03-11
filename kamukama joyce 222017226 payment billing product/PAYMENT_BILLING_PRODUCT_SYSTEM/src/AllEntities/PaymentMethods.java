package AllEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class PaymentMethods {//	payment_method_id	type	customer_id	card_number	expiration_date
	private int payid;
	private String 	type;
	private String 	cstid;
	private String  cardnmbr;
	private String expdate;
	
	public PaymentMethods() {
	    // Default constructor
      }
	public PaymentMethods(int payid, String type,String cstid, String cardnmbr,String expdate) {
		super();
		this.payid=payid;
		this.type=type;
		this.cstid=cstid;
		this.cardnmbr=cardnmbr;
		this.expdate=expdate;
		}
	
	public int getPayid() {
		return payid;
	}
	public void setPayid(int payid) {
		this.payid = payid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCstid() {
		return cstid;
	}
	public void setCstid(String cstid) {
		this.cstid = cstid;
	}
	public String getCardnmbr() {
		return cardnmbr;
	}
	public void setCardnmbr(String cardnmbr) {
		this.cardnmbr = cardnmbr;
	}
	public String getExpdate() {
		return expdate;
	}
	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}
	public void makeconnection() {
	}
		public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/payment_billing_product";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO paymentmethods(type,	customer_id,	card_number,	expiration_date) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       //preparedStatement.setString(1, this.actid);
	     
	       preparedStatement.setString(1, this.type);
	       preparedStatement.setString(2, this.cstid);
	       preparedStatement.setString(3, this.cardnmbr);
	       preparedStatement.setString(4, this.expdate);
	      
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

	        String sql = "SELECT * FROM paymentmethods";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	public void update(int inputpayid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/payment_billing_product";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE paymentmethods SET type=?,	customer_id=?,	card_number=?,	expiration_date=? WHERE payment_method_id =?";

	    try (   
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getType());
	          stm.setString(2, this.getCstid());
	        // Assuming there is a column named 'id' for the WHERE clause
	          stm.setString(3, this.getCardnmbr());
	          stm.setString(4, this.getExpdate());
	         
	          
	          stm.setInt(5, inputpayid);
	         
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
	public void delete(int inputpayid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/payment_billing_product";
	    
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM paymentmethods WHERE payment_method_id =?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputpayid); // Assuming there is a column named 'id' for the WHERE clause

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



