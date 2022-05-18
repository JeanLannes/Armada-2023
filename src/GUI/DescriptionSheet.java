package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dao.BoatDAO;
import dao.CompteDAO;
import dao.DescriptionDAO;
import dao.ParticipantDAO;
import model.Boat;
import model.Compte;
import model.Description;
import model.Participant;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DescriptionSheet extends JPanel {
	private static JButton btnConfirm;
	private static JButton btnReturn;
	private static JTextField tfDescription;
	private static JLabel lblDescription;
	private static JTextField tfName;
	private static JLabel lblName;
	
	public DescriptionSheet() {
		setLayout(null);
		
		//AJOUT DU LOGO ARMADA2023
		JLabel lblArmada = new JLabel("ARMADA 2023");
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblArmada.setBounds(657, 100, 209, 67);
		
		//AJOUT DU LOGO ESIGELEC
		JLabel lblEsigelec = new JLabel("ESIGELEC");	
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblEsigelec.setBounds(200, 100, 147, 67);
		
		//CHAMP DE TEXTE NOM
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(250, 266, 579, 41);
		
		//TEXTE NOM
		lblName = new JLabel("NOM ");
		lblName.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		lblName.setBounds(167, 273, 68, 34);
		
		//TEXTE DESCRIPTION
		lblDescription = new JLabel("DESCRIPTIF");
		lblDescription.setBounds(88, 329, 147, 34);
		lblDescription.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		
		//CHAMP DE TEXTE DESCRIPTION
		tfDescription = new JTextField();
		tfDescription.setBounds(250, 329, 579, 174);
		
		//BONTON <<VALIDER>> 
		btnConfirm = new JButton("VALIDER");
		btnConfirm.setBounds(250, 544, 200, 51);
		btnConfirm.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Description des = new Description(DescriptionDAO.getMaxID()+1, tfName.getText(), tfDescription.getText());
				DescriptionDAO.add(des);
				Compte cpt = new Compte();
				cpt=CompteDAO.getWithMail(Main.getMail());
				ParticipantDAO.setConnexion(cpt.getId(), 8, des.getIdSheet());
				Menu.block();
				change();
			}
		});
		
		//BONTON <<RETOUR>> 
		btnReturn = new JButton("RETOUR");
		btnReturn.setBounds(631, 544, 200, 51);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change();
			}
		});
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		
		//AJOUT DES ELEMENTS GRAPHIQUES
		add(tfName);
		add(lblName);
		add(btnConfirm);
		add(btnReturn);
		add(lblArmada);
		add(lblEsigelec);
		add(lblDescription);
		add(tfDescription);
	}
	
	/**
	 * Permet de retourner sur le menu
	 */
	protected void change() {
		Main.dsToMenu();
	}
	
	/**
	 * Permet de bloquer l'edition des champs de texte
	 */
	protected void blockDS() {
		tfDescription.setEditable(false);
		tfName.setEditable(false);
	}

	/**
	 * Permet de débloquer l'edition des champs de texte
	 */
	protected void unblockDS() {
		tfDescription.setEditable(true);
		tfName.setEditable(true);
	}

	/**
	 * Permet de mettre à jour la page Bateau avec les informations importés 
	 * @param Participant
	 */ 
	public static void showUpdateProfile() {
		Compte cpt =new Compte();
		cpt=CompteDAO.getWithMail(Main.getMail());
		Participant part = new Participant();
		part = ParticipantDAO.get(cpt.getId());
		Description ds = new Description();
		ds=DescriptionDAO.get(part.getIdFiche());
		//IMPORTATION DES DONNEES 
		tfDescription.setText(ds.getDescription());
		tfName.setText(ds.getName());
	}

}
