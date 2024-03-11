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

import AllEntities.Invoices;


public class InvoicesForm implements ActionListener{
	JFrame frame;//invoice_id	customer_id	payment_method_id	issue_date		total_amount	currency	payment_status	
	JLabel invid_lb=new JLabel("invoice_id");
	JLabel cusid_lb=new JLabel("customer_id");
	JLabel paymthid_lb=new JLabel("payment_method_id");
	JLabel issudate_lb=new JLabel("issue_date");
	JLabel  totamnt_lb=new JLabel("total_amount");
	JLabel currncy_lb=new JLabel("currency");
	JLabel paystuts_lb=new JLabel("payment_status");
	
	JTextField invid_txf=new JTextField();
	JTextField cusid_txf=new JTextField();
	JTextField paymthid_txf=new JTextField();
	JTextField issudate_txf=new JTextField();
	JTextField  totamnt_txf=new JTextField();
	JTextField currncy_txf=new JTextField();
	JTextField paystuts_txf=new JTextField();

	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public InvoicesForm(){
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
		frame.setTitle("INVOICES FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.GREEN);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		invid_lb.setBounds(10,10,130,30);
		cusid_lb.setBounds(10,50,130,30);
		paymthid_lb.setBounds(10,90,210,30);
		issudate_lb.setBounds(10,130,170,30);
		totamnt_lb.setBounds(10,170,200,30);
		currncy_lb.setBounds(10,210,200,30);
		paystuts_lb.setBounds(10,250,200,30);
		
		invid_txf.setBounds(230,10,190,30);
		cusid_txf.setBounds(230,50,190,30);
		paymthid_txf.setBounds(230,90,190,30);
		issudate_txf.setBounds(230,130,190,30);
		totamnt_txf.setBounds(230,170,190,30);
		currncy_txf.setBounds(230,210,190,30);
		paystuts_txf.setBounds(230,250,190,30);

		insert_btn.setBounds(10,300,85,30);
		read_btn.setBounds(110,300,85,30);
		update_btn.setBounds(210,300,85,30);
		delete_btn.setBounds(310,300,85,30);
		
		table.setBounds(500, 30, 700, 240);
		
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		invid_lb.setFont(font);
		cusid_lb.setFont(font);
		paymthid_lb.setFont(font);
		issudate_lb.setFont(font);
		totamnt_lb.setFont(font);
		currncy_lb.setFont(font);
		paystuts_lb.setFont(font);
	
		invid_txf.setFont(font);
		cusid_txf.setFont(font);
		paymthid_txf.setFont(font);
		issudate_txf.setFont(font);
		totamnt_txf.setFont(font);
		currncy_txf.setFont(font);
		paystuts_txf.setFont(font);
		

	    Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(invid_lb);
		frame.add(cusid_lb);
		frame.add(paymthid_lb);
		frame.add(issudate_lb);
		frame.add(totamnt_lb);
		frame.add(currncy_lb);
		frame.add(paystuts_lb);
		
		frame.add(invid_txf);
		frame.add(cusid_txf);
		frame.add(paymthid_txf);
		frame.add(issudate_txf);
		frame.add(totamnt_txf);
		frame.add(currncy_txf);
		frame.add(paystuts_txf);

		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
		frame.add(table);
		ActionEvent ();


}
@Override
public void actionPerformed(ActionEvent e) {
	Invoices in=new Invoices();
	if(e.getSource()==insert_btn) {
		
        in.setCusid(cusid_txf.getText());
        in.setPaymthid(paymthid_txf.getText());
		in.setIssudate(issudate_txf.getText());
		in.setTotamnt(totamnt_txf.getText());
		in.setCurrncy(currncy_txf.getText());
		in.setPaystuts(paystuts_txf.getText());
        in.insertData();
		
	}
	else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(1);
        model.addColumn("invoice_id");
        model.addColumn("customer_id");
        model.addColumn("payment_method_id");
        model.addColumn("issue_date ");
        model.addColumn("total_amount");
        model.addColumn("currency");
        model.addColumn("payment_status");
      //invoice_id	customer_id	payment_method_id	issue_date		total_amount	currency	payment_status
       ResultSet resultSet =Invoices.viewData();
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
		int id=Integer.parseInt(invid_txf.getText());


        in.setCusid(cusid_txf.getText());
        in.setPaymthid(paymthid_txf.getText());
		in.setIssudate(issudate_txf.getText());
		in.setTotamnt(totamnt_txf.getText());
		in.setCurrncy(currncy_txf.getText());
		in.setPaystuts(paystuts_txf.getText());
		in.update(id);
    }
  else {
		int id=Integer.parseInt(invid_txf.getText());
		in.delete(id);}

	

}
public static void main(String[] args) {
	InvoicesForm  invf= new InvoicesForm ();
	System.out.println(invf);

}

}