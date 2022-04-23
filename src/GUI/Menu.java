package GUI;

import java.awt.Font;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Menu extends JPanel {
	JButton btnModifyParcipant;
	JButton btnDeleteParticipant;
	JButton btnSeeAProfil;
	JButton btnInscriptionManagment;
	JButton btnAssignLocation;
	JButton btnReturn;
	JButton btnSeeProfil;
	JButton btnCompleteProfil;
	JButton modifyDescriptionSheet;
	JButton insertDescriptionSheet;
	JButton btnAddParticipant;
	public Menu() {
		
		JLabel lblEsigelec = new JLabel("ESIGELEC");
		lblEsigelec.setBounds(216, 100, 147, 67);
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		JLabel lblArmada = new JLabel("ARMADA 2023");
		lblArmada.setBounds(673, 100, 207, 67);
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		btnAddParticipant = new JButton("AJOUTER UN PARTICIPANT");
		btnAddParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(3, 0);
			}
		});

		btnModifyParcipant = new JButton("MODIFIER UN PARTICIPANT");
		btnModifyParcipant.setBounds(532, 266, 348, 39);
		btnModifyParcipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(2, 1);
			}
		});
		btnModifyParcipant.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		btnDeleteParticipant = new JButton("SUPPRIMER UN PARTICIPANT");
		btnDeleteParticipant.setBounds(532, 315, 348, 39);
		btnDeleteParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(2, 2);
			}
		});
		btnDeleteParticipant.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		btnSeeAProfil = new JButton("CONSULTER UN PROFIL");
		btnSeeAProfil.setBounds(530, 364, 350, 39);
		btnSeeAProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(2, 3);
			}
		});
		btnSeeAProfil.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		btnInscriptionManagment = new JButton("GERER LES INSCRIPTIONS");
		btnInscriptionManagment.setBounds(530, 413, 350, 39);
		btnInscriptionManagment.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		btnAssignLocation  = new JButton("ATTRIBUER UN EMPLACEMENT");
		btnAssignLocation.setBounds(530, 462, 350, 39);
		btnAssignLocation.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		btnReturn = new JButton("RETOUR");
		btnReturn.setBounds(430, 530, 200, 51);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(1, 0);
			}
		});
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		
		btnSeeProfil = new JButton("CONSULTER SON PROFIL");
		btnSeeProfil.setBounds(200, 217, 314, 39);
		btnSeeProfil.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		btnCompleteProfil = new JButton("COMPLETER UN PROFIL");
		btnCompleteProfil.setBounds(200, 266, 314, 39);
		btnCompleteProfil.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		modifyDescriptionSheet = new JButton("INSERER UNE FICHE DESCRIPTIVE");
		modifyDescriptionSheet.setBounds(200, 315, 314, 39);
		modifyDescriptionSheet.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		insertDescriptionSheet = new JButton("MODIFIER UNE FICHE DESCRIPTIVE");
		insertDescriptionSheet.setBounds(200, 364, 314, 39);
		insertDescriptionSheet.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			
		btnAddParticipant.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnAddParticipant.setBounds(532, 217, 348, 39);
		add(btnAddParticipant);

		setLayout(null);
		add(lblEsigelec);
		add(lblArmada);
		add(btnSeeProfil);
		add(btnModifyParcipant);
		add(btnCompleteProfil);
		add(btnDeleteParticipant);
		add(modifyDescriptionSheet);
		add(btnSeeAProfil);
		add(insertDescriptionSheet);
		add(btnInscriptionManagment);
		add(btnAssignLocation);
		add(btnReturn);

	}

		/*
		 * Permet de faire appel aux passerelles(dans le fichier Main) pour changer de page
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
			EditParticipant.changeIndex(j);
		}
	}
	
	/*
	 * 			Détermine si la personne qui s'est connecté est admin ou un participant
	 * 						/!\ ICI IL FAUT SE CONNECTER A LA BDD 
	 * 			Cette fonction est importante car l'ensemble des pages qui suivent dépendent de cette distinction
	 */
	protected void detectType() {

	}
	
	/*
	 * Restreint l'accès à différentes parties du menu en fonction du type de personne (admin/participant) 
	 * en supprimant les admin dans le cas ou non l'utlisiteur n'est pas un admin
	 */
	protected void restriction() {

	}
	
	/*
	 * Supprime les boutons d'un compte non admin
	 */
	protected void admin() {
		modifyDescriptionSheet.setVisible(false);
		insertDescriptionSheet.setVisible(false);
		btnSeeProfil.setVisible(false);
		btnCompleteProfil.setVisible(false);
		btnAddParticipant.setVisible(true);
		btnModifyParcipant.setVisible(true);
		btnSeeAProfil.setVisible(true);
		btnDeleteParticipant.setVisible(true);
		btnInscriptionManagment.setVisible(true);
		btnAssignLocation.setVisible(true);
	}

	/*
	 * Supprime les boutons d'un compte non participant
	 */
	protected void participant() {
		modifyDescriptionSheet.setVisible(true);
		insertDescriptionSheet.setVisible(true);
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
