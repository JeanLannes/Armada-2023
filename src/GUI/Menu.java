package GUI;

import java.awt.Font;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Menu extends JPanel {
	
	public Menu() {
		
		JLabel lblEsigelec = new JLabel("ESIGELEC");
		lblEsigelec.setBounds(216, 100, 147, 67);
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		JLabel lblArmada = new JLabel("ARMADA 2023");
		lblArmada.setBounds(673, 100, 207, 67);
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		JButton btnModifyParcipant = new JButton("MODIFIER UN PARTICIPANT");
		btnModifyParcipant.setBounds(532, 266, 348, 39);
		btnModifyParcipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(2, 1);
			}
		});
		btnModifyParcipant.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		JButton btnDeleteParticipant = new JButton("SUPPRIMER UN PARTICIPANT");
		btnDeleteParticipant.setBounds(532, 315, 348, 39);
		btnDeleteParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(2, 2);
			}
		});
		btnDeleteParticipant.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		JButton btnSeeAProfil = new JButton("CONSULTER UN PROFIL");
		btnSeeAProfil.setBounds(530, 364, 350, 39);
		btnSeeAProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(2, 3);
			}
		});
		btnSeeAProfil.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		JButton btnInscriptionManagment = new JButton("GERER LES INSCRIPTIONS");
		btnInscriptionManagment.setBounds(530, 413, 350, 39);
		btnInscriptionManagment.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		JButton btnAssignLocation  = new JButton("ATTRIBUER UN EMPLACEMENT");
		btnAssignLocation.setBounds(530, 462, 350, 39);
		btnAssignLocation.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		JButton btnReturn = new JButton("RETOUR");
		btnReturn.setBounds(430, 530, 200, 51);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(1, 0);
			}
		});
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		
		JButton btnSeeProfil = new JButton("CONSULTER SON PROFIL");
		btnSeeProfil.setBounds(200, 266, 314, 39);
		btnSeeProfil.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		JButton btnCompleteProfil = new JButton("COMPLETER UN PROFIL");
		btnCompleteProfil.setBounds(200, 315, 314, 39);
		btnCompleteProfil.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		JButton requestPass = new JButton("FAIRE UNE DEMANDE DE LAISSEZ-PASSER");
		requestPass.setBounds(198, 364, 314, 39);
		requestPass.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		JButton consultPass = new JButton("CONSULTER UNE DEMANDE");
		consultPass.setBounds(198, 413, 314, 39);
		consultPass.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		setLayout(null);
		add(lblEsigelec);
		add(lblArmada);
		add(btnSeeProfil);
		add(btnModifyParcipant);
		add(btnCompleteProfil);
		add(btnDeleteParticipant);
		add(requestPass);
		add(btnSeeAProfil);
		add(consultPass);
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
			ModifyParticipant.changeIndex(j);
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
}
