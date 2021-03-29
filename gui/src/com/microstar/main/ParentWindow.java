package com.microstar.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ParentWindow{

	private JFrame jf;
	private JDesktopPane dtp;
	private JMenuBar mb;
	private JMenu fm;
	
	private JInternalFrame innitialFrame;
	private JInternalFrame loginFrame;
	private JInternalFrame customerFrame;
	private JInternalFrame employeeFrame;
	private JInternalFrame accountFrame;
	private JInternalFrame complaintFrame;
	
	private JLabel custFrame;
	private JLabel empFrame;
	private JLabel accFrame;
	private JLabel complFrame;
	private JLabel loginLabel;
	private JLabel welcomeLabel;
	
	private JPanel loginPanel;
	
	private JButton loginButton;
	private JTextField txtUserId;
	private JPasswordField txtPassword;
	
	private JMenuItem customerMIt;
	private JMenuItem empoyeeMIt;
	private JMenuItem accountMIt;
	private JMenuItem complaintMIt;




	public ParentWindow() {


		initilizeComponets();
		layoutComponents();
		addactionLitsners();
		addToDeskTopPane();

	}//end of the ParentWindow()


	public void initilizeComponets() {

		jf = new JFrame("Micro-Star Cable Vision");
		dtp = new JDesktopPane();
		mb = new JMenuBar();
		fm = new JMenu("File");

		customerFrame = new JInternalFrame("Customer Table", true, true, true, true);
		custFrame = new JLabel("You are in the Customer Database Tbale");
		customerMIt = new JMenuItem("Customer");

		employeeFrame = new JInternalFrame("Employee Table", true, true, true, true);
		empFrame = new JLabel(" You are in the Employee Database Table");
		empoyeeMIt = new JMenuItem("Employee");

		accountFrame = new JInternalFrame("Customer Accounts Table", true, true, true, true);
		accFrame = new JLabel("You are in the Customer Account Table");
		accountMIt = new JMenuItem("Account");

		complaintFrame = new JInternalFrame("Complaint Table", true, true, true, true);
		complFrame = new JLabel("You are in the Complaint Table");
		complaintMIt = new JMenuItem("Complaint");
		
		innitialFrame = new JInternalFrame("Welcome", false);
		loginLabel = new JLabel("Login Here");
		welcomeLabel = new JLabel("Micro-Star Cable Vision");
		
		loginFrame = new JInternalFrame("Login", false);
		loginPanel = new JPanel(new GridLayout(4,1));
		loginButton = new JButton("Login");
		
		txtPassword = new JPasswordField();
		txtUserId = new JTextField();

	}

	public void addactionLitsners() {
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(
					txtUserId.getText().isBlank() ||
					txtUserId.getText().isEmpty() ||
					txtPassword.getText().isBlank() ||
					txtPassword.getText().isEmpty()
				) {
					JOptionPane.showMessageDialog(null,
							"Username and Password is required",
							"Error Message", JOptionPane.ERROR_MESSAGE);
					
				} else {

					Login userLogin = new Login(txtUserId.getText(), txtPassword.getText());
					System.out.println("Attempting to login user");
					System.out.println(userLogin.toString());
					;
					
					JOptionPane.showMessageDialog(null,
							userLogin.sendLoginRequest(userLogin),
							"Login Status", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
				//
				
			}
		});

		//Add customer action menu item to the menu bar
		fm.add(customerMIt);
		customerMIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				customerFrame.setVisible(true);
				dtp.add(customerFrame);
			}
		});


		//Add employee action menu item to the menu bar
		fm.add(empoyeeMIt);
		empoyeeMIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				employeeFrame.setVisible(true);
				dtp.add(employeeFrame);
			}
		});


		//Add account table action menu item to the menu bar
		fm.add(complaintMIt);
		accountMIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				accountFrame.setVisible(true);
				dtp.add(accountFrame);
			}
		});

		//Add account table action menu item to the menu bar
		fm.add(accountMIt);
		complaintMIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				complaintFrame.setVisible(true);
				dtp.add(complaintFrame);
			}
		});

		//Add exit action menu item to the menu bar
		mb.add(fm);
		JMenuItem mi;
		fm.add(mi = new JMenuItem("Exit"));
		mi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}


	public void addToDeskTopPane() {
		
				
		dtp.add(innitialFrame);
		dtp.add(loginFrame);
		setTimer(3000);

//		dtp.add(customerFrame);
//		dtp.add(employeeFrame);
//		dtp.add(accountFrame);
//		dtp.add(complaintFrame);

	}


	public void layoutComponents() {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenSize.width -= 42;
		screenSize.height -= 42;
		jf.setSize(screenSize);
		jf.setLocation(20, 20);
		jf.setResizable(false);

		jf.setContentPane(dtp);
		jf.setJMenuBar(mb);
		
		//Initial JInternalFrame with Greeting message
		innitialFrame.setContentPane(welcomeLabel);
		innitialFrame.setSize(400, 300);
		innitialFrame.setLocation(50, 50);
		innitialFrame.setVisible(true);
		
		
		//Login JInternalFrame with login Form
		loginPanel.add(loginLabel);
		loginPanel.add(txtUserId);
		loginPanel.add(txtPassword);
		loginPanel.add(loginButton);
		loginFrame.setContentPane(loginPanel);
		loginFrame.setSize(400, 300);
		loginFrame.setLocation(50, 50);


		//JInternalFrame For Customer Table
		customerFrame.setContentPane(custFrame);
		customerFrame.setSize(400, 300);
		customerFrame.setLocation(50, 50);
		customerFrame.setVisible(true);



		//JInternalFrame For Employee Table
		employeeFrame.setContentPane(empFrame);
		employeeFrame.setSize(300, 200);
		employeeFrame.setLocation(200, 200);
		employeeFrame.setVisible(true);


		//JInternalFrame For Customer Account Table
		accountFrame.setContentPane(accFrame);
		accountFrame.setLocation(400, 400);
		accountFrame.setSize(500, 200);
		accountFrame.setVisible(true);



		//JInternalFrame For Complaint Table
		complaintFrame.setContentPane(complFrame);
		complaintFrame.setLocation(800, 400);
		complaintFrame.setSize(300, 200);
		complaintFrame.setVisible(true);



		jf.setVisible(true);
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				jf.setVisible(false);
				jf.dispose();
				System.exit(0);
			}
		});

	}
	
	public void setTimer(int time) {
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				innitialFrame.setVisible(false);
				loginFrame.setVisible(true);
				
			}
			
		}, time);
		
	}

	public static void main(String[] args) {

		new ParentWindow();
	}
}


