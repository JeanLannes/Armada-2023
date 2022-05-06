package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dao.CompteDAO;
import dao.DescriptionDAO;
import dao.PersonneDAO;
import model.Compte;
import model.Description;
import model.Personne;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DropMode;

@SuppressWarnings("serial")
public class DescriptionSheet extends JPanel {
	private JButton btnConfirm;
	private JButton btnReturn;
	private JTextField tfDescription;
	private static JLabel lblDescription;
	private JLabel lblType;
	private JTextField tfName;
	private JLabel lblName;
	
	public DescriptionSheet() {
		setLayout(null);
		
		JLabel lblArmada = new JLabel("ARMADA 2023");	//AJOUT DU LOGO ARMADA2023
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblArmada.setBounds(657, 100, 209, 67);
		
		JLabel lblEsigelec = new JLabel("ESIGELEC");	//AJOUT DU LOGO ESIGELEC
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblEsigelec.setBounds(200, 100, 147, 67);
		
		btnConfirm = new JButton("VALIDER");
		btnConfirm.setBounds(250, 544, 200, 51);
		btnConfirm.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Description des = new Description(DescriptionDAO.getMaxID()+1, tfName.getText(), tfDescription.getText(), 1);
				DescriptionDAO.add(des);
				change();
			}
		});
		
		btnReturn = new JButton("RETOUR");
		btnReturn.setBounds(631, 544, 200, 51);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change();
			}
		});
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		
		lblDescription = new JLabel("DESCRIPTIF");
		lblDescription.setBounds(88, 393, 147, 34);
		lblDescription.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		
		tfDescription = new JTextField();
		tfDescription.setBounds(250, 393, 579, 110);
		add(tfDescription);
		tfDescription.setColumns(10);
		
		lblType = new JLabel("TYPE");
		lblType.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		lblType.setBounds(166, 331, 74, 34);
		
		JComboBox type = new JComboBox();
		type.setBounds(250, 331, 581, 34);

		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(250, 266, 579, 41);
		
		lblName = new JLabel("NOM ");
		lblName.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		lblName.setBounds(167, 273, 68, 34);
		
		add(lblType);
		add(type);		
		add(tfName);
		add(lblName);
		add(btnConfirm);
		add(btnReturn);
		add(lblArmada);
		add(lblEsigelec);
		add(lblDescription);
	}

	protected void change() {
		Main.dsToMenu();
	}
}
