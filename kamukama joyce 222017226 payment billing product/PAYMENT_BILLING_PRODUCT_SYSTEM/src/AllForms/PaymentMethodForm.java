package AllForms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import AllEntities.PaymentMethods;

public class PaymentMethodForm implements ActionListener{
	JFrame frame;//payment_method_id	type	customer_id	card_number	expiration_date
	JLabel payid_lb=new JLabel("payment_method_id");
	JLabel type_lb=new JLabel("type");
	JLabel cstid_lb=new JLabel("customer_id");
	JLabel cardnmbr_lb=new JLabel("card_number");
	JLabel expdate_lb=new JLabel("expiration_date");
	
	JTextField payid_txf=new JTextField();
	JTextField type_txf=new JTextField();
	JTextField cstid_txf=new JTextField();
	JTextField cardnmbr_txf=new JTextField();
	JTextField expdate_txf=new JTextField();

	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public PaymentMethodForm(){
		createForm();
	    }
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
		}
	
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("PAYMENT METHOD FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.GREEN);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		payid_lb.setBounds(10,10,200,30);
		type_lb.setBounds(10,50,170,30);
		cstid_lb.setBounds(10,90,170,30);
		cardnmbr_lb.setBounds(10,130,150,30);
		expdate_lb.setBounds(10,170,200,30);
		
		
		payid_txf.setBounds(230,10,190,30);
		type_txf.setBounds(230,50,190,30);
		cstid_txf.setBounds(230,90,190,30);
		cardnmbr_txf.setBounds(230,130,190,30);
		expdate_txf.setBounds(230,170,190,30);
		

		insert_btn.setBounds(10,240,85,30);
		read_btn.setBounds(110,240,85,30);
		update_btn.setBounds(210,240,85,30);
		delete_btn.setBounds(310,240,85,30);
		
		table.setBounds(500, 30, 600, 240);
		
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		payid_lb.setFont(font);
		type_lb.setFont(font);
		cstid_lb.setFont(font);
		cardnmbr_lb.setFont(font);
		expdate_lb.setFont(font);
		
		payid_txf.setFont(font);
		type_txf.setFont(font);
		cstid_txf.setFont(font);
		cardnmbr_txf.setFont(font);
		expdate_txf.setFont(font);
		
	    Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(payid_lb);
		frame.add(type_lb);
		frame.add(cstid_lb);
		frame.add(cardnmbr_lb);
		frame.add(expdate_lb);
		
		frame.add(payid_txf);
		frame.add(type_txf);
		frame.add(cstid_txf);
		frame.add(cardnmbr_txf);
		frame.add(expdate_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
		frame.add(table);
		ActionEvent ();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PaymentMethods PMT=new PaymentMethods();
		if(e.getSource()==insert_btn) {
			
	        PMT.setType(type_txf.getText());
	        PMT.setCstid(cstid_txf.getText());
			PMT.setCardnmbr(cardnmbr_txf.getText());
			PMT.setExpdate(expdate_txf.getText());
			
			PMT.insertData();
			
		}
		else if (e.getSource() == read_btn) {
	        model.setColumnCount(0);
	        model.setRowCount(1);
	        model.addColumn("payment_method_id");
	        model.addColumn("type");
	        model.addColumn("customer_id");
	        model.addColumn("card_number");
	        model.addColumn("expiration_date");
	       
	      //payment_method_id	type	customer_id	card_number	expiration_date
	       ResultSet resultSet =PaymentMethods.viewData();
	        if (resultSet != null) {
	            try {
	                while (resultSet.next()) {
	                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
	                            resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)});
	                }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	    }
	    else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(payid_txf.getText());
			  PMT.setType(type_txf.getText());
		        PMT.setCstid(cstid_txf.getText());
				PMT.setCardnmbr(cardnmbr_txf.getText());
				PMT.setExpdate(expdate_txf.getText());
			PMT.update(id);
	    }
	  else {
			int id=Integer.parseInt(payid_txf.getText());
			PMT.delete(id);}

		}
	public static void main(String[] args) {
		PaymentMethodForm invf= new PaymentMethodForm ();
		System.out.println(invf);
		
	}

	

	}
