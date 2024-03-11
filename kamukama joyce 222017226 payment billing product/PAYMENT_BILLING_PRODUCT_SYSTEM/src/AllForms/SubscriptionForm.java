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

import AllEntities.Subscriptions;

public class SubscriptionForm implements ActionListener{
	JFrame frame;//subscription_id	product_id	start_date	end_date	status
	JLabel subsid_lb=new JLabel("subscription_id");
	JLabel pid_lb=new JLabel("product_id");
	JLabel strtdate_lb=new JLabel("start_date");
	JLabel enddate_lb=new JLabel("end_date");
	JLabel status_lb=new JLabel("status");
	
	JTextField subsid_txf=new JTextField();
	JTextField pid_txf=new JTextField();
	JTextField strtdate_txf=new JTextField();
	JTextField enddate_txf=new JTextField();
	JTextField status_txf=new JTextField();
	
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public SubscriptionForm(){
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
		frame.setTitle("SUBSCRIPTION FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.GREEN);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		subsid_lb.setBounds(10,10,170,30);
		pid_lb.setBounds(10,50,170,30);
		strtdate_lb.setBounds(10,90,130,30);
		enddate_lb.setBounds(10,130,150,30);
		status_lb.setBounds(10,170,200,30);
	
		
		subsid_txf.setBounds(190,10,190,30);
		pid_txf.setBounds(190,50,190,30);
		strtdate_txf.setBounds(190,90,190,30);
		enddate_txf.setBounds(190,130,190,30);
		status_txf.setBounds(190,170,190,30);
		
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
		subsid_lb.setFont(font);
		pid_lb.setFont(font);
		strtdate_lb.setFont(font);
		enddate_lb.setFont(font);
		status_lb.setFont(font);
		
	
		subsid_txf.setFont(font);
		pid_txf.setFont(font);
		strtdate_txf.setFont(font);
		enddate_txf.setFont(font);
		status_txf.setFont(font);
		
	    Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(subsid_lb);
		frame.add(pid_lb);
		frame.add(strtdate_lb);
		frame.add(enddate_lb);
		frame.add(status_lb);
		
		frame.add(subsid_txf);
		frame.add(pid_txf);
		frame.add(strtdate_txf);
		frame.add(enddate_txf);
		frame.add(status_txf);
	
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
		frame.add(table);
		ActionEvent ();
	}

@Override
public void actionPerformed(ActionEvent e) {
	Subscriptions cst=new Subscriptions();
	if(e.getSource()==insert_btn) {
		
        cst.setPid(pid_txf.getText());
        cst.setStrtdate(strtdate_txf.getText());
		cst.setEnddate(enddate_txf.getText());
		cst.setStatus(status_txf.getText());
		
		cst.insertData();
		
	}
	else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(1);
        model.addColumn("subscription_id");
        model.addColumn("product_id");
        model.addColumn("start_date");
        model.addColumn("end_date");
        model.addColumn("status");
       
      //subscription_id	product_id	start_date	end_date	status
       ResultSet resultSet =Subscriptions.viewData();
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
		int id=Integer.parseInt(subsid_txf.getText());
		cst.setPid(pid_txf.getText());
        cst.setStrtdate(strtdate_txf.getText());
		cst.setEnddate(enddate_txf.getText());
		cst.setStatus(status_txf.getText());;
		cst.update(id);
    }
  else {
		int id=Integer.parseInt(subsid_txf.getText());
		cst.delete(id);}

	
	
}
public static void main(String[] args) {
	SubscriptionForm  subf= new SubscriptionForm ();
	System.out.println(subf);
	
}

}
