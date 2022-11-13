import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.CompoundBorder;
import javax.swing.JToggleButton;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;

public class patientDashboard extends JFrame {
	private PCVS controller;
	private JPanel contentPane;
	private JPanel panelMain;
	private JPanel panelRequestVaccinationAppointment;
	private JPanel panelViewSA;
	private JComboBox comboBoxAvailableVaccine;
	private JComboBox comboBoxHealthcare;
	private JComboBox comboBoxAvailableVaccineBatch;
	private JTable tableVaccinationAppointment;
	

	/**
	 * Create the frame.
	 */
	public patientDashboard(PCVS pcvs, final String username) {
		controller = pcvs;
		setResizable(false);
		setLocationByPlatform(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int closing = JOptionPane.showConfirmDialog(getParent(), 
						"Logout from this program?",
						"Logoute",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.CLOSED_OPTION);
				if(closing==JOptionPane.YES_OPTION) {
					PCVSGUI loginBack = new PCVSGUI(controller);
					loginBack.setVisible(true);
					dispose();
				}
			}
		});
		
		setTitle("PCVS - Patient");
		setIconImage(Toolkit.getDefaultToolkit().getImage(patientDashboard.class.getResource("/img/pcvsIcon.png")));
		setBounds(100, 50, 1240, 625);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPane.setBounds(10, 10, 1206, 407);
		contentPane.add(layeredPane);
		
		final JPanel panelRequestVaccinationAppointment_1 = new JPanel();
		panelRequestVaccinationAppointment_1.setVisible(false);
		
		final JPanel panelViewVaccinationAppointment = new JPanel();
		panelViewVaccinationAppointment.setVisible(false);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		final JPanel panelMain_1 = new JPanel();
		panelMain_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPane.add(panelMain_1, "name_397551532585500");
		panelMain_1.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(patientDashboard.class.getResource("/img/pcvsIcon.png")));
		logo.setBounds(519, 22, 169, 147);
		panelMain_1.add(logo);
		
		JLabel lblTitlePC = new JLabel("PRIVATE COVID-19");
		lblTitlePC.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitlePC.setFont(new Font("Arial", Font.BOLD, 48));
		lblTitlePC.setBounds(299, 179, 609, 63);
		panelMain_1.add(lblTitlePC);
		
		JLabel lblTitleVS = new JLabel("VACCINATION SYSTEM");
		lblTitleVS.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleVS.setFont(new Font("Arial", Font.PLAIN, 24));
		lblTitleVS.setBounds(299, 240, 609, 36);
		panelMain_1.add(lblTitleVS);
		
		JLabel lblHi = new JLabel("Hi,");
		lblHi.setHorizontalAlignment(SwingConstants.CENTER);
		lblHi.setForeground(Color.DARK_GRAY);
		lblHi.setFont(new Font("Arial", Font.BOLD, 20));
		lblHi.setBounds(299, 298, 609, 36);
		panelMain_1.add(lblHi);
		
		String user = controller.getFullNamePatientForLogin(username);
		JLabel lblNameUser = new JLabel("User");
		lblNameUser.setText(user);
		lblNameUser.setForeground(Color.DARK_GRAY);
		lblNameUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameUser.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNameUser.setBounds(299, 329, 609, 36);
		panelMain_1.add(lblNameUser);
		panelViewVaccinationAppointment.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPane.add(panelViewVaccinationAppointment, "name_397551556887600");
		panelViewVaccinationAppointment.setLayout(null);
		
		JLabel lblVaccinationAppointment = new JLabel("Vaccination Appointment");
		lblVaccinationAppointment.setForeground(new Color(30, 144, 255));
		lblVaccinationAppointment.setFont(new Font("Arial", Font.BOLD, 24));
		lblVaccinationAppointment.setBounds(10, 10, 857, 58);
		panelViewVaccinationAppointment.add(lblVaccinationAppointment);
		
		JScrollPane scrollPaneVaccinationAppointment = new JScrollPane();
		scrollPaneVaccinationAppointment.setBounds(10, 67, 1182, 326);
		panelViewVaccinationAppointment.add(scrollPaneVaccinationAppointment);
		
		Object[][]objVaccinationAppointment= {};
		String[]titleVaccinationAppointment = {"Vaccination ID", "Vaccine Name", "Appointment Date", "Status"};
		tableVaccinationAppointment = new JTable(objVaccinationAppointment, titleVaccinationAppointment);
		scrollPaneVaccinationAppointment.setViewportView(tableVaccinationAppointment);
		panelRequestVaccinationAppointment_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPane.add(panelRequestVaccinationAppointment_1, "name_397551581382100");
		panelRequestVaccinationAppointment_1.setLayout(null);
		
		JLabel lblRequestVA = new JLabel("Vaccination Appointment Application Form");
		lblRequestVA.setForeground(new Color(30, 144, 255));
		lblRequestVA.setFont(new Font("Arial", Font.BOLD, 24));
		lblRequestVA.setBounds(411, 10, 765, 58);
		panelRequestVaccinationAppointment_1.add(lblRequestVA);
		
		JLabel lblAvailableVaccine = new JLabel("Available Vaccine");
		lblAvailableVaccine.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAvailableVaccine.setBounds(411, 81, 125, 32);
		panelRequestVaccinationAppointment_1.add(lblAvailableVaccine);
		 
		//populate the item of the combo box based on the array list data vaccine
		String[]availableVaccine = new String[controller.getVaccineData().size()];
		for (int i = 0; i < controller.getVaccineData().size(); i++)
        {
			availableVaccine[i] = "Vaccine name: " + controller.getVaccineData().
					get(i).getVaccineName() + ", Manufactured by: " + controller.
					getVaccineData().get(i).getManufacturer();
        }
		final JComboBox comboBoxAvailableVaccine = new JComboBox(availableVaccine);
		comboBoxAvailableVaccine.setBounds(590, 81, 586, 32);
		panelRequestVaccinationAppointment_1.add(comboBoxAvailableVaccine);
		
		JLabel lblAvailableAtHealthcare = new JLabel("Healthcare Centre");
		lblAvailableAtHealthcare.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAvailableAtHealthcare.setBounds(411, 142, 126, 32);
		panelRequestVaccinationAppointment_1.add(lblAvailableAtHealthcare);
		
		String[]centreDataOffering = new String[controller.getCentreOfHealth().size()];
    	ArrayList<healthCareCentre> storeHealthCareProvideVaccine = new ArrayList<>();
        vaccine centreHealthVaccine = controller.getVaccineBatch(comboBoxAvailableVaccine.getSelectedIndex());

    	for(int k = 0; k < controller.getCentreOfHealth().size();k++) {
    		centreDataOffering[k]= "Centre Name: "+controller.getCentreOfHealth().get(k).getCentreName()+", Address:"+controller.getCentreOfHealth().get(k).getAddress();
    	}
    	
		final JComboBox comboBoxHealthcare = new JComboBox(centreDataOffering);
		comboBoxHealthcare.setBounds(590, 143, 586, 32);
		panelRequestVaccinationAppointment_1.add(comboBoxHealthcare);
		
		JLabel lblAvailableVaccineBatch = new JLabel("Available Vaccine Batch");
		lblAvailableVaccineBatch.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAvailableVaccineBatch.setBounds(411, 205, 169, 32);
		panelRequestVaccinationAppointment_1.add(lblAvailableVaccineBatch);
		
		final int availableVacSelected = comboBoxAvailableVaccine.getSelectedIndex();
		final int availableHCSelected = comboBoxHealthcare.getSelectedIndex();
		final JComboBox comboBoxAvailableVaccineBatch = new JComboBox();
		comboBoxAvailableVaccineBatch.setBounds(590, 205, 462, 32);
		panelRequestVaccinationAppointment_1.add(comboBoxAvailableVaccineBatch);
		
		JLabel lblAppointmentDate = new JLabel("Appointment Date");
		lblAppointmentDate.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAppointmentDate.setBounds(411, 267, 169, 32);
		panelRequestVaccinationAppointment_1.add(lblAppointmentDate);
		
		String[]datesAppointment = {"","1","2","3","4","5","6","7","8","9","10",
				"11","12","13","14","15","16","17","18","19","20","21","22",
				"23","24","25","26","27","28","29","30","31"};
		
		String[]monthAppointment = {"","January","February","March","April","May",
				"June","July","August","September","October","November",
				"December"};
		
		String[]yearAppointment= {"","2019","2020","2021","2022","2023","2024","2025"};
		
		final JComboBox comboBoxAppointmentDate = new JComboBox(datesAppointment);
		comboBoxAppointmentDate.setBounds(590, 268, 70, 32);
		panelRequestVaccinationAppointment_1.add(comboBoxAppointmentDate);
		
		JLabel lblAppointmentMonth = new JLabel("Appointment Month");
		lblAppointmentMonth.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAppointmentMonth.setBounds(670, 267, 125, 32);
		panelRequestVaccinationAppointment_1.add(lblAppointmentMonth);
		
		final JComboBox comboBoxAppointmentMonth = new JComboBox(monthAppointment);
		comboBoxAppointmentMonth.setBounds(805, 268, 145, 32);
		panelRequestVaccinationAppointment_1.add(comboBoxAppointmentMonth);
		
		JLabel lblAppointmentYear = new JLabel("Appointment Year");
		lblAppointmentYear.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAppointmentYear.setBounds(960, 267, 114, 32);
		panelRequestVaccinationAppointment_1.add(lblAppointmentYear);
		
		final JComboBox comboBoxAppointmentYear = new JComboBox(yearAppointment);
		comboBoxAppointmentYear.setBounds(1084, 267, 92, 32);
		panelRequestVaccinationAppointment_1.add(comboBoxAppointmentYear);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 390, 407);
		panelRequestVaccinationAppointment_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(patientDashboard.class.getResource("/img/signInBg.png")));
		lblNewLabel.setBounds(-155, 0, 545, 407);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Input Data");
		final int availableBatchSelected = comboBoxAvailableVaccineBatch.getSelectedIndex()+1;
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String dateVaccApp = comboBoxAppointmentDate.getSelectedIndex() + "/" + comboBoxAppointmentMonth.getSelectedIndex() + "/" + comboBoxAppointmentYear.getSelectedItem();
				String vaccID = controller.generateVaccinationID(availableVacSelected, availableHCSelected, availableBatchSelected);
				vaccination newVaccination = new vaccination(vaccID, dateVaccApp, "Pending", "");
				patient pat = controller.getPatientVaccination(username);
				pat.getVaccinations().add(newVaccination);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(154, 205, 50));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(552, 340, 223, 43);
		panelRequestVaccinationAppointment_1.add(btnNewButton);
		
		JButton btnCleardata = new JButton("Clear Data");
		btnCleardata.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBoxAppointmentDate.setSelectedItem("");
				comboBoxAppointmentMonth.setSelectedItem("");
				comboBoxAppointmentYear.setSelectedItem("");
			}
		});
		btnCleardata.setForeground(new Color(255, 255, 255));
		btnCleardata.setBackground(new Color(255, 0, 0));
		btnCleardata.setFont(new Font("Arial", Font.BOLD, 14));
		btnCleardata.setBounds(813, 340, 223, 43);
		panelRequestVaccinationAppointment_1.add(btnCleardata);
		
		JButton btnFindBatch = new JButton("Find Batch");
		
		btnFindBatch.setFont(new Font("Arial", Font.PLAIN, 14));
		btnFindBatch.setBackground(new Color(102, 205, 170));
		btnFindBatch.setBounds(1062, 205, 114, 32);
		panelRequestVaccinationAppointment_1.add(btnFindBatch);
		
		btnFindBatch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//if(controller.vaacBatch(availableVacSelected, availableHCSelected)!=0) 
