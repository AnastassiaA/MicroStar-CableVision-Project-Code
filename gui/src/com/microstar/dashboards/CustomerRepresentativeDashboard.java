package com.microstar.dashboards;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import com.microstar.models.CompanyServices;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class CustomerRepresentativeDashboard {

	private JFrame frame;

	private JDesktopPane desktopPane;

	private JPanel panel;

	private JButton servicesBtn;
	private JButton complaintButton;
	private JButton queryButton;
	private JButton chatButton;
	private JButton logOutButton;
	private JButton lodgeButton;

	private JInternalFrame complaintFrame;
	private JInternalFrame liveChatFrame;
	private JInternalFrame serviceFrame;

	private JTextPane textPane;

	private Image images1;
	private Image images2;

	private ImageIcon homeIcon;
	private ImageIcon starIcon;

	private JLabel homeImageLbl;
	private JLabel welcomeLabel;
	private JLabel servicesLabel, loadingLabel;

	private JRadioButton technicalRadioButton;
	private JRadioButton accountRadioButton;
	private JRadioButton serviceRadioButton;

	private JLabel serviceLabel;
	private JMenuBar menuBar;
	private JMenuItem viewOption, addOption, editOption, removeOption;
	private JMenu mainMenu, customerMenu, serviceMenu, technicianMenu, complaintMenu;
	private JPanel mainPanel, customerPanel, servicePanel, technicianPanel, complaintPanel, loadingPanel;

	private DefaultTableModel serviceTableModel;
	private JTable serviceTable;
	private JScrollPane scrollPane;

	private AccountInfoTable accTable;

	private String[][] serviceTableRows = {
			{ "4031", "Kundan Kumar", "CSE" },
			{ "6014", "Anand Jha", "IT" }
	};

	private String[] serviceTableColumns = {
			"Service Id",
			"Service Name",
			"Service Description"
	};



	public CustomerRepresentativeDashboard() {
		//calls all functions 
		initialize();
		layoutComponents();
		addactionLitsners();

	}//

	public void initialize() {

		//Initialization of containers 
		frame = new JFrame("Customer Representative Dashboard");
		desktopPane = new JDesktopPane();
		panel = new JPanel();

		//Buttons
		servicesBtn = new JButton("Services");
		complaintButton = new JButton("Complaint");
		queryButton = new JButton("Query");
		chatButton = new JButton("Representative");
		logOutButton = new JButton("Log Out");
		lodgeButton = new JButton("Lodge Complaint");


		//Initialization of JInternalFrames
		complaintFrame = new JInternalFrame("Complaint", false, true, true, true);
		liveChatFrame = new JInternalFrame("Live Chat", false, true, true, true);
		serviceFrame = new JInternalFrame("Services", false, true, true, true);

		//Jlabels and images
		//URL imageUrl = getClass().getResource("D:/AdvancedProgramming/ap-project/MicroStar-CableVision-Project-Code/gui/images/home-icon.png");
		//homeIcon = new ImageIcon(imageUrl);
		homeImageLbl = new JLabel("Home");
		//images1 = new ImageIcon(this.getClass().getResource("/images/home-icon.png")).getImage();
		//images2 = new ImageIcon(this.getClass().getResource("/images/Star-full-icon.png")).getImage();
		welcomeLabel = new JLabel("Micro-Star CableVision");
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		loadingLabel = new JLabel("Loadin... Please wait");

		//radio buttons on complaint Frame
		technicalRadioButton = new JRadioButton("Technical");
		accountRadioButton = new JRadioButton("Account");
		serviceRadioButton= new JRadioButton("Service Package");

		//Jtable to display customer account info
		accTable = new AccountInfoTable();

		menuBar = new JMenuBar();
		mainMenu = new JMenu("Home");
		customerMenu = new JMenu("Customers");
		serviceMenu = new JMenu("Services");
		technicianMenu = new JMenu("Technician");
		complaintMenu = new JMenu("Complaint");

		viewOption = new JMenuItem("View Services");
		addOption = new JMenuItem("Add Service");
		editOption = new JMenuItem("Edit Service");
		removeOption = new JMenuItem("Remove Service");

		servicePanel = new JPanel();
		loadingPanel = new JPanel();

		// Initializing the JTable
		serviceTableModel = new DefaultTableModel(serviceTableColumns, 0);
		serviceTable = new JTable(serviceTableModel);
		//serviceTable.setBounds(30, 40, 100, 100);
		serviceTable.setPreferredScrollableViewportSize(new Dimension(650, 200));
		serviceTable.setFillsViewportHeight(true);
		scrollPane = new JScrollPane(serviceTable);



	}//end of initialize function

	public void layoutComponents() {


		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenSize.width -= 42;
		screenSize.height -= 42;

		//layout for main container
		frame.setBounds(1, 1, 1069, 814);
		frame.setSize(screenSize);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		//layout for panel
		panel.setBounds(0, 0, 240, 827);
		panel.setLayout(null);
		frame.getContentPane().add(panel);


		//Buttons on the panel
		servicesBtn.setBounds(34, 279, 165, 58);
		servicesBtn.setMnemonic('s');
		servicesBtn.setToolTipText("press 'alt+s' to open or click button");
		panel.add(servicesBtn);

		complaintButton.setBounds(34, 388, 165, 58);
		complaintButton.setMnemonic('c');
		complaintButton.setToolTipText("press 'alt+c' to open or click button");
		panel.add(complaintButton);

		queryButton.setBounds(34, 500, 165, 58);
		queryButton.setMnemonic('q');
		queryButton.setToolTipText("press 'alt+q' to open or click button");
		panel.add(queryButton);


		chatButton.setBounds(34, 605, 165, 58);
		chatButton.setMnemonic('r');
		chatButton.setToolTipText("press 'alt+r' to open or click button");
		panel.add(chatButton);

		logOutButton.setBounds(34, 718, 165, 58);
		panel.add(logOutButton);


		serviceMenu.add(viewOption);
		serviceMenu.add(addOption);
		serviceMenu.add(editOption);
		serviceMenu.add(removeOption);

		menuBar.add(mainMenu);
		menuBar.add(customerMenu);
		menuBar.add(complaintMenu);
		menuBar.add(serviceMenu);
		menuBar.add(technicianMenu);		

		servicePanel.add(scrollPane);
		servicePanel.setBounds(23, 23, 650, 500);
		servicePanel.setBackground(Color.BLUE);
		servicePanel.setVisible(false);

		scrollPane.setVisible(true);
		
		loadingPanel.setBounds(23, 23, 650, 500);
		loadingPanel.add(loadingLabel);
		loadingPanel.setVisible(false);

		serviceFrame.setJMenuBar(menuBar);
		//this.add(scrollPane);
		serviceFrame.add(servicePanel);
		//serviceFrame.add(loadingPanel);
		serviceFrame.setBounds(10, 40, 1045, 784);

		//labels
		homeImageLbl.setBounds(65, 111, 134, 133);
		//homeImageLbl.setIcon(homeIcon);
		panel.add(homeImageLbl);
		//label showing the name of the company and home images
		welcomeLabel.setBounds(4, 10, 236, 50);
		//welcomeLabel.setIcon(new ImageIcon(images2));
		panel.add(welcomeLabel);


		//layout for desktop pane 
		desktopPane.setBounds(250, 0, 1536, 827);
		desktopPane.setSize(screenSize);
		frame.getContentPane().add(desktopPane);

		//JInternal Frames
		complaintFrame.setBounds(10, 40, 1045, 784);
		complaintFrame.getContentPane().setLayout(null);

		//textpane added to the complaintFrame
		textPane = new JTextPane();
		textPane.setBounds(241, 44, 719, 479);
		complaintFrame.getContentPane().add(textPane);

		//Radio buttons on complaintFrame 
		technicalRadioButton.setBounds(41, 181, 103, 21);
		complaintFrame.getContentPane().add(technicalRadioButton);


		accountRadioButton.setBounds(41, 277, 103, 21);
		complaintFrame.getContentPane().add(accountRadioButton);


		serviceRadioButton.setBounds(41, 373, 135, 21);
		complaintFrame.getContentPane().add(serviceRadioButton);


		lodgeButton.setBounds(534, 567, 215, 39);
		complaintFrame.getContentPane().add(lodgeButton);


		//JinternalFrame for query
		accTable.setBounds(10, 80, 1045, 784);


		//JinternalFrame for payment history
		liveChatFrame.setBounds(10, 40, 1045, 784);



	}//end of layoutComponents method

	public void addactionLitsners() {
		//addaction Litsner to open complaint window

		servicesBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				liveChatFrame.setVisible(false);
				desktopPane.remove(liveChatFrame);

				accTable.setVisible(false);
				desktopPane.remove(accTable);

				complaintFrame.setVisible(false);
				desktopPane.remove(complaintFrame);

				serviceFrame.setVisible(true);
				desktopPane.add(serviceFrame);

			}
		});

		complaintButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				liveChatFrame.setVisible(false);
				desktopPane.remove(liveChatFrame);

				accTable.setVisible(false);
				desktopPane.remove(accTable);

				complaintFrame.setVisible(true);
				desktopPane.add(complaintFrame);
			}
		});

		viewOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loadingPanel.setVisible(true);
				System.out.println("Viewing...");
	
				for( var service : CompanyServices.prepareList( CompanyServices.getAllCompanyServices() ) ) {
					System.out.println(service);
					Object[] obj = { service.getServiceId(), service.getServiceName(), service.getServiceDescription() };
					serviceTableModel.addRow(obj);
				}
				loadingPanel.setVisible(false);
				scrollPane.setVisible(true);
				servicePanel.setVisible(true);
				
			}
		});

		addOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Adding...");
				
			}
		});

		editOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Editing...");
				
			}
		});

		removeOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Removing...");
				
			}
		});

		//addaction Litsner to open query window
		queryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				liveChatFrame.setVisible(false);
				desktopPane.remove(liveChatFrame);

				complaintFrame.setVisible(false);
				desktopPane.remove(complaintFrame);

				accTable.setVisible(true);
				desktopPane.add(accTable);

			}
		});

		//addaction Litsner to open payment history window
		chatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				accTable.setVisible(false);
				desktopPane.remove(accTable);				

				complaintFrame.setVisible(false);
				desktopPane.remove(complaintFrame);

				liveChatFrame.setVisible(true);
				desktopPane.add(liveChatFrame);
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

		//addaction Litsner to lodge a complaint
		lodgeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(technicalRadioButton.isSelected()) {
					JOptionPane.showMessageDialog(lodgeButton, "Technical Complaint Lodged");
				}
				if(accountRadioButton.isSelected()) {
					JOptionPane.showMessageDialog(lodgeButton, "Complaint about Account Lodged.");
				}
				if(serviceRadioButton.isSelected()) {
					JOptionPane.showMessageDialog(lodgeButton, "Complaint about Internet/Cable service Lodged.");
				}
			}
		});
	}//





	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerRepresentativeDashboard window = new CustomerRepresentativeDashboard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}