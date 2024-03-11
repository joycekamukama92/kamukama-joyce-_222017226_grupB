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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import AllEntities.Product;

public class ProductForm implements ActionListener{
	JFrame frame;//product_id	product_name	description	category	price
	JLabel pid_lb=new JLabel("product_id");
	JLabel pname_lb=new JLabel("product_name");
	JLabel pdescrptn_lb=new JLabel("description");
	JLabel catgry_lb=new JLabel("category");
	JLabel price_lb=new JLabel("price");
	
	JTextField pid_txf=new JTextField();
	JTextField pname_txf=new JTextField();
	JTextField pdescrptn_txf=new JTextField();
	JTextField catgry_txf=new JTextField();
	JTextField price_txf=new JTextField();
	

	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public ProductForm(){
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
		frame.setTitle("PRODUCT FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.GREEN);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		pid_lb.setBounds(10,10,130,30);
		pname_lb.setBounds(10,50,170,30);
		pdescrptn_lb.setBounds(10,90,130,30);
		catgry_lb.setBounds(10,130,150,30);
		price_lb.setBounds(10,170,200,30);
		
		pid_txf.setBounds(150,10,190,30);
		pname_txf.setBounds(150,50,190,30);
		pdescrptn_txf.setBounds(150,90,190,30);
		catgry_txf.setBounds(150,130,190,30);
		price_txf.setBounds(150,170,190,30);
		
		
		insert_btn.setBounds(10,220,85,30);
		read_btn.setBounds(110,220,85,30);
		update_btn.setBounds(210,220,85,30);
		delete_btn.setBounds(310,220,85,30);
		
		table.setBounds(500, 30, 600, 240);
		
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		pid_lb.setFont(font);
		pname_lb.setFont(font);
		pdescrptn_lb.setFont(font);
		catgry_lb.setFont(font);
		price_lb.setFont(font);
		
		pid_txf.setFont(font);
		pname_txf.setFont(font);
		pdescrptn_txf.setFont(font);
		catgry_txf.setFont(font);
		price_txf.setFont(font);
		
	    Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(pid_lb);
		frame.add(pname_lb);
		frame.add(pdescrptn_lb);
		frame.add(catgry_lb);
		frame.add(price_lb);
		
	    frame.add(pid_txf);
		frame.add(pname_txf);
		frame.add(pdescrptn_txf);
		frame.add(catgry_txf);
		frame.add(price_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
		frame.add(table);
		ActionEvent ();
	}

    @Override
	public void actionPerformed(ActionEvent e) {
		Product Pt=new Product();
		if(e.getSource()==insert_btn) {
			
	        Pt.setPname(pname_txf.getText());
	        Pt.setPdescrptn(pdescrptn_txf.getText());
			Pt.setCatgry(catgry_txf.getText());
			Pt.setPrice(price_txf.getText());
			Pt.insertData();
			
		}
		else if (e.getSource() == read_btn) {
	        model.setColumnCount(0);
	        model.setRowCount(0);
	        model.addColumn("product_id");
	        model.addColumn("product_name");
	        model.addColumn("description");
	        model.addColumn("category");
	        model.addColumn("price");
	       
	       ResultSet resultSet =Product.viewData();
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
			int id=Integer.parseInt(pid_txf.getText());

	        Pt.setPname(pname_txf.getText());
	        Pt.setPdescrptn(pdescrptn_txf.getText());
			Pt.setCatgry(catgry_txf.getText());
			Pt.setPrice(price_txf.getText());
			Pt.update(id);
	    }
	  else {
			int id=Integer.parseInt(pid_txf.getText());
			Pt.delete(id);}

		
		
}
public static void main(String[] args) {
	ProductForm   invf= new ProductForm  ();
	System.out.println(invf);
}

}