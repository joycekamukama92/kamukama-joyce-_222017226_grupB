package AllEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Customer {//	customer_id	first_name	last_name	email	phone_number	country	gender
	private int cstid;
	private String 	fnme;
	private String 	lnme;
	private String email;
	private String phnenmbr;
	private String cntry;
	private String gender;
	
	public Customer() {
	    // Default constructor
      }
	public Customer(int cstid, String fnme,String lnme, String email,String phnenmbr,String cntry,String gender) {
		super();
		this.cstid=cstid;
		this.fnme=fnme;
		this.lnme=lnme;
		this.email=email;
		this.phnenmbr=phnenmbr;
		this.cntry=cntry;
		this.gender=gender;
		}
	
	public int getCstid() {
		return cstid;
	}
	public void setCstid(int cstid) {
		this.cstid = cstid;
	}
	public String getFnme() {
		return fnme;
	}
	public void setFnme(String fnme) {
		this.fnme = fnme;
	}
	public String getLnme() {
		return lnme;
	}
	public void setLnme(String lnme) {
		this.lnme = lnme;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhnenmbr() {
		return phnenmbr;
	}
	public void setPhnenmbr(String phnenmbr) {
		this.phnenmbr = phnenmbr;
	}
	public String getCntry() {
		return cntry;
	}
	public void setCntry(String cntry) {
		this.cntry = cntry;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void makeconnection() {
	}
		public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/payment_billing_product";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO customers(first_name,	last_name,	email,	phone_number,	country,	gender) VALUES (?,?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       //preparedStatement.setString(1, this.actid);
	     
	       preparedStatement.setString(1, this.fnme);
	       preparedStatement.setString(2, this.lnme);
	       preparedStatement.setString(3, this.email);
	       preparedStatement.setString(4, this.phnenmbr);
	       preparedStatement.setString(5, this.cntry);
	       preparedStatement.setString(6, this.gender);
	       
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

	        String sql = "SELECT * FROM customers";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	public void update(int inputcstid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/payment_billing_product";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE customers SET first_name=?,	last_name=?,	email=?,	phone_number=?,	country=?,	gender=? WHERE customer_id	=?";

	    try (   
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getFnme());
	          stm.setString(2, this.getLnme());
	        // Assuming there is a column named 'id' for the WHERE clause
	          stm.setString(4, this.getEmail());
	          stm.setString(5, this.getPhnenmbr());
	          stm.setString(3, this.getCntry()); 
	          stm.setString(6, this.getGender());
	          
	          stm.setInt(7, inputcstid);
	        
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
	public void delete(int inputcstid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/payment_billing_product";
	    
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM customers WHERE customer_id	 =?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputcstid); // Assuming there is a column named 'id' for the WHERE clause

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



