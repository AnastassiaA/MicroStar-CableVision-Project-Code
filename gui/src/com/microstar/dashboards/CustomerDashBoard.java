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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JMenuBar;

public class CustomerDashBoard {
	private JFrame frame;
	private JDesktopPane desktopPane;
	private JPanel panel;
	private JButton complaintButton;
	private JButton queryButton;
	private JButton chatButton;
	private JButton logOutButton;
	private JButton lodgeButton;
	private JInternalFrame complaintFrame;
	private JInternalFrame liveChatFrame;
	private JTextPane textPane;
	private JLabel homeImage;
	private Image images1;
	private Image images2;
	private JLabel welcomeLabel;
	private JLabel servicesLabel;
	private JRadioButton technicalRadioButton;
	private JRadioButton accountRadioButton;
	private JRadioButton serviceRadioButton;
	private AccountInfoTable accTable;



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

		//Buttons 
		complaintButton = new JButton("Complaint");
		queryButton = new JButton("Query");
		chatButton = new JButton("Representative");
		logOutButton = new JButton("Log Out");
		lodgeButton = new JButton("Lodge Complaint");


		//Initialization of JInternalFrames
		complaintFrame = new JInternalFrame("Complaint", true, true, true, true);
		liveChatFrame= new JInternalFrame("Live Chat", true, true, true, true);



		//Jlabels and images 
		homeImage = new JLabel("");
		images1 = new ImageIcon(this.getClass().getResource("/home-icon.png")).getImage();
		images2 = new ImageIcon(this.getClass().getResource("/Star-full-icon.png")).getImage();
		welcomeLabel = new JLabel("Micro-Star CableVision");
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));

		//radio buttons on complaint Frame
		technicalRadioButton = new JRadioButton("Technical");
		accountRadioButton = new JRadioButton("Account");
		serviceRadioButton= new JRadioButton("Service Package");

		//Jtable to display customer account info
		accTable = new AccountInfoTable();



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


		//Buttons on the panel
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

		//labels
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
		complaintButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				complaintFrame.setVisible(true);
				desktopPane.add(complaintFrame);
			}
		});

		//addaction Litsner to open query window
		queryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				accTable.setVisible(true);
				desktopPane.add(accTable);	

			}
		});

		//addaction Litsner to open payment history window
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
					CustomerDashBoard window = new CustomerDashBoard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}