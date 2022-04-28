package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class FindParticipant extends JPanel {
	private JTextField tfId;
	private JLabel lblFirstName;
	private JLabel lblId;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JButton btnConfirm;
	private JButton btnReturn;
	private static JLabel lblMessageMdf;
	private static JLabel lblMessageDlt;
	private static JLabel lblMessageCsl;

	public FindParticipant() {
		setLayout(null);
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
		
		btnConfirm = new JButton("VALIDER");
		btnConfirm.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnConfirm.setBounds(250, 530, 200, 51);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(2);
			}
		});
		
		btnReturn = new JButton("RETOUR");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(1);
			}
		});
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnReturn.setBounds(631, 530, 200, 51);
		
		lblMessageMdf = new JLabel("QUEL PARTICIPANT SOUHAITEZ-VOUS MODIFIER ?");
		lblMessageMdf.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessageMdf.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		lblMessageMdf.setBounds(200, 211, 673, 38);

		lblMessageDlt = new JLabel("QUEL PARTICIPANT SOUHAITEZ-VOUS SUPPRIMER ?");
		lblMessageDlt.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessageDlt.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		lblMessageDlt.setBounds(200, 211, 673, 38);

		lblMessageCsl = new JLabel("QUEL PROFIL SOUHAITEZ-VOUS CONSULTER ?");
		lblMessageCsl.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessageCsl.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		lblMessageCsl.setBounds(200, 211, 673, 38);

		//
		add(lblEsigelec);
		add(lblArmada);
		add(lblLastName);
		add(lblId);
		add(lblFirstName);
		add(tfFirstName);
		add(tfId);
		add(tfLastName);
		add(btnConfirm);
		add(btnReturn);
		add(lblMessageMdf);
		add(lblMessageDlt);
		add(lblMessageCsl);
	}
	
	/**
	 * Permet de faire appel aux passerelles(dans le fichier Main) pour changer de page
	 * @param i
	 */
	protected void change(int i) {
		if (i==1)
			Main.fpToMenu();
		if (i==2)
			Main.fpToMp();
	}
	
	/**
	 * Permet d'adapter le design de la page en fonction de l'action souhaitée par l'admin
	 * @param i
	 */
	protected static void changeIndex(int i) {
		if (i==1) {
			lblMessageMdf.setVisible(true);
			lblMessageDlt.setVisible(false);
			lblMessageCsl.setVisible(false);
		}
		if (i==2) {
			lblMessageMdf.setVisible(false);
			lblMessageDlt.setVisible(true);
			lblMessageCsl.setVisible(false);
		}
		if (i==3) {
			lblMessageMdf.setVisible(false);
			lblMessageDlt.setVisible(false);
			lblMessageCsl.setVisible(true);
		}
	}

}
