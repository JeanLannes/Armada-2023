package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.CompteDAO;
import dao.PersonneDAO;
import model.Compte;
import model.Personne;

@SuppressWarnings("serial")
public class AddParticipant extends JPanel {

	private JPasswordField tfPassword;
	private JTextField tfId;
	private String userText;
	private String pwdText;

	public AddParticipant() {
		this.setLayout(null);
		
		JLabel lblArmada = new JLabel("ARMADA 2023");	//AJOUT DU LOGO ARMADA2023
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblArmada.setBounds(657, 100, 209, 67);
		
		JLabel lblEsigelec = new JLabel("ESIGELEC");	//AJOUT DU LOGO ESIGELEC
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblEsigelec.setBounds(200, 100, 147, 67);
		
		JLabel lblId = new JLabel("MAIL :");	//AJOUT DU TEXTE MAIL
		lblId.setBounds(200, 239, 100, 67);
		lblId.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		
		JLabel lblPassword = new JLabel("MDP :");	//AJOUT DU TEXTE MDP
		lblPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblPassword.setBounds(206, 326, 96, 67);
		
		JButton btnAdd = new JButton("CREER");		//AJOUT DU BOUTON <<CREER>>
		btnAdd.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
	            userText = tfId.getText();
	            pwdText = tfPassword.getText();
	            Compte cpt=null;
	            Personne per=null;
	            if (verifytf()) {	//ASSURE QUE TOUS LES CHAMPS SONT OCCUPES
	            	cpt = new Compte(CompteDAO.getMaxID()+1,pwdText,userText);
	            	per = new Personne();
	            	per.setId(CompteDAO.getMaxID()+1);
		            if (CompteDAO.add(cpt)!=2) {	// AJOUTE LE COMPTE DANS LA BDD
		            	PersonneDAO.add(per);
		            	change();
		            }
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
		
		tfPassword = new JPasswordField();	//AJOUT DE LA ZONE DE TEXTE RELATIVE AU MAIL
		tfPassword.setBounds(306, 326, 560, 50);
		tfPassword.setColumns(10);
		
		tfId = new JTextField();	//AJOUT DE LA ZONE DE TEXTE RELATIVE AU MDP
		tfId.setBounds(306, 239, 560, 50);
		tfId.setColumns(10);

		// AJOUT DE TOUS LES ELEMENTS GRAPHIQUES AU PANEL 
		add(lblArmada);
		add(lblEsigelec);
		add(lblId);
		add(lblPassword);
		add(btnAdd);
		add(btnReturn);
		add(tfPassword);
		add(tfId);
	}
	
	/**
	 * Affiche un message d'erreur si l'id et/ou le mdp sont incorrects
	 */
	protected void reject() {
		JOptionPane.showMessageDialog(this, "ID ou MDP incorrect.");
	}

	/**
	 * Verifie si tout les champs sont remplis 
	 * @return boolean
	 */
	protected boolean verifytf() {
        if (!userText.isEmpty() && !pwdText.isEmpty())
        	return true;
        JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.");
        return false;
	}
	
	/**
	 * Permet de faire appel aux passerelles(dans le fichier Main) pour changer de page
	 * @param int i Indice permetant de choisir la page a afficher
	 */
	protected void change() {
		Main.addToMenu();
	}
}
