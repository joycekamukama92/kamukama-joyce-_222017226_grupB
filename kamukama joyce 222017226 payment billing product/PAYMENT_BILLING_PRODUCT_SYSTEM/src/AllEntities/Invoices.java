package AllEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Invoices {//invoice_id	customer_id	payment_method_id	issue_date		total_amount	currency	payment_status	
	private int invid;
	private String 	cusid;
	private String 	paymthid;
	private String issudate;
	private String totamnt;
	private String currncy;
	private String paystuts;
	
	public Invoices() {
	    // Default constructor
      }
	public Invoices(int invid, String cusid,String paymthid, String issudate,String totamnt,String currncy,String paystuts) {
		super();
		this.invid=invid;
		this.cusid=cusid;
		this.paymthid=paymthid;
		this.issudate=issudate;
		this.totamnt=totamnt;
		this.currncy=currncy;
		this.paystuts=paystuts;
		}
	
	public int getInvid() {
		return invid;
	}
	public void setInvid(int invid) {
		this.invid = invid;
	}
	public String getCusid() {
		return cusid;
	}
	public void setCusid(String cusid) {
		this.cusid = cusid;
	}
	public String getPaymthid() {
		return paymthid;
	}
	public void setPaymthid(String paymthid) {
		this.paymthid = paymthid;
	}
	public String getIssudate() {
		return issudate;
	}
	public void setIssudate(String issudate) {
		this.issudate = issudate;
	}
	public String getTotamnt() {
		return totamnt;
	}
	public void setTotamnt(String totamnt) {
		this.totamnt = totamnt;
	}
	public String getCurrncy() {
		return currncy;
	}
	public void setCurrncy(String currncy) {
		this.currncy = currncy;
	}
	public String getPaystuts() {
		return paystuts;
	}
	public void setPaystuts(String paystuts) {
		this.paystuts = paystuts;
	}
	public void makeconnection() {
	}
		public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/payment_billing_product";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO invoices(customer_id,	payment_method_id,	issue_date,	total_amount,	currency,	payment_status	) VALUES (?,?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       //preparedStatement.setString(1, this.actid);
	     
	       preparedStatement.setString(1, this.cusid);
	       preparedStatement.setString(2, this.paymthid);
	       preparedStatement.setString(3, this.issudate);
	       preparedStatement.setString(4, this.totamnt);
	       preparedStatement.setString(5, this.currncy);
	       preparedStatement.setString(6, this.paystuts);
	       
	      
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

	        String sql = "SELECT * FROM invoices";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	public void update(int inputinvid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/payment_billing_product";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE invoices SET customer_id=?,	payment_method_id=?,	issue_date=?,	total_amount=?,	currency=?,	payment_status=? WHERE invoice_id	=?";

	    try (   
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getCusid());
	          stm.setString(2, this.getPaymthid());
	        // Assuming there is a column named 'id' for the WHERE clause
	          stm.setString(3, this.getIssudate());
	          stm.setString(4, this.getTotamnt());
	          stm.setString(5, this.getCurrncy()); 
	          stm.setString(6, this.getPaystuts());
	          
	          stm.setInt(7, inputinvid);
	          
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
	public void delete(int inputinvid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/payment_billing_product";
	    
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM invoices WHERE invoice_id	=?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputinvid); // Assuming there is a column named 'id' for the WHERE clause

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




