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
import dao.ParticipantDAO;
import dao.PersonneDAO;
import model.Compte;
import model.Participant;
import model.Personne;

@SuppressWarnings("serial")
public class AddParticipantGUI extends JPanel {

	private JPasswordField tfPassword;
	private JTextField tfId;
	private String userText;
	private String pwdText;

	public AddParticipantGUI() {
		this.setLayout(null);
		
		//AJOUT DU LOGO ARMADA2023
		JLabel lblArmada = new JLabel("ARMADA 2023");	
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblArmada.setBounds(657, 100, 209, 67);
		
		//AJOUT DU LOGO ESIGELEC
		JLabel lblEsigelec = new JLabel("ESIGELEC");	
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblEsigelec.setBounds(200, 100, 147, 67);
		
		//AJOUT DU TEXTE MAIL
		JLabel lblId = new JLabel("MAIL :");
		lblId.setBounds(200, 239, 100, 67);
		lblId.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		
		//AJOUT DU TEXTE MDP
		JLabel lblPassword = new JLabel("MDP :");	
		lblPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblPassword.setBounds(206, 326, 96, 67);
		
		//AJOUT DU BOUTON <<CREER>>
		JButton btnAdd = new JButton("CREER");		
		btnAdd.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
	            userText = tfId.getText();
	            pwdText = tfPassword.getText();
	            Compte cpt=null;
	            Personne per=null;
	            Participant part=null;
	            if (verifytf()) {	//ASSURE QUE TOUS LES CHAMPS SONT OCCUPES
	            	cpt = new Compte(CompteDAO.getMaxID()+1,pwdText,userText);	            	
	            	per = new Personne(0,"0","0","0","1/1/01");
	            	per.setId(cpt.getId());
	            	part = new Participant(cpt.getId());
	            	part.setProfil("0");
		            if (CompteDAO.add(cpt)!=2) {	// AJOUTE LE COMPTE DANS LA BDD
		            	PersonneDAO.add(per);
		            	ParticipantDAO.add(part);
		            	JOptionPane.showMessageDialog(tfPassword, "SUCCES : Le compte a été crée.");
		            	change();
		            }
	            }
			}
		});
		btnAdd.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnAdd.setBounds(200, 505, 286, 50);
		
		//AJOUT DU BOUTON SE <<RETOUR>>
		JButton btnReturn = new JButton("RETOUR");	
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change();
			}
		});
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnReturn.setBounds(580, 505, 286, 51);
		
		//AJOUT DE LA ZONE DE TEXTE RELATIVE AU MAIL
		tfPassword = new JPasswordField();
		tfPassword.setBounds(306, 326, 560, 50);
		tfPassword.setColumns(10);
		
		//AJOUT DE LA ZONE DE TEXTE RELATIVE AU MDP
		tfId = new JTextField();
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
