package Menus;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import AllForms.CustomerForm;
import AllForms.InvoicesForm;
import AllForms.PaymentMethodForm;
import AllForms.ProductForm;
import AllForms.SubscriptionForm;

public class FormMenu extends JFrame implements ActionListener {
	JFrame frame;

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
    private JMenu Customermenu;
    private JMenu Invoicesmenu;
    private JMenu PaymentMethodmenu;
    private JMenu Productmenu;
    private JMenu Subscriptionsmenu;
    private JMenu Logoutmenu;
    
    public FormMenu() {
		// TODO Auto-generated constructor stub
	}
    
    private JMenuItem CustomerItem;
    private JMenuItem InvoicesItem;
    private JMenuItem PaymentMethodItem;
    private JMenuItem ProductItem;
    private JMenuItem SubscriptionsItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public FormMenu(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        Customermenu = new JMenu("ApplicantInfo");
        Invoicesmenu = new JMenu("CourseInfo");
        PaymentMethodmenu= new JMenu("Financial_issues_info");
        Productmenu = new JMenu("ProjectResearchInfo ");
        Subscriptionsmenu = new JMenu("ProjectResearchInfo");
       
        Logoutmenu = new JMenu("Logout");
        		

        // Create menu items
        menuBar.add(Customermenu);
        CustomerItem = new JMenuItem("CustomerForm");
        CustomerItem.addActionListener(this);
        
        menuBar.add(Invoicesmenu);
        InvoicesItem = new JMenuItem("InvoicesForm");
        InvoicesItem.addActionListener(this);
        
        menuBar.add(PaymentMethodmenu);
        PaymentMethodItem = new JMenuItem("PaymentMethodForm");
        PaymentMethodItem.addActionListener(this);
        
        menuBar.add(Productmenu);
        ProductItem = new JMenuItem("ProductForm");
        ProductItem.addActionListener(this);
        
        menuBar.add(Subscriptionsmenu);
        SubscriptionsItem = new JMenuItem("SubscriptionsForm");
        SubscriptionsItem.addActionListener(this);
        

        menuBar.add(Logoutmenu);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        Customermenu.add(CustomerItem);
        Invoicesmenu.add(InvoicesItem);
        PaymentMethodmenu.add(PaymentMethodItem);
        Productmenu.add(ProductItem);
        Subscriptionsmenu.add(SubscriptionsItem);
        
        Logoutmenu.addSeparator();
        Logoutmenu.add(logoutItem);

        // Add home menu to menu bar
        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " DASHBOARD");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == CustomerItem) {
            new CustomerForm();
        
        } else if (e.getSource() == InvoicesItem) {
            new InvoicesForm();
        
        } else if (e.getSource() == PaymentMethodItem) {
            new PaymentMethodForm();
       
        } else if (e.getSource() == ProductItem) {
           new ProductForm();
        
        } else if (e.getSource() == SubscriptionsItem) {
           new SubscriptionForm();
           
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormMenu("TO PAYMENT BILLING PRODUCTION SYSTEM"));
    }
}





