/**
 * This is the main class of Private Covid-19 Vaccination System using Graphical User Interface(GUI)
 */

/**
 * @author I Ketut Mahendra
 * Student ID: E1900340
 * IDE: Eclipse IDE for Java Developers (includes Incubating components)
 * Version: 2021-12 (4.22.0)
 * Java runtime version: 16.0.1+9-24
 * Java version: 16.0.1
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PCVSGUI extends JFrame implements ActionListener{
	//create PCVS Object
	private PCVS controller;
	JFrame frmLogin;
	private JPanel loginPanel;
	private JTextField usernameTextField;
	private JPasswordField passwordField;
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		PCVS controller = new PCVS();
		JFrame pcvsGUI = new PCVSGUI(controller);
		pcvsGUI.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public PCVSGUI(PCVS pcvs) 
	{
		//initialize PCVS Object
		controller = pcvs;
		
		setUndecorated(true);
		setTitle("PRIVATE COV-19 VACCINATION SYSTEM");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PCVSGUI.class.getResource("/img/pcvsIcon.png")));
		setResizable(false);
		setBounds(200, 150, 1053, 532);
		loginPanel = new JPanel();
		loginPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(loginPanel);
		loginPanel.setLayout(null);
		
		JLabel welcomeToLbl = new JLabel("Welcome to");
		welcomeToLbl.setFont(new Font("Montserrat", Font.BOLD, 48));
		welcomeToLbl.setForeground(SystemColor.text);
		welcomeToLbl.setHorizontalAlignment(SwingConstants.LEFT);
		welcomeToLbl.setBounds(222, 193, 362, 68);
		loginPanel.add(welcomeToLbl);
		
		JLabel privateC19Lbl = new JLabel("Private COVID-19");
		privateC19Lbl.setHorizontalAlignment(SwingConstants.LEFT);
		privateC19Lbl.setForeground(Color.WHITE);
		privateC19Lbl.setFont(new Font("Montserrat", Font.PLAIN, 36));
		privateC19Lbl.setBounds(222, 250, 362, 50);
		loginPanel.add(privateC19Lbl);
		
		JLabel VaccinationSystemLbl = new JLabel("Vaccination System");
		VaccinationSystemLbl.setHorizontalAlignment(SwingConstants.LEFT);
		VaccinationSystemLbl.setForeground(Color.WHITE);
		VaccinationSystemLbl.setFont(new Font("Montserrat", Font.PLAIN, 24));
		VaccinationSystemLbl.setBounds(222, 289, 362, 50);
		loginPanel.add(VaccinationSystemLbl);
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon(PCVSGUI.class.getResource("/img/pcvsIcon.png")));
		logo.setBounds(37, 193, 169, 169);
		loginPanel.add(logo);
		
		JLabel loginLbl = new JLabel("Login.");
		loginLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		loginLbl.setFont(new Font("Montserrat", Font.BOLD, 38));
		loginLbl.setBounds(631, 53, 376, 54);
		loginPanel.add(loginLbl);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Montserrat", Font.PLAIN, 14));
		usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameLabel.setBounds(701, 117, 306, 33);
		loginPanel.add(usernameLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameTextField.setFont(new Font("Montserrat", Font.PLAIN, 18));
		usernameTextField.setBounds(631, 147, 376, 41);
		loginPanel.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setFont(new Font("Montserrat", Font.PLAIN, 14));
		passwordLabel.setBounds(701, 198, 306, 33);
		loginPanel.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordField.setFont(new Font("Montserrat", Font.PLAIN, 18));
		passwordField.setBounds(631, 224, 376, 41);
		loginPanel.add(passwordField);
		
		final JLabel lblUsernameNotFound = new JLabel("Username not found");
		lblUsernameNotFound.setVisible(false);
		lblUsernameNotFound.setForeground(Color.RED);
		lblUsernameNotFound.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsernameNotFound.setFont(new Font("Montserrat", Font.PLAIN, 14));
		lblUsernameNotFound.setBounds(631, 117, 306, 33);
		loginPanel.add(lblUsernameNotFound);
		
		final JLabel lblPasswordNotFound = new JLabel("Password not found");
		lblPasswordNotFound.setVisible(false);
		lblPasswordNotFound.setHorizontalAlignment(SwingConstants.LEFT);
		lblPasswordNotFound.setForeground(Color.RED);
		lblPasswordNotFound.setFont(new Font("Montserrat", Font.PLAIN, 14));
		lblPasswordNotFound.setBounds(631, 198, 306, 33);
		loginPanel.add(lblPasswordNotFound);
		
	/**
	 * login as administrator trying
	 */
		JButton loginAdminBtn = new JButton("Login as Admin");
		loginAdminBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if ((controller.loginCheckAdmin(usernameTextField.getText(), passwordField.getText()))) {
					adminDashboard adminPage = new adminDashboard(controller, usernameTextField.getText());
					adminPage.setVisible(true);
					dispose();
				}
				else if(usernameTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(usernameTextField, "Username is Blank");
				}
				else if(passwordField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(passwordField, "Password is Blank");
				}
				else {
					lblUsernameNotFound.setVisible(true);
					lblPasswordNotFound.setVisible(true);
				}
			}
		});
		loginAdminBtn.setFont(new Font("Montserrat", Font.PLAIN, 16));
		loginAdminBtn.setBackground(new Color(100, 149, 237));
		loginAdminBtn.setForeground(new Color(230, 230, 250));
		loginAdminBtn.setBounds(631, 291, 185, 53);
		loginPanel.add(loginAdminBtn);
		
		JButton loginPatientBtn = new JButton("Login as Patient");
		loginPatientBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 //if the text in user name text field and password 
				 //in the password field is founded in arraylist, 
				 //the method from object PCVS that called below 
				 //will return true 
				if(controller.loginCheckPatient(usernameTextField.getText(), passwordField.getText())) {
					patientDashboard patient = new patientDashboard(controller, usernameTextField.getText());
					patient.setVisible(true);
					dispose();
				}
				//if the user name field is empty, 
				//it will displaying a message dialog
				else if(usernameTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(usernameTextField, "Username is Blank");
					lblUsernameNotFound.setVisible(false);
					lblPasswordNotFound.setVisible(false);
				}
				//if the password field is empty
				//it will displaying a message dialog
				else if(passwordField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(passwordField, "Password is Blank");
					lblUsernameNotFound.setVisible(false);
					lblPasswordNotFound.setVisible(false);
				}
				//if the data isn't found a label will appear
				else {
					lblUsernameNotFound.setVisible(true);
					lblPasswordNotFound.setVisible(true);
				}
			}
		});
		loginPatientBtn.setForeground(new Color(230, 230, 250));
		loginPatientBtn.setFont(new Font("Montserrat", Font.PLAIN, 16));
		loginPatientBtn.setBackground(new Color(30, 144, 255));
		loginPatientBtn.setBounds(814, 291, 193, 53);
		loginPanel.add(loginPatientBtn);
		
		JLabel registerLabel = new JLabel("New here?");
		registerLabel.setBackground(new Color(30, 144, 255));
		registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registerLabel.setForeground(new Color(30, 144, 255));
		registerLabel.setFont(new Font("Montserrat", Font.PLAIN, 18));
		registerLabel.setBounds(631, 376, 185, 33);
		loginPanel.add(registerLabel);
		
	/**
	 * registering trying
	 */
		JButton registerBtn = new JButton("Create Account");
		registerBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				signUp reg = new signUp(controller);
				reg.setVisible(true);
				dispose();
			}
		});
		registerBtn.setForeground(new Color(230, 230, 250));
		registerBtn.setFont(new Font("Montserrat", Font.PLAIN, 16));
		registerBtn.setBackground(new Color(32, 178, 170));
		registerBtn.setBounds(631, 410, 185, 53);
		loginPanel.add(registerBtn);
		panel.setBounds(0, 0, 552, 547);
		loginPanel.add(panel);
		panel.setLayout(null);
		
		JLabel devInfoLabel = new JLabel("Developed by:\r\nI Ketut Mahendra "
				+ "(E1900340) \r\nfor BIT205-Advance OOP\r\n "
				+ "Semester September 2021");
		devInfoLabel.setBounds(10, 484, 457, 33);
		panel.add(devInfoLabel);
		devInfoLabel.setForeground(new Color(255, 255, 255));
		devInfoLabel.setFont(new Font("Montserrat", Font.PLAIN, 9));
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(PCVSGUI.class.getResource("/img/signInBg.png")));
		Background.setBounds(0, 0, 552, 534);
		panel.add(Background);
		
		/**
		 * action listener to close the panel
		 */
		JLabel Close = new JLabel("\u2022");
		Close.setVerticalTextPosition(SwingConstants.TOP);
		Close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int closing = JOptionPane.showConfirmDialog(getParent(), 
						"Are you sure to exit this program?",
						"Program Close",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.CLOSED_OPTION);
				if(closing==JOptionPane.YES_OPTION) {
					System.exit(0);
				}
				
			}
		});
		Close.setFont(new Font("Montserrat", Font.BOLD, 72));
		Close.setForeground(Color.RED);
		Close.setHorizontalAlignment(SwingConstants.RIGHT);
		Close.setBounds(1017, 0, 26, 43);
		loginPanel.add(Close);
		
	/**
	 * Action Listener to minimize the panel
	 */
		JLabel Minimize = new JLabel("\u2022");
		Minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		Minimize.setVerticalTextPosition(SwingConstants.TOP);
		Minimize.setHorizontalAlignment(SwingConstants.RIGHT);
		Minimize.setForeground(Color.ORANGE);
		Minimize.setFont(new Font("Montserrat", Font.BOLD, 72));
		Minimize.setBounds(981, 0, 26, 43);
		loginPanel.add(Minimize);
		
		JLabel lblHaveAData = new JLabel("Have a Data?");
		lblHaveAData.setHorizontalAlignment(SwingConstants.CENTER);
		lblHaveAData.setForeground(new Color(30, 144, 255));
		lblHaveAData.setFont(new Font("Montserrat", Font.PLAIN, 18));
		lblHaveAData.setBackground(new Color(30, 144, 255));
		lblHaveAData.setBounds(814, 376, 193, 33);
		loginPanel.add(lblHaveAData);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.setForeground(new Color(230, 230, 250));
		btnLoadData.setFont(new Font("Montserrat", Font.PLAIN, 16));
		btnLoadData.setBackground(new Color(50, 205, 50));
		btnLoadData.setBounds(814, 410, 193, 53);
		loginPanel.add(btnLoadData);
		
		
	}

	public String getUsernameLogin() {
		return usernameTextField.getText();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
