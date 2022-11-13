import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JRadioButton;

//public class signUp extends JFrame {
public class signUp extends JFrame {
	private PCVS controller;
	private JPanel signUpPanel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField verifyPasswordField;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField icPassFields;
	private JLabel lblUsernameHasBeen;
	private JLabel passwordErrorLbl;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					signUp frame = new signUp();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @param pcvs 
	 */
	public signUp(PCVS pcvs) {
		//initialize controller object
		controller = pcvs;
		
		setTitle("Sign Up Form");
		setIconImage(Toolkit.getDefaultToolkit().getImage(signUp.class.getResource("/img/pcvsIcon.png")));
		setUndecorated(true);
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1117, 562);
		signUpPanel = new JPanel();
		signUpPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(signUpPanel);
		signUpPanel.setLayout(null);
		
		JPanel panelBackground = new JPanel();
		panelBackground.setBounds(0, 0, 488, 562);
		signUpPanel.add(panelBackground);
		panelBackground.setLayout(null);
		
		JLabel SignUp = new JLabel("SignUp.");
		SignUp.setForeground(new Color(255, 255, 255));
		SignUp.setFont(new Font("Montserrat", Font.BOLD, 72));
		SignUp.setBounds(50, 258, 381, 160);
		panelBackground.add(SignUp);
		
