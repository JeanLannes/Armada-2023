package GUI;

import java.awt.Font;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JPanel {
	
	public Menu() {
		this.setLayout(null);
		
		JLabel lblEsigelec = new JLabel("ESIGELEC");
		lblEsigelec.setBounds(200, 100, 147, 67);
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		JLabel lblArmada = new JLabel("ARMADA 2023");
		lblArmada.setBounds(657, 100, 207, 67);
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		JButton btnModifyParcipant = new JButton("MODIFIER UN PARTICIPANT");
		btnModifyParcipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(2, 1);
			}
		});
		btnModifyParcipant.setBounds(200, 266, 664, 39);
		btnModifyParcipant.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		JButton btnDeleteParticipant = new JButton("SUPPRIMER UN PARTICIPANT");
		btnDeleteParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(2, 2);
			}
		});
		btnDeleteParticipant.setBounds(200, 315, 664, 39);
		btnDeleteParticipant.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		JButton btnEditParticipant = new JButton("EDITER UN PARTICIPANT");
		btnEditParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(2, 3);
			}
		});
		btnEditParticipant.setBounds(200, 364, 664, 39);
		btnEditParticipant.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		JButton btnInscriptionManagment = new JButton("GERER LES INSCRIPTIONS");
		btnInscriptionManagment.setBounds(200, 413, 664, 39);
		btnInscriptionManagment.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		JButton btnAssignLocation  = new JButton("ATTRIBUER UN EMPLACEMENT");
		btnAssignLocation.setBounds(200, 462, 664, 39);
		btnAssignLocation.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		JButton btnReturn = new JButton("RETOUR");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(1, 0);
			}
		});
		btnReturn.setBounds(430, 530, 200, 51);
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
	
		add(lblEsigelec);
		add(lblArmada);
		add(btnModifyParcipant);
		add(btnDeleteParticipant);
		add(btnEditParticipant);
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
	 * Détermine si la personne qui s'inscrit est admin ou un participant
	 */
	protected void detectType() {

	}
	
	/*
	 * Restreint l'accès à différentes parties du menu en fonction du type de personne (admin/participant) 
	 */
	protected void restriction() {

	}
	
	
	
}
