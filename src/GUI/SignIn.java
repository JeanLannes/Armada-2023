package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import dao.InscriptionDAO;
import model.Inscription;

@SuppressWarnings("serial")
public class SignIn extends JPanel {
	private JTextField tfActivity;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfMail;
	private String activitySI;
	private String lastNameSI;
	private String firstNameSI;
	private String mailSI;
	
	/**
	 * Genere une page d'inscription
	 */
	public SignIn() {
		this.setLayout(null);
		
		//AJOUT DU BOUTON <<VALIDER>>
		JButton btnAccept = new JButton("VALIDER");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Recuperation des infos dans les zones de texte
				activitySI = tfActivity.getText();
				lastNameSI = tfLastName.getText();
				firstNameSI = tfFirstName.getText();
				mailSI = tfMail.getText();
				
				if (verifytf()) {
					Inscription ins = new Inscription(InscriptionDAO.getMaxID()+1, firstNameSI, lastNameSI, mailSI, activitySI);
					InscriptionDAO.add(ins); // Ajout d'une nouvelle inscription dans la BDD
					accepted(); // Message de validation
					change(1); // Retour a la page d'accueil
				}
			}
		});
		btnAccept.setBounds(200, 505, 200, 51);
		btnAccept.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		
		//AJOUT DU BOUTON <<RETOUR>>
		JButton btnReturn = new JButton("RETOUR");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(1);
			}
		});
		btnReturn.setBounds(666, 505, 200, 51);
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		
		//AJOUT DU TEXTE NOM
		JLabel lblLastName = new JLabel("NOM :");
		lblLastName.setBounds(193, 239, 95, 38);
		lblLastName.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		
		//AJOUT DU TEXTE PRENOM
		JLabel lblFirstName = new JLabel("PRENOM :");
		lblFirstName.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblFirstName.setBounds(500, 239, 139, 38);
		
		//AJOUT DU TEXTE ACTIVITE
		JLabel lblActivity = new JLabel("ACTIVITE :");
		lblActivity.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblActivity.setBounds(500, 306, 163, 38);
		
		//AJOUT DU TEXTE MAIL
		JLabel lblMail = new JLabel("MAIL :");
		lblMail.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblMail.setBounds(193, 306, 95, 38);
		add(lblMail);
		
		//AJOUT DU TEXTE ESIGELEC
		JLabel lblEsigelec = new JLabel("ESIGELEC");
		lblEsigelec.setBounds(200, 100, 147, 67);
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		//AJOUT DU TEXTE ARMADA
		JLabel lblArmada = new JLabel("ARMADA 2023");
		lblArmada.setBounds(657, 100, 207, 67);
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		
		//AJOUT DU CHAMP DE TEXTE ACTIVITE
		tfActivity = new JTextField();
		tfActivity.setColumns(10);
		tfActivity.setBounds(666, 308, 200, 50);
	
		//AJOUT DU CHAMP DE TEXTE PRENOM
		tfFirstName = new JTextField();
		tfFirstName.setColumns(10);
		tfFirstName.setBounds(666, 239, 200, 50);
		
		//AJOUT DU CHAMP DE TEXTE NOM
		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		tfLastName.setBounds(287, 239, 200, 50);
		
		//AJOUT DU CHAMP DE TEXTE MAIL
		tfMail = new JTextField();
		tfMail.setColumns(10);
		tfMail.setBounds(287, 306, 200, 50);

		//AJOUT DES ELEMENTS GRAPHIQUES
		add(btnAccept);
		add(btnReturn);
		add(lblLastName);
		add(lblFirstName);
		add(lblActivity);
		add(lblEsigelec);
		add(lblArmada);
		add(tfActivity);
		add(tfFirstName);
		add(tfLastName);
		add(tfMail);
	}

	/**
	 * Verifie si tout les champs sont remplis
	 * @return boolean 
	 */
	protected boolean verifytf() {
        if (!activitySI.isEmpty() && !lastNameSI.isEmpty() && !firstNameSI.isEmpty() & !mailSI.isEmpty())
        	return true;
        JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.");
        return false;
	}
	
	/**
	 * Affiche un message de confirmation dans le cas ou la demande d'inscription a été ajoutée à la BDD
	 */
	protected void accepted() {
        JOptionPane.showMessageDialog(this, "Votre demande d'inscription a bien été prise en compte.\nNous reviendrons vers vous au plus vite.");
	}
	
	/**
	 * Permet de faire appel aux passerelles(dans le fichier Main) pour changer de page
	 */
	protected void change(int i) {
		if (i==1)
			Main.siToWel();
	}
}
