package com.microstar.dashboards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import com.microstar.models.CompanyServices;
import com.microstar.models.Complaint;
import com.microstar.models.Response;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
	private JButton lodgeButton, responseBtn, submitResponseBtn;
	private JButton addServicesBtn, editServicesBtn, removeServicesBtn, cancelServicesFormBtn;
	
	private JTextField serviceIdField, complaintIdField;
	private JTextField serviceNameField, visitDateField;
	private JTextArea serviceDescriptionField, complaintDescriptionField, responseDescriptionField;

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
	private JLabel serviceIdLbl, serviceNameLbl, complaintIdLbl, serviceDescriptionLbl, visitDatLbl, responseDescLbl;

	private JRadioButton technicalRadioButton;
	private JRadioButton accountRadioButton;
	private JRadioButton serviceRadioButton;

	private JLabel serviceLabel;
	private JMenuBar menuBar;
	private JMenuItem viewOption, addOption, editOption, removeOption;
	private JMenu mainMenu, customerMenu, serviceMenu, technicianMenu, complaintMenu;
	private JPanel mainPanel, customerPanel, servicePanel, formFieldsPanel, technicianPanel,
					complaintPanel, loadingPanel, servicesFormPanel, 
					complaintDetailsPanel, responseFormPanel;

	private DefaultTableModel serviceTableModel;
	private JTable serviceTable;
	private JScrollPane scrollPane;
	
	private DefaultTableModel complaintTableModel;
	private JTable complaintTable;
	private JScrollPane complaintScrollPane;

	private AccountInfoTable accTable;


	private String[] serviceTableColumns = {
			"Service Id",
			"Service Name",
			"Service Description"
	};
	
	private String[] complaintTableColumns = {
			"Complaint Id",
			"Service Id",
			"Complaint Type",
			"Complaint Status",
			"Complaint Description",
			"Customer Id"
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
		queryButton = new JButton("Customer");
		chatButton = new JButton("Technician");
		logOutButton = new JButton("Log Out");
		lodgeButton = new JButton("Lodge Complaint");
		

		addServicesBtn = new JButton("Save"); 
		editServicesBtn = new JButton("Update");
		removeServicesBtn = new JButton("Delete");
		cancelServicesFormBtn = new JButton("Cancel");
		
		serviceIdField = new JTextField();
		serviceIdLbl = new JLabel("Service Id");
		serviceIdField.setSize(10, 15);
		
		serviceNameField = new JTextField();
		serviceNameLbl = new JLabel("Service Name");
		
		serviceDescriptionField = new JTextArea();
		serviceDescriptionLbl = new JLabel("Service Description");
		
		servicesFormPanel = new JPanel(new GridLayout(6,1));
		formFieldsPanel = new JPanel();
		formFieldsPanel.setLayout(new GridLayout(4,2));
		
		formFieldsPanel.add(serviceIdLbl);
		formFieldsPanel.add(serviceIdField);
		
		formFieldsPanel.add(serviceNameLbl);
		formFieldsPanel.add(serviceNameField);
		
		formFieldsPanel.add(serviceDescriptionLbl);
		formFieldsPanel.add(serviceDescriptionField);
		
		formFieldsPanel.add(addServicesBtn);
		formFieldsPanel.add(cancelServicesFormBtn);
		


		//Initialization of JInternalFrames
		complaintFrame = new JInternalFrame("Complaints", false, true, true, true);
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
		serviceTable.setRowSelectionAllowed(true);
		scrollPane = new JScrollPane(serviceTable);
		
		complaintIdLbl = new JLabel("Complaint Id:");
		complaintIdField = new JTextField();
		complaintDescriptionField = new JTextArea();
		complaintPanel = new JPanel();
		complaintDetailsPanel = new JPanel(new GridLayout(3, 2));
		complaintTableModel = new DefaultTableModel(complaintTableColumns, 0);
		complaintTable = new JTable(complaintTableModel);
		complaintTable.setPreferredScrollableViewportSize(new Dimension(650, 200));
		complaintTable.setFillsViewportHeight(true);
		complaintTable.setRowSelectionAllowed(true);
		complaintScrollPane = new JScrollPane(complaintTable);
		
		visitDatLbl = new JLabel("Visit Date:");
		responseDescLbl = new JLabel("Response Details:");
		visitDateField = new JTextField();
		responseDescriptionField = new JTextArea();
		responseBtn = new JButton("Respond");
		submitResponseBtn = new JButton("Submit");
		responseFormPanel = new JPanel(new GridLayout(4, 2));



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

		//menuBar.add(mainMenu);
		//menuBar.add(customerMenu);
		//menuBar.add(complaintMenu);
		menuBar.add(serviceMenu);
		//menuBar.add(technicianMenu);		

		servicePanel.add(scrollPane);
		scrollPane.setVisible(true);
		servicePanel.setBounds(23, 23, 650, 500);
		servicePanel.setBackground(Color.BLUE);
		servicePanel.setVisible(false);
		
		servicesFormPanel.setBackground(Color.RED);
		servicesFormPanel.setVisible(false);
		
		formFieldsPanel.add(cancelServicesFormBtn);
		formFieldsPanel.setBounds(23, 23, 350, 500);
		formFieldsPanel.setBackground(Color.LIGHT_GRAY);
		formFieldsPanel.setVisible(false);
		
		loadingPanel.setBounds(23, 23, 650, 500);
		loadingPanel.add(loadingLabel);
		loadingPanel.setVisible(false);

		serviceFrame.setJMenuBar(menuBar);
		//this.add(scrollPane);
		serviceFrame.add(servicePanel);
		serviceFrame.add(servicesFormPanel);
		serviceFrame.add(formFieldsPanel);
		//serviceFrame.add(loadingPanel);
		serviceFrame.setBounds(10, 40, 1045, 784);
		serviceFrame.getContentPane().setLayout(null);


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
		
		complaintPanel.add(complaintScrollPane);
		complaintScrollPane.setVisible(true);
		complaintPanel.setBounds(23, 23, 650, 500);
		complaintPanel.setBackground(Color.BLUE);
		complaintPanel.setVisible(false);
		
		complaintDetailsPanel.add(complaintIdField);
		complaintDetailsPanel.add(complaintDescriptionField);
		complaintDetailsPanel.add(responseBtn);
		complaintDetailsPanel.setBounds(23, 23, 650, 500);
		complaintDetailsPanel.setBackground(Color.RED);
		complaintDetailsPanel.setVisible(false);
		
		responseFormPanel.add(complaintIdLbl);
		responseFormPanel.add(complaintIdField);
		responseFormPanel.add(visitDatLbl);
		responseFormPanel.add(visitDateField);
		responseFormPanel.add(responseDescLbl);
		responseFormPanel.add(responseDescriptionField);
		responseFormPanel.add(submitResponseBtn);
		responseFormPanel.setBounds(23, 23, 650, 500);
		responseFormPanel.setBackground(Color.RED);
		responseFormPanel.setVisible(false);

		//textpane added to the complaintFrame
		textPane = new JTextPane();
		textPane.setBounds(241, 44, 719, 479);
		textPane.setVisible(false);
		complaintFrame.getContentPane().add(textPane);

		//Radio buttons on complaintFrame 
		technicalRadioButton.setBounds(41, 181, 103, 21);
		technicalRadioButton.setVisible(false);
		complaintFrame.getContentPane().add(technicalRadioButton);


		accountRadioButton.setBounds(41, 277, 103, 21);
		accountRadioButton.setVisible(false);
		complaintFrame.getContentPane().add(accountRadioButton);


		serviceRadioButton.setBounds(41, 373, 135, 21);
		serviceRadioButton.setVisible(false);
		complaintFrame.getContentPane().add(serviceRadioButton);


		lodgeButton.setBounds(534, 567, 215, 39);
		lodgeButton.setVisible(false);
		complaintFrame.getContentPane().add(lodgeButton);
		
		complaintFrame.getContentPane().add(complaintPanel);
		complaintFrame.getContentPane().add(complaintDetailsPanel);
		complaintFrame.getContentPane().add(responseFormPanel);


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
				
				getServices();

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
				
				getComplaints();
			}
		});
		
		complaintTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel tableModel = (DefaultTableModel) complaintTable.getModel();
				int selectIndex = complaintTable.getSelectedRow();
				
				System.out.println("\n row selected");
				System.out.println(tableModel.getValueAt(selectIndex, 0).toString());
				System.out.println(tableModel.getValueAt(selectIndex, 1).toString());
				System.out.println(tableModel.getValueAt(selectIndex, 2).toString());
				System.out.println(tableModel.getValueAt(selectIndex, 3).toString());
				System.out.println(tableModel.getValueAt(selectIndex, 4).toString());
				System.out.println(tableModel.getValueAt(selectIndex, 5).toString());
				
				String responseData = Complaint.getComplaintById( Integer.valueOf( tableModel.getValueAt(selectIndex, 0).toString() ) );
				
				Complaint dataObject = Complaint.parseResponse(responseData);
				
				complaintIdField.setText(dataObject.getComplaintId().toString());
				complaintIdField.setEnabled(false);
				
				String info = "Customer Id: " + dataObject.getCustomer().getCustomerId() + "\n"
								+ "Customer Name: " + dataObject.getCustomer().getFirstName() + "  " + dataObject.getCustomer().getLastName() + "\n"
								+ "Customer Email: " + dataObject.getCustomer().getEmailAddress() + "\n"
								+ "Contact number" + dataObject.getCustomer().getContactNumber() + "\n"
								
								+ "Complaint Type: " + dataObject.getComplaintType() + "\n"
								+ "Complaint Status: " + dataObject.getComplaintStatus() + "\n"
								+ "Complaint Details:\n" + dataObject.getComplaintDescription() + "\n"
						;
				
				complaintDescriptionField.setText( info );
				complaintDetailsPanel.setVisible(true);
				complaintPanel.setVisible(false);
				
			}
		});
		
		responseBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				complaintIdField.setEnabled(false);
				complaintDetailsPanel.setVisible(false);
				complaintPanel.setVisible(false);
				
				responseFormPanel.setVisible(true);
				
			}
		});
		
		submitResponseBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Response complaintResponse = new Response(null,
													visitDateField.getText(),
													responseDescriptionField.getText(),
													Integer.valueOf(complaintIdField.getText())
												);
				
				String serverSays = Response.addResponse(complaintResponse);
				

				JOptionPane.showMessageDialog(null, serverSays, "Information", JOptionPane.INFORMATION_MESSAGE);
				
				if( serverSays.equals("Saved!") ) {
					complaintIdField.setEnabled(false);
					complaintDetailsPanel.setVisible(false);
					responseFormPanel.setVisible(false);
					
					complaintPanel.setVisible(true);
					
				}
				
			}
		});

		viewOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getServices();
			}
		});

		addOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Adding...");

				scrollPane.setVisible(false);
				servicePanel.setVisible(false);
				serviceIdField.setEnabled(false);
				servicesFormPanel.setVisible(true);
				formFieldsPanel.setVisible(true);
				
			}
		});

		editOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Editing...");
				serviceIdField.setEnabled(true);
				
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
		
		addServicesBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = serviceNameField.getText();
				String description = serviceDescriptionField.getText();
				
				CompanyServices newService = new CompanyServices(null, name, description);
				String response = CompanyServices.addCompanyService(newService);
				
				if( response.equals("Saved!") ) {
					JOptionPane.showMessageDialog(null,
							response,
							"Success",
							JOptionPane.INFORMATION_MESSAGE);
					
					getServices();
					
				} else {
					JOptionPane.showMessageDialog(null,
							response,
							"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}//

	public void getServices() {
		loadingPanel.setVisible(true);
		System.out.println("Viewing...");
		
		//serviceTableModel = new DefaultTableModel(serviceTableColumns, 0);
		//serviceTable = new JTable(serviceTableModel);
		
		DefaultTableModel model = (DefaultTableModel) serviceTable.getModel();
		model.setRowCount(0);

		for( var service : CompanyServices.prepareList( CompanyServices.getAllCompanyServices() ) ) {
			System.out.println(service);
			Object[] obj = { service.getServiceId(), service.getServiceName(), service.getServiceDescription() };
			
			serviceTableModel.addRow(obj);
		}
		loadingPanel.setVisible(false);
		servicesFormPanel.setVisible(false);
		formFieldsPanel.setVisible(false);
		scrollPane.setVisible(true);
		servicePanel.setVisible(true);
	}
	
	
	public void getComplaints() {
		//loadingPanel.setVisible(true);
		System.out.println("Viewing... complaints");
		
		//Complaint.getAllComplaintsTest();
		DefaultTableModel model = (DefaultTableModel) serviceTable.getModel();
		model.setRowCount(0);

		for( var complaint : Complaint.prepareList( Complaint.getAllComplaints() ) ) {
			System.out.println(complaint.toString());
			
			Object[] obj = {
					complaint.getComplaintId(), complaint.getServiceId(), complaint.getComplaintType(),
					complaint.getComplaintStatus(), complaint.getComplaintDescription(), complaint.getCustomerId()
				};
			complaintTableModel.addRow(obj);
		}
		//loadingPanel.setVisible(false);
		//servicesFormPanel.setVisible(false);
		//formFieldsPanel.setVisible(false);
		complaintScrollPane.setVisible(true);
		complaintPanel.setVisible(true);
	}
	
	
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