		JLabel pcvsIcon = new JLabel("");
		pcvsIcon.setIcon(new ImageIcon(signUp.class.getResource("/img/pcvsIcon.png")));
		pcvsIcon.setBounds(21, 147, 169, 169);
		panelBackground.add(pcvsIcon);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(signUp.class.getResource("/img/signInBg.png")));
		background.setBounds(0, 0, 488, 562);
		panelBackground.add(background);
		
		JLabel Close = new JLabel("\u2022");
	/**
	 * exit button
	 */
		Close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int closing = JOptionPane.showConfirmDialog(getParent(), 
						"Are you sure to exit this process?",
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
		Close.setVerticalTextPosition(SwingConstants.TOP);
		Close.setHorizontalAlignment(SwingConstants.RIGHT);
		Close.setForeground(Color.RED);
		Close.setFont(new Font("Montserrat", Font.BOLD, 72));
		Close.setBounds(1081, 0, 26, 43);
		signUpPanel.add(Close);
		
		
	/**
	 * minimize
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
		Minimize.setBounds(1045, 0, 26, 43);
		signUpPanel.add(Minimize);
		
		JLabel usernameLbl = new JLabel("Username");
		usernameLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameLbl.setFont(new Font("Montserrat", Font.PLAIN, 14));
		usernameLbl.setBounds(630, 82, 218, 13);
		signUpPanel.add(usernameLbl);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Montserrat", Font.PLAIN, 18));
		usernameField.setBounds(520, 98, 328, 48);
		signUpPanel.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel rolesLbl = new JLabel("Roles");
		rolesLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		rolesLbl.setFont(new Font("Montserrat", Font.PLAIN, 14));
		rolesLbl.setBounds(858, 80, 218, 13);
		signUpPanel.add(rolesLbl);
		
		String[] roles = {"Administrator", "Patient"};
		final JComboBox comboBoxRoles = new JComboBox(roles);
		comboBoxRoles.setFont(new Font("Montserrat", Font.PLAIN, 18));
		comboBoxRoles.setBounds(858, 98, 219, 48);
		signUpPanel.add(comboBoxRoles);
		
		JLabel passwordLbl = new JLabel("Password");
		passwordLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLbl.setFont(new Font("Montserrat", Font.PLAIN, 14));
		passwordLbl.setBounds(630, 172, 163, 13);
		signUpPanel.add(passwordLbl);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Montserrat", Font.PLAIN, 18));
		passwordField.setBounds(520, 190, 273, 46);
		signUpPanel.add(passwordField);
		
		JLabel verifyPassLbl = new JLabel("Verify your Password");
		verifyPassLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		verifyPassLbl.setFont(new Font("Montserrat", Font.PLAIN, 14));
		verifyPassLbl.setBounds(913, 172, 163, 13);
		signUpPanel.add(verifyPassLbl);
		
		verifyPasswordField = new JPasswordField();
		verifyPasswordField.setFont(new Font("Montserrat", Font.PLAIN, 18));
		verifyPasswordField.setBounds(804, 190, 273, 46);
		signUpPanel.add(verifyPasswordField);
		
		JLabel nameLbl = new JLabel("Name");
		nameLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLbl.setFont(new Font("Montserrat", Font.PLAIN, 14));
		nameLbl.setBounds(630, 266, 159, 13);
		signUpPanel.add(nameLbl);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Montserrat", Font.PLAIN, 18));
		nameField.setColumns(10);
		nameField.setBounds(520, 282, 269, 48);
		signUpPanel.add(nameField);
		
		JLabel emailLabel = new JLabel("E-Mail");
		emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		emailLabel.setFont(new Font("Montserrat", Font.PLAIN, 14));
		emailLabel.setBounds(913, 266, 163, 13);
		signUpPanel.add(emailLabel);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Montserrat", Font.PLAIN, 18));
		emailField.setColumns(10);
		emailField.setBounds(803, 282, 273, 48);
		signUpPanel.add(emailField);
		
		final JLabel ICPassLbl = new JLabel("IC/Passport Number");
		ICPassLbl.setVisible(false);
		ICPassLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		ICPassLbl.setFont(new Font("Montserrat", Font.PLAIN, 14));
		ICPassLbl.setBounds(914, 366, 163, 13);
		signUpPanel.add(ICPassLbl);
		
		icPassFields = new JTextField();
		icPassFields.setVisible(false);
		icPassFields.setFont(new Font("Montserrat", Font.PLAIN, 18));
		icPassFields.setColumns(10);
		icPassFields.setBounds(520, 382, 557, 48);
		signUpPanel.add(icPassFields);
		
		comboBoxRoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxRoles.getSelectedItem().toString() == "Administrator") {
					icPassFields.setVisible(false);
					ICPassLbl.setVisible(false);
				}else if(comboBoxRoles.getSelectedItem().toString() == "Patient") {
					icPassFields.setVisible(true);
					ICPassLbl.setVisible(true);
				}
			}
		});
		
		final JLabel healthCareLbl = new JLabel("Health Care");
		healthCareLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		healthCareLbl.setFont(new Font("Montserrat", Font.PLAIN, 14));
		healthCareLbl.setBounds(914, 367, 163, 13);
		signUpPanel.add(healthCareLbl);
		
		
		String[] healthCare = {"FMC General Hospital, Address: Jalan Arjuna 18, Gianyar, Bali", "SMCDenpasar, Address: Jalan P.B. Sudirman, Denpasar, Bali"};
		final JComboBox comboBoxHealthCare = new JComboBox(healthCare);
		comboBoxHealthCare.setFont(new Font("Montserrat", Font.PLAIN, 18));
		comboBoxHealthCare.setBounds(520, 382, 557, 48);
		signUpPanel.add(comboBoxHealthCare);
		
		comboBoxRoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//  
				if(comboBoxRoles.getSelectedItem().toString()=="Administrator") {
					comboBoxHealthCare.setVisible(true);
					healthCareLbl.setVisible(true);
				}else if(comboBoxRoles.getSelectedItem().toString()=="Patient") {
					comboBoxHealthCare.setVisible(false);
					healthCareLbl.setVisible(false);
				}
			}
		});


		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usernameInput = usernameField.getText();
				String passwordInput = passwordField.getText();
				String emailInput = emailField.getText();
				String fullNameInput = nameField.getText();
				String ICPASSInput = icPassFields.getText();
				String staffID = controller.generateID(comboBoxHealthCare.getSelectedIndex()+1);
				if(controller.inspectSignInAdmin(usernameInput)) {
					JOptionPane.showMessageDialog(passwordField, "Your Username has been taken before");
					usernameField.setText("");
				}
				else if (usernameField.getText().isEmpty()||passwordField.getText().isEmpty()||emailField.getText().isEmpty()||nameField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(passwordField, "please fill the blank field");
				}
				else if (!(passwordField.getText().equals(verifyPasswordField.getText()))) {
					JOptionPane.showMessageDialog(passwordField, "Password did not match, try again");
					passwordField.setText("");
					verifyPasswordField.setText("");
				}
				else if((comboBoxRoles.getSelectedItem().toString()=="Administrator")) {
					administrator newAdmin = new administrator(usernameInput, passwordInput, emailInput, fullNameInput, staffID);
					controller.setAdminData(newAdmin);
					healthCareCentre centre = controller.getHealthcareCentre(comboBoxHealthCare.getSelectedIndex());
					centre.setAdminHealthCare(newAdmin);
					JOptionPane.showMessageDialog(passwordField, "You are succesfully registered with: "+
							"\nUsername: "+usernameInput+"\nName: "+fullNameInput+"\nHealth Care Centre: "+ 
									comboBoxHealthCare.getSelectedItem()+"\n\nYour Staff ID: "+staffID);
					PCVSGUI gui = new PCVSGUI(controller);
					gui.setVisible(true);
					dispose();
				}
				else if(comboBoxRoles.getSelectedItem().toString()=="Patient") {
					patient newPatient = new patient(usernameInput, passwordInput, emailInput, fullNameInput, ICPASSInput);
					PCVSGUI gui = new PCVSGUI(controller);
					JOptionPane.showMessageDialog(passwordField, "You are succesfully registered with: "+
					"\nUsername: "+usernameInput+"\nName: "+fullNameInput+"\nIC/Passport: "+ICPASSInput);
					controller.setPatientsData(newPatient);
					gui.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(passwordField, "all data is Blank");
				}
			}
		});
		registerButton.setForeground(new Color(255, 255, 255));
		registerButton.setBackground(new Color(154, 205, 50));
		registerButton.setFont(new Font("Montserrat", Font.PLAIN, 18));
		registerButton.setBounds(520, 480, 273, 48);
		signUpPanel.add(registerButton);
		
		JButton btnClearData = new JButton("Clear Data");
		btnClearData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usernameField.setText("");
				passwordField.setText("");
				verifyPasswordField.setText("");
				emailField.setText("");
				nameField.setText("");
				if(comboBoxRoles.getSelectedItem().toString()=="Patient")
					icPassFields.setText("");
			}
		});
		btnClearData.setForeground(new Color(255, 255, 255));
		btnClearData.setFont(new Font("Montserrat", Font.PLAIN, 18));
		btnClearData.setBackground(new Color(255, 0, 0));
		btnClearData.setBounds(804, 480, 273, 48);
		signUpPanel.add(btnClearData);
	}
}
