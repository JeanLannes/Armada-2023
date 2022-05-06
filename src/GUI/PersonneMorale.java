package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Compte;
import model.Personne;
import javax.swing.JCheckBox;

public class PersonneMorale extends JPanel {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public PersonneMorale() {
	setLayout(null);

	JLabel lblArmada = new JLabel("ARMADA 2023");	//AJOUT DU LOGO ARMADA2023
	lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
	lblArmada.setBounds(657, 100, 209, 67);
	
	JLabel lblEsigelec = new JLabel("ESIGELEC");	//AJOUT DU LOGO ESIGELEC
	lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
	lblEsigelec.setBounds(200, 100, 147, 67);
	
	JLabel lblActivity = new JLabel("DATE :");	//AJOUT DU TEXTE MDP
	lblActivity.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
	lblActivity.setBounds(200, 327, 156, 67);
	
	JButton btnAdd = new JButton("CREER");		//AJOUT DU BOUTON <<CREER>>
	btnAdd.addActionListener(new ActionListener() {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
            Compte cpt=null;
            Personne per=null;
            if (verifytf()) {	//ASSURE QUE TOUS LES CHAMPS SONT OCCUPES

            	// A MODIFIER + CONNECTION BDD
	        
            }
		}
	});
	
	btnAdd.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
	btnAdd.setBounds(200, 505, 286, 50);
	
	JButton btnReturn = new JButton("RETOUR");	//AJOUT DU BOUTON SE <<RETOUR>>
	btnReturn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			change();
		}
	});
	btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
	btnReturn.setBounds(580, 505, 286, 51);
	

	// AJOUT DE TOUS LES ELEMENTS GRAPHIQUES AU PANEL 
	add(lblArmada);
	add(lblEsigelec);
	add(lblActivity);
	add(btnAdd);
	add(btnReturn);
	
	textField = new JTextField();
	textField.setBounds(366, 332, 500, 50);
	add(textField);
	textField.setColumns(10);
	
	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(366, 397, 500, 50);
	add(textField_1);
	
	JLabel lblImmatriculation = new JLabel("MAIL : ");
	lblImmatriculation.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
	lblImmatriculation.setBounds(200, 392, 306, 67);
	add(lblImmatriculation);
	
	textField_2 = new JTextField();
	textField_2.setColumns(10);
	textField_2.setBounds(366, 203, 209, 50);
	add(textField_2);
	
	textField_3 = new JTextField();
	textField_3.setColumns(10);
	textField_3.setBounds(366, 268, 500, 50);
	add(textField_3);
	
	JLabel lblPrenom = new JLabel("PRENOM :");
	lblPrenom.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
	lblPrenom.setBounds(200, 263, 306, 67);
	add(lblPrenom);
	
	JLabel lblNom = new JLabel("NOM :");
	lblNom.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
	lblNom.setBounds(200, 198, 156, 67);
	add(lblNom);
	
	JLabel lblSexe = new JLabel("SEXE :");
	lblSexe.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
	lblSexe.setBounds(616, 198, 93, 67);
	add(lblSexe);
	
	JCheckBox chckbxNewCheckBox = new JCheckBox("H");
	chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 22));
	chckbxNewCheckBox.setBounds(728, 217, 42, 36);
	add(chckbxNewCheckBox);
	
	JCheckBox chckbxF = new JCheckBox("F");
	chckbxF.setFont(new Font("Tahoma", Font.PLAIN, 22));
	chckbxF.setBounds(787, 217, 42, 36);
	add(chckbxF);
}

	/**
	 * Verifie si tout les champs sont remplis 
	 * @return boolean
	 */
	protected boolean verifytf() {
	    return true;
	}
	
	/**
	 * Permet de faire appel aux passerelles(dans le fichier Main) pour changer de page
	 * @param int i Indice permetant de choisir la page a afficher
	 */
	protected void change() {
		Main.pmToMp();
	}
}
