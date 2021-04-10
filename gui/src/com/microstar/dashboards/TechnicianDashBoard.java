package com.microstar.dashboards;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TechnicianDashBoard {
	
	private JFrame frame;
	private JDesktopPane desktopPane;
	private JPanel panel;
	private JPanel complaintPanel;
	private JPanel queryPanel;
	private JButton complaintButton;
	private JButton queryButton;
	private JButton logOutButton;
	private JLabel homeImage;
	private Image images1;
	private Image images2;
	private JLabel welcomeLabel;
	private JLabel servicesLabel;
	private JMenuBar complaintMenuBar;
	private JMenuBar queryMenuBar;
	private JMenu queryMenu;
	private JMenu complaintMenu;
	private JMenuItem responseComplaint;
	private JMenuItem viewComplaint;
	private JMenuItem complaintExit;
	private JMenuItem queryAccStatus;
	private JMenuItem queryExit;
	private JLabel complaintLabel;
	private JLabel queryLabel;
	private ResponseForm responseForm;
	private ComplaintResponseTable comResTable;
	private CustomerInfoTable custTable;
	
	public TechnicianDashBoard() {
		//calls all functions 
		initialize();
		layoutComponents();
		addactionLitsners();
		
	}//
	
public void initialize() {
		
		//Initialization of containers 
		frame = new JFrame("Technician Dashboard");
		desktopPane = new JDesktopPane();
		panel = new JPanel();
		
		/*Initialization of panel that holds 
		 * the ComplaintInfoTable and LodgeComplaint Function
		 * Menu bar, menu and all menu items for the complaint panel 
		 * is initialized here*/
		complaintPanel = new JPanel();
		complaintMenuBar = new JMenuBar();
		complaintMenu = new JMenu("Menu");
		responseComplaint = new JMenuItem("Response Form");
		viewComplaint = new JMenuItem("View Complaint");
		complaintExit = new JMenuItem("Exit");
		complaintLabel = new JLabel("Micro-Star CableVision \nComplaint Center");
		
		/*Initialization of panel that holds 
		 * the ComplaintInfoTable and LodgeComplaint Function
		 * Menu bar, menu and all menu items for the complaint panel 
		 * is initialized here*/
		queryPanel = new JPanel();
		queryMenuBar = new JMenuBar();
		queryMenu = new JMenu("Menu");
		queryAccStatus = new JMenuItem("Customer Details");
		queryExit = new JMenuItem("Exit");
		queryLabel  = new JLabel("Micro-Star CableVision \nCustomer Details");
		
		
		//Buttons that are place on the side panel
		complaintButton = new JButton("Complaint");
		queryButton = new JButton("Query");
		logOutButton = new JButton("Log Out");
		
	
		//Jlabels and images that are placed on the side panel 
		homeImage = new JLabel("");
		images1 = new ImageIcon(this.getClass().getResource("/home-icon.png")).getImage();
		images2 = new ImageIcon(this.getClass().getResource("/Star-full-icon.png")).getImage();
		welcomeLabel = new JLabel("Micro-Star CableVision");
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		
		
		/*Jtable to display customer account info
		 * Payment history
		 * past complaints
		 * form to lodge a complaint*/
		responseForm = new ResponseForm();
		comResTable = new ComplaintResponseTable();
		custTable = new CustomerInfoTable();
	
		
		
	}//end of initialize function
	
public void layoutComponents() {
	
	
	 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	  screenSize.width -= 42;
	  screenSize.height -= 42;
	  
	//layout for main container
	frame.setBounds(300, 300, 1069, 814);
	frame.setSize(screenSize);
	frame.getContentPane().setLayout(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//layout for panel
	panel.setBounds(0, 0, 240, 827);
	panel.setLayout(null);
	frame.getContentPane().add(panel);
	
	/*layout for the complaintPanel and it's menu bar
	 * menu and menu items*/
	complaintPanel.setBounds(10, 10, 1251, 798);
	complaintPanel.setLayout(null);
	complaintPanel.add(complaintMenuBar);
	complaintMenuBar.setBounds(0, 0, 1251, 22);
	complaintMenuBar.add(complaintMenu);
	complaintMenu.add(responseComplaint);
	complaintMenu.add(viewComplaint);
	complaintMenu.add(complaintExit);
	//layout for the label displayed on the complaintPanel
	complaintLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
	complaintLabel.setBounds(88, 334, 844, 163);
	
	/*layout for the queryPanel and it's menu bar
	 * menu and menu items*/
	queryPanel.setBounds(10, 10, 1251, 798);
	queryPanel.setLayout(null);
	queryPanel.add(queryMenuBar);
	queryMenuBar.setBounds(0, 0, 1251, 22);
	queryMenuBar.add(queryMenu);
	queryMenu.add(queryAccStatus);
	queryMenu.add(queryExit);
	//layout for the label displayed on the queryPanel
	queryLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
	queryLabel.setBounds(88, 334, 844, 163);
	
	
	//Buttons on the side panel
	complaintButton.setBounds(34, 388, 165, 58);
	complaintButton.setMnemonic('c');
	complaintButton.setToolTipText("press 'alt+c' to open or click button");
	panel.add(complaintButton);
	
	queryButton.setBounds(34, 500, 165, 58);
	queryButton.setMnemonic('q');
	queryButton.setToolTipText("press 'alt+q' to open or click button");
	panel.add(queryButton);
	
	logOutButton.setBounds(34, 634, 165, 58);
	panel.add(logOutButton);

	//labels on the side panel
	homeImage.setBounds(65, 111, 134, 133);
	homeImage.setIcon(new ImageIcon(images1));
	panel.add(homeImage);
	
	//label showing the name of the company and home images
	welcomeLabel.setBounds(4, 10, 236, 50);
	welcomeLabel.setIcon(new ImageIcon(images2));
	panel.add(welcomeLabel);
	
	servicesLabel = new JLabel("Technician Center");
	servicesLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
	servicesLabel.setBounds(65, 279, 134, 50);
	panel.add(servicesLabel);
	
	//layout for desktop pane 
	desktopPane.setBounds(250, 0, 1272, 864);
	desktopPane.setSize(screenSize);
	frame.getContentPane().add(desktopPane);
	
	//Layout for JinternalFrame from the tables
	responseForm.setBounds(37, 45, 823, 494);
	comResTable.setBounds(37, 45, 823, 494);
	custTable.setBounds(37, 45, 823, 494);
	//
	
	
	
	
}//end of layoutComponents method

public void addactionLitsners() {
	
	
	/*addaction Litsner to open complaint panel
	 * and add complaintPanel to the desktop pane*/
	complaintButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			desktopPane.add(complaintPanel);
			complaintPanel.setVisible(true);
			complaintPanel.add(complaintLabel);
			complaintLabel.setVisible(true);	
		}
	});
	
	/*addaction Litsner to open complaint table
	 * and add the complaint table to the 
	 * complaintPanel*/
	responseComplaint.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			complaintPanel.add(responseForm);
			responseForm.setVisible(true);
			complaintLabel.setVisible(false);
		}
	});

	/*addaction Litsner to open lodge complaint form
	 * and add the complaint form to the 
	 * complaintPanel*/
	viewComplaint.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
			complaintPanel.add(comResTable);
			comResTable.setVisible(true);
			complaintLabel.setVisible(false);	
		}
	});
	
	/*addaction Litsner to close out the complaint panel*/
	complaintExit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			complaintPanel.setVisible(false);
							
		}
	});
	
	
	/*addaction Litsner to open query panel window
	 * and add it to the desktop pane
	*/
	queryButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				
			desktopPane.add(queryPanel);
			queryPanel.setVisible(true);
			queryPanel.add(queryLabel);
			queryLabel.setVisible(true);	
		}
	});
	
	/*addaction Litsner to open AccountInfoTable
	 * and add it on the queryPanel
	*/
	queryAccStatus.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			queryPanel.add(custTable);
			custTable.setVisible(true);
			queryLabel.setVisible(false);				
		}
	});
	
	
	/*addaction Litsner to close out the query panel*/
	queryExit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			queryPanel.setVisible(false);
							
		}
	});
	
	//addaction Litsner to logout the window
	logOutButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		frame.setVisible(false);
		frame.dispose();
		System.exit(0);
				}
			});
	
	
}//


public static void main(String[] args) {
	
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				TechnicianDashBoard window = new TechnicianDashBoard();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});

}

}
