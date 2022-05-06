package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Compte;
import model.Personne;
import javax.swing.JTextField;

public class Entreprise extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public Entreprise() {
		setLayout(null);

		JLabel lblArmada = new JLabel("ARMADA 2023");	//AJOUT DU LOGO ARMADA2023
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblArmada.setBounds(657, 100, 209, 67);
		
		JLabel lblEsigelec = new JLabel("ESIGELEC");	//AJOUT DU LOGO ESIGELEC
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblEsigelec.setBounds(200, 100, 147, 67);
		
		JLabel lblCountry = new JLabel("NOM :");	//AJOUT DU TEXTE MDP
		lblCountry.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblCountry.setBounds(400, 296, 86, 67);
		
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
		add(lblCountry);
		add(btnAdd);
		add(btnReturn);
		
		textField = new JTextField();
		textField.setBounds(506, 301, 360, 50);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(506, 366, 360, 50);
		add(textField_1);
		
		JLabel lblImmatriculation = new JLabel("IMMATRICULATION :");
		lblImmatriculation.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblImmatriculation.setBounds(200, 361, 286, 67);
		add(lblImmatriculation);
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
		Main.addToMenu();
	}
}
