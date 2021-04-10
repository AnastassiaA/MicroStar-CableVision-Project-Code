package com.microstar.dashboards;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class CustomerDashBoard {

	private JFrame frame;
	private JDesktopPane desktopPane;
	private JPanel panel;
	private JPanel queryPanel;
	private JPanel complaintPanel;
	private JButton complaintButton;
	private JButton queryButton;
	private JButton chatButton;
	private JButton logOutButton;
	private JInternalFrame liveChatFrame;
	private JLabel homeImage;
	private Image images1;
	private Image images2;
	private JLabel welcomeLabel;
	private JLabel servicesLabel;
	private AccountInfoTable accTable;
	private PaymentInfoTable payTable;
	private ComplaintInfoTable comTable;
	private LodgeComplaint logFrame;
	private JMenuBar queryMenuBar;
	private JMenuBar complaintMenuBar;
	private JMenu queryMenu;
	private JMenu complaintMenu;
	private JMenuItem viewComplaint;
	private JMenuItem lodgeComplaint;
	private JMenuItem queryAccStatus;
	private JMenuItem queryPayHistory;
	private JMenuItem complaintExit;
	private JMenuItem queryExit;
	private JLabel complaintLabel;
	private JLabel queryLabel;



	public CustomerDashBoard() {
		//calls all functions 
		initialize();
		layoutComponents();
		addactionLitsners();

	}//

	public void initialize() {

		//Initialization of containers 
		frame = new JFrame("Customer Dashboard");
		desktopPane = new JDesktopPane();
		panel = new JPanel();

		/*Initialization of panel that holds 
		 * the ComplaintInfoTable and LodgeComplaint Function
		 * Menu bar, menu and all menu items for the complaint panel 
		 * is initialized here*/
		complaintPanel = new JPanel();
		complaintMenuBar = new JMenuBar();
		complaintMenu = new JMenu("Menu");
		viewComplaint = new JMenuItem("View Complaints");
		lodgeComplaint = new JMenuItem("Lodge Complaint");
		complaintExit = new JMenuItem("Exit");
		complaintLabel = new JLabel("Micro-Star CableVision \nComplaint Center");

		/*Initialization of panel that holds 
		 * the AccountInfoTable and PaymentInfoTable
		 * Menu bar, menu and all menu items for the query panel 
		 * is initialized here*/
		queryPanel = new JPanel();
		queryMenuBar = new JMenuBar();
		queryMenu = new JMenu("Menu");
		queryAccStatus = new JMenuItem("Account Status");
		queryPayHistory = new JMenuItem("Payment History");
		queryExit = new JMenuItem("Exit");
		queryLabel  = new JLabel("Micro-Star CableVision \nQuery Center");

		//Buttons that are place on the side panel
		complaintButton = new JButton("Complaint");
		queryButton = new JButton("Query");
		chatButton = new JButton("Representative");
		logOutButton = new JButton("Log Out");



		//Initialization of liveChatFrame
		liveChatFrame= new JInternalFrame("Live Chat", true, true, true, true);


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
		accTable = new AccountInfoTable();
		payTable = new PaymentInfoTable();
		comTable = new ComplaintInfoTable();
		logFrame = new LodgeComplaint();



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
		complaintMenu.add(viewComplaint);
		complaintMenu.add(lodgeComplaint);
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
		queryMenu.add(queryPayHistory);
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


		chatButton.setBounds(34, 605, 165, 58);
		chatButton.setMnemonic('r');
		chatButton.setToolTipText("press 'alt+r' to open or click button");
		panel.add(chatButton);

		logOutButton.setBounds(34, 718, 165, 58);
		panel.add(logOutButton);

		//labels on the side panel
		homeImage.setBounds(65, 111, 134, 133);
		homeImage.setIcon(new ImageIcon(images1));
		panel.add(homeImage);

		//label showing the name of the company and home images
		welcomeLabel.setBounds(4, 10, 236, 50);
		welcomeLabel.setIcon(new ImageIcon(images2));
		panel.add(welcomeLabel);

		servicesLabel = new JLabel("Services");
		servicesLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		servicesLabel.setBounds(65, 279, 104, 50);
		panel.add(servicesLabel);

		//layout for desktop pane 
		desktopPane.setBounds(250, 0, 1536, 827);
		desktopPane.setSize(screenSize);
		frame.getContentPane().add(desktopPane);

		//Layout for JinternalFrame from the tables
		accTable.setBounds(37, 45, 823, 494);//AccountInfoTable
		payTable.setBounds(37, 45, 823, 494);//PaymentInfoTable
		comTable.setBounds(37, 45, 823, 494);//ComplaintInfoTable
		logFrame.setBounds(37, 45, 823, 494);//LodgeComplaint

		//JinternalFrame for liveChatFrame
		liveChatFrame.setBounds(10, 40, 1045, 784);


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
		viewComplaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				complaintPanel.add(comTable);
				comTable.setVisible(true);
				complaintLabel.setVisible(false);	
			}
		});

		/*addaction Litsner to open lodge complaint form
		 * and add the complaint form to the 
		 * complaintPanel*/
		lodgeComplaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				complaintPanel.add(logFrame);
				logFrame.setVisible(true);
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

				queryPanel.add(accTable);
				accTable.setVisible(true);
				queryLabel.setVisible(false);				
			}
		});

		/*addaction Litsner to open PaymentInfoTable
		 and add it on the queryPanel*/
		queryPayHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				queryPanel.add(payTable);
				payTable.setVisible(true);
				queryLabel.setVisible(false);

			}
		});

		/*addaction Litsner to close out the query panel*/
		queryExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				queryPanel.setVisible(false);

			}
		});



		//addaction Litsner to open live chat window
		chatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

	}//


	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerDashBoard window = new CustomerDashBoard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}