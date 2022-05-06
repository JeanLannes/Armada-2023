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

public class Bateau extends JPanel {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	public Bateau() {
		setLayout(null);

		JLabel lblArmada = new JLabel("ARMADA 2023");	//AJOUT DU LOGO ARMADA2023
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblArmada.setBounds(657, 100, 209, 67);
		
		JLabel lblEsigelec = new JLabel("ESIGELEC");	//AJOUT DU LOGO ESIGELEC
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblEsigelec.setBounds(200, 100, 147, 67);
		
		JLabel lblActivity = new JLabel("PAVILLON :");	//AJOUT DU TEXTE MDP
		lblActivity.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblActivity.setBounds(200, 322, 161, 67);
		
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
		textField.setBounds(400, 327, 466, 50);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(400, 392, 466, 50);
		add(textField_1);
		
		JLabel lblImmatriculation = new JLabel("CAPITAINE :");
		lblImmatriculation.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblImmatriculation.setBounds(200, 387, 180, 67);
		add(lblImmatriculation);
		
		JLabel lblNom = new JLabel("NOM :");
		lblNom.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblNom.setBounds(200, 188, 156, 67);
		add(lblNom);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(366, 193, 180, 50);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(366, 258, 180, 50);
		add(textField_3);
		
		JLabel lblTaille = new JLabel("TAILLE :");
		lblTaille.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblTaille.setBounds(200, 253, 156, 67);
		add(lblTaille);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(686, 258, 180, 50);
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(686, 193, 180, 50);
		add(textField_5);
		
		JLabel lblType = new JLabel("TYPE :");
		lblType.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblType.setBounds(558, 188, 102, 67);
		add(lblType);
		
		JLabel lblDate = new JLabel("DATE :");
		lblDate.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblDate.setBounds(556, 250, 122, 67);
		add(lblDate);
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
		Main.batToMp();
	}
}
