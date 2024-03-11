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

import AllEntities.Customer;

public class CustomerForm implements ActionListener{

	JFrame frame;//customer_id	first_name	last_name	email	phone_number	country	gender
	JLabel cstid_lb=new JLabel("customer_id");
	JLabel fnme_lb=new JLabel("first_name");
	JLabel lnme_lb=new JLabel("last_name");
	JLabel email_lb=new JLabel("email");
	JLabel phnenmbr_lb=new JLabel("Phone");
	JLabel cntry_lb=new JLabel("country");
	JLabel gender_lb=new JLabel("Gender");
	
	JTextField cstid_txf=new JTextField();
	JTextField fnme_txf=new JTextField();
	JTextField lnme_txf=new JTextField();
	JTextField email_txf=new JTextField();
	JTextField phnenmbr_txf=new JTextField();
	JTextField cntry_txf=new JTextField();
	JTextField gender_txf=new JTextField();
	 
	String []gender={"Male", "Female"};
	JComboBox<String> genderBox = new JComboBox<>(gender);
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public CustomerForm(){
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
		frame.setTitle("CUSTOMER FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.GREEN);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		cstid_lb.setBounds(10,10,130,30);
		fnme_lb.setBounds(10,50,130,30);
		lnme_lb.setBounds(10,90,130,30);
		email_lb.setBounds(10,130,150,30);
		phnenmbr_lb.setBounds(10,170,200,30);
		cntry_lb.setBounds(10,210,200,30);
		gender_lb.setBounds(10,250,150,30);
		
		cstid_txf.setBounds(150,10,190,30);
		fnme_txf.setBounds(150,50,190,30);
		lnme_txf.setBounds(150,90,190,30);
		email_txf.setBounds(150,130,190,30);
		phnenmbr_txf.setBounds(150,170,190,30);
		cntry_txf.setBounds(150,210,190,30);
		genderBox.setBounds(150,250,190,30);
		
		insert_btn.setBounds(10,300,85,30);
		read_btn.setBounds(110,300,85,30);
		update_btn.setBounds(210,300,85,30);
		delete_btn.setBounds(310,300,85,30);
		
		table.setBounds(500, 30, 600, 240);
		
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		cstid_lb.setFont(font);
		fnme_lb.setFont(font);
		lnme_lb.setFont(font);
		email_lb.setFont(font);
		phnenmbr_lb.setFont(font);
		cntry_lb.setFont(font);
		gender_lb.setFont(font);
	
		cstid_txf.setFont(font);
		fnme_txf.setFont(font);
		lnme_txf.setFont(font);
		email_txf.setFont(font);
		phnenmbr_txf.setFont(font);
		cntry_txf.setFont(font);
		genderBox.setFont(font);
		
	    Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(cstid_lb);
		frame.add(fnme_lb);
		frame.add(lnme_lb);
		frame.add(email_lb);
		frame.add(phnenmbr_lb);
		frame.add(cntry_lb);
		frame.add(gender_lb);
		
		frame.add(cstid_txf);
		frame.add(fnme_txf);
		frame.add(lnme_txf);
		frame.add(email_txf);
		frame.add(phnenmbr_txf);
		frame.add(cntry_txf);
		frame.add(genderBox);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
		frame.add(table);
		ActionEvent ();
}
@Override
public void actionPerformed(ActionEvent e) {
	Customer cst=new Customer();
	if(e.getSource()==insert_btn) {
		
        cst.setFnme(fnme_txf.getText());
        cst.setLnme(lnme_txf.getText());
		cst.setEmail(email_txf.getText());
		cst.setPhnenmbr(phnenmbr_txf.getText());
		cst.setCntry(cntry_txf.getText());
		
		String selectedOption = (String) genderBox.getSelectedItem();
		cst.setGender(selectedOption);
		cst.insertData();
		
	}
	else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(1);
        model.addColumn("customer_id");
        model.addColumn("first_name");
        model.addColumn("last_name");
        model.addColumn("Email");
        model.addColumn("phone_number");
        model.addColumn("country");
        model.addColumn("Gender");
      //customer_id	first_name	last_name	email	phone_number	country	gender 
       ResultSet resultSet =Customer.viewData();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)
                            , resultSet.getString(7)});
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    else if (e.getSource()==update_btn) {
		int id=Integer.parseInt(cstid_txf.getText());

        cst.setFnme(fnme_txf.getText());
        cst.setLnme(lnme_txf.getText());
		cst.setEmail(email_txf.getText());
		cst.setPhnenmbr(phnenmbr_txf.getText());
		cst.setCntry(cntry_txf.getText());
		cst.setGender((String)genderBox.getSelectedItem());
		cst.update(id);
    }
  else {
		int id=Integer.parseInt(cstid_txf.getText());
		cst.delete(id);}

  }
public static void main(String[] args) {
	CustomerForm actf= new CustomerForm();
	System.out.println(actf);


}

}