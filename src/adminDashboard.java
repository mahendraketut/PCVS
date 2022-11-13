import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.io.*;
import java.security.PublicKey;

import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class adminDashboard extends JFrame implements ActionListener
{
	private PCVS controller;
	private JMenuItem itmNew, itmOpen, itmSave, itmSaveAs, itmExit;
	private JMenuItem itmAddNewVaccineBatch, itmViewVaccineBatchInfo;
	private JMenuItem itmConfVaccAppointment, itmVacAdministered;
	private JMenuItem itmViewUser, itmViewVaccAppointment;
	private JMenuItem itmAboutPCVS;
	private JLayeredPane layeredPaneVaccine;
	private JPanel panelViewVaccineBatch;
	private JPanel panelRecordNewVaccineBatch;
	private JPanel panelConfirmOrRejectAppointment;
	private JPanel panelHomePage;
	
	private JLabel lblViewVB;
	private JLabel lblRecordNewVB;
	private JLabel lblVaccineID;
	private JTextField manufacturerTextField;
	private JTextField vaccineNameTextField;
	private JLabel lblBatchNumber;
	private JTextField batchNumTextField;
	private JLabel lblExpiryDateExpiry;
	private JLabel lblQuantityDose;
	private JTextField quantityOfDoseTextField;
	private JButton btnDeleteData;
	private JPanel panelViewVaccinationAdministered;
	private JPanel panelListingUser;
	private JPanel panelListingVaccinationAppointment;
	private JLabel lblVaccinationAdministered;
	private JLabel lblUserData;
	private JLabel lblVaccinationAppointmentData;
	private JLabel logo;
	private JLabel lblNewLabel;
	private JLabel lblProvidedByMinistry;
	private JLabel lblAuthorIKetut;
	private JLabel lblConfirmOrReject;
	private JTable tableViewVB;
	private JScrollPane scrollTableViewVB;
	private JTable tableConfirmReject;
	private JLabel lblTitleUpdateStatus;
	private JLabel lblVaccinationID;
	private JTextField vaccinationIdField;
	private JButton btnUpdateStatusVaccination;
	private JTable tableVaccinationAdministered;
	private JTextField textFieldVaccIDAdministered;
	private JTable tableVaccinationAppointmentData;
	private JScrollPane scrollPaneVaccinationAppointmentData;
	private JComboBox comboBoxListSort;
	private JLabel lblSort;
	private JButton btnSort;
	private JTable tableUserData;
	private JScrollPane scrollPaneUserData;

	/**
	 * Create the frame.
	 */
	public adminDashboard(PCVS pcvs, String username) {
		controller = pcvs;
		setVisible(true);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int closing = JOptionPane.showConfirmDialog(getParent(), 
						"Are you sure to exit this program?\nMake sure you has Saving this Project",
						"Program Close",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.CLOSED_OPTION);
				if(closing==JOptionPane.YES_OPTION) {
					PCVSGUI loginBack = new PCVSGUI(controller);
					loginBack.setVisible(true);
					dispose();
				}
			}
		});
		
		setTitle("PCVS - Admin");
		setIconImage(Toolkit.getDefaultToolkit().getImage(adminDashboard.class.getResource("/img/pcvsIcon.png")));
		setBounds(100, 50, 1240, 720);
		
		/**
		 * Menu Bar
		 */
		JMenuBar menuListing = new JMenuBar();
		menuListing.setBorderPainted(false);
		menuListing.setBackground(new Color(255, 255, 255));
		setJMenuBar(menuListing);
		JMenu fileMenu = new JMenu("File");
		fileMenu.setBackground(new Color(255, 255, 255));
		fileMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuListing.add(fileMenu);
		
		//menu new
		itmNew = new JMenuItem("New");
		fileMenu.add(itmNew);
		itmNew.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		//menu open
		itmOpen = new JMenuItem("Open");
		fileMenu.add(itmOpen);
		itmOpen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		//menu save
		itmSave = new JMenuItem("Save");
		fileMenu.add(itmSave);
		itmSave.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		//menu save as
		itmSaveAs = new JMenuItem("Save As");
		fileMenu.add(itmSaveAs);
		itmSaveAs.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		//menu logout
		itmExit = new JMenuItem("Logout");
		itmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int closing = JOptionPane.showConfirmDialog(getParent(), 
						"Logout from PCVS?","Logout",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.CLOSED_OPTION);
				if(closing==JOptionPane.YES_OPTION) {
					PCVSGUI loginBack = new PCVSGUI(controller);
					loginBack.setVisible(true);
					dispose();
				}
			}
		});
		fileMenu.add(itmExit);
		itmExit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		/**
		 * Menu Bar Vaccine
		 */
		JMenu vaccineMenu = new JMenu("Vaccine");
		vaccineMenu.setBackground(new Color(255, 255, 255));
		vaccineMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuListing.add(vaccineMenu);
		
		//menu record new vaccine batch
		itmAddNewVaccineBatch = new JMenuItem("Add New Vaccine Batch");
		itmAddNewVaccineBatch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelRecordNewVaccineBatch.setVisible(true);
				panelViewVaccineBatch.setVisible(false);
				panelConfirmOrRejectAppointment.setVisible(false);
				panelViewVaccinationAdministered.setVisible(false);
				panelListingUser.setVisible(false);
				panelListingVaccinationAppointment.setVisible(false);
			}
		});
		vaccineMenu.add(itmAddNewVaccineBatch);
		itmAddNewVaccineBatch.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		//menu view vaccine batch information
		itmViewVaccineBatchInfo = new JMenuItem("View Vaccine Batch Information");
		itmViewVaccineBatchInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelRecordNewVaccineBatch.setVisible(false);
				panelViewVaccineBatch.setVisible(true);
				panelConfirmOrRejectAppointment.setVisible(false);
				panelViewVaccinationAdministered.setVisible(false);
				panelListingUser.setVisible(false);
				panelListingVaccinationAppointment.setVisible(false);
			}
		});
		vaccineMenu.add(itmViewVaccineBatchInfo);
		itmViewVaccineBatchInfo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		/**
		 * Menu Bar Vaccination
		 */
		JMenu vaccinationMenu = new JMenu("Vaccination");
		vaccinationMenu.setBackground(new Color(255, 255, 255));
		vaccinationMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuListing.add(vaccinationMenu);
		
		//menu confirm or reject vaccination appointment
		itmConfVaccAppointment = new JMenuItem("Confirm or Reject Vaccination Appointment");
		itmConfVaccAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelViewVaccineBatch.setVisible(false);
				panelRecordNewVaccineBatch.setVisible(false);
				panelConfirmOrRejectAppointment.setVisible(true);
				panelViewVaccinationAdministered.setVisible(false);
				panelListingUser.setVisible(false);
				panelListingVaccinationAppointment.setVisible(false);
			}
		});
		vaccinationMenu.add(itmConfVaccAppointment);
		itmConfVaccAppointment.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		//menu record vaccination administered
		itmVacAdministered = new JMenuItem("Record Vaccination Administered");
		itmVacAdministered.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelViewVaccineBatch.setVisible(false);
				panelRecordNewVaccineBatch.setVisible(false);
				panelConfirmOrRejectAppointment.setVisible(false);
				panelViewVaccinationAdministered.setVisible(true);
				panelListingUser.setVisible(false);
				panelListingVaccinationAppointment.setVisible(false);
			}
		});
		vaccinationMenu.add(itmVacAdministered);
		itmVacAdministered.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		/**
		 * Menu Bar View
		 */
		JMenu viewMenu = new JMenu("View");
		viewMenu.setBounds(186, -21, 43, 24);
		menuListing.add(viewMenu);
		viewMenu.setBackground(new Color(255, 255, 255));
		viewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		//menu view users data
		itmViewUser = new JMenuItem("View Users Data");
		itmViewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelViewVaccineBatch.setVisible(false);
				panelRecordNewVaccineBatch.setVisible(false);
				panelConfirmOrRejectAppointment.setVisible(false);
				panelViewVaccinationAdministered.setVisible(false);
				panelListingUser.setVisible(true);
				panelListingVaccinationAppointment.setVisible(false);
			}
		});
		viewMenu.add(itmViewUser);
		itmViewUser.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		//menu view vaccination appointment
		itmViewVaccAppointment = new JMenuItem("View Vaccination Appointment");
		itmViewVaccAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelViewVaccineBatch.setVisible(false);
				panelRecordNewVaccineBatch.setVisible(false);
				panelConfirmOrRejectAppointment.setVisible(false);
				panelViewVaccinationAdministered.setVisible(false);
				panelListingUser.setVisible(false);
				panelListingVaccinationAppointment.setVisible(true);
			}
		});
		viewMenu.add(itmViewVaccAppointment);
		itmViewVaccAppointment.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		/**
		 * Menu Bar About
		 */
		JMenu aboutMenu = new JMenu("About");
		aboutMenu.setBackground(new Color(255, 255, 255));
		aboutMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuListing.add(aboutMenu);
		
		//menu about PCVS
		itmAboutPCVS = new JMenuItem("About PCVS");
		itmAboutPCVS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutMe me = new aboutMe();
				me.setVisible(true);
			}
		});
		aboutMenu.add(itmAboutPCVS);
		itmAboutPCVS.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		getContentPane().setLayout(null);
		
		//panel health care centre
		JPanel panelHealthCareName = new JPanel();
		panelHealthCareName.setBounds(10, 10, 893, 51);
		getContentPane().add(panelHealthCareName);
		panelHealthCareName.setLayout(null);
		
		//label health care name
		//it will find the health care name based on the user name who has logged in to the system
		String hcName = controller.getHealthCareCentreNameForAdminLogin(username);
		final JLabel healthCareName = new JLabel("New label");
		//display the health care name using setTex
		healthCareName.setText(hcName);
		healthCareName.setForeground(Color.RED);
		healthCareName.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 36));
		healthCareName.setBounds(0, 0, 893, 51);
		panelHealthCareName.add(healthCareName);
		
		//layered pane
		layeredPaneVaccine = new JLayeredPane();
		layeredPaneVaccine.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPaneVaccine.setBounds(10, 71, 1206, 576);
		getContentPane().add(layeredPaneVaccine);
		
		//vaccine ID
		String[]vaccine = {"", "mRNA-1273", "BNT162B2"};
		
		//array of dates, it will be the data in combo box
		String[]datesExpiry = {"","1","2","3","4","5","6","7","8","9","10",
				"11","12","13","14","15","16","17","18","19","20","21","22",
				"23","24","25","26","27","28","29","30","31"};
		
		//array of month, it will be the data in combo box
		String[]monthExpiry = {"","January","February","March","April","May",
				"June","July","August","September","October","November",
				"December"};
		
		//array of year, it will be the data in combo box
		//i assume that the range of the year was started from 2019 until 2025
		String[]yearExpiry = {"","2019","2020","2021","2022","2023","2024","2025"};
		
		//panel view vaccination appointment
		panelListingVaccinationAppointment = new JPanel();
		layeredPaneVaccine.setLayer(panelListingVaccinationAppointment, 3);
		panelListingVaccinationAppointment.setVisible(false);
		
		//panel record vaccination administered
		panelViewVaccinationAdministered = new JPanel();
		layeredPaneVaccine.setLayer(panelViewVaccinationAdministered, 2);
		panelViewVaccinationAdministered.setVisible(false);
		
		//panel view vaccinee batch
		panelViewVaccineBatch = new JPanel();
		layeredPaneVaccine.setLayer(panelViewVaccineBatch, 6);
		panelViewVaccineBatch.setBackground(Color.WHITE);
		panelViewVaccineBatch.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelViewVaccineBatch.setVisible(false);
		
		//panel cinfirm or rejcet vaccination appointment
		panelConfirmOrRejectAppointment = new JPanel();
		layeredPaneVaccine.setLayer(panelConfirmOrRejectAppointment, 1);
		panelConfirmOrRejectAppointment.setBackground(Color.WHITE);
		panelConfirmOrRejectAppointment.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelConfirmOrRejectAppointment.setVisible(false);
		layeredPaneVaccine.setLayout(new CardLayout(0, 0));
		
		//panel homepage admin dashboard
		panelHomePage = new JPanel();
		panelHomePage.setBackground(Color.WHITE);
		panelHomePage.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPaneVaccine.add(panelHomePage, "name_340232002684400");
		panelHomePage.setLayout(null);
		
		//icon pcvs
		logo = new JLabel("");
		logo.setIcon(new ImageIcon(adminDashboard.class.getResource("/img/pcvsIcon.png")));
		logo.setBounds(518, 125, 169, 169);
		panelHomePage.add(logo);
		
		//label title application
		lblNewLabel = new JLabel("PRIVATE COVID-19 VACCINATION SYSTEM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setBounds(301, 319, 603, 41);
		panelHomePage.add(lblNewLabel);
		
		lblProvidedByMinistry = new JLabel("PROVIDED BY: MINISTRY OF HEALTH");
		lblProvidedByMinistry.setHorizontalAlignment(SwingConstants.CENTER);
		lblProvidedByMinistry.setFont(new Font("Arial", Font.PLAIN, 18));
		lblProvidedByMinistry.setBounds(301, 350, 603, 40);
		panelHomePage.add(lblProvidedByMinistry);
		
		lblAuthorIKetut = new JLabel("Developed by: I Ketut Mahendra (E1900340)");
		lblAuthorIKetut.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthorIKetut.setFont(new Font("Arial", Font.PLAIN, 18));
		lblAuthorIKetut.setBounds(301, 400, 603, 40);
		panelHomePage.add(lblAuthorIKetut);
		panelConfirmOrRejectAppointment.setLayout(null);
		layeredPaneVaccine.add(panelConfirmOrRejectAppointment, "name_340232029253800");
		
		//label confirm or reject vaccination appointment
		lblConfirmOrReject = new JLabel("Confirm or Reject Vaccination Appointment");
		lblConfirmOrReject.setForeground(new Color(30, 144, 255));
		lblConfirmOrReject.setFont(new Font("Arial", Font.BOLD, 28));
		lblConfirmOrReject.setBounds(10, 10, 608, 55);
		panelConfirmOrRejectAppointment.add(lblConfirmOrReject);
		
		Object[][]objTableConfirmReject = {};
		String[] titleConfirmTable = {"Vaccination ID","Patient Full Name","IC/Passport","Vaccine Batch","Expiry Date","Manufacturer","Vaccine Name","Status"};
		
		JScrollPane scrollTableConfirmVaccination = new JScrollPane();
		scrollTableConfirmVaccination.setBounds(10, 75, 1182, 382);
		panelConfirmOrRejectAppointment.add(scrollTableConfirmVaccination);
		tableConfirmReject = new JTable(objTableConfirmReject, titleConfirmTable);
		tableConfirmReject.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollTableConfirmVaccination.setViewportView(tableConfirmReject);
		
		lblTitleUpdateStatus = new JLabel("Update Status");
		lblTitleUpdateStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleUpdateStatus.setFont(new Font("Arial", Font.BOLD, 14));
		lblTitleUpdateStatus.setBounds(548, 478, 104, 32);
		panelConfirmOrRejectAppointment.add(lblTitleUpdateStatus);
		
		lblVaccinationID = new JLabel("Vaccination ID");
		lblVaccinationID.setFont(new Font("Arial", Font.PLAIN, 14));
		lblVaccinationID.setBounds(177, 516, 104, 32);
		panelConfirmOrRejectAppointment.add(lblVaccinationID);
		
		vaccinationIdField = new JTextField();
		vaccinationIdField.setBounds(286, 516, 218, 32);
		panelConfirmOrRejectAppointment.add(vaccinationIdField);
		vaccinationIdField.setColumns(10);
		
		JLabel lblSetStatusVaccination = new JLabel("Set Status");
		lblSetStatusVaccination.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSetStatusVaccination.setBounds(514, 516, 74, 32);
		panelConfirmOrRejectAppointment.add(lblSetStatusVaccination);
		
		String[]setStatusVaccination = {"Confirm","Reject"};
		JComboBox comboBoxVaccinationStatus = new JComboBox(setStatusVaccination);
		comboBoxVaccinationStatus.setModel(new DefaultComboBoxModel(new String[] {"", "Confirm", "Reject"}));
		comboBoxVaccinationStatus.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBoxVaccinationStatus.setBounds(598, 516, 218, 32);
		panelConfirmOrRejectAppointment.add(comboBoxVaccinationStatus);
		
		btnUpdateStatusVaccination = new JButton("Update");
		btnUpdateStatusVaccination.setForeground(new Color(255, 255, 255));
		btnUpdateStatusVaccination.setBackground(new Color(50, 205, 50));
		btnUpdateStatusVaccination.setFont(new Font("Arial", Font.BOLD, 14));
		btnUpdateStatusVaccination.setBounds(819, 516, 143, 32);
		panelConfirmOrRejectAppointment.add(btnUpdateStatusVaccination);
		layeredPaneVaccine.add(panelViewVaccineBatch, "name_340232052609700");
		panelViewVaccineBatch.setLayout(null);
		
		lblViewVB = new JLabel("View Vaccine Batch");
		lblViewVB.setBounds(10, 10, 608, 55);
		lblViewVB.setForeground(new Color(30, 144, 255));
		lblViewVB.setFont(new Font("Arial", Font.BOLD, 28));
		panelViewVaccineBatch.add(lblViewVB);
		
		//table data
		Object[][]batchInfo = {};
		
		String[]title = {"Batches","Vaccine Name","Pending Appointment"};
		
		scrollTableViewVB = new JScrollPane();
		scrollTableViewVB.setEnabled(false);
		scrollTableViewVB.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		scrollTableViewVB.setFont(new Font("Arial", Font.BOLD, 14));
		scrollTableViewVB.setBounds(10, 69, 1182, 423);
		panelViewVaccineBatch.add(scrollTableViewVB);
		tableViewVB = new JTable(batchInfo, title);
		scrollTableViewVB.setViewportView(tableViewVB);
		tableViewVB.setRowHeight(30);
		tableViewVB.setFont(new Font("Arial", Font.PLAIN, 14));
		tableViewVB.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton seeDetailVBButton = new JButton("See Detail");
		seeDetailVBButton.setFont(new Font("Arial", Font.PLAIN, 14));
		seeDetailVBButton.setBounds(522, 502, 158, 60);
		panelViewVaccineBatch.add(seeDetailVBButton);
		
		panelRecordNewVaccineBatch = new JPanel();
		layeredPaneVaccine.setLayer(panelRecordNewVaccineBatch, 5);
		panelRecordNewVaccineBatch.setBackground(Color.WHITE);
		panelRecordNewVaccineBatch.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelRecordNewVaccineBatch.setLayout(null);
		layeredPaneVaccine.add(panelRecordNewVaccineBatch, "name_340232072685100");
		
		lblRecordNewVB = new JLabel("Record New Vaccine Batch");
		lblRecordNewVB.setForeground(new Color(30, 144, 255));
		lblRecordNewVB.setFont(new Font("Arial", Font.BOLD, 28));
		lblRecordNewVB.setBounds(10, 10, 608, 55);
		panelRecordNewVaccineBatch.add(lblRecordNewVB);
		
		lblVaccineID = new JLabel("SELECT VACCINE ID");
		lblVaccineID.setFont(new Font("Arial", Font.PLAIN, 14));
		lblVaccineID.setBounds(10, 87, 200, 48);
		panelRecordNewVaccineBatch.add(lblVaccineID);
		
		final JComboBox comboBoxVaccineID = new JComboBox(vaccine);
		comboBoxVaccineID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxVaccineID.getSelectedIndex()==0) {
					manufacturerTextField.setText("");
					vaccineNameTextField.setText("");
				}
				else if(comboBoxVaccineID.getSelectedIndex()==1) {
					manufacturerTextField.setText(controller.getVaccineManufacturer(0));
					vaccineNameTextField.setText(controller.getVaccineName(0));
				}else if(comboBoxVaccineID.getSelectedIndex()==2) {
					manufacturerTextField.setText(controller.getVaccineManufacturer(1));
					vaccineNameTextField.setText(controller.getVaccineName(1));
				}
			}
		});
		comboBoxVaccineID.setBackground(Color.WHITE);
		comboBoxVaccineID.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBoxVaccineID.setBounds(264, 88, 346, 47);
		panelRecordNewVaccineBatch.add(comboBoxVaccineID);
		
		JLabel lblVaccineData = new JLabel("VACCINE DATA");
		lblVaccineData.setFont(new Font("Arial", Font.BOLD, 14));
		lblVaccineData.setBounds(10, 180, 440, 26);
		panelRecordNewVaccineBatch.add(lblVaccineData);
		
		JLabel lblManufacturer = new JLabel("MANUFACTURER");
		lblManufacturer.setFont(new Font("Arial", Font.PLAIN, 14));
		lblManufacturer.setBounds(10, 216, 244, 47);
		panelRecordNewVaccineBatch.add(lblManufacturer);
		
		manufacturerTextField = new JTextField();
		manufacturerTextField.setEditable(false);
		manufacturerTextField.setBackground(Color.WHITE);
		manufacturerTextField.setFont(new Font("Arial", Font.PLAIN, 14));
		manufacturerTextField.setBounds(264, 216, 932, 47);
		panelRecordNewVaccineBatch.add(manufacturerTextField);
		manufacturerTextField.setColumns(10);
		
		//panel view vaccination administered
		panelViewVaccinationAdministered.setBackground(Color.WHITE);
		panelViewVaccinationAdministered.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPaneVaccine.add(panelViewVaccinationAdministered, "name_340232089176700");
		panelViewVaccinationAdministered.setLayout(null);
		
		//Vaccine name label
		JLabel lblVaccineName = new JLabel("VACCINE NAME");
		lblVaccineName.setFont(new Font("Arial", Font.PLAIN, 14));
		lblVaccineName.setBounds(10, 282, 244, 47);
		panelRecordNewVaccineBatch.add(lblVaccineName);
		
		//Vaccine name text field
		vaccineNameTextField = new JTextField();
		vaccineNameTextField.setEditable(false);
		vaccineNameTextField.setBackground(Color.WHITE);
		vaccineNameTextField.setFont(new Font("Arial", Font.PLAIN, 14));
		vaccineNameTextField.setColumns(10);
		vaccineNameTextField.setBounds(264, 282, 932, 47);
		panelRecordNewVaccineBatch.add(vaccineNameTextField);
		
		//Batch number label
		lblBatchNumber = new JLabel("BATCH NUMBER");
		lblBatchNumber.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBatchNumber.setBounds(10, 347, 244, 47);
		panelRecordNewVaccineBatch.add(lblBatchNumber);
		
		//Batch number text field
		batchNumTextField = new JTextField();
		batchNumTextField.setBackground(Color.WHITE);
		batchNumTextField.setFont(new Font("Arial", Font.PLAIN, 14));
		batchNumTextField.setColumns(10);
		batchNumTextField.setBounds(264, 347, 932, 47);
		panelRecordNewVaccineBatch.add(batchNumTextField);
		
		//Label quantity of dose available
		lblQuantityDose = new JLabel("QUANTITY DOSE AVAILABLE");
		lblQuantityDose.setFont(new Font("Arial", Font.PLAIN, 14));
		lblQuantityDose.setBounds(10, 483, 244, 47);
		panelRecordNewVaccineBatch.add(lblQuantityDose);
		
		//text field quantity of dose
		quantityOfDoseTextField = new JTextField();
		quantityOfDoseTextField.setBackground(Color.WHITE);
		quantityOfDoseTextField.setFont(new Font("Arial", Font.PLAIN, 14));
		quantityOfDoseTextField.setColumns(10);
		quantityOfDoseTextField.setBounds(264, 483, 932, 47);
		panelRecordNewVaccineBatch.add(quantityOfDoseTextField);
		
		//combobox expiry date
		final JComboBox comboBoxDateExpiry = new JComboBox(datesExpiry);
		comboBoxDateExpiry.setBackground(Color.WHITE);
		comboBoxDateExpiry.setBounds(264, 415, 228, 48);
		panelRecordNewVaccineBatch.add(comboBoxDateExpiry);
		
		//Label expiry date
		lblExpiryDateExpiry = new JLabel("EXPIRY DATE");
		lblExpiryDateExpiry.setFont(new Font("Arial", Font.PLAIN, 14));
		lblExpiryDateExpiry.setBounds(10, 416, 244, 47);
		panelRecordNewVaccineBatch.add(lblExpiryDateExpiry);
		
		//Label expiry month
		JLabel lblExpiryMonthExpiry = new JLabel("EXPIRY MONTH");
		lblExpiryMonthExpiry.setFont(new Font("Arial", Font.PLAIN, 14));
		lblExpiryMonthExpiry.setBounds(502, 417, 109, 47);
		panelRecordNewVaccineBatch.add(lblExpiryMonthExpiry);
		
		//combobox expiry month
		final JComboBox comboBoxMonthExpiry = new JComboBox(monthExpiry);
		comboBoxMonthExpiry.setBackground(Color.WHITE);
		comboBoxMonthExpiry.setBounds(620, 416, 228, 48);
		panelRecordNewVaccineBatch.add(comboBoxMonthExpiry);
		
		//Label expiry year
		JLabel lblExpiryYearExpiry = new JLabel("EXPIRY YEAR");
		lblExpiryYearExpiry.setFont(new Font("Arial", Font.PLAIN, 14));
		lblExpiryYearExpiry.setBounds(861, 416, 94, 47);
		
		//combobox expiry year
		final JComboBox comboBoxYearExpiry = new JComboBox(yearExpiry);
		comboBoxYearExpiry.setBackground(Color.WHITE);
		comboBoxYearExpiry.setBounds(968, 416, 228, 48);
		panelRecordNewVaccineBatch.add(comboBoxYearExpiry);
		panelRecordNewVaccineBatch.add(lblExpiryYearExpiry);
		
		//Save data JButton
		JButton btnNewButton = new JButton("SAVE DATA");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//parsing the text in batch number text field
				String batchNum = batchNumTextField.getText().toString();
				int batch = Integer.parseInt(batchNum);
				
				//make a data format of vaccine expiry date
				String expiry = (String) comboBoxDateExpiry.getSelectedItem()+"/"+comboBoxMonthExpiry.getSelectedIndex()+"/"+comboBoxYearExpiry.getSelectedItem();
				
				//parsing the text in vaccine quantity text field
				String availableQty = quantityOfDoseTextField.getText().toString();
				int availableQuantity = Integer.parseInt(availableQty);
				
				//make a vaccine batch object
				batch vaccineBatch = new batch(batch, expiry, availableQuantity, 0);
				
				//record the vaccine batch to the arraylist in class health care centre
				healthCareCentre centre = controller.getHealthCareCentreBasedOnName(healthCareName.getText());
				centre.setBatchesVaccine(vaccineBatch);
				
				//record the vaccine batch to the arraylist in class vaccine
				String vacID = comboBoxVaccineID.getSelectedItem().toString();
				vaccine batchVac = controller.getVaccineById(vacID);
				batchVac.setVaccineBatch(vaccineBatch);
				
				//displaying a message dialog due to the successful of the process  
				JOptionPane.showMessageDialog(getParent(), "Your vaccine batch is succesfully registered ");
				
				//Set the text field to blank if the data has been successfully recorded to arraylist
				batchNumTextField.setText("");
				comboBoxVaccineID.setSelectedItem("");
				comboBoxDateExpiry.setSelectedItem("");
				comboBoxMonthExpiry.setSelectedItem("");
				comboBoxYearExpiry.setSelectedItem("");
				quantityOfDoseTextField.setText("");
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(154, 205, 50));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(620, 87, 283, 48);
		panelRecordNewVaccineBatch.add(btnNewButton);
		
		//DELETE DATA JBUTTON
		btnDeleteData = new JButton("DELETE DATA");
		btnDeleteData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//set the text field to empty if this jbutton is clicked
				batchNumTextField.setText("");
				comboBoxVaccineID.setSelectedItem("");
				comboBoxDateExpiry.setSelectedItem("");
				comboBoxMonthExpiry.setSelectedItem("");
				comboBoxYearExpiry.setSelectedItem("");
				quantityOfDoseTextField.setText("");
				
			}
		});
		btnDeleteData.setForeground(new Color(255, 255, 255));
		btnDeleteData.setFont(new Font("Arial", Font.BOLD, 16));
		btnDeleteData.setBackground(new Color(255, 0, 0));
		btnDeleteData.setBounds(913, 87, 283, 48);
		panelRecordNewVaccineBatch.add(btnDeleteData);
		
		//Label view vaccination administered
		lblVaccinationAdministered = new JLabel("Record Vaccination Administered");
		lblVaccinationAdministered.setForeground(new Color(30, 144, 255));
		lblVaccinationAdministered.setFont(new Font("Arial", Font.BOLD, 28));
		lblVaccinationAdministered.setBounds(10, 10, 608, 55);
		panelViewVaccinationAdministered.add(lblVaccinationAdministered);
		
		JScrollPane scrollPaneTableVaccineAdministered = new JScrollPane();
		scrollPaneTableVaccineAdministered.setBounds(10, 74, 1182, 387);
		panelViewVaccinationAdministered.add(scrollPaneTableVaccineAdministered);
		
		Object[][]objectAdministered= {};
		String[]titleAdministered= {"Vaccination ID", "Patient Full Name", "IC/Passport", "Vaccine Batch", "Expiry Date", "Manufacturer", "Vaccine Name", "Status"};
		tableVaccinationAdministered = new JTable(objectAdministered, titleAdministered);
		scrollPaneTableVaccineAdministered.setViewportView(tableVaccinationAdministered);
		
		JLabel lblUpdateStatusAdministered = new JLabel("Update Status");
		lblUpdateStatusAdministered.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateStatusAdministered.setFont(new Font("Arial", Font.BOLD, 14));
		lblUpdateStatusAdministered.setBounds(540, 471, 121, 31);
		panelViewVaccinationAdministered.add(lblUpdateStatusAdministered);
		
		JLabel lblVaccinationId = new JLabel("Vaccination ID");
		lblVaccinationId.setFont(new Font("Arial", Font.PLAIN, 14));
		lblVaccinationId.setBounds(382, 502, 121, 43);
		panelViewVaccinationAdministered.add(lblVaccinationId);
		
		textFieldVaccIDAdministered = new JTextField();
		textFieldVaccIDAdministered.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldVaccIDAdministered.setBounds(504, 502, 194, 43);
		panelViewVaccinationAdministered.add(textFieldVaccIDAdministered);
		textFieldVaccIDAdministered.setColumns(10);
		
		JButton btnSetAdministered = new JButton("Administered");
		btnSetAdministered.setForeground(new Color(255, 255, 255));
		btnSetAdministered.setBackground(new Color(50, 205, 50));
		btnSetAdministered.setFont(new Font("Arial", Font.BOLD, 14));
		btnSetAdministered.setBounds(707, 502, 163, 43);
		panelViewVaccinationAdministered.add(btnSetAdministered);
		panelListingVaccinationAppointment.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelListingVaccinationAppointment.setBackground(Color.WHITE);
		layeredPaneVaccine.add(panelListingVaccinationAppointment, "name_340232109726500");
		panelListingVaccinationAppointment.setLayout(null);
		
		//Label vaccination appointment
		lblVaccinationAppointmentData = new JLabel("Vaccination Appointment Data");
		lblVaccinationAppointmentData.setForeground(new Color(30, 144, 255));
		lblVaccinationAppointmentData.setFont(new Font("Arial", Font.BOLD, 28));
		lblVaccinationAppointmentData.setBounds(10, 10, 608, 55);
		panelListingVaccinationAppointment.add(lblVaccinationAppointmentData);
		
		Object[][]objectVaccinationAppointment = {};
		String[]titleAppointmentView = {"Vaccination ID", "Patient Name","Vaccine ID","Vaccine Name","Vaccine Batch","Status"};
		
		scrollPaneVaccinationAppointmentData = new JScrollPane();
		scrollPaneVaccinationAppointmentData.setBounds(10, 64, 1182, 498);
		panelListingVaccinationAppointment.add(scrollPaneVaccinationAppointmentData);
		tableVaccinationAppointmentData = new JTable(objectVaccinationAppointment, titleAppointmentView);
		scrollPaneVaccinationAppointmentData.setViewportView(tableVaccinationAppointmentData);
		
	
		//Panel listing user
		panelListingUser = new JPanel();
		layeredPaneVaccine.setLayer(panelListingUser, 4);
		panelListingUser.setVisible(false);
		panelListingUser.setBackground(Color.WHITE);
		panelListingUser.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPaneVaccine.add(panelListingUser, "name_340232131084700");
		panelListingUser.setLayout(null);
		
		//Label user data
		lblUserData = new JLabel("User Data");
		lblUserData.setForeground(new Color(30, 144, 255));
		lblUserData.setFont(new Font("Arial", Font.BOLD, 28));
		lblUserData.setBounds(10, 10, 608, 55);
		panelListingUser.add(lblUserData);
		
		//combobox type of sorting data user
		String[]listSort = {"","Patient","Administrator"};
		comboBoxListSort = new JComboBox(listSort);
		comboBoxListSort.setBounds(943, 23, 156, 31);
		panelListingUser.add(comboBoxListSort);
		
		lblSort = new JLabel("Sort By");
		lblSort.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSort.setBounds(893, 23, 47, 31);
		panelListingUser.add(lblSort);
		
		btnSort = new JButton("Sort");
		btnSort.setForeground(new Color(255, 255, 255));
		btnSort.setBackground(new Color(50, 205, 50));
		btnSort.setFont(new Font("Arial", Font.BOLD, 14));
		btnSort.setBounds(1109, 23, 83, 31);
		panelListingUser.add(btnSort);
		
		scrollPaneUserData = new JScrollPane();
		scrollPaneUserData.setBounds(10, 75, 1182, 487);
		panelListingUser.add(scrollPaneUserData);
		
		Object[][]objUserData = {};
		String[]titleUserData = {"Admin ID or IC/Passport","Name","E-Mail","Health Care"};
		tableUserData = new JTable(objUserData, titleUserData);
		tableUserData.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Admin ID or IC/Passport", "Name", "E-Mail", "Health Care"
			}
		));
		scrollPaneUserData.setViewportView(tableUserData);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
