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
import dao.OrganisateurDAO;
import model.Compte;
import model.Organisateur;

@SuppressWarnings("serial")
public class Welcoming extends JPanel {

	private JPasswordField tfPassword;
	private JTextField tfId;
	private String userText;
	private String pwdText;

	public Welcoming() {
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
		
		JButton btnLogIn = new JButton("SE CONNECTER");		//AJOUT DU BOUTON <<SE CONNECTER>>
		btnLogIn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
	            userText = tfId.getText();
	            pwdText = tfPassword.getText();
	            Compte cpt=null;
	            Organisateur org=null;
	            int test=0;
	            if (verifytf()) {	//ASSURE QUE TOUS LES CHAMPS SONT OCCUPES
		            cpt=CompteDAO.SignIn(userText, pwdText);	// RECUPERE LE COMPTE S'IL EXISTE DANS LA BDD
		            org=OrganisateurDAO.SignIn(userText, pwdText);	
	            	Main.setMail(userText);
		            if (cpt != null) {
		            	change(1);	//AFFICHE LE MENU
		            	Menu.participant(); 	//RESTREINT LE MENU A CELUI D'UN COMPTE PARTICIPANT
			            test++;
		            } else if (org != null) {
		            	change(1);	//AFFICHE LE MENU
		            	Menu.admin(); 	//RESTREINT LE MENU A CELUI D'UN COMPTE ORGANISATEUR
			            test++;
		            } 
		            if (test==0) {
		            	reject();
		            }
	            }
			}
		});
		
		btnLogIn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnLogIn.setBounds(200, 505, 200, 50);
		
		JButton btnLeave = new JButton("QUITTER");	//AJOUT DU BOUTON SE <<QUITTER>>
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLeave.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnLeave.setBounds(666, 505, 200, 51);
		
		JButton btnSignIn = new JButton("S'INSCRIRE");	//AJOUT DU BOUTON SE <<S'INSCRIRE>>
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(2);
			}
		});
		btnSignIn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnSignIn.setBounds(433, 505, 200, 51);
		
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
		add(btnLogIn);
		add(btnLeave);
		add(btnSignIn);
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
	protected void change(int i) {
		if (i==1)
			Main.welToMenu();
		if (i==2)
			Main.welToSi();
	}
}
