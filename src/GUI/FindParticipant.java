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

public class FindParticipant extends JPanel {
	private JTextField tfId;
	private JLabel lblFirstName;
	private JLabel lblId;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JButton btnConfirm;
	private JButton btnReturn;
	private JLabel lblMessage;

	public FindParticipant() {
		JLabel lblLastName = new JLabel("NOM ");
		lblLastName.setBounds(206, 322, 74, 38);
		lblLastName.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		
		JLabel lblEsigelec = new JLabel("ESIGELEC");
		lblEsigelec.setBounds(200, 100, 147, 67);
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		JLabel lblArmada = new JLabel("ARMADA 2023");
		lblArmada.setBounds(657, 100, 207, 67);
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		tfId = new JTextField();
		tfId.setBounds(391, 446, 482, 50);
		tfId.setColumns(10);
		
		lblFirstName = new JLabel("PRENOM ");
		lblFirstName.setBounds(206, 378, 151, 50);
		lblFirstName.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		
		lblId = new JLabel("ID");
		lblId.setBounds(206, 446, 86, 50);
		lblId.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		
		tfFirstName = new JTextField();
		tfFirstName.setBounds(391, 378, 482, 50);
		tfFirstName.setColumns(10);
		
		tfLastName = new JTextField();
		tfLastName.setBounds(391, 310, 482, 50);
		tfLastName.setColumns(10);
		setLayout(null);
		add(lblEsigelec);
		add(lblArmada);
		add(lblLastName);
		add(lblId);
		add(lblFirstName);
		add(tfFirstName);
		add(tfId);
		add(tfLastName);
		
		btnConfirm = new JButton("VALIDER");
		btnConfirm.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnConfirm.setBounds(250, 530, 200, 51);
		add(btnConfirm);
		
		btnReturn = new JButton("RETOUR");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnReturn.setBounds(631, 530, 200, 51);
		add(btnReturn);
		
		lblMessage = new JLabel("QUEL PARTCIPANT SOUHAITEZ-VOUS MODIFIER ?");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		lblMessage.setBounds(200, 211, 673, 38);
		add(lblMessage);
	}

}
