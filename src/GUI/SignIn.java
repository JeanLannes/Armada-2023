package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class SignIn extends JPanel {
	private JTextField tfInterest;
	private JTextField tfActivity;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfMail;
	
	private String activitySI;
	private String lastNameSI;
	private String FirstNameSI;
	private String mailSI;
	/*
	 * Genere une page d'inscrption
	 */
	public SignIn() {
		this.setLayout(null);
		
		JButton btnAccept = new JButton("VALIDER");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* 
				 *  A MODIFIER : CETTE METHODE SE DECLANCHE LORSQUE QU'ON CLIQUE SUR LE BOUTON <<VALIDER>>
				 */
				
				/*
				 * RECUPERE LE TEXTE DES DIFFERENTS CHAMPS
				 */
				activitySI = tfActivity.getText();
				lastNameSI = tfLastName.getText();
				FirstNameSI = tfFirstName.getText();
				mailSI = tfMail.getText();
				
				if (verifytf()) {
					
					//			/!\ C'EST ICI QU'IL FAUT SE CONNECTER A LA BDD /!\
					
					accepted(); // APPEL UN MESSAGE DE VALIDATION - CE MESSAGE DOIT ETRE AFFICHE SSI LE COMPTE CREE N'EXISTE PAS ENCORE & SSI LA DEMANDE D'INSCRIPTION EST BIEN DANS LA BDD
					change(1); // RETOURNE A LA PAGE D'ACCUEIL
				}
			}
		});
		btnAccept.setBounds(200, 505, 200, 51);
		btnAccept.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		add(btnAccept);
		
		JButton btnReturn = new JButton("RETOUR");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change(1);
			}
		});
		btnReturn.setBounds(666, 505, 200, 51);
		btnReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		add(btnReturn);
		
		JLabel lblLastName = new JLabel("NOM :");
		lblLastName.setBounds(193, 239, 95, 38);
		lblLastName.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		add(lblLastName);
		
		JLabel lblFirstName = new JLabel("PRENOM :");
		lblFirstName.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblFirstName.setBounds(500, 239, 139, 38);
		add(lblFirstName);
		
		JLabel lblActivity = new JLabel("ACTIVITE :");
		lblActivity.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblActivity.setBounds(500, 306, 163, 38);
		add(lblActivity);
		
		JLabel lblMail = new JLabel("MAIL :");
		lblMail.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblMail.setBounds(193, 306, 95, 38);
		add(lblMail);
		
		JLabel lblInterest = new JLabel("MOTIVATION :");
		lblInterest.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
		lblInterest.setBounds(193, 375, 207, 38);
		add(lblInterest);
		
		JLabel lblEsigelec = new JLabel("ESIGELEC");
		lblEsigelec.setBounds(200, 100, 147, 67);
		lblEsigelec.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		add(lblEsigelec);
		
		JLabel lblArmada = new JLabel("ARMADA 2023");
		lblArmada.setBounds(657, 100, 207, 67);
		lblArmada.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		add(lblArmada);
		
		tfInterest = new JTextField();
		tfInterest.setColumns(10);
		tfInterest.setBounds(410, 377, 456, 50);
		add(tfInterest);
		
		tfActivity = new JTextField();
		tfActivity.setColumns(10);
		tfActivity.setBounds(666, 308, 200, 50);
		add(tfActivity);
		
		tfFirstName = new JTextField();
		tfFirstName.setColumns(10);
		tfFirstName.setBounds(666, 239, 200, 50);
		add(tfFirstName);
		
		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		tfLastName.setBounds(287, 239, 200, 50);
		add(tfLastName);
		
		tfMail = new JTextField();
		tfMail.setColumns(10);
		tfMail.setBounds(287, 306, 200, 50);
		add(tfMail);

	}

	/*
	 * Verifie si tout les champs sont remplis 
	 */
	protected boolean verifytf() {
        if (!activitySI.isEmpty() && !lastNameSI.isEmpty() && !FirstNameSI.isEmpty() & !mailSI.isEmpty())
        	return true;
        JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.");
        return false;
	}
	
	/*
	 * Affiche un message de confirmation dans le cas ou la demande d'inscription a été ajoutée à la BDD
	 */
	protected void accepted() {
        JOptionPane.showMessageDialog(this, "Votre demande d'inscription a bien été prise en compte.\nNous reviendrons vers vous au plus vite.");
	}
	
	/*
	 * Permet de faire appel aux passerelles(dans le fichier Main) pour changer de page
	 */
	protected void change(int i) {
		if (i==1)
			Main.siToWel();
	}
}
