package GUI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ModifyParticipant extends JPanel {
	private JTextField tfPassword;
	private JButton btnConfirm;
	private JButton btnReturn;
	private JTextField tfId;
	private JTextField tfParticipant;
	private JTextField tfMail;
	private JTextField tfFirstName;
	private JTextField tfLastName;

	public ModifyParticipant() {
		JLabel lblLastName = new JLabel("NOM ");
		lblLastName.setBounds(200, 206, 74, 34);
		lblLastName.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		
		JLabel lblEsigelec = new JLabel("ESIGELEC");
		lblEsigelec.setBounds(200, 100, 147, 67);
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		JLabel lblArmada = new JLabel("ARMADA 2023");
		lblArmada.setBounds(657, 100, 207, 67);
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		tfPassword = new JTextField();
		tfPassword.setBounds(391, 446, 482, 39);
		tfPassword.setColumns(10);
		
		btnConfirm = new JButton("VALIDER");
		btnConfirm.setBounds(250, 530, 200, 51);
		btnConfirm.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		
		btnReturn = new JButton("RETOUR");
		btnReturn.setBounds(631, 530, 200, 51);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		
		tfId = new JTextField();
		tfId.setBounds(391, 397, 482, 39);
		tfId.setColumns(10);
		
		tfParticipant = new JTextField();
		tfParticipant.setBounds(391, 348, 482, 39);
		tfParticipant.setColumns(10);
		
		tfMail = new JTextField();
		tfMail.setBounds(391, 299, 482, 39);
		tfMail.setColumns(10);
		
		tfFirstName = new JTextField();
		tfFirstName.setBounds(391, 250, 482, 39);
		tfFirstName.setColumns(10);
		
		tfLastName = new JTextField();
		tfLastName.setBounds(391, 201, 482, 39);
		tfLastName.setColumns(10);
		
		JLabel lblFirstName = new JLabel("PRENOM");
		lblFirstName.setBounds(200, 255, 157, 34);
		lblFirstName.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		
		JLabel lblMail = new JLabel("MAIL");
		lblMail.setBounds(200, 304, 74, 34);
		lblMail.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		
		JLabel lblParticipant = new JLabel("PARTICIPANT");
		lblParticipant.setBounds(200, 353, 181, 34);
		lblParticipant.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(200, 402, 74, 34);
		lblId.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		
		JLabel lblPassword = new JLabel("MDP");
		lblPassword.setBounds(200, 451, 74, 34);
		lblPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		setLayout(null);
		add(btnConfirm);
		add(btnReturn);
		add(lblLastName);
		add(lblMail);
		add(lblId);
		add(lblPassword);
		add(lblFirstName);
		add(lblParticipant);
		add(tfMail);
		add(tfParticipant);
		add(tfId);
		add(tfPassword);
		add(tfFirstName);
		add(tfLastName);
		add(lblEsigelec);
		add(lblArmada);
	}
}
