package GUI;

import java.awt.Font;
import javax.swing.*;

import dao.CompteDAO;
import dao.ParticipantDAO;
import model.Compte;
import model.Participant;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Menu extends JPanel {
	static JButton btnModifyParcipant;
	static JButton btnDeleteParticipant;
	static JButton btnSeeAProfil;
	static JButton btnInscriptionManagment;
	static JButton btnAssignLocation;
	static JButton btnReturn;
	static JButton btnSeeProfil;
	static JButton btnCompleteProfil;
	static JButton InsertDescriptionSheet;
	static JButton ModifyDescriptionSheet;
	static JButton btnAddParticipant;
	int completeCond=0;
	
	/**
	 * Genere une page d'inscription
	 */
	public Menu() {
		//AJOUT DU LOGO ARMADA2023
		JLabel lblEsigelec = new JLabel("ESIGELEC");
		lblEsigelec.setBounds(216, 100, 147, 67);
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		//AJOUT DU LOGO ESIGELEC
		JLabel lblArmada = new JLabel("ARMADA 2023");
		lblArmada.setBounds(673, 100, 207, 67);
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		//AJOUT DU BOUTON SE <<AJOUTER UN PARTICIPANT>>	
		btnAddParticipant = new JButton("AJOUTER UN PARTICIPANT");		
		btnAddParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(4, 0);
			}
		});
		btnAddParticipant.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnAddParticipant.setBounds(532, 217, 348, 39);

		//AJOUT DU BOUTON <<MODIFIER UN PARTICIPANT>>
		btnModifyParcipant = new JButton("MODIFIER UN PARTICIPANT");		
		btnModifyParcipant.setBounds(532, 266, 348, 39);
		btnModifyParcipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(2, 1);
			}
		});
		btnModifyParcipant.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		//AJOUT DU BOUTON <<SUPPRIMER UN PARTICIPANT>>
		btnDeleteParticipant = new JButton("SUPPRIMER UN PARTICIPANT");		
		btnDeleteParticipant.setBounds(532, 315, 348, 39);
		btnDeleteParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(2, 2);
			}
		});
		btnDeleteParticipant.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		//AJOUT DU BOUTON <<CONSULTER UN PROFIL>>
		btnSeeAProfil = new JButton("CONSULTER UN PROFIL");		
		btnSeeAProfil.setBounds(530, 364, 350, 39);
		btnSeeAProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(2, 3);
			}
		});
		btnSeeAProfil.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		//AJOUT DU BOUTON <<GERER LES INSCRIPTIONS>>
		btnInscriptionManagment = new JButton("GERER LES INSCRIPTIONS");		
		btnInscriptionManagment.setBounds(530, 413, 350, 39);
		btnInscriptionManagment.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		//AJOUT DU BOUTON <<ATTRIBUER UN EMPLACEMENT>>
		btnAssignLocation  = new JButton("ATTRIBUER UN EMPLACEMENT");	
		btnAssignLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(6, 4);
			}
		});
		btnAssignLocation.setBounds(530, 462, 350, 39);
		btnAssignLocation.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		//AJOUT DU BOUTON DE <<RETOUR>> POUR RETOURNER A L'ECRAN DE CONNECTION
		btnReturn = new JButton("RETOUR");		
		btnReturn.setBounds(430, 530, 200, 51);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(1, 0);
			}
		});
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		
		//AJOUT DU BOUTON <<CONSULTER SON PROFIL>>
		btnSeeProfil = new JButton("CONSULTER SON PROFIL");		
		btnSeeProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(3, 4);
				Compte cpt = new Compte();
				cpt = CompteDAO.getWithMail(Main.getMail());	
				//METS A JOUR LES INFOS POUR ETRE EN RACCORD AVEC LE COMPTE CONNECTE 
				EditParticipant.showUpdateProfile(cpt.getId());
			}
		});
		btnSeeProfil.setBounds(200, 217, 314, 39);
		btnSeeProfil.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		//AJOUT DU BOUTON <<COMPLETER UN PROFIL>>
		btnCompleteProfil = new JButton("COMPLETER UN PROFIL");		
		btnCompleteProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(3, 0);
				Compte cpt = new Compte();
				cpt = CompteDAO.getWithMail(Main.getMail());	
				EditParticipant.showUpdateProfile(cpt.getId());
			}
		});
		btnCompleteProfil.setBounds(200, 266, 314, 39);
		btnCompleteProfil.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		//AJOUT DU BOUTON <<INSERER UNE FICHE DESCRIPTIVE>>
		InsertDescriptionSheet = new JButton("INSERER UNE FICHE DESCRIPTIVE");		
		InsertDescriptionSheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(5, 0);
			}
		});
		InsertDescriptionSheet.setBounds(200, 315, 314, 39);
		InsertDescriptionSheet.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		//AJOUT DU BOUTON <<MODIFIER UNE FICHE DESCRIPTIVE>>
		ModifyDescriptionSheet = new JButton("MODIFIER UNE FICHE DESCRIPTIVE");		
		ModifyDescriptionSheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DescriptionSheet.showUpdateProfile();
				change(5, 1);
			}
		});
		ModifyDescriptionSheet.setBounds(200, 364, 314, 39);
		ModifyDescriptionSheet.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		//EMPECHE L'ACCES AU MENU CONSULTER LE PROFIL
		btnSeeProfil.setEnabled(false);
		
		//AJOUT DES ELEMENTS GRAPHIQUES
		setLayout(null);
		add(lblEsigelec);
		add(lblArmada);
		add(btnSeeProfil);
		add(btnModifyParcipant);
		add(btnCompleteProfil);
		add(btnDeleteParticipant);
		add(InsertDescriptionSheet);
		add(btnSeeAProfil);
		add(ModifyDescriptionSheet);
		add(btnInscriptionManagment);
		add(btnAssignLocation);
		add(btnReturn);
		add(btnAddParticipant);
	}

	/**
	 * Permet de bloquer l'accès à des boutons en fonctions des différentes infos obtenues
	 */
	protected static void block() {
		Participant part = new Participant(); 
		Compte cpt = new Compte(); 
		cpt = CompteDAO.getWithMail(Main.getMail());
		part=ParticipantDAO.get(cpt.getId());
		//VERIFIE SI LE PARTICIPANT EST AU MOINS ASSOCIE A UN TYPE
		if (part.getIdBoat()!=0 || part.getIdRetailer()!=0 || part.getIdPersonneMorale()!=0  || part.getIdDelegation() != 0  || part.getIdEntreprise() != 0  || part.getIdFamille()!=0  || part.getIdPlaisancier()!=0) {
			btnSeeProfil.setEnabled(true);
			btnCompleteProfil.setEnabled(false);
		} else {
			btnSeeProfil.setEnabled(false);
			btnCompleteProfil.setEnabled(true);
		}
		System.out.println(part.getIdFiche());
		if (part.getIdFiche()==0) {
			InsertDescriptionSheet.setEnabled(true);
			ModifyDescriptionSheet.setEnabled(false);
		} else {
			InsertDescriptionSheet.setEnabled(false);
			ModifyDescriptionSheet.setEnabled(true);
		}
	}
	
	/**
	 * Permet de faire appel aux passerelles(dans le fichier Main) pour changer de page
	 * @param i
	 * @param j
	 */
	protected void change(int i, int j) {
		if (i==1)
			Main.menuToWel();	
		if (i==2) {
			Main.menuToFp();
			FindParticipant.changeIndex(j);
			EditParticipant.changeIndex(j);
		}		
		if (i==3) {
			Main.menuToMp();
			//REND LES CASES NON MODIFIABLES
			EditParticipant.changeIndex(j);
		}
		if (i==4)	//AJOUT D'UN COMPTE
			Main.menuToAdd();
		if (i==5)
			Main.menuToDs();
		if (i==6) {
			Main.menuToFp();
			FindParticipant.changeIndex(j);
		}
	}
	
	/**
	 * Supprime les boutons d'un compte non admin
	 */
	protected static void admin() {
		InsertDescriptionSheet.setVisible(false);
		ModifyDescriptionSheet.setVisible(false);
		btnSeeProfil.setVisible(false);
		btnCompleteProfil.setVisible(false);
		btnAddParticipant.setVisible(true);
		btnModifyParcipant.setVisible(true);
		btnSeeAProfil.setVisible(true);
		btnDeleteParticipant.setVisible(true);
		btnInscriptionManagment.setVisible(true);
		btnAssignLocation.setVisible(true);
	}

	/**
	 * Supprime les boutons d'un compte non participant
	 */
	protected static void participant() {
		InsertDescriptionSheet.setVisible(true);
		ModifyDescriptionSheet.setVisible(true);
		btnSeeProfil.setVisible(true);
		btnCompleteProfil.setVisible(true);
		btnAddParticipant.setVisible(false);
		btnModifyParcipant.setVisible(false);
		btnSeeAProfil.setVisible(false);
		btnDeleteParticipant.setVisible(false);
		btnInscriptionManagment.setVisible(false);
		btnAssignLocation.setVisible(false);
	}

}