//				if(controller.vaacBatch(availableVacSelected, availableHCSelected)!=0)
//				{
//					comboBoxAvailableVaccineBatch.removeAllItems();
//					comboBoxAvailableVaccineBatch.addItem(controller.vaacBatch(availableVacSelected, availableHCSelected));
//				}
//				else
//				{
//					JOptionPane.showMessageDialog(comboBoxAvailableVaccineBatch, "Sorry, no vaccine batches are available for this type of vaccine\n"+"or, the stock of vaccine batch in healthcare that you have choosen is empty\n\n"+"Suggestion:\n"+"Try to find in another healthcare centre or try to select anothe vaccine");
//					comboBoxAvailableVaccineBatch.removeAllItems();
//				}
				comboBoxAvailableVaccineBatch.removeAllItems();
//				for(int i = 0; i < controller.getHealthcareCentre(availableHCSelected).getBatchesVaccine().size();i++) {
//				
//					comboBoxAvailableVaccineBatch.addItem(controller.getVaccineBatchForAppoimtment(availableHCSelected, availableVacSelected));
//				}
				for(int i = 0; i < controller.getVaccineBatchForAppoimtment(availableHCSelected, availableVacSelected).size();i++) {
					comboBoxAvailableVaccineBatch.addItem(controller.getVaccineBatchForAppoimtment(availableHCSelected, availableVacSelected));
				}
			}
		});
		
		JButton btnMainButton = new JButton("Main Panel");
		btnMainButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMain_1.setVisible(true);
				panelRequestVaccinationAppointment_1.setVisible(false);
				panelViewVaccinationAppointment.setVisible(false);
			}
		});
		btnMainButton.setFont(new Font("Arial", Font.PLAIN, 18));
		btnMainButton.setBounds(33, 456, 356, 96);
		contentPane.add(btnMainButton);
		
		JButton btnRequestNewVaccination = new JButton("Request New Vaccination Appointment");
		btnRequestNewVaccination.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMain_1.setVisible(false);
				panelRequestVaccinationAppointment_1.setVisible(true);
				panelViewVaccinationAppointment.setVisible(false);
			}
		});
		btnRequestNewVaccination.setFont(new Font("Arial", Font.PLAIN, 18));
		btnRequestNewVaccination.setBounds(422, 455, 369, 97);
		contentPane.add(btnRequestNewVaccination);
		
		JButton btnViewVaccinationAppointment = new JButton("View Vaccination Appointment");
		btnViewVaccinationAppointment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMain_1.setVisible(false);
				panelRequestVaccinationAppointment_1.setVisible(false);
				panelViewVaccinationAppointment.setVisible(true);
			}
		});
		btnViewVaccinationAppointment.setFont(new Font("Arial", Font.PLAIN, 18));
		btnViewVaccinationAppointment.setBounds(824, 455, 369, 97);
		contentPane.add(btnViewVaccinationAppointment);
	}
}
