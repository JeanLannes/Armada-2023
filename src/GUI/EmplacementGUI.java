package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.BoatDAO;
import dao.CompteDAO;
import dao.EmplacementDAO;
import dao.ParticipantDAO;
import model.Boat;
import model.Compte;
import model.Emplacement;
import model.Participant;

import javax.swing.JCheckBox;

public class EmplacementGUI extends JPanel {
	private static JTextField tfEmplacement;
	private static JTextField tfLengh;
	private static JCheckBox boxG;
	private static JCheckBox boxD;
	private static int index=0;
	
	public EmplacementGUI() {
		setLayout(null);
		
		//LOGO ESIGELEC
		JLabel lblEsigelec = new JLabel("ESIGELEC");
		lblEsigelec.setBounds(200, 100, 147, 67);
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		//LOGO ARMADA
		JLabel lblArmada = new JLabel("ARMADA 2023");
		lblArmada.setBounds(657, 100, 207, 67);
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		//AJOUT DU TEXTE EMPLACEMENT
		JLabel lblEmplacement = new JLabel("EMPLACEMENT :");	
		lblEmplacement.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblEmplacement.setBounds(200, 296, 231, 67);
		
		//AJOUT DU BOUTON <<VALIDER>>
		JButton btnAdd = new JButton("VALIDER");		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (verifytf()) {
					if(index==1) {
						Emplacement emp;
						if(boxG.isSelected())
							emp = new Emplacement(EmplacementDAO.getMaxID()+1, tfEmplacement.getText(),"Gauche", tfLengh.getText());
						else 
							emp = new Emplacement(EmplacementDAO.getMaxID()+1, tfEmplacement.getText(),"Droite", tfLengh.getText());
						EmplacementDAO.add(emp);
						Compte cpt = new Compte();
						cpt=CompteDAO.getWithMail(FindParticipant.getMail());
						Participant part = new Participant();
						part=ParticipantDAO.setConnexion(cpt.getId(),6, EmplacementDAO.getMaxID());
						JOptionPane.showMessageDialog(btnAdd, "SUCCES : L'emplacement a bien été attribué.");
					}
					change(1);
				}
			}
		});
		btnAdd.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnAdd.setBounds(200, 505, 286, 50);
		
		//AJOUT DU BOUTON <<RETOUR>>
		JButton btnReturn = new JButton("RETOUR");	
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(0);
			}
		});
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnReturn.setBounds(580, 505, 286, 51);
		
		//AJOUT DU CHAMP DE TEXTE EMPLACEMENT
		tfEmplacement = new JTextField();
		tfEmplacement.setColumns(10);
		tfEmplacement.setBounds(441, 301, 425, 50);

		// AJOUT DE TOUS LES ELEMENTS GRAPHIQUES AU PANEL 
		add(lblArmada);
		add(lblEsigelec);
		add(lblEmplacement);
		add(btnAdd);
		add(btnReturn);
		add(tfEmplacement);
		
		JLabel lblTaille = new JLabel("TAILLE :");
		lblTaille.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblTaille.setBounds(198, 361, 119, 67);
		add(lblTaille);
		
		tfLengh = new JTextField();
		tfLengh.setColumns(10);
		tfLengh.setBounds(327, 366, 207, 50);
		add(tfLengh);
		
		JLabel lblRive = new JLabel("Rive :");
		lblRive.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblRive.setBounds(607, 361, 93, 67);
		add(lblRive);
		
		boxG = new JCheckBox("G");
		boxG.setFont(new Font("Tahoma", Font.PLAIN, 32));
		boxG.setBounds(709, 374, 58, 37);
		add(boxG);
		
		boxD = new JCheckBox("D");
		boxD.setFont(new Font("Tahoma", Font.PLAIN, 32));
		boxD.setBounds(783, 374, 58, 37);
		add(boxD);
	}

	/**
	 * Verifie si tout les champs sont remplis 
	 * @return boolean
	 */
	protected boolean verifytf() {
		String emplacement=tfEmplacement.getText();
		String lengh=tfLengh.getText();
        if(!emplacement.isEmpty() && !lengh.isEmpty()) {
        	if(boxG.isSelected() && boxD.isSelected()) {
        		JOptionPane.showMessageDialog(this, "Veuillez ne sélectionner qu'une seule rive.");
        		return false;
        	}
        	return true;
        }
        else {
        	JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.");
        	return false;
        }
	}
	
	/**
	 * Permet de faire appel aux passerelles(dans le fichier Main) pour changer de page
	 * @param int i Indice permetant de choisir la page a afficher
	 */
	protected void change(int i) {
		if (i==0)
			Main.empToFp();
		else if (i==1)
			Main.empToMenu();
	}

	public static void showUpdateProfile(int id) {
		if (ParticipantDAO.getIdEmplacement(id)!=0) {	//CAS OU LE PARTICIPANT POSSEDE DEJA UN EMPLACEMENT
			index=0;
			blockEmplacement();
			//AJOUT DE L'OBJET EMPLACEMENT 
			Emplacement emp = new Emplacement();
			emp=EmplacementDAO.get(id);
			//IMPORTATION DES DONNEES 
			tfEmplacement.setText(emp.getName());
			tfLengh.setText(emp.getLengh());
			if(emp.getRive().equals("Gauche")) {
				boxG.setSelected(true);
				boxD.setSelected(false);
			}
			else{
				boxD.setSelected(true);
				boxG.setSelected(false);
			}
		}
		else {	//MODE AJOUTER
			index=1;
			unblockEmplacement();
		}
	}
	
	/**
	 * Permet de bloquer les champs de texte
	 */
	public static void blockEmplacement() {
		tfEmplacement.setEditable(false);
		tfLengh.setEditable(false);
		boxG.setFocusable(false);
		boxD.setFocusable(false);
	}
	
	/**
	 * Permet de débloquer les champs de texte
	 */
	public static void unblockEmplacement() {
		tfEmplacement.setEditable(true);
		tfLengh.setEditable(true);
		boxG.setFocusable(true);
		boxD.setFocusable(true);
	}
}
