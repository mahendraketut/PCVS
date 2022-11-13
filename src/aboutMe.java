import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Toolkit;

public class aboutMe extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public aboutMe() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(aboutMe.class.getResource("/img/pcvsIcon.png")));
		setResizable(false);
		getContentPane().setBackground(SystemColor.controlDkShadow);
		setUndecorated(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 574, 464);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlDkShadow);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(aboutMe.class.getResource("/img/pcvsIcon.png")));
			lblNewLabel.setBounds(10, 10, 175, 143);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblVaccinationSystem = new JLabel("PRIVATE COVID-19");
			lblVaccinationSystem.setForeground(SystemColor.menu);
			lblVaccinationSystem.setFont(new Font("Arial", Font.BOLD, 38));
			lblVaccinationSystem.setBounds(195, 30, 355, 63);
			contentPanel.add(lblVaccinationSystem);
		}
		{
			JLabel lblPrivateCovid19 = new JLabel("vaccination system.");
			lblPrivateCovid19.setForeground(SystemColor.menu);
			lblPrivateCovid19.setFont(new Font("Arial", Font.PLAIN, 24));
			lblPrivateCovid19.setBounds(195, 84, 355, 41);
			contentPanel.add(lblPrivateCovid19);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 193, 554, 193);
		contentPanel.add(scrollPane);
		{
			JTextPane txtpnDevelopedByStudent = new JTextPane();
			txtpnDevelopedByStudent.setEditable(false);
			txtpnDevelopedByStudent.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtpnDevelopedByStudent.setText("Developed by:\r\nStudent Name\t  : I Ketut Mahendra\r\nStudent ID\t\t  : E1900340\r\nSubject\t\t  : BIT203 - Advance Object Oriented Programming\r\n");
			scrollPane.setColumnHeaderView(txtpnDevelopedByStudent);
		}
		
		JTextPane txtpnTheCovidVaccination = new JTextPane();
		txtpnTheCovidVaccination.setEditable(false);
		txtpnTheCovidVaccination.setFont(new Font("Arial", Font.PLAIN, 12));
		txtpnTheCovidVaccination.setText("The Covid-19 vaccination rollout in Malaysia and most countries have been underway for a\r\nfew months. As more and more of the population have been vaccinated, private healthcare\r\ncentres have been allowed to purchase and administer vaccines, especially to patients who want\r\nto choose the type of vaccine that they receive. However, the vaccinations that have been\r\nadministered by the private healthcare centres have to be recorded in the national vaccination\r\ncommittee database. A system is required for the Private Covid-19 Vaccination Scheme, known\r\nas PCVS.");
		scrollPane.setViewportView(txtpnTheCovidVaccination);
		{
			JLabel lblVersion = new JLabel("Version 1.0");
			lblVersion.setForeground(SystemColor.menu);
			lblVersion.setFont(new Font("Arial", Font.PLAIN, 14));
			lblVersion.setBounds(195, 122, 355, 31);
			contentPanel.add(lblVersion);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.controlDkShadow);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
