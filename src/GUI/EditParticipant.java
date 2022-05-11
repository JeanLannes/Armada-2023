package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import dao.CompteDAO;
import dao.ParticipantDAO;
import dao.PersonneDAO;
import model.Boat;
import model.Compte;
import model.HostFamily;
import model.Participant;
import model.Personne;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class EditParticipant extends JPanel {
	private JButton btnConfirm;
	private JButton btnReturn;
	private static JTextField tfId;
	private static JTextField tfMail;
	private static JTextField tfPassword;
	private static JTextField tfFirstName;
	private static JTextField tfLastName;
	private static JTextField tfbirthday;
	private static JLabel lblId;
	private static int index;
	private static JLabel lblMessageAdd;
	private static JLabel lblMessageMdf;
	private static JLabel lblMessageDlt;
	private static JLabel lblMessageCsl;
	private static JComboBox cbType;

	public EditParticipant() {

		//AJOUT DU TEXTE NOM
		JLabel lblLastName = new JLabel("NOM ");
		lblLastName.setBounds(200, 206, 74, 34);
		lblLastName.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		
		//AJOUT DU TEXTE ESIGELEC
		JLabel lblEsigelec = new JLabel("ESIGELEC");
		lblEsigelec.setBounds(200, 100, 147, 67);
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		//AJOUT DU TEXTE ARMADA 2023
		JLabel lblArmada = new JLabel("ARMADA 2023");
		lblArmada.setBounds(657, 100, 207, 67);
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		//AJOUT DE LA BOITE A SELECTION DES DIFFERENTS PARTICIPANTS
		String[] tab = { "Bateau", "Commerçant", "Délégation", "Entreprise", "Famille d'accueil"};
		cbType = new JComboBox(tab);
		cbType.setBounds(391, 359, 141, 38);
		cbType.setSelectedIndex(4);
		add(cbType);
		
		//AJOUT DU CHAMP DE TEXTE MOT DE PASSE
		tfPassword = new JTextField();
		tfPassword.setBounds(391, 460, 482, 39);
		tfPassword.setColumns(10);
		
		//AJOUT DU BOUTON <<VALIDER>>
		btnConfirm = new JButton("VALIDER");
		btnConfirm.setBounds(250, 544, 200, 51);
		btnConfirm.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbType.getSelectedItem().toString().equals("Bateau")) {
					Main.mpToBat();
				} else if (cbType.getSelectedItem().toString().equals("Commerçant")) {
					Main.mpToCom();
				} else if (cbType.getSelectedItem().toString().equals("Entreprise")) {
					Main.mpToEnt();
				} else if (cbType.getSelectedItem().toString().equals("Délégation")) {
					Main.mpToDeleg();
				} else if (cbType.getSelectedItem().toString().equals("Famille d'accueil")) {
					Main.mpToFa();
				}
			}
		});
		
		//AJOUT DU BOUTON <<RETOUR>>
		btnReturn = new JButton("RETOUR");
		btnReturn.setBounds(631, 544, 200, 51);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(1);
			}
		});
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		
		//AJOUT DU CHAMP DE TEXTE ID
		tfId = new JTextField();
		tfId.setBounds(391, 411, 482, 39);
		tfId.setColumns(10);
		
		//AJOUT DU CHAMP DE TEXTE MAIL
		tfMail = new JTextField();
		tfMail.setBounds(391, 299, 482, 39);
		tfMail.setColumns(10);
		
		//AJOUT DU CHAMP DE TEXTE PRENOM
		tfFirstName = new JTextField();
		tfFirstName.setBounds(391, 250, 482, 39);
		tfFirstName.setColumns(10);
		
		//AJOUT DU CHAMP DE TEXTE NOM
		tfLastName = new JTextField();
		tfLastName.setBounds(391, 201, 482, 39);
		tfLastName.setColumns(10);
		
		//AJOUT DU TEXTE PRENOM
		JLabel lblFirstName = new JLabel("PRENOM");
		lblFirstName.setBounds(200, 255, 157, 34);
		lblFirstName.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		
		//AJOUT DU TEXTE MAIL
		JLabel lblMail = new JLabel("MAIL");
		lblMail.setBounds(200, 304, 74, 34);
		lblMail.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		
		//AJOUT DU TEXTE PARTICIPANT
		JLabel lblParticipant = new JLabel("PARTICIPANT");
		lblParticipant.setBounds(200, 363, 181, 34);
		lblParticipant.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		
		//AJOUT DU TEXTE ID
		lblId = new JLabel("ID");
		lblId.setBounds(200, 416, 74, 34);
		lblId.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		
		//AJOUT DU TEXTE MDP
		JLabel lblPassword = new JLabel("MDP");
		lblPassword.setBounds(200, 465, 74, 34);
		lblPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		
		//AJOUT DU TEXTE AJOUTER UN PARTICIPANT
		lblMessageAdd = new JLabel("AJOUTER UN PARTICIPANT ");
		lblMessageAdd.setBounds(290, 151, 422, 38);
		lblMessageAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessageAdd.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));

		//AJOUT DU TEXTE MODIFIER UN PARTICIPANT
		lblMessageMdf = new JLabel("MODIFIER UN PARTICIPANT ");
		lblMessageMdf.setBounds(315, 151, 392, 38);
		lblMessageMdf.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessageMdf.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));

		//AJOUT DU TEXTE SUPPRIMER UN PARTICIPANT
		lblMessageDlt = new JLabel("SUPPRIMER UN PARTICIPANT ");
		lblMessageDlt.setBounds(285, 151, 469, 38);
		lblMessageDlt.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessageDlt.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));

		//AJOUT DU TEXTE CONSULTER UN PROFIL
		lblMessageCsl = new JLabel("CONSULTER UN PROFIL ");
		lblMessageCsl.setBounds(177, 151, 673, 38);
		lblMessageCsl.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessageCsl.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		
		//AJOUT DU TEXTE NAISSANCE
		JLabel lblBirthday = new JLabel("NAISSANCE");
		lblBirthday.setBounds(542, 363, 147, 34);
		lblBirthday.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		setLayout(null);
		
		//AJOUT DE LA ZONE DE TEXTE NAISSANCE
		tfbirthday = new JTextField();
		tfbirthday.setBounds(697, 358, 176, 39);
		tfbirthday.setColumns(10);
		
		//AJOUT DES ELEMENTS GRAPHIQUES
		add(tfbirthday);
		add(lblMessageDlt);
		add(lblMessageCsl);
		add(lblMessageAdd);
		add(lblEsigelec);
		add(lblMessageMdf);
		add(lblArmada);
		add(lblLastName);
		add(tfLastName);
		add(lblFirstName);
		add(tfFirstName);
		add(lblMail);
		add(tfMail);
		add(lblParticipant);
		add(lblBirthday);
		add(lblId);
		add(tfId);
		add(lblPassword);
		add(tfPassword);
		add(btnConfirm);
		add(btnReturn);
	}
	
	/**
	 * Cette méthode sert à modifier/supprimer un compte/participant/personne
	 */
	public static void closeEditParticipant() {
		if (index==1 || index==0) {	
			//MODIFIE UN PARTICIPANT/COMPTE DANS LA BDD
			Compte cpt = new Compte(Integer.parseInt(tfId.getText()), tfPassword.getText(), tfMail.getText());
			CompteDAO.update(cpt);	
			Personne per = new Personne(Integer.parseInt(tfId.getText()), tfFirstName.getText(), tfLastName.getText(), cbType.getSelectedItem().toString(), tfbirthday.getText());
			PersonneDAO.update(per);
			Menu.block();
		} else if (index==2) {	
			//SUPPRIME UN PARTICIPANT/COMPTE DANS LA BDD
			CompteDAO.delete(Integer.parseInt(tfId.getText()));	
			PersonneDAO.delete(Integer.parseInt(tfId.getText()));
		}
		change(2);	//RETOURNE AU MENU
	}
	
	/**
	 * Affiche un message d'erreur si l'identifiant est déjà attribué
	 */
	public static void reject(int i) {
		if (i==1)
			JOptionPane.showMessageDialog(lblMessageAdd, "ID déjà utilise. Veuillez en changer.");
	}
	
	/**
	 * Permet de faire appel aux passerelles(dans le fichier Main) pour changer de page
	 */
	protected static void change(int i) {
		if (i==1)
			Main.fmToMenu();
		if (i==2)
			Main.fmToMenu();
	}
	
	/**
	 * Affiche diffentes configuration de la page EditParticipant en fonction de l'action realisee
	 * 0 => MODIFICATION Participant
	 * 1 => MODIFICATION Admin
	 * 2 => SUPPRESION Admin
	 * 3 => CONSULTATION Admin
	 * 4 => CONSULTATION Participant
	 * @param i
	 */
	protected static void changeIndex(int i) {
		if (i==0) { // MODIFICATION PARTICIPANT 
			index=0;
			lblMessageAdd.setVisible(true);
			lblMessageMdf.setVisible(false);
			lblMessageDlt.setVisible(false);
			lblMessageCsl.setVisible(false);
			tfId.setEditable(false);
			tfMail.setEditable(true);
			tfPassword.setEditable(true);
			cbType.setEditable(true);
			tfFirstName.setEditable(true);
			tfLastName.setEditable(true);
			tfbirthday.setEditable(true);
			tfId.setVisible(false);
			lblId.setVisible(false);
		}
		if (i==1) {	// MODIFICATION ADMIN 
			index=1;
			lblMessageAdd.setVisible(false);
			lblMessageMdf.setVisible(true);
			lblMessageDlt.setVisible(false);
			lblMessageCsl.setVisible(false);
			tfId.setEditable(false);
			tfMail.setEditable(true);
			tfPassword.setEditable(true);
			cbType.setEditable(true);
			tfFirstName.setEditable(true);
			tfLastName.setEditable(true);
			tfbirthday.setEditable(true);
			tfId.setVisible(true);
			lblId.setVisible(true);
			BoatGUI.unblockBoat();
			RetailerGUI.unblockRetailer();
			Famille.blockHostFamily();
			Delegation.blockDelegation();
			EntrepriseGUI.blockEntreprise();
		}
		if (i==2) {	// SUPPRESION DE PROFIL
			index=2;
			lblMessageAdd.setVisible(false);
			lblMessageMdf.setVisible(false);
			lblMessageDlt.setVisible(true);
			lblMessageCsl.setVisible(false);
			tfId.setEditable(false);
			tfMail.setEditable(false);
			tfPassword.setEditable(false);
			cbType.setEditable(false);
			tfFirstName.setEditable(false);
			tfLastName.setEditable(false);
			tfbirthday.setEditable(false);
			tfId.setVisible(true);
			lblId.setVisible(true);
			BoatGUI.blockBoat();
			RetailerGUI.blockRetailer();
			Famille.blockHostFamily();
			Delegation.blockDelegation();
			EntrepriseGUI.blockEntreprise();
		}
		if (i==3) { // CONSULTATION DE PROFIL ADMIN
			index=3;
			lblMessageAdd.setVisible(false);
			lblMessageMdf.setVisible(false);
			lblMessageDlt.setVisible(false);
			lblMessageCsl.setVisible(true);
			tfId.setEditable(false);
			tfId.setEditable(false);
			tfMail.setEditable(false);
			tfPassword.setEditable(false);
			cbType.setEditable(false);
			tfFirstName.setEditable(false);
			tfLastName.setEditable(false);
			tfbirthday.setEditable(false);
			tfId.setVisible(true);
			lblId.setVisible(true);
			BoatGUI.blockBoat();
			RetailerGUI.blockRetailer();
			Famille.blockHostFamily();
			Delegation.blockDelegation();
			EntrepriseGUI.blockEntreprise();
		}
		if (i==4) {	// CONSULTATION DE PROFIL PARTICIPANT
			index=4;
			lblMessageAdd.setVisible(false);
			lblMessageMdf.setVisible(false);
			lblMessageDlt.setVisible(false);
			lblMessageCsl.setVisible(true);
			tfId.setEditable(false);
			tfId.setEditable(false);
			tfMail.setEditable(false);
			tfPassword.setEditable(false);
			cbType.setEnabled(false);
			tfFirstName.setEditable(false);
			tfLastName.setEditable(false);
			tfbirthday.setEditable(false);
			tfId.setVisible(false);
			lblId.setVisible(false);
			BoatGUI.blockBoat();
			RetailerGUI.blockRetailer();
			Famille.blockHostFamily();
			Delegation.blockDelegation();
			EntrepriseGUI.blockEntreprise();
		}
	}

	/**
	 * Incrit les informations relatives a un participant dont l'id est en parametre
	 * @param id
	 */
	protected static void showUpdateProfile(int id) {
		//RECUPERATION DES INFOS
		Compte cpt = new Compte();
		cpt=CompteDAO.get(id);
		Personne per = new Personne();
		per=PersonneDAO.get(id);
		Participant part = new Participant();
		part=ParticipantDAO.get(id);

		//UPDATE GRAPHIQUE DES INFOS 
		tfId.setText(Integer.toString(id));
		tfMail.setText(cpt.getMail());
		tfPassword.setText(cpt.getPassword());
		tfFirstName.setText(per.getFirstName());
		tfLastName.setText(per.getLastName());
		tfbirthday.setText(per.getBirthday());

		if (part.getIdRetailer()!=0) {
			//FORCE & MET A JOUR LA SELECTION DU COMMERCANT
			cbType.setSelectedItem("Commerçant");
			RetailerGUI.showUpdateProfile(part);
		} 
		if (part.getBoatName()!=null) {
			//FORCE & MET A JOUR LA SELECTION DU BATEAU
			cbType.setSelectedItem("Bateau");
			Boat.showUpdateProfile(part);
		} 
		if (part.getCountry()!=null) {
			//FORCE & MET A JOUR LA SELECTION DE LA DELEGATION
			cbType.setSelectedItem("Délégation");
			Delegation.showUpdateProfile(part);
		} 
		if (part.getImEntreprise()!=null) {
			//FORCE & MET A JOUR LA SELECTION DE L'ENTREPRISE
			cbType.setSelectedItem("Entreprise");
			EntrepriseGUI.showUpdateProfile(part);
		} 
		if (part.getIdFamille()!=0) {
			//FORCE & MET A JOUR LA SELECTION DE LA FAMILLE D'ACCUEIL
			cbType.setSelectedItem("Famille d'accueil");
			Famille.showUpdateProfile(part);
		} 
	}

	/**
	 * Retourne l'index désignant le type d'action choisi par l'utilisateur
	 * @return int 
	 */
	public static int getIndex() {
		return index;
	}
}